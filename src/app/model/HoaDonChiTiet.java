/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;

import java.util.Date;

/**
 *
 * @author admin
 */
public class HoaDonChiTiet {
    
     private int idHoaDon;
    
    private int id_CTSP;
    
    private Double donGia;
    
    private int trangThaiXoa;
    
    private Date ngayTao;
    
    private Date ngaySua;
    
    private int soLuong;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int idHoaDon, int id_CTSP, Double donGia, int trangThaiXoa, Date ngayTao, Date ngaySua) {
        this.idHoaDon = idHoaDon;
        this.id_CTSP = id_CTSP;
        this.donGia = donGia;
        this.trangThaiXoa = trangThaiXoa;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
    }

    public HoaDonChiTiet(int idHoaDon, int id_CTSP, Double donGia, int trangThaiXoa, Date ngayTao, Date ngaySua, int soLuong) {
        this.idHoaDon = idHoaDon;
        this.id_CTSP = id_CTSP;
        this.donGia = donGia;
        this.trangThaiXoa = trangThaiXoa;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.soLuong = soLuong;
    }

    
    

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getId_CTSP() {
        return id_CTSP;
    }

    public void setId_CTSP(int id_CTSP) {
        this.id_CTSP = id_CTSP;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
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

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    
    
    
    
}
