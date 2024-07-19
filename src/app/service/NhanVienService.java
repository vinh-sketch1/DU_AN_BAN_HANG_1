/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.service;

import app.model.NhanVien;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;
import utils.Constant;

/**
 *
 * @author admin
 */
public class NhanVienService {

    List<NhanVien> listNV;

    PreparedStatement preparedStatement = null;

    ResultSet resultSet = null;

    String sql = "";

    Connection connection = null;

    public NhanVien dangNhap(String sdt, String matKhau) {

        try {
            connection = DBConnect.getConnection();
            sql = "SELECT [id]\n"
                    + "      ,[hoTen]\n"
                    + "      ,[ngaySinh]\n"
                    + "      ,[gioiTinh]\n"
                    + "      ,[diaChi]\n"
                    + "      ,[SDT]\n"
                    + "      ,[email]\n"
                    + "      ,[matKhau]\n"
                    + "      ,[vaiTro]\n"
                    + "      ,[trangThaiXoa]\n"
                    + "      ,[ngayTao]\n"
                    + "      ,[ngaySuaCuoi]\n, maNV"
                    + "  FROM [dbo].[NhanVien] WHERE SDT = ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, sdt);

            resultSet = preparedStatement.executeQuery();

            if (resultSet == null) {
                return null;
            }
            NhanVien nhanVien = null;
            while (resultSet.next()) {
                nhanVien = new NhanVien(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDate(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getBoolean(10),
                        resultSet.getDate(11),
                        resultSet.getDate(12), resultSet.getString(13));

            }
            if (nhanVien == null) {
                return null;
            }
            if (BCrypt.checkpw(matKhau, nhanVien.getMatKhau())) {
                return nhanVien;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public List<NhanVien> getAll() {
        List<NhanVien> listNV = new ArrayList<>();
        String sql = "SELECT id, maNV, hoTen, vaiTro, ngaySinh, gioiTinh, SDT, email, diaChi, matKhau, trangThaiXoa FROM NhanVien";
        try {
            connection = DBConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                NhanVien nv = new NhanVien(
                        resultSet.getInt("id"),
                        resultSet.getString("maNV"),
                        resultSet.getString("hoTen"),
                        resultSet.getDate("ngaySinh"),
                        resultSet.getInt("gioiTinh"),
                        resultSet.getString("diaChi"),
                        resultSet.getString("SDT"),
                        resultSet.getString("email"),
                        resultSet.getString("vaiTro"),
                        resultSet.getString("matKhau"),
                        resultSet.getBoolean("trangThaiXoa")
                );

                listNV.add(nv);
            }
            return listNV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int insertNV(NhanVien nv) {
        sql = "insert into NhanVien( maNV,hoTen,vaiTro,ngaySinh, gioiTinh,SDT, email, diaChi, matKhau, trangThaiXoa, ngayTao, ngaySuaCuoi )values(?,?,?,?,?,?,?,?,?, ?,getDate(),getDate())";
        try {
            connection = DBConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, nv.getMaNV());
            preparedStatement.setObject(2, nv.getHoTen());
            preparedStatement.setObject(3, nv.getVaiTro());
            preparedStatement.setObject(4, nv.getNgaySinh());
            preparedStatement.setObject(5, nv.getGioiTinh());
            preparedStatement.setObject(6, nv.getSdt());
            preparedStatement.setObject(7, nv.getEmail());
            preparedStatement.setObject(8, nv.getDiaChi());
            preparedStatement.setObject(9, nv.getMatKhau());
            preparedStatement.setObject(10, nv.isTrangThaiXoa());
            return preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return 0;
    }

    public int updateNhanVien(String ma, NhanVien nv) {
        sql = "update NhanVien set hoTen = ?, vaiTro = ?,ngaySinh = ?, gioiTinh=?, SDT = ?,email = ?, diaChi = ?, trangThaiXoa = ?, ngaySuaCuoi = getDate()  where maNV like ?";
        try {
            connection = DBConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(9, nv.getMaNV());
            preparedStatement.setObject(1, nv.getHoTen());
            preparedStatement.setObject(2, nv.getVaiTro());
            preparedStatement.setObject(3, nv.getNgaySinh());
            preparedStatement.setObject(4, nv.getGioiTinh());
            preparedStatement.setObject(5, nv.getSdt());
            preparedStatement.setObject(6, nv.getEmail());
            preparedStatement.setObject(7, nv.getDiaChi());
            preparedStatement.setObject(8, nv.isTrangThaiXoa());

            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int doiMatKhauNhanVien(String ma, String matKhauMoi) {
        sql = "update NhanVien set matKhau = ? where maNV = ?";
        try {
            connection = DBConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, matKhauMoi);
            preparedStatement.setObject(2, ma);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<NhanVien> timTheoTen(String ten) {
        try {
            listNV = new ArrayList<>();
            connection = DBConnect.getConnection();
            sql = "select id, maNV,hoTen, vaiTro, ngaySinh, gioiTinh, SDT, email, diaChi,matKhau, trangThaiXoa from NhanVien where hoTen like ?";
            preparedStatement = connection.prepareCall(sql);
            preparedStatement.setString(1, "%" + ten + "%");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                NhanVien nv = new NhanVien(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(5),
                        resultSet.getInt(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(4),
                        resultSet.getString(10),
                        resultSet.getBoolean(11)
                );
                listNV.add(nv);
            }
            return listNV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int deleteNV(String ma) {
        sql = "delete from KhachHang where maNV like ?";
        try {// xóa được 
            connection = DBConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ma);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public NhanVien timTheoSdt(String sdt) {
        try {
            connection = DBConnect.getConnection();
            sql = "select id, maNV,hoTen,ngaySinh,gioiTinh,diaChi ,SDT ,email ,vaiTro,matKhau, trangThaiXoa from NhanVien where SDT =  ? ";
            preparedStatement = connection.prepareCall(sql);
            preparedStatement.setString(1, sdt);
            resultSet = preparedStatement.executeQuery();
            NhanVien nv = null;
            while (resultSet.next()) {
                nv = new NhanVien(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4),
                        resultSet.getInt(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10),
                        resultSet.getBoolean(11)
                );
            }
            return nv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public NhanVien timTheoEmail(String email) {
        try {
            connection = DBConnect.getConnection();
            sql = "select id, maNV,hoTen, vaiTro, ngaySinh, gioiTinh, SDT, email, diaChi,matKhau, trangThaiXoa from NhanVien where email = ?";
            preparedStatement = connection.prepareCall(sql);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            NhanVien nv = null;
            while (resultSet.next()) {
                nv = new NhanVien(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(5),
                        resultSet.getInt(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(4),
                        resultSet.getString(10),
                        resultSet.getBoolean(11)
                );
            }
            return nv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public NhanVien timTheoMaNV(String maNV) {
        try {
            connection = DBConnect.getConnection();
            sql = "select id, maNV,hoTen, vaiTro, ngaySinh, gioiTinh, SDT, email, diaChi,matKhau, trangThaiXoa from NhanVien where maNV = ?";
            preparedStatement = connection.prepareCall(sql);
            preparedStatement.setString(1, maNV);
            resultSet = preparedStatement.executeQuery();
            NhanVien nv = null;
            while (resultSet.next()) {
                nv = new NhanVien(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(5),
                        resultSet.getInt(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(4),
                        resultSet.getString(10),
                        resultSet.getBoolean(11)
                );
            }
            return nv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String matKhauHash = BCrypt.hashpw("123", BCrypt.gensalt(Constant.saltRoundPassword));

        String matKhauHashhNhapVao = "123";
        System.out.println(matKhauHash);

        if (BCrypt.checkpw(matKhauHashhNhapVao, matKhauHash)) {
            System.out.println("ok");
        } else {
            System.out.println("k ok");
        }
    }

}
