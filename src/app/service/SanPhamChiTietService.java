/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.service;

import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import app.model.ChiTietSanPham;
import com.microsoft.sqlserver.jdbc.SQLServerStatementColumnEncryptionSetting;

import java.util.ArrayList;
import java.util.List;

public class SanPhamChiTietService {

    public List<ChiTietSanPham> getAllSPCT() {
        List<ChiTietSanPham> list = new ArrayList<>();
        String sql = """
       select maCTSP,SanPham.ten, ChatLieu.ten, KichCo.ten,MauSac.ten, Hang.ten, soLuongCon,giaBan as[giaBan]  from ChiTietSanPham
                  join SanPham on SanPham.id = ChiTietSanPham.id_SanPham
                  join ChatLieu on ChatLieu.id = ChiTietSanPham.id_ChatLieu
                  join KichCo on KichCo.id = ChiTietSanPham.id_KichCo
                  join MauSac on MauSac.id = ChiTietSanPham.id_MauSac
                  join Hang on Hang.id = ChiTietSanPham.id_Hang
                """;
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
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
                        rs.getDouble(8)
                );

                list.add(ctsp);
            }
        } catch (Exception e) {
            e.printStackTrace(); // In ra thông báo lỗi để xem nguyên nhân cụ thể
        }
        return list; // Trả về danh sách, có thể rỗng nếu có lỗi xảy ra
    }

    public List<ChiTietSanPham> getAllSPCTCoId() {
        List<ChiTietSanPham> list = new ArrayList<>();
        String sql = """
       select maCTSP,SanPham.ten, ChatLieu.ten, KichCo.ten,MauSac.ten, Hang.ten, soLuongCon, giaBan, ChiTietSanPham.id from ChiTietSanPham
                  join SanPham on SanPham.id = ChiTietSanPham.id_SanPham
                  join ChatLieu on ChatLieu.id = ChiTietSanPham.id_ChatLieu
                  join KichCo on KichCo.id = ChiTietSanPham.id_KichCo
                  join MauSac on MauSac.id = ChiTietSanPham.id_MauSac
                  join Hang on Hang.id = ChiTietSanPham.id_Hang
                """;
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
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
                        rs.getInt(9)
                );

                list.add(ctsp);
            }
        } catch (Exception e) {
            e.printStackTrace(); // In ra thông báo lỗi để xem nguyên nhân cụ thể
        }
        return list; // Trả về danh sách, có thể rỗng nếu có lỗi xảy ra
    }

    public List<ChiTietSanPham> findByKeyWork(String txtSearch) {
        List<ChiTietSanPham> list = new ArrayList<>();
        String sql = """
       select maCTSP,SanPham.ten, ChatLieu.ten, KichCo.ten,MauSac.ten, Hang.ten, soLuongCon,giaBan as[giaBan]  from ChiTietSanPham
                  join SanPham on SanPham.id = ChiTietSanPham.id_SanPham
                  join ChatLieu on ChatLieu.id = ChiTietSanPham.id_ChatLieu
                  join KichCo on KichCo.id = ChiTietSanPham.id_KichCo
                  join MauSac on MauSac.id = ChiTietSanPham.id_MauSac
                  join Hang on Hang.id = ChiTietSanPham.id_Hang  where SanPham.ten like ? 
                """;
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, "%" + txtSearch + "%");
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
                        rs.getDouble(8)
                );

                list.add(ctsp);
            }
        } catch (Exception e) {
            e.printStackTrace(); // In ra thông báo lỗi để xem nguyên nhân cụ thể
        } finally {
            try {

            } catch (Exception e) {
            }
        }
        return list; // Trả về danh sách, có thể rỗng nếu có lỗi xảy ra
    }

    public List<ChiTietSanPham> locSanPham(String hang, String mauSac, String size) {

        List<ChiTietSanPham> list = new ArrayList<>();
        System.out.println(hang);
        System.out.println(mauSac);
        System.out.println(size);

        String sql = """
       select maCTSP,SanPham.ten, ChatLieu.ten, KichCo.ten,MauSac.ten, Hang.ten, soLuongCon,giaBan as[giaBan]  from ChiTietSanPham
                  join SanPham on SanPham.id = ChiTietSanPham.id_SanPham
                  join ChatLieu on ChatLieu.id = ChiTietSanPham.id_ChatLieu
                  join KichCo on KichCo.id = ChiTietSanPham.id_KichCo
                  join MauSac on MauSac.id = ChiTietSanPham.id_MauSac
                  join Hang on Hang.id = ChiTietSanPham.id_Hang 
                """;

        try {
            Connection con = DBConnect.getConnection();
            if (!hang.equalsIgnoreCase("Chọn") || !mauSac.equalsIgnoreCase("Chọn") || !size.equalsIgnoreCase("Chọn")) {
                sql += " WHERE";
                if (!hang.equalsIgnoreCase("Chọn")) {
                    sql += " Hang.ten = ? AND";
                }
                if (!mauSac.equalsIgnoreCase("Chọn")) {
                    sql += " MauSac.ten = ? AND";
                }
                if (!size.equalsIgnoreCase("Chọn")) {
                    sql += " KichCo.ten = ? AND";
                }
                // Xóa phần "AND" cuối cùng nếu có
                sql = sql.replaceAll("AND$", "");
            }

            PreparedStatement ps = con.prepareStatement(sql);

            // Đặt tham số cho các điều kiện lọc
            int parameterIndex = 1;
            if (!hang.equalsIgnoreCase("Chọn")) {
                ps.setString(parameterIndex++, hang);
            }
            if (!mauSac.equalsIgnoreCase("Chọn")) {
                ps.setString(parameterIndex++, mauSac);
            }
            if (!size.equalsIgnoreCase("Chọn")) {
                ps.setString(parameterIndex, size);
            }
            System.out.println(sql);
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
                        rs.getDouble(8)
                );

                list.add(ctsp);
            }
        } catch (Exception e) {
            e.printStackTrace(); // In ra thông báo lỗi để xem nguyên nhân cụ thể
        }
        return list; // Trả về danh sách, có thể rỗng nếu có lỗi xảy ra

    }

}
