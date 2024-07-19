/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;

/**
 *
 * @author admin
 */
public class ChiTietSanPham {

    private int id;
    private String maCTSP;
    private String id_SanPham;
    private double giaBan;
    private int soLuongCon;
    private String id_MauSac;
    private String id_KichCo;
    private String id_Hang;
    private String id_ChatLieu;
    private String id_CTSP_KhuyenMai;
    private String ngayTao;
    private String ngaySuaCuoi;
    private int trangThaiXoa;
    private String mota;
    private String maVach;

    private int soLuongTrongGioHang;
    private String maKhuyenMai;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(String maCTSP, String id_SanPham, double giaBan, int soLuongCon, String id_MauSac, String id_KichCo, String id_Hang, String id_ChatLieu, String ngayTao, String ngaySuaCuoi, int trangThaiXoa, String mota, String maVach) {
        this.maCTSP = maCTSP;
        this.id_SanPham = id_SanPham;
        this.giaBan = giaBan;
        this.soLuongCon = soLuongCon;
        this.id_MauSac = id_MauSac;
        this.id_KichCo = id_KichCo;
        this.id_Hang = id_Hang;
        this.id_ChatLieu = id_ChatLieu;
        this.ngayTao = ngayTao;
        this.ngaySuaCuoi = ngaySuaCuoi;
        this.trangThaiXoa = trangThaiXoa;
        this.mota = mota;
        this.maVach = maVach;
    }

    public ChiTietSanPham(int id, String maCTSP, String id_SanPham, double giaBan, int soLuongCon, String id_MauSac, String id_KichCo, String id_Hang, String id_ChatLieu, String id_CTSP_KhuyenMai, String ngayTao, String ngaySuaCuoi, int trangThaiXoa, String mota, String maVach) {
        this.id = id;
        this.maCTSP = maCTSP;
        this.id_SanPham = id_SanPham;
        this.giaBan = giaBan;
        this.soLuongCon = soLuongCon;
        this.id_MauSac = id_MauSac;
        this.id_KichCo = id_KichCo;
        this.id_Hang = id_Hang;
        this.id_ChatLieu = id_ChatLieu;
        this.id_CTSP_KhuyenMai = id_CTSP_KhuyenMai;
        this.ngayTao = ngayTao;
        this.ngaySuaCuoi = ngaySuaCuoi;
        this.trangThaiXoa = trangThaiXoa;
        this.mota = mota;
        this.maVach = maVach;
    }

    public ChiTietSanPham(String maCTSP, String id_SanPham, double giaBan, int soLuongCon, String id_MauSac, String id_KichCo, String id_Hang, String id_ChatLieu, String id_CTSP_KhuyenMai, int trangThaiXoa, String mota, String maVach) {
        this.maCTSP = maCTSP;
        this.id_SanPham = id_SanPham;
        this.giaBan = giaBan;
        this.soLuongCon = soLuongCon;
        this.id_MauSac = id_MauSac;
        this.id_KichCo = id_KichCo;
        this.id_Hang = id_Hang;
        this.id_ChatLieu = id_ChatLieu;
        this.id_CTSP_KhuyenMai = id_CTSP_KhuyenMai;
        this.trangThaiXoa = trangThaiXoa;
        this.mota = mota;
        this.maVach = maVach;
    }

    public ChiTietSanPham(String maCTSP, String id_SanPham, double giaBan, int soLuongCon, String id_MauSac, String id_KichCo, String id_Hang, String id_ChatLieu, int trangThaiXoa, String mota, String maVach) {
        this.maCTSP = maCTSP;
        this.id_SanPham = id_SanPham;
        this.giaBan = giaBan;
        this.soLuongCon = soLuongCon;
        this.id_MauSac = id_MauSac;
        this.id_KichCo = id_KichCo;
        this.id_Hang = id_Hang;
        this.id_ChatLieu = id_ChatLieu;
        this.trangThaiXoa = trangThaiXoa;
        this.mota = mota;
        this.maVach = maVach;
    }

    public ChiTietSanPham(String id_SanPham, String id_MauSac, String id_KichCo, String id_Hang, String id_ChatLieu, int soLuongCon, String maCTSP, double giaBan) {
        this.id_SanPham = id_SanPham;
        this.id_MauSac = id_MauSac;
        this.id_KichCo = id_KichCo;
        this.id_Hang = id_Hang;
        this.id_ChatLieu = id_ChatLieu;
        this.soLuongCon = soLuongCon;
        this.maCTSP = maCTSP;
        this.giaBan = giaBan;
    }

    public ChiTietSanPham(String id_SanPham, String id_MauSac, String id_KichCo, String id_Hang, String id_ChatLieu, int soLuongCon, String maCTSP, double giaBan, int id) {
        this.id_SanPham = id_SanPham;
        this.id_MauSac = id_MauSac;
        this.id_KichCo = id_KichCo;
        this.id_Hang = id_Hang;
        this.id_ChatLieu = id_ChatLieu;
        this.soLuongCon = soLuongCon;
        this.maCTSP = maCTSP;
        this.giaBan = giaBan;
        this.id = id;
    }
    
    public ChiTietSanPham(String id_SanPham, String id_MauSac, String id_KichCo, String id_Hang, String id_ChatLieu, int soLuongCon, String maCTSP, double giaBan, int id, int soLuongTrongGioHang) {
        this.id_SanPham = id_SanPham;
        this.id_MauSac = id_MauSac;
        this.id_KichCo = id_KichCo;
        this.id_Hang = id_Hang;
        this.id_ChatLieu = id_ChatLieu;
        this.soLuongCon = soLuongCon;
        this.maCTSP = maCTSP;
        this.giaBan = giaBan;
        this.id = id;
        this.soLuongTrongGioHang = soLuongTrongGioHang;
    }

    public ChiTietSanPham(int id, String maCTSP, String id_SanPham, double giaBan, int soLuongCon, String id_MauSac, String id_KichCo, String id_Hang, String id_ChatLieu, String id_CTSP_KhuyenMai, String ngayTao, String ngaySuaCuoi, int trangThaiXoa, String mota, String maVach, int soLuongTrongGioHang) {
        this.id = id;
        this.maCTSP = maCTSP;
        this.id_SanPham = id_SanPham;
        this.giaBan = giaBan;
        this.soLuongCon = soLuongCon;
        this.id_MauSac = id_MauSac;
        this.id_KichCo = id_KichCo;
        this.id_Hang = id_Hang;
        this.id_ChatLieu = id_ChatLieu;
        this.id_CTSP_KhuyenMai = id_CTSP_KhuyenMai;
        this.ngayTao = ngayTao;
        this.ngaySuaCuoi = ngaySuaCuoi;
        this.trangThaiXoa = trangThaiXoa;
        this.mota = mota;
        this.maVach = maVach;
        this.soLuongTrongGioHang = soLuongTrongGioHang;
    }

    public int getSoLuongTrongGioHang() {
        return soLuongTrongGioHang;
    }

    public void setSoLuongTrongGioHang(int soLuongTrongGioHang) {
        this.soLuongTrongGioHang = soLuongTrongGioHang;
    }

    @Override
    public String toString() {
        return "ChiTietSanPham{" + "id=" + id + ", maCTSP=" + maCTSP + ", id_SanPham=" + id_SanPham + ", giaBan=" + giaBan + ", soLuongCon=" + soLuongCon + ", id_MauSac=" + id_MauSac + ", id_KichCo=" + id_KichCo + ", id_Hang=" + id_Hang + ", id_ChatLieu=" + id_ChatLieu + ", id_CTSP_KhuyenMai=" + id_CTSP_KhuyenMai + ", ngayTao=" + ngayTao + ", ngaySuaCuoi=" + ngaySuaCuoi + ", trangThaiXoa=" + trangThaiXoa + ", mota=" + mota + ", maVach=" + maVach + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaCTSP() {
        return maCTSP;
    }

    public void setMaCTSP(String maCTSP) {
        this.maCTSP = maCTSP;
    }

    public String getId_SanPham() {
        return id_SanPham;
    }

    public void setId_SanPham(String id_SanPham) {
        this.id_SanPham = id_SanPham;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuongCon() {
        return soLuongCon;
    }

    public void setSoLuongCon(int soLuongCon) {
        this.soLuongCon = soLuongCon;
    }

    public String getId_MauSac() {
        return id_MauSac;
    }

    public void setId_MauSac(String id_MauSac) {
        this.id_MauSac = id_MauSac;
    }

    public String getId_KichCo() {
        return id_KichCo;
    }

    public void setId_KichCo(String id_KichCo) {
        this.id_KichCo = id_KichCo;
    }

    public String getId_Hang() {
        return id_Hang;
    }

    public void setId_Hang(String id_Hang) {
        this.id_Hang = id_Hang;
    }

    public String getId_ChatLieu() {
        return id_ChatLieu;
    }

    public void setId_ChatLieu(String id_ChatLieu) {
        this.id_ChatLieu = id_ChatLieu;
    }

    public String getId_CTSP_KhuyenMai() {
        return id_CTSP_KhuyenMai;
    }

    public void setId_CTSP_KhuyenMai(String id_CTSP_KhuyenMai) {
        this.id_CTSP_KhuyenMai = id_CTSP_KhuyenMai;
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

    public int getTrangThaiXoa() {
        return trangThaiXoa;
    }

    public void setTrangThaiXoa(int trangThaiXoa) {
        this.trangThaiXoa = trangThaiXoa;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getMaVach() {
        return maVach;
    }

    public void setMaVach(String maVach) {
        this.maVach = maVach;
    }

}
