/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;

/**
 *
 * @author admin
 */
public class Hang {

    private int id;
    private String maHang;
    private String ten;
    private int trangThaiXoa;
    private String ngayTao;
    private String ngaySuaCuoi;

    public Hang() {
    }

    public Hang(String maHang, String ten, int trangThaiXoa, String ngayTao, String ngaySuaCuoi) {
        this.maHang = maHang;
        this.ten = ten;
        this.trangThaiXoa = trangThaiXoa;
        this.ngayTao = ngayTao;
        this.ngaySuaCuoi = ngaySuaCuoi;
    }

    public Hang(String maHang, String ten, int trangThaiXoa) {
        this.maHang = maHang;
        this.ten = ten;
        this.trangThaiXoa = trangThaiXoa;
    }
    

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
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

}
