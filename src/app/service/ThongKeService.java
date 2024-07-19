package app.service;

import app.model.KhachHang;
import app.model.Thongke;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ThongKeService {

    private List<Thongke> listTK;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    
    public List<Thongke> getAll() {
      
        listTK = new ArrayList<>();

        sql = """
                SELECT c.maCTSP, s.ten, SUM(h.soLuong) as SoLuongBan, (c.giaBan * SUM(h.soLuong)) as TongDoanhThu
                            FROM ChiTietSanPham c
                            left JOIN HoaDonChiTiet h ON c.id = h.id_CTSP
                            left JOIN HoaDon d ON h.id_HoaDon = d.id
                            left JOIN SanPham s ON s.id = c.id_SanPham
                            GROUP BY c.maCTSP, s.ten,c.giaBan
                            
                            ORDER BY SoLuongBan DESC""";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Thongke tk = new Thongke(rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(1));

                listTK.add(tk);
            }
            return listTK;
        } catch (SQLException e) {
            return null;
        }
      
    }

    public List<Thongke> timTheoMa(String maCTSP) {
        listTK = new ArrayList<>();

        sql = "SELECT c.maCTSP, s.ten, SUM(h.soLuong) as SoLuongBan, (c.giaBan * SUM(h.soLuong)) as TongDoanhThu\n"
                + "                            FROM ChiTietSanPham c\n"
                + "                            left JOIN HoaDonChiTiet h ON c.id = h.id_CTSP\n"
                + "                            left JOIN HoaDon d ON h.id_HoaDon = d.id\n"
                + "                            left JOIN SanPham s ON s.id = c.id_SanPham\n"
                + "                             where c.maCTSP =?\n"
                + "                            GROUP BY c.maCTSP, s.ten,c.giaBan";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, maCTSP);
            rs = ps.executeQuery();

            while (rs.next()) {
                Thongke tk = new Thongke(rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(1));

                listTK.add(tk);
            }
            return listTK;

        } catch (SQLException e) {
            return null;
        }
    }

    public double sumDay() {
        sql = """
              select sum (tienSauGiamGia) as tongtien from HoaDon where day(ngayTao) = day(GETDATE())
              """;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
        }
        return 0;
    }

    public double sumMonth() {
        sql = """
              select sum (tienSauGiamGia) as tongtien from HoaDon where month(ngayTao) = month(GETDATE())
              """;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
        }
        return 0;
    }

    public double sumYear() {
        sql = """
              select sum (tienSauGiamGia) as tongtien from HoaDon where year(ngayTao) = year(GETDATE())
              """;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
        }
        return 0;
    }
 

    public List<Thongke> KhoangDate(java.util.Date start, java.util.Date end) {
        listTK = new ArrayList<>();

        sql = """
              SELECT (d.ngaySuaCuoi) as Thang, s.ten, h.soLuong, SUM(D.tienSauGiamGia) as TongTien
                              FROM HoaDon d
                              JOIN HoaDonChiTiet h ON d.id = h.id_HoaDon
                              JOIN ChiTietSanPham c ON h.id_CTSP = c.id
                              JOIN SanPham s ON c.id_SanPham = s.id
                              WHERE d.ngaySuaCuoi BETWEEN ? AND ?
              \t\t\t\tGROUP BY s.ten, h.soLuong, d.ngaySuaCuoi""";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            ps.setString(1, sdf.format(start));
            ps.setString(2, sdf.format(end));
            rs = ps.executeQuery();
            while (rs.next()) {
                Thongke tk = new Thongke(rs.getDate(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                listTK.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTK;

    }

    public List<String> getThang() {
        List<String> listThang = new ArrayList();
        sql = "select distinct month(ngayTao) AS ngay from HoaDon order by ngay desc ";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String thang = rs.getString(1);
                listThang.add(thang);
            }
            return listThang;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<String> getNam() {
        List<String> listNam = new ArrayList();

        sql = "select distinct year(ngayTao) from HoaDon";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String nam = rs.getString(1);
                listNam.add(nam);
            }
            return listNam;
        } catch (SQLException e) {
            return null;
        }

    }

    public List<KhachHang> top5Kh() {
        List<KhachHang> listKH = new ArrayList<>();

        sql = """
              SELECT top 5 kh.maKh, kh.hoTen, kh.gioiTinh,kh.diaChi,kh.ngaySinh, kh.SDT, COUNT(*) AS sl,SUM(hd.thanhTien) as [tong tien]
              FROM HoaDon hd
              JOIN KhachHang kh ON hd.id_KhachHang = kh.id
              GROUP BY kh.id, kh.maKh, kh.hoTen, kh.gioiTinh,kh.diaChi,kh.ngaySinh, kh.SDT order by [tong tien] desc""";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(6), rs.getDouble(8), rs.getInt(7));
                listKH.add(kh);
            }
            return listKH;
        } catch (SQLException e) {
            return null;
        }

    }

    public String demSoLuongHD(String start_date, String end_date) {
        sql = """
            select count(id) As slhd from HoaDon where ngayTao >= ? and ngayTao <= ?
              """;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, start_date);
            ps.setString(2, end_date);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public String soLuongCacSPDaBan(String start_date, String end_date) {
        sql = """
            select sum(soLuong) As sl from HoaDonChiTiet where ngayTao >= ? and ngayTao <= ?
              """;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, start_date);
            ps.setString(2, end_date);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public String tongTienDaBan(String start_date, String end_date) {
        sql = """
            select sum(tienSauGiamGia) As tongtien from HoaDon where ngayTao >= ? and ngayTao <= ?
              """;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, start_date);
            ps.setString(2, end_date);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public static void main(String[] args) {
        List<Thongke> list = new ArrayList<>();
        ThongKeService qld = new ThongKeService();
        list = qld.timTheoMa("CTSP233");
        for (Thongke grade : list) {
            System.out.println(grade.toString());
        }
        System.out.println(qld.soLuongCacSPDaBan("2024-04-04", "2024-04-11"));
    }

}
