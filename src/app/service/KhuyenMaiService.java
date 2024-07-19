package app.service;

import app.model.KhuyenMai;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhuyenMaiService {
    
    private List<KhuyenMai> listKM;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    
    public List<KhuyenMai> getAll() {
        listKM = new ArrayList<>();
        
        sql = "select id, maKM, tenKM, loaiKM, ngayBatDau, ngayKetThuc, giaTri from KhuyenMai";
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getDate(5), rs.getDate(6),
                        rs.getInt(7));
                
                listKM.add(km);
            }
            return listKM;
            
        } catch (SQLException e) {
            return null;
        }
    }

    public List<KhuyenMai> timKiem(String ma) {
        listKM = new ArrayList<>();
        sql = "select id, maKM, tenKM, loaiKM, ngayBatDau, ngayKetThuc, giaTri from KhuyenMai where maKM = ?";
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getDate(5), rs.getDate(6),
                        rs.getInt(7));
                
                listKM.add(km);
            }
            return listKM;
            
        } catch (SQLException e) {  
            return null;
        }
    }
    
    public int AddKM(KhuyenMai km) {
        sql = "insert into KhuyenMai (maKM, tenKM, loaiKM, ngayBatDau, ngayKetThuc, giaTri) values (?, ?, ?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, km.getTen());
            ps.setObject(2, km.getLoaiGiam());
            ps.setObject(3, km.getNgayBD());
            ps.setObject(4, km.getNgayKT());
            ps.setObject(5, km.getGiatri());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int updateKM(String ma, KhuyenMai km) {
        sql = "Update KhuyenMai set tenKM = ?, loaiKM = ?, ngayBatDau = ?, ngayKetThuc = ?, giaTri = ?\n"
                + "where maKM like ?";
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
        }
    }
    
    public KhuyenMai findKhuyenMaiByMaKhuyenMai(String maKhuyenMai) {
        KhuyenMai km = null;
        
        sql = "select id, maKM, tenKM, loaiKM, ngayBatDau, ngayKetThuc, giaTri from KhuyenMai where maKM = ?";
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maKhuyenMai);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                km = new KhuyenMai(rs.getInt(1), rs.getString(3),
                        rs.getString(2), rs.getString(4),
                        rs.getDate(5), rs.getDate(6),
                        rs.getInt(7));
                
            }
            return km;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
