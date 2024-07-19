/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dto;

import java.util.Date;

/**
 *
 * @author admin
 */
public class HoaDonChiTietDTO {
    
    private int id_HoaDon;
    private String id_CTSP;
    private Double donGia;
    private int soLuong;
    private int trangThaiXoa;
    private Date ngayTao;
    private Date ngaySuaCuoi;
    private String tenSanPham; // Tên sản phẩm từ bảng SanPham
    private double giaBan;

    public HoaDonChiTietDTO(int id_HoaDon, String id_CTSP, Double donGia, int soLuong, int trangThaiXoa, Date ngayTao, Date ngaySuaCuoi, String tenSanPham, double giaBan) {
        this.id_HoaDon = id_HoaDon;
        this.id_CTSP = id_CTSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.trangThaiXoa = trangThaiXoa;
        this.ngayTao = ngayTao;
        this.ngaySuaCuoi = ngaySuaCuoi;
        this.tenSanPham = tenSanPham;
        this.giaBan = giaBan;
    }

    

    public HoaDonChiTietDTO() {
    }
    

    public int getId_HoaDon() {
        return id_HoaDon;
    }

    public void setId_HoaDon(int id_HoaDon) {
        this.id_HoaDon = id_HoaDon;
    }

    public String getId_CTSP() {
        return id_CTSP;
    }

    public void setId_CTSP(String id_CTSP) {
        this.id_CTSP = id_CTSP;
    }

    

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTrangThaiXoa() {
        return trangThaiXoa;
    }

    public void setTrangThaiXoa(int trangThaiXoa) {
        this.trangThaiXoa = trangThaiXoa;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySuaCuoi() {
        return ngaySuaCuoi;
    }

    public void setNgaySuaCuoi(Date ngaySuaCuoi) {
        this.ngaySuaCuoi = ngaySuaCuoi;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return "HoaDonChiTietDTO{" + "id_HoaDon=" + id_HoaDon + ", id_CTSP=" + id_CTSP + ", donGia=" + donGia + ", soLuong=" + soLuong + ", trangThaiXoa=" + trangThaiXoa + ", ngayTao=" + ngayTao + ", ngaySuaCuoi=" + ngaySuaCuoi + ", tenSanPham=" + tenSanPham + ", giaBan=" + giaBan + '}';
    }
    
    
    
    
}
