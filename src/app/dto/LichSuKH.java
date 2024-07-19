/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dto;

import java.util.Date;

/**
 *
 * @author Ha Thanh
 */
public class LichSuKH {
    private int id;
    private String hoTen;
    private String maHoaDon;
    private String diaChi;
    private Date ngayTao;
    private Long thanhTien;
    private int trangThaiThanhtToan;

    public LichSuKH() {
    }

    public LichSuKH(int id, String hoTen, String maHoaDon, String diaChi, Date ngayTao, Long thanhTien, int trangThaiThanhtToan) {
        this.id = id;
        this.hoTen = hoTen;
        this.maHoaDon = maHoaDon;
        this.diaChi = diaChi;
        this.ngayTao = ngayTao;
        this.thanhTien = thanhTien;
        this.trangThaiThanhtToan = trangThaiThanhtToan;
    }

    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Long getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Long thanhTien) {
        this.thanhTien = thanhTien;
    }

    public int getTrangThaiThanhtToan() {
        return trangThaiThanhtToan;
    }

    public void setTrangThaiThanhtToan(int trangThaiThanhtToan) {
        this.trangThaiThanhtToan = trangThaiThanhtToan;
    }
    
    public Object[] toDataRowLS(){
        return new Object[]{
            this.id, this.hoTen , this.maHoaDon, this.diaChi, this. ngayTao, this.thanhTien, this.trangThaiThanhtToan
        };
    }
    
}
