/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.repository;

import app.dto.HoaDonDTO;
import app.model.ChiTietSanPham;
import app.model.HoaDon;
import app.service.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public class HoaDonRepository {

    PreparedStatement preparedStatement = null;

    ResultSet resultSet = null;

    String sql = "";

    Connection connection = null;

    public String taoHoaDonByHoaDon(HoaDon hoaDon) {
        String maHoaDon = null;
        try {
            connection = DBConnect.getConnection();
            // Tạo hóa đơn. Lấy ra id hóa đơn rồi tạo  
            sql = "INSERT INTO [dbo].[HoaDon]\n"
                    + "           ([id_KhachHang]\n"
                    + "           ,[id_NhanVien]\n"
                    + "           ,[maHoaDon]\n"
                    + "           ,[tienKhachTra]\n"
                    + "           ,[tienThuaLai]\n"
                    + "           ,[thanhTien]\n"
                    + "           ,[ghiChu]\n"
                    + "           ,[hinhThucThanhToan]\n"
                    + "           ,[trangThaiThanhToan]\n"
                    + "           ,[maVoucher]\n"
                    + "           ,[tienSauGiamGia]\n" // Đặt dấu ngoặc mở ở đây
                    + "           ,[ngayTao]\n"
                    + "           ,[ngaySuaCuoi])\n" // Đóng dấu ngoặc sau danh sách giá trị
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, GETDATE(), GETDATE())\n";

            // Tạo hóa đơn xong lấy id hóa đơn và danh sách sản phẩm. 
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, hoaDon.getIdKhachHang());
            preparedStatement.setObject(2, hoaDon.getIdNhanVien());
            preparedStatement.setObject(3, hoaDon.getMaHoaDon());
            preparedStatement.setObject(4, hoaDon.getTienKhachTra());
            preparedStatement.setObject(5, hoaDon.getTienThuaLai());
            preparedStatement.setObject(6, hoaDon.getThanhTien());
            preparedStatement.setObject(7, hoaDon.getGhiChu());
            preparedStatement.setObject(8, hoaDon.getHinhThucThanhToan());
            preparedStatement.setObject(9, hoaDon.getTrangThaiThanhToan());
            preparedStatement.setObject(10, hoaDon.getIdVoucher());
            preparedStatement.setObject(11, hoaDon.getTienSauGiamGia());

            int kq = preparedStatement.executeUpdate();
            if (kq > 0) {
                return hoaDon.getMaHoaDon();
            }

            return maHoaDon;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return maHoaDon;
    }

    public HoaDonDTO findHoaDonByMaHoaDon(String maHoaDon) {
        HoaDonDTO hoaDon = null;
        try {

            connection = DBConnect.getConnection();
             sql = "SELECT [HoaDon].id\n"
                    + "      ,id_KhachHang\n"
                    + "      ,id_NhanVien\n"
                    + "      ,maHoaDon\n"
                    + "      ,tenNguoiNhan\n"
                    + "      ,[HoaDon].diaChi\n"
                    + "      ,tienKhachTra\n"
                    + "      ,tienThuaLai\n"
                    + "      ,thanhTien\n"
                    + "      ,[HoaDon].trangThaiXoa\n"
                    + "      ,[HoaDon].ngayTao\n"
                    + "      ,[HoaDon].ngaySuaCuoi\n"
                    + "      ,ghiChu,\n"
                    + "	  NhanVien.hoTen,\n"
                    + "	  KhachHang.hoTen,\n"
                    + "	  KhachHang.SDT, hinhThucThanhToan, trangThaiThanhToan,Voucher.maVoucher, tienSauGiamGia  \n"
                    + "  FROM [dbo].[HoaDon] "
                    + " left join NhanVien on HoaDon.id_NhanVien = NhanVien.id "
                    + " left join KhachHang on KhachHang.id = HoaDon.id_KhachHang "
                    + " LEFT JOIN Voucher on Voucher.id = HoaDon.maVoucher where maHoaDon = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, maHoaDon);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                hoaDon = new HoaDonDTO(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getDouble(7),
                        resultSet.getDouble(8),
                        resultSet.getDouble(9),
                        resultSet.getBoolean(10),
                        resultSet.getDate(11),
                        resultSet.getDate(12),
                        resultSet.getString(13),
                        resultSet.getString(14),
                        resultSet.getString(15),
                        resultSet.getString(16),
                        resultSet.getString(17),
                        resultSet.getInt(18),
                        resultSet.getString(19),
                        resultSet.getDouble(20)
                );
            }

            return hoaDon;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hoaDon;
    }

    public int updateHoaDonByMaHoaDon(String maHoaDonUpdate) {
        int kq = -1;
        try {
            connection = DBConnect.getConnection();
            // Tạo hóa đơn. Lấy ra id hóa đơn rồi tạo  
            sql = "UPDATE [BanGiayTheHans].[dbo].[HoaDon] \n"
                    + " SET trangThaiThanhToan = 1 \n"
                    + " WHERE maHoaDon = ?"; // Tạo hóa đơn xong lấy id hóa đơn và danh sách sản phẩm. 
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, maHoaDonUpdate);

            kq = preparedStatement.executeUpdate();

            return kq;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return kq;
    }

    public List<ChiTietSanPham> findChiTietSanPhamByMaHoaDon(String maHoaDon) {
        List<ChiTietSanPham> list = new ArrayList<>();
        String sql = "select maCTSP,SanPham.ten, ChatLieu.ten, KichCo.ten,MauSac.ten, Hang.ten, soLuongCon, giaBan, ChiTietSanPham.id, HoaDonChiTiet.soLuong  from ChiTietSanPham\n"
                + "                  join SanPham on SanPham.id = ChiTietSanPham.id_SanPham\n"
                + "                  join ChatLieu on ChatLieu.id = ChiTietSanPham.id_ChatLieu\n"
                + "                  join KichCo on KichCo.id = ChiTietSanPham.id_KichCo\n"
                + "                  join MauSac on MauSac.id = ChiTietSanPham.id_MauSac\n"
                + "                  join Hang on Hang.id = ChiTietSanPham.id_Hang\n"
                + "				  join HoaDonChiTiet on HoaDonChiTiet.id_CTSP = ChiTietSanPham.id\n"
                + "				  join HoaDon on HoaDon.id = HoaDonChiTiet.id_HoaDon\n"
                + "				  where HoaDon.maHoaDon = ? ";
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maHoaDon);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham(
                        rs.getString(2),
                        rs.getString(5),
                        rs.getString(4),
                        rs.getString(6),
                        rs.getString(3),
                        rs.getInt(7),
                        rs.getString(1),
                        rs.getDouble(8),
                        rs.getInt(9),
                        rs.getInt(10)
                );

                list.add(ctsp);
            }
        } catch (Exception e) {
            e.printStackTrace(); // In ra thông báo lỗi để xem nguyên nhân cụ thể
        } finally {
            try {
                 connection.close();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return list; // Trả về danh sách, có thể rỗng nếu có lỗi xảy ra

    }

    public int updateHoaDonByHoaDonDTO(HoaDonDTO hoaDonUpdate) {
        int kq = -1;
        try {
            connection = DBConnect.getConnection();
            // Tạo hóa đơn. Lấy ra id hóa đơn rồi tạo  
            sql = "UPDATE [BanGiayTheHans].[dbo].[HoaDon]\n"
                    + "SET \n"
                    + "	tienKhachTra = ?,\n"
                    + "	tienThuaLai = ?,\n"
                    + "	thanhTien = ?,\n"
                    + "	ngaySuaCuoi = GETDATE(),\n"
                    + "	ghiChu = ?,\n"
                    + "	hinhThucThanhToan = ?,\n"
                    + "	trangThaiThanhToan = ?,\n"
                    + "	maVoucher = ?, \n"
                    + "	tienSauGiamGia = ?\n"
                    + "WHERE maHoaDon = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, hoaDonUpdate.getTienKhachTra());
            preparedStatement.setObject(2, hoaDonUpdate.getTienThuaLai());
            preparedStatement.setObject(3, hoaDonUpdate.getThanhTien());
            preparedStatement.setObject(4, hoaDonUpdate.getGhiChu());
            preparedStatement.setObject(5, hoaDonUpdate.getHinhThucThanhToan());
            preparedStatement.setObject(6, hoaDonUpdate.getTrangThaiThanhToan());
            preparedStatement.setObject(7, hoaDonUpdate.getIdVoucher());
            preparedStatement.setObject(8, hoaDonUpdate.getTienSauGiamGia());
            preparedStatement.setObject(9, hoaDonUpdate.getMaHoaDon());
            kq = preparedStatement.executeUpdate();

            return kq;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return kq;
    }

    public void truSoLuongTrongSanPham(String maCTSP, int soLuongTrongGioHang) {
        int kq = -1;
        try {
            connection = DBConnect.getConnection();
            // Tạo hóa đơn. Lấy ra id hóa đơn rồi tạo  
            sql = "UPDATE ChiTietSanPham\n"
                    + "SET soLuongCon = soLuongCon - ? \n"
                    + "WHERE ChiTietSanPham.maCTSP = ?"; // Tạo hóa đơn xong lấy id hóa đơn và danh sách sản phẩm. 
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, soLuongTrongGioHang);
            preparedStatement.setObject(2, maCTSP);

            kq = preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    
     public List<HoaDonDTO> findHoaDonByTenKhachHang(String tenKhachHang) {
        List<HoaDonDTO> hoaDons = null;
        try {

            connection = DBConnect.getConnection();
             sql = "SELECT [HoaDon].id\n"
                    + "      ,id_KhachHang\n"
                    + "      ,id_NhanVien\n"
                    + "      ,maHoaDon\n"
                    + "      ,tenNguoiNhan\n"
                    + "      ,[HoaDon].diaChi\n"
                    + "      ,tienKhachTra\n"
                    + "      ,tienThuaLai\n"
                    + "      ,thanhTien\n"
                    + "      ,[HoaDon].trangThaiXoa\n"
                    + "      ,[HoaDon].ngayTao\n"
                    + "      ,[HoaDon].ngaySuaCuoi\n"
                    + "      ,ghiChu,\n"
                    + "	  NhanVien.hoTen,\n"
                    + "	  KhachHang.hoTen,\n"
                    + "	  KhachHang.SDT, hinhThucThanhToan, trangThaiThanhToan,Voucher.maVoucher, tienSauGiamGia  \n"
                    + "  FROM [dbo].[HoaDon] "
                    + " left join NhanVien on HoaDon.id_NhanVien = NhanVien.id "
                    + " left join KhachHang on KhachHang.id = HoaDon.id_KhachHang "
                    + " LEFT JOIN Voucher on Voucher.id = HoaDon.maVoucher where KhachHang.hoTen like %?%";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, tenKhachHang);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
              HoaDonDTO  hoaDon = new HoaDonDTO(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getDouble(7),
                        resultSet.getDouble(8),
                        resultSet.getDouble(9),
                        resultSet.getBoolean(10),
                        resultSet.getDate(11),
                        resultSet.getDate(12),
                        resultSet.getString(13),
                        resultSet.getString(14),
                        resultSet.getString(15),
                        resultSet.getString(16),
                        resultSet.getString(17),
                        resultSet.getInt(18),
                        resultSet.getString(19),
                        resultSet.getDouble(20)
                );
              hoaDons.add(hoaDon);
            }

            return hoaDons;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hoaDons;
    }

}
