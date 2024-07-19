/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;

/**
 *
 * @author admin
 */
public class SanPham {

    private int id;
    private String maSP;
    private String ten;
    private int trangThaiXoa;
    private String ngayTao;
    private String ngaySuaCuoi;

    public SanPham() {
    }

    public SanPham(String maSP, String ten, int trangThaiXoa, String ngayTao, String ngaySuaCuoi) {
        this.maSP = maSP;
        this.ten = ten;
        this.trangThaiXoa = trangThaiXoa;
        this.ngayTao = ngayTao;
        this.ngaySuaCuoi = ngaySuaCuoi;
    }

    public SanPham(String maSP, String ten, int trangThaiXoa) {
        this.maSP = maSP;
        this.ten = ten;
        this.trangThaiXoa = trangThaiXoa;
    }
    

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTrangThaiXoa() {
        return trangThaiXoa;
    }

    public void setTrangThaiXoa(int trangThaiXoa) {
        this.trangThaiXoa = trangThaiXoa;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgaySuaCuoi() {
        return ngaySuaCuoi;
    }

    public void setNgaySuaCuoi(String ngaySuaCuoi) {
        this.ngaySuaCuoi = ngaySuaCuoi;
    }

    @Override
    public String toString() {
        return "SanPham{" + "id="  + ", maSP=" + maSP + ", ten=" + ten + ", trangThaiXoa=" + trangThaiXoa + ", ngayTao=" + ngayTao + ", ngaySuaCuoi=" + ngaySuaCuoi + '}';
    }

}
