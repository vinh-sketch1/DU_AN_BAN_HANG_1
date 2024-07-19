/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.service;

import app.model.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class SanPhamService {

    List<SanPham> listSanPham;

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<SanPham> timKiemSanPhamTheoMa(String ma) {
        listSanPham = new ArrayList<>();
        sql = "select maSP,ten,trangthaixoa,ngaytao,ngaysuacuoi from SanPham where maSP like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + ma + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                listSanPham.add(sp);
            }
            return listSanPham;
        } catch (Exception e) {
            return null;
        }
    }

    public List<SanPham> timKiemSanPhamTheoTen(String ten) {
        listSanPham = new ArrayList<>();
        sql = "select maSP,ten,trangthaixoa,ngaytao,ngaysuacuoi from SanPham where ten like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + ten + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                listSanPham.add(sp);
            }
            return listSanPham;
        } catch (Exception e) {
            return null;
        }
    }

    public List<SanPham> getAllSanPham() {
        listSanPham = new ArrayList<>();
        sql = "select maSP,ten,trangthaixoa,ngaytao,ngaysuacuoi from SanPham";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                listSanPham.add(sp);
            }
            return listSanPham;
        } catch (Exception e) {
            return null;
        }
    }

    public int themSanPham(SanPham sp) {
        if (sp == null) {
            return 0;
        }

        sql = "insert into SanPham\n"
                + "values \n"
                + "(?,?,?,getDate(),getDate())";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, sp.getMaSP());
            ps.setString(2, sp.getTen());
            ps.setInt(3, sp.getTrangThaiXoa());
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int suaSanPham(SanPham sp, String ma) {
        if (sp == null) {
            return 0;
        }
        sql = "update SanPham set maSP = ?,ten = ?, trangThaiXoa = ?,ngaySuaCuoi = GETDATE() where maSP = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, sp.getMaSP());
            ps.setString(2, sp.getTen());
            ps.setInt(3, sp.getTrangThaiXoa());
            ps.setString(4, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean kiemTraTrungMaSP(String ma) {
        sql = "select maSP from sanpham where masp = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

    public boolean kiemTraTrungtenSP(String ten) {
        sql = "select ten from sanpham where ten = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

    public static void main(String[] args) {
        List<SanPham> list = new ArrayList<>();
        SanPhamService qld = new SanPhamService();
        list = qld.timKiemSanPhamTheoTen("tên sp");
        for (SanPham grade : list) {
            System.out.println(grade.toString());
        }
    }

}
