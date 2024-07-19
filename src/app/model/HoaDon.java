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
public class HoaDon {
    private int id;
    
    private int idKhachHang;
    
    private int idNhanVien;
    
    private String maHoaDon;
    
    private String tenNguoiNhan;
    
    private String diaChi;
    
    private Double tienKhachTra;
    
    private Double tienThuaLai;
    
    private Double thanhTien;
    
    private boolean trangThaiXoa;
    
    private Date ngayTao;
    
    private Date ngaySuaCuoi;
    
    private String ghiChu;
    
    private String hinhThucThanhToan;
    
    
    private Double tienSauGiamGia;
    
    private int trangThaiThanhToan;
    
    private String maVoucher;
    
    private Integer idVoucher;

    public HoaDon(int id, int idKhachHang, int idNhanVien, String maHoaDon, String tenNguoiNhan, String diaChi, Double tienKhachTra, Double tienThuaLai, Double thanhTien, boolean trangThaiXoa, Date ngayTao, Date ngaySuaCuoi, String ghiChu, String hinhThucThanhToan, Double tienSauGiamGia, int trangThaiThanhToan, String maVoucher) {
        this.id = id;
        this.idKhachHang = idKhachHang;
        this.idNhanVien = idNhanVien;
        this.maHoaDon = maHoaDon;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.tienKhachTra = tienKhachTra;
        this.tienThuaLai = tienThuaLai;
        this.thanhTien = thanhTien;
        this.trangThaiXoa = trangThaiXoa;
        this.ngayTao = ngayTao;
        this.ngaySuaCuoi = ngaySuaCuoi;
        this.ghiChu = ghiChu;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.tienSauGiamGia = tienSauGiamGia;
        this.trangThaiThanhToan = trangThaiThanhToan;
        this.maVoucher = maVoucher;
    }

    public HoaDon() {
    }

    public HoaDon(int id, int idKhachHang, int idNhanVien, String maHoaDon, String tenNguoiNhan, String diaChi, Double tienKhachTra, Double tienThuaLai, Double thanhTien, boolean trangThaiXoa, Date ngayTao, Date ngaySuaCuoi, String ghiChu) {
        this.id = id;
        this.idKhachHang = idKhachHang;
        this.idNhanVien = idNhanVien;
        this.maHoaDon = maHoaDon;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.tienKhachTra = tienKhachTra;
        this.tienThuaLai = tienThuaLai;
        this.thanhTien = thanhTien;
        this.trangThaiXoa = trangThaiXoa;
        this.ngayTao = ngayTao;
        this.ngaySuaCuoi = ngaySuaCuoi;
        this.ghiChu = ghiChu;
    }

    public HoaDon(int id, int idKhachHang, int idNhanVien, String maHoaDon, String tenNguoiNhan, String diaChi, Double tienKhachTra, Double tienThuaLai, Double thanhTien, boolean trangThaiXoa, Date ngayTao, Date ngaySuaCuoi, String ghiChu, String hinhThucThanhToan) {
        this.id = id;
        this.idKhachHang = idKhachHang;
        this.idNhanVien = idNhanVien;
        this.maHoaDon = maHoaDon;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.tienKhachTra = tienKhachTra;
        this.tienThuaLai = tienThuaLai;
        this.thanhTien = thanhTien;
        this.trangThaiXoa = trangThaiXoa;
        this.ngayTao = ngayTao;
        this.ngaySuaCuoi = ngaySuaCuoi;
        this.ghiChu = ghiChu;
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public HoaDon(int id, int idKhachHang, int idNhanVien, String maHoaDon, String tenNguoiNhan, String diaChi, Double tienKhachTra, Double tienThuaLai, Double thanhTien, boolean trangThaiXoa, Date ngayTao, Date ngaySuaCuoi, String ghiChu, String hinhThucThanhToan, Double tienSauGiamGia, int trangThaiThanhToan, String maVoucher, Integer idVoucher) {
        this.id = id;
        this.idKhachHang = idKhachHang;
        this.idNhanVien = idNhanVien;
        this.maHoaDon = maHoaDon;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.tienKhachTra = tienKhachTra;
        this.tienThuaLai = tienThuaLai;
        this.thanhTien = thanhTien;
        this.trangThaiXoa = trangThaiXoa;
        this.ngayTao = ngayTao;
        this.ngaySuaCuoi = ngaySuaCuoi;
        this.ghiChu = ghiChu;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.tienSauGiamGia = tienSauGiamGia;
        this.trangThaiThanhToan = trangThaiThanhToan;
        this.maVoucher = maVoucher;
        this.idVoucher = idVoucher;
    }
    
    

    public int getTrangThaiThanhToan() {
        return trangThaiThanhToan;
    }

    public void setTrangThaiThanhToan(int trangThaiThanhToan) {
        this.trangThaiThanhToan = trangThaiThanhToan;
    }

    public String getMaVoucher() {
        return maVoucher;
    }

    public void setMaVoucher(String maVoucher) {
        this.maVoucher = maVoucher;
    }

    public HoaDon(int id, int idKhachHang, int idNhanVien, String maHoaDon, String tenNguoiNhan, String diaChi, Double tienKhachTra, Double tienThuaLai, Double thanhTien, boolean trangThaiXoa, Date ngayTao, Date ngaySuaCuoi, String ghiChu, String hinhThucThanhToan, Double tienSauGiamGia) {
        this.id = id;
        this.idKhachHang = idKhachHang;
        this.idNhanVien = idNhanVien;
        this.maHoaDon = maHoaDon;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.tienKhachTra = tienKhachTra;
        this.tienThuaLai = tienThuaLai;
        this.thanhTien = thanhTien;
        this.trangThaiXoa = trangThaiXoa;
        this.ngayTao = ngayTao;
        this.ngaySuaCuoi = ngaySuaCuoi;
        this.ghiChu = ghiChu;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.tienSauGiamGia = tienSauGiamGia;
    }
    
    
    

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

   
    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Double getTienKhachTra() {
        return tienKhachTra;
    }

    public void setTienKhachTra(Double tienKhachTra) {
        this.tienKhachTra = tienKhachTra;
    }

    public Double getTienThuaLai() {
        return tienThuaLai;
    }

    public void setTienThuaLai(Double tienThuaLai) {
        this.tienThuaLai = tienThuaLai;
    }

    public Double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
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

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public Double getTienSauGiamGia() {
        return tienSauGiamGia;
    }

    public void setTienSauGiamGia(Double tienSauGiamGia) {
        this.tienSauGiamGia = tienSauGiamGia;
    }

    public Integer getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(Integer idVoucher) {
        this.idVoucher = idVoucher;
    }
    
   
    @Override
    public String toString() {
        return "HoaDon{" + "id=" + id + ", idKhachHang=" + idKhachHang + ", idNhanVien=" + idNhanVien + ", maHoaDon=" + maHoaDon + ", tenNguoiNhan=" + tenNguoiNhan + ", diaChi=" + diaChi + ", tienKhachTra=" + tienKhachTra + ", tienThuaLai=" + tienThuaLai + ", thanhTien=" + thanhTien + ", trangThaiXoa=" + trangThaiXoa + ", ngayTao=" + ngayTao + ", ngaySuaCuoi=" + ngaySuaCuoi + '}';
    }
      
}
