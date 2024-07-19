package app.service;

import app.model.KhuyenMai;
import app.model.Voucher;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VoucherService {

    private List<Voucher> listKM;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public List<Voucher> getAll() {

        listKM = new ArrayList<>();
        sql = "select id, maVoucher, tenVoucher, loaiVoucher, ngayBatDau, ngayKetThuc, giaTri from Voucher";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Voucher km = new Voucher(rs.getInt(1), rs.getString(3),
                        rs.getString(2), rs.getString(4),
                        rs.getDate(5), rs.getDate(6),
                        rs.getInt(7));

                listKM.add(km);
            }
            return listKM;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                con.close();
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public List<Voucher> timKiemTheoMa(String ma) {

        listKM = new ArrayList<>();
        sql = "select id, maVoucher, tenVoucher, loaiVoucher, ngayBatDau, ngayKetThuc, giaTri from Voucher where maVoucher = ?";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            rs = ps.executeQuery();

            while (rs.next()) {
                Voucher km = new Voucher(rs.getInt(1), rs.getString(3),
                        rs.getString(2), rs.getString(4),
                        rs.getDate(5), rs.getDate(6),
                        rs.getInt(7));

                listKM.add(km);
            }
            return listKM;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                con.close();
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int AddKM(Voucher km) {
        System.out.println(km.toString());
        sql = "insert into Voucher (maVoucher, tenVoucher, loaiVoucher, ngayBatDau, ngayKetThuc, giaTri) values (?, ?, ?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, km.getMa());
            ps.setObject(2, km.getTen());
            ps.setObject(3, km.getLoaiGiam());
            ps.setObject(4, km.getNgayBD());
            ps.setObject(5, km.getNgayKT());
            ps.setObject(6, km.getGiatri());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            try {
                con.close();
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int updateKM(String ma, Voucher km) {
        sql = "Update Voucher set tenVoucher = ?, loaiVoucher = ?, ngayBatDau = ?, ngayKetThuc = ?, giaTri = ?\n"
                + "where maVoucher like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setObject(1, km.getTen());
            ps.setObject(2, km.getLoaiGiam());
            ps.setObject(3, km.getNgayBD());
            ps.setObject(4, km.getNgayKT());
            ps.setObject(5, km.getGiatri());
            ps.setObject(6, km.getMa());

            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            try {
                con.close();
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Voucher findKhuyenMaiByMaKhuyenMai(String maKhuyenMai) {
        Voucher km = null;

        sql = "select id, maVoucher, tenVoucher, loaiVoucher, ngayBatDau, ngayKetThuc, giaTri from Voucher where maVoucher = ?";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maKhuyenMai);
            rs = ps.executeQuery();

            while (rs.next()) {
                km = new Voucher(rs.getInt(1), rs.getString(3),
                        rs.getString(2), rs.getString(4),
                        rs.getDate(5), rs.getDate(6),
                        rs.getInt(7));

            }
            return km;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                con.close();
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
