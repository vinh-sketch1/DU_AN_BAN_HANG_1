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
public class KhachHang {

    private int id;
    private String maKH;
    private String hoTen;
    private Date ngaySinh;
    private int gioiTinh;
    private String diaChi;
    private String sdt;
    private String email;
    private String capBac;
    private boolean trangThaiXoa;
    private Date ngayTao;
    private Date ngaySuaCuoi;

    public KhachHang() {
    }

    public KhachHang(int id, String maKH, String hoTen, Date ngaySinh, int gioiTinh, String diaChi, String sdt, String email, String capBac, boolean trangThaiXoa, Date ngayTao, Date ngaySuaCuoi) {
        this.id = id;
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.capBac = capBac;
        this.trangThaiXoa = trangThaiXoa;
        this.ngayTao = ngayTao;
        this.ngaySuaCuoi = ngaySuaCuoi;
    }

    public KhachHang(int id, String maKH, String hoTen, Date ngaySinh, int gioiTinh, String diaChi, String sdt, String email) {
        this.id = id;
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
    }

    public KhachHang(String maKH, String hoTen, Date ngaySinh, int gioiTinh, String diaChi, String sdt, String email) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCapBac() {
        return capBac;
    }

    public void setCapBac(String capBac) {
        this.capBac = capBac;
    }

    public boolean isTrangThaiXoa() {
        return trangThaiXoa;
    }

    public void setTrangThaiXoa(boolean trangThaiXoa) {
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

    public Object[] toDataRow() {
        return new Object[]{
            this.id, this.maKH, this.hoTen, this.ngaySinh, this.gioiTinh, this.email, this.sdt, this.diaChi, this.capBac, this.trangThaiXoa, this.ngayTao, this.ngaySuaCuoi
        };
    }

    @Override
    public String toString() {
        return "KhachHang{" + "id=" + id + ", maKH=" + maKH + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", sdt=" + sdt + ", email=" + email + ", capBac=" + capBac + ", trangThaiXoa=" + trangThaiXoa + ", ngayTao=" + ngayTao + ", ngaySuaCuoi=" + ngaySuaCuoi + '}';
    }

    private double tongTienMua;
    private int soLuongHDMua;

    public double getTongTienMua() {
        return tongTienMua;
    }

    public void setTongTienMua(double tongTienMua) {
        this.tongTienMua = tongTienMua;
    }

    public int getSoLuongHDMua() {
        return soLuongHDMua;
    }

    public void setSoLuongHDMua(int soLuongHDMua) {
        this.soLuongHDMua = soLuongHDMua;
    }

    public KhachHang(String maKH, String hoTen, Date ngaySinh, int gioiTinh, String diaChi, String sdt, double tongTienMua, int soLuongHDMua) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.tongTienMua = tongTienMua;
        this.soLuongHDMua = soLuongHDMua;
    }

    public KhachHang(String maKH, String hoTen, int gioiTinh, String sdt, double tongTienMua, int soLuongHDMua) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.tongTienMua = tongTienMua;
        this.soLuongHDMua = soLuongHDMua;
    }

}
