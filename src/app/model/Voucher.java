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
public class Voucher {
    private int id;
    private String ten;
    private String ma;
    private String loaiGiam;
    private Date ngayBD;
    private Date ngayKT;
    private int Giatri;

    public Voucher() {
    }

    public Voucher(int id, String ten, String ma, String loaiGiam, Date ngayBD, Date ngayKT, int Giatri) {
        this.id = id;
        this.ten = ten;
        this.ma = ma;
        this.loaiGiam = loaiGiam;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.Giatri = Giatri;
    }

    public Voucher(String ten, String ma, String loaiGiam, Date ngayBD, Date ngayKT, int Giatri) {
        this.ten = ten;
        this.ma = ma;
        this.loaiGiam = loaiGiam;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.Giatri = Giatri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getLoaiGiam() {
        return loaiGiam;
    }

    public void setLoaiGiam(String loaiGiam) {
        this.loaiGiam = loaiGiam;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    public int getGiatri() {
        return Giatri;
    }

    public void setGiatri(int Giatri) {
        this.Giatri = Giatri;
    }

    @Override
    public String toString() {
        return "Voucher{" + "id=" + id + ", ten=" + ten + ", ma=" + ma + ", loaiGiam=" + loaiGiam + ", ngayBD=" + ngayBD + ", ngayKT=" + ngayKT + ", Giatri=" + Giatri + '}';
    }

    
    public Object[] toDataRow() {
        return new Object[]{this.getId(), this.getMa(), this.getTen(),
            this.getLoaiGiam(), this.getGiatri(), this.getNgayBD(),
            this.getNgayKT()};
    }
    
}
