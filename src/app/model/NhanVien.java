/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class NhanVien {

    private int id;
    
    private String maNV;
    
    private String hoTen;
    
    private Date ngaySinh;
    
    private int gioiTinh;
    
    private String diaChi;
    
    private String sdt;
    
    private String email;
    
    private String matKhau;
    
    private String vaiTro;
    
    private boolean trangThaiXoa;
    
    private Date ngayTao;
    
    private Date ngaySuaCuoi;

    public NhanVien() {
    }

    public NhanVien(int id, String hoTen, Date ngaySinh, int gioiTinh, String diaChi, String sdt, String email, String matKhau, String vaiTro, boolean trangThaiXoa, Date ngayTao, Date ngaySuaCuoi, String maNV) {
        this.id = id;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.trangThaiXoa = trangThaiXoa;
        this.ngayTao = ngayTao;
        this.ngaySuaCuoi = ngaySuaCuoi;
        this.maNV = maNV;
    }
 
    public NhanVien(String maNV, String hoTen, Date ngaySinh, int gioiTinh, String diaChi, String sdt, String email, String vaiTro, String matKhau, Boolean trangThaiXoa) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.vaiTro = vaiTro;
        this.matKhau = matKhau;
         this.trangThaiXoa = trangThaiXoa;
    }
    
    public NhanVien(int id, String maNV, String hoTen, Date ngaySinh, int gioiTinh, String diaChi, String sdt, String email, String matKhau, String vaiTro, boolean trangThaiXoa, Date ngayTao, Date ngaySuaCuoi) {
        this.id = id;
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.trangThaiXoa = trangThaiXoa;
        this.ngayTao = ngayTao;
        this.ngaySuaCuoi = ngaySuaCuoi;
    }

    public NhanVien(int id, String maNV, String hoTen, Date ngaySinh, int gioiTinh, String diaChi, String sdt, String email, String vaiTro, String matKhau, Boolean trangThaiXoa) {
        this.id = id;
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.vaiTro = vaiTro;
        this.matKhau = matKhau;
        this.trangThaiXoa = trangThaiXoa;
        
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

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
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

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    
    
    @Override
    public String toString() {
        return "NhanVien{" + "id=" + id + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", sdt=" + sdt + ", email=" + email + ", matKhau=" + matKhau + ", vaiTro=" + vaiTro + ", trangThaiXoa=" + trangThaiXoa + ", ngayTao=" + ngayTao + ", ngaySuaCuoi=" + ngaySuaCuoi + '}';
    }
    
    public Object[] toDataRow() {
        return new Object[]{this.id, this.maNV, this.hoTen,this.vaiTro, this.ngaySinh, this.gioiTinh, this.diaChi,this.sdt, this.email, this.trangThaiXoa,  this.matKhau,  this.trangThaiXoa, this.ngayTao,this.ngaySuaCuoi
        };
    }
    
    
}

