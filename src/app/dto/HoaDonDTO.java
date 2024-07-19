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
public class HoaDonDTO {
    
    private int hoaDonId;
    private int id_KhachHang;
    private int id_NhanVien;
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
    private String tenNhanVien;
    private String tenKhachHang;
    private String sdtKhachHang;
    private String hinhThucThanhToan;
    private Integer trangThaiThanhToan;
    private String maVoucher;
    private Double tienSauGiamGia;
    private Integer idVoucher;
    
    

    public HoaDonDTO() {
    }

    
    
    public HoaDonDTO(int hoaDonId, int id_KhachHang, int id_NhanVien, String maHoaDon, String tenNguoiNhan, String diaChi, Double tienKhachTra, Double tienThuaLai, Double thanhTien, boolean trangThaiXoa, Date ngayTao, Date ngaySuaCuoi, String ghiChu, String tenNhanVien, String tenKhachHang, String sdtKhachHang) {
        this.hoaDonId = hoaDonId;
        this.id_KhachHang = id_KhachHang;
        this.id_NhanVien = id_NhanVien;
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
        this.tenNhanVien = tenNhanVien;
        this.tenKhachHang = tenKhachHang;
        this.sdtKhachHang = sdtKhachHang;
    }

    public HoaDonDTO(int hoaDonId, int id_KhachHang, int id_NhanVien, String maHoaDon, String tenNguoiNhan, String diaChi, Double tienKhachTra, Double tienThuaLai, Double thanhTien, boolean trangThaiXoa, Date ngayTao, Date ngaySuaCuoi, String ghiChu, String tenNhanVien, String tenKhachHang, String sdtKhachHang, String hinhThucThanhToan) {
        this.hoaDonId = hoaDonId;
        this.id_KhachHang = id_KhachHang;
        this.id_NhanVien = id_NhanVien;
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
        this.tenNhanVien = tenNhanVien;
        this.tenKhachHang = tenKhachHang;
        this.sdtKhachHang = sdtKhachHang;
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public HoaDonDTO(int hoaDonId, int id_KhachHang, int id_NhanVien, String maHoaDon, String tenNguoiNhan, String diaChi, Double tienKhachTra, Double tienThuaLai, Double thanhTien, boolean trangThaiXoa, Date ngayTao, Date ngaySuaCuoi, String ghiChu, String tenNhanVien, String tenKhachHang, String sdtKhachHang, String hinhThucThanhToan, Integer trangThaiThanhToan) {
        this.hoaDonId = hoaDonId;
        this.id_KhachHang = id_KhachHang;
        this.id_NhanVien = id_NhanVien;
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
        this.tenNhanVien = tenNhanVien;
        this.tenKhachHang = tenKhachHang;
        this.sdtKhachHang = sdtKhachHang;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.trangThaiThanhToan = trangThaiThanhToan;
    }

    public HoaDonDTO(int hoaDonId, int id_KhachHang, int id_NhanVien, String maHoaDon, String tenNguoiNhan, String diaChi, Double tienKhachTra, Double tienThuaLai, Double thanhTien, boolean trangThaiXoa, Date ngayTao, Date ngaySuaCuoi, String ghiChu, String tenNhanVien, String tenKhachHang, String sdtKhachHang, String hinhThucThanhToan, Integer trangThaiThanhToan, String maVoucher) {
        this.hoaDonId = hoaDonId;
        this.id_KhachHang = id_KhachHang;
        this.id_NhanVien = id_NhanVien;
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
        this.tenNhanVien = tenNhanVien;
        this.tenKhachHang = tenKhachHang;
        this.sdtKhachHang = sdtKhachHang;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.trangThaiThanhToan = trangThaiThanhToan;
        this.maVoucher = maVoucher;
    }

    public HoaDonDTO(int hoaDonId, int id_KhachHang, int id_NhanVien, String maHoaDon, String tenNguoiNhan, String diaChi, Double tienKhachTra, Double tienThuaLai, Double thanhTien, boolean trangThaiXoa, Date ngayTao, Date ngaySuaCuoi, String ghiChu, String tenNhanVien, String tenKhachHang, String sdtKhachHang, String hinhThucThanhToan, Integer trangThaiThanhToan, String maVoucher, Double tienSauGiamGia) {
        this.hoaDonId = hoaDonId;
        this.id_KhachHang = id_KhachHang;
        this.id_NhanVien = id_NhanVien;
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
        this.tenNhanVien = tenNhanVien;
        this.tenKhachHang = tenKhachHang;
        this.sdtKhachHang = sdtKhachHang;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.trangThaiThanhToan = trangThaiThanhToan;
        this.maVoucher = maVoucher;
        this.tienSauGiamGia = tienSauGiamGia;
    }
    
    
    
    
    public int getHoaDonId() {
        return hoaDonId;
    }

    public void setHoaDonId(int hoaDonId) {
        this.hoaDonId = hoaDonId;
    }

    public int getId_KhachHang() {
        return id_KhachHang;
    }

    public void setId_KhachHang(int id_KhachHang) {
        this.id_KhachHang = id_KhachHang;
    }

    public int getId_NhanVien() {
        return id_NhanVien;
    }

    public void setId_NhanVien(int id_NhanVien) {
        this.id_NhanVien = id_NhanVien;
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

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSdtKhachHang() {
        return sdtKhachHang;
    }

    public void setSdtKhachHang(String sdtKhachHang) {
        this.sdtKhachHang = sdtKhachHang;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public Integer getTrangThaiThanhToan() {
        return trangThaiThanhToan;
    }

    public void setTrangThaiThanhToan(Integer trangThaiThanhToan) {
        this.trangThaiThanhToan = trangThaiThanhToan;
    }

    public String getMaVoucher() {
        return maVoucher;
    }

    public void setMaVoucher(String maVoucher) {
        this.maVoucher = maVoucher;
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
        return "HoaDonDTO{" + "hoaDonId=" + hoaDonId + ", id_KhachHang=" + id_KhachHang + ", id_NhanVien=" + id_NhanVien + ", maHoaDon=" + maHoaDon + ", tenNguoiNhan=" + tenNguoiNhan + ", diaChi=" + diaChi + ", tienKhachTra=" + tienKhachTra + ", tienThuaLai=" + tienThuaLai + ", thanhTien=" + thanhTien + ", trangThaiXoa=" + trangThaiXoa + ", ngayTao=" + ngayTao + ", ngaySuaCuoi=" + ngaySuaCuoi + ", ghiChu=" + ghiChu + ", tenNhanVien=" + tenNhanVien + ", tenKhachHang=" + tenKhachHang + ", sdtKhachHang=" + sdtKhachHang + ", hinhThucThanhToan=" + hinhThucThanhToan + ", trangThaiThanhToan=" + trangThaiThanhToan + ", maVoucher=" + maVoucher + ", tienSauGiamGia=" + tienSauGiamGia + ", idVoucher=" + idVoucher + '}';
    }
    
    
    
    

}
