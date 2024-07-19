/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.repository;

import app.model.HoaDonChiTiet;
import app.service.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author admin
 */
public class HoaDonChiTietRepository {

    PreparedStatement preparedStatement = null;

    ResultSet resultSet = null;

    String sql = "";

    Connection connection = null;

    public int taoHoaDonChiTiet(List<HoaDonChiTiet> hoaDonChiTietList) {
    int rowsAffected = 0;
    try {
        connection = DBConnect.getConnection();
        sql = "INSERT INTO [dbo].[HoaDonChiTiet]\n"
                + "           ([id_HoaDon]\n"
                + "           ,[id_CTSP]\n"
                + "           ,[donGia]\n"
                + "           ,[soLuong]\n"
                + "           ,[trangThaiXoa]\n"
                + "           ,[ngayTao]\n"
                + "           ,[ngaySuaCuoi])\n"
                + "     VALUES (?,?,?,?,?,GETDATE(),GETDATE())";
        preparedStatement = connection.prepareStatement(sql);
        
        for (HoaDonChiTiet hoaDonChiTiet : hoaDonChiTietList) {
            preparedStatement.setObject(1, hoaDonChiTiet.getIdHoaDon());
            preparedStatement.setObject(2, hoaDonChiTiet.getId_CTSP());
            preparedStatement.setObject(3, hoaDonChiTiet.getDonGia());
            preparedStatement.setObject(4, hoaDonChiTiet.getSoLuong());
            preparedStatement.setObject(5, hoaDonChiTiet.getTrangThaiXoa());

            
            rowsAffected += preparedStatement.executeUpdate();
        }
    } catch (Exception e) {
        e.printStackTrace();
        // Xử lý ngoại lệ nếu cần
    } finally {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý ngoại lệ nếu cần
        }
    }
    return rowsAffected;
}

}
