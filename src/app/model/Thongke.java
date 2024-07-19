package app.model;

import java.util.Date;

public class Thongke {

    private Date thang;
    private String ten;
    private int soLuong;
    private int tongTien;
    private String maChiTietSanPham;
    
    private String thangString;

    public Thongke() {

    }

    public Thongke(int soLuong, String ten) {
        this.soLuong = soLuong;
        this.ten = ten;
    }

    public Thongke(String ten, int soLuong, int tongTien, String maChiTietSanPham) {
        this.ten = ten;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.maChiTietSanPham = maChiTietSanPham;
    }
    
    
    
    
    

    public Thongke(Date thang, String ten, int soLuong, int tongTien) {
        this.thang = thang;
        this.ten = ten;
        this.soLuong = soLuong;
        this.tongTien = tongTien;

    }

    public Date getThang() {
        return thang;
    }

    public void setThang(Date thang) {
        this.thang = thang;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public String getThangString() {
        return thangString;
    }

    public void setThangString(String thangString) {
        this.thangString = thangString;
    }

    public String getMaChiTietSanPham() {
        return maChiTietSanPham;
    }

    public void setMaChiTietSanPham(String maChiTietSanPham) {
        this.maChiTietSanPham = maChiTietSanPham;
    }

    @Override
    public String toString() {
        return "Thongke{" + "thang=" + thang + ", ten=" + ten + ", soLuong=" + soLuong + ", tongTien=" + tongTien + ", maChiTietSanPham=" + maChiTietSanPham + ", thangString=" + thangString + '}';
    }
    
    


    public Object[] toDataRow() {
        return new Object[]{this.getThang(), this.getTen(), this.getSoLuong(), 
            this.getTongTien()};
    }

   

}
