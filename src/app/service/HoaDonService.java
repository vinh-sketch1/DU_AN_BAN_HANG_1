/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.service;

import app.dto.HoaDonChiTietDTO;
import app.dto.HoaDonDTO;
import app.model.ChiTietSanPham;
import app.model.HoaDon;
import app.repository.HoaDonRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public class HoaDonService {

    PreparedStatement preparedStatement = null;

    ResultSet resultSet = null;

    String sql = "";

    Connection connection = null;

    private List<HoaDonDTO> hoaDonDTOs = null;

    private HoaDonRepository hoaDonRepository = new HoaDonRepository();

    private HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietService();

    public List<HoaDonDTO> findAllHoaDon() {
        try {
            hoaDonDTOs = new ArrayList<>();
            connection = DBConnect.getConnection();
            sql = "SELECT [HoaDon].id\n"
                    + "      ,id_KhachHang\n"
                    + "      ,id_NhanVien\n"
                    + "      ,maHoaDon\n"
                    + "      ,tenNguoiNhan\n"
                    + "      ,[HoaDon].diaChi\n"
                    + "      ,tienKhachTra\n"
                    + "      ,tienThuaLai\n"
                    + "      ,thanhTien\n"
                    + "      ,[HoaDon].trangThaiXoa\n"
                    + "      ,[HoaDon].ngayTao\n"
                    + "      ,[HoaDon].ngaySuaCuoi\n"
                    + "      ,ghiChu,\n"
                    + "	  NhanVien.hoTen,\n"
                    + "	  KhachHang.hoTen,\n"
                    + "	  KhachHang.SDT, hinhThucThanhToan, trangThaiThanhToan,Voucher.maVoucher, tienSauGiamGia  \n"
                    + "  FROM [dbo].[HoaDon] "
                    + " left join NhanVien on HoaDon.id_NhanVien = NhanVien.id "
                    + " left join KhachHang on KhachHang.id = HoaDon.id_KhachHang "
                    + " LEFT JOIN Voucher on Voucher.id = HoaDon.maVoucher order by HoaDon.ngayTao desc";

            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                HoaDonDTO hoaDonDTO = new HoaDonDTO(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getDouble(7),
                        resultSet.getDouble(8),
                        resultSet.getDouble(9),
                        resultSet.getBoolean(10),
                        resultSet.getDate(11),
                        resultSet.getDate(12),
                        resultSet.getString(13),
                        resultSet.getString(14),
                        resultSet.getString(15),
                        resultSet.getString(16),
                        resultSet.getString(17),
                        resultSet.getInt(18),
                        resultSet.getString(19),
                        resultSet.getDouble(20)
                );
                hoaDonDTOs.add(hoaDonDTO);

            }

            return hoaDonDTOs;
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
        return hoaDonDTOs;
    }
    
     public List<HoaDonDTO> findHoaDonByMaNhanVien(String maNhanVien) {
         hoaDonDTOs = new ArrayList<>();  
       try {
         
            connection = DBConnect.getConnection();
            sql = "SELECT [HoaDon].id\n"
                    + "      ,id_KhachHang\n"
                    + "      ,id_NhanVien\n"
                    + "      ,maHoaDon\n"
                    + "      ,tenNguoiNhan\n"
                    + "      ,[HoaDon].diaChi\n"
                    + "      ,tienKhachTra\n"
                    + "      ,tienThuaLai\n"
                    + "      ,thanhTien\n"
                    + "      ,[HoaDon].trangThaiXoa\n"
                    + "      ,[HoaDon].ngayTao\n"
                    + "      ,[HoaDon].ngaySuaCuoi\n"
                    + "      ,ghiChu,\n"
                    + "	  NhanVien.hoTen,\n"
                    + "	  KhachHang.hoTen,\n"
                    + "	  KhachHang.SDT, hinhThucThanhToan, trangThaiThanhToan,Voucher.maVoucher, tienSauGiamGia  \n"
                    + "  FROM [dbo].[HoaDon] "
                    + " left join NhanVien on HoaDon.id_NhanVien = NhanVien.id "
                    + " left join KhachHang on KhachHang.id = HoaDon.id_KhachHang "
                    + " LEFT JOIN Voucher on Voucher.id = HoaDon.maVoucher "
                    + " where NhanVien.maNV = ? "
                    + " order by HoaDon.ngayTao desc" ;

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, maNhanVien);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                HoaDonDTO hoaDonDTO = new HoaDonDTO(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getDouble(7),
                        resultSet.getDouble(8),
                        resultSet.getDouble(9),
                        resultSet.getBoolean(10),
                        resultSet.getDate(11),
                        resultSet.getDate(12),
                        resultSet.getString(13),
                        resultSet.getString(14),
                        resultSet.getString(15),
                        resultSet.getString(16),
                        resultSet.getString(17),
                        resultSet.getInt(18),
                        resultSet.getString(19),
                        resultSet.getDouble(20)
                );
                hoaDonDTOs.add(hoaDonDTO);
            }

            return hoaDonDTOs;
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
        return hoaDonDTOs;
    }

    public List<HoaDonDTO> locTheoGiaTri(String trangThai, String hinhThucThanhToan, Date tuNgay, Date denNgay) {
        List<HoaDonDTO> hoaDonDTOs = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnect.getConnection();
            hoaDonDTOs = new ArrayList<>();

            String sql = sql = "SELECT [HoaDon].id\n"
                    + "      ,id_KhachHang\n"
                    + "      ,id_NhanVien\n"
                    + "      ,maHoaDon\n"
                    + "      ,tenNguoiNhan\n"
                    + "      ,[HoaDon].diaChi\n"
                    + "      ,tienKhachTra\n"
                    + "      ,tienThuaLai\n"
                    + "      ,thanhTien\n"
                    + "      ,[HoaDon].trangThaiXoa\n"
                    + "      ,[HoaDon].ngayTao\n"
                    + "      ,[HoaDon].ngaySuaCuoi\n"
                    + "      ,ghiChu,\n"
                    + "	  NhanVien.hoTen,\n"
                    + "	  KhachHang.hoTen,\n"
                    + "	  KhachHang.SDT, hinhThucThanhToan, trangThaiThanhToan,Voucher.maVoucher, tienSauGiamGia  \n"
                    + "  FROM [dbo].[HoaDon] "
                    + " left join NhanVien on HoaDon.id_NhanVien = NhanVien.id "
                    + " left join KhachHang on KhachHang.id = HoaDon.id_KhachHang "
                    + " LEFT JOIN Voucher on Voucher.id = HoaDon.maVoucher";

            int count = 1;

            if (trangThai != null && !trangThai.isEmpty()) {
                sql += " WHERE trangThaiThanhToan = ?";
                count++;
            }

            if (hinhThucThanhToan != null && !hinhThucThanhToan.isEmpty()) {
                if (count > 1) {
                    sql += " AND hinhThucThanhToan = ?";
                } else {
                    sql += " WHERE hinhThucThanhToan = ?";
                }
                count++;
            }

            if (tuNgay != null && denNgay != null) {
                if (count > 1) {
                    sql += " AND [HoaDon].ngaySuaCuoi BETWEEN ? AND ?";
                } else {
                    sql += " WHERE [HoaDon].ngaySuaCuoi BETWEEN ? AND ?";
                }
            }
            
            sql += " order by HoaDon.ngayTao desc";

            preparedStatement = connection.prepareStatement(sql);
            count = 1;

            if (trangThai != null && !trangThai.isEmpty()) {
                preparedStatement.setString(count++, trangThai);
            }

            if (hinhThucThanhToan != null && !hinhThucThanhToan.isEmpty()) {
                preparedStatement.setString(count++, hinhThucThanhToan);
            }

            if (tuNgay != null && denNgay != null) {
                java.sql.Date sqlTuNgay = new java.sql.Date(tuNgay.getTime());
                java.sql.Date sqlDenNgay = new java.sql.Date(denNgay.getTime());
                preparedStatement.setDate(count++, sqlTuNgay);
                preparedStatement.setDate(count++, sqlDenNgay);
            }

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                HoaDonDTO hoaDonDTO = new HoaDonDTO(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getDouble(7),
                        resultSet.getDouble(8),
                        resultSet.getDouble(9),
                        resultSet.getBoolean(10),
                        resultSet.getDate(11),
                        resultSet.getDate(12),
                        resultSet.getString(13),
                        resultSet.getString(14),
                        resultSet.getString(15),
                        resultSet.getString(16),
                        resultSet.getString(17),
                        resultSet.getInt(18),
                        resultSet.getString(19),
                        resultSet.getDouble(20)
                );
                hoaDonDTOs.add(hoaDonDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hoaDonDTOs;
    }

    public List<HoaDonDTO> getHoaDonToDay() {
        List<HoaDonDTO> hoaDonDTOs = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnect.getConnection();
            hoaDonDTOs = new ArrayList<>();

            String sql = sql = "SELECT [HoaDon].id\n"
                    + "      ,id_KhachHang\n"
                    + "      ,id_NhanVien\n"
                    + "      ,maHoaDon\n"
                    + "      ,tenNguoiNhan\n"
                    + "      ,[HoaDon].diaChi\n"
                    + "      ,tienKhachTra\n"
                    + "      ,tienThuaLai\n"
                    + "      ,thanhTien\n"
                    + "      ,[HoaDon].trangThaiXoa\n"
                    + "      ,[HoaDon].ngayTao\n"
                    + "      ,[HoaDon].ngaySuaCuoi\n"
                    + "      ,ghiChu,\n"
                    + "	  NhanVien.hoTen,\n"
                    + "	  KhachHang.hoTen,\n"
                    + "	  KhachHang.SDT, hinhThucThanhToan, trangThaiThanhToan,Voucher.maVoucher, tienSauGiamGia  \n"
                    + "  FROM [dbo].[HoaDon] "
                    + " left join NhanVien on HoaDon.id_NhanVien = NhanVien.id "
                    + " left join KhachHang on KhachHang.id = HoaDon.id_KhachHang "
                    + " LEFT JOIN Voucher on Voucher.id = HoaDon.maVoucher "
                    + " WHERE CONVERT(DATE, [HoaDon].ngayTao) = CONVERT(DATE, GETDATE())";

            int count = 1;
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                HoaDonDTO hoaDonDTO = new HoaDonDTO(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getDouble(7),
                        resultSet.getDouble(8),
                        resultSet.getDouble(9),
                        resultSet.getBoolean(10),
                        resultSet.getDate(11),
                        resultSet.getDate(12),
                        resultSet.getString(13),
                        resultSet.getString(14),
                        resultSet.getString(15),
                        resultSet.getString(16),
                        resultSet.getString(17),
                        resultSet.getInt(18),
                        resultSet.getString(19),
                        resultSet.getDouble(20)
                );
                hoaDonDTOs.add(hoaDonDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hoaDonDTOs;
    }

    public String taoHoaDon(HoaDon hoaDon) {
        String maHoaDon = hoaDonRepository.taoHoaDonByHoaDon(hoaDon);
        System.out.println(maHoaDon);
        return maHoaDon;
    }

    public HoaDonDTO findHoaDonByMaHoaDon(String maHoaDon) {
        return hoaDonRepository.findHoaDonByMaHoaDon(maHoaDon);
    }
    
    public List<HoaDonDTO> findHoaDonByTenKhachHang(String tenKhachHang) {
        return hoaDonRepository.findHoaDonByTenKhachHang(tenKhachHang);
    }

    public int updateHoaDonByMaHoaDon(String maHoaDonUpdate) {
        return hoaDonRepository.updateHoaDonByMaHoaDon(maHoaDonUpdate);
    }

    public List<ChiTietSanPham> findChiTietSanPhamByMaHoaDon(String maHoaDon) {
        return hoaDonRepository.findChiTietSanPhamByMaHoaDon(maHoaDon);
    }

    public int updateHoaDonByHoaDonUpdate(HoaDonDTO hoaDonUpdate) {
        return hoaDonRepository.updateHoaDonByHoaDonDTO(hoaDonUpdate);
    }

    public void inHoaDonRaPDF(String maHoaDon) {
        List<HoaDonChiTietDTO> hoaDonChiTietDTOs = hoaDonChiTietService.getHoaDonChiTietDTOByMaHoaDon(maHoaDon);
        HoaDonDTO hoaDon = hoaDonRepository.findHoaDonByMaHoaDon(maHoaDon);
        System.out.println(hoaDon.toString());
        Document document = new Document();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateFormat.format(new Date());

        String pdfFile = "src/HoaDon/" + "hoadon_" + timestamp + ".pdf";

        try {
            PdfWriter.getInstance(document, new FileOutputStream(pdfFile));
            document.open();
            addContent(document, hoaDonChiTietDTOs, hoaDon);
            document.close();
            openPDFFile(pdfFile);
            System.out.println("PDF printed successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addContent(Document document, List<HoaDonChiTietDTO> hoaDonChiTietDTOs, HoaDonDTO hoaDon) throws DocumentException {
        // Thêm tiêu đề hóa đơn
        Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        Paragraph title = new Paragraph("THE HANS SHOP \nHOA DON MUA HANG", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        // Thêm thông tin hóa đơn
        Font infoFont = new Font(Font.FontFamily.TIMES_ROMAN, 12);
        Paragraph info = new Paragraph("Ngay thanh toan : " + hoaDon.getNgaySuaCuoi() + "\nMa Hoa Don : " + hoaDon.getMaHoaDon()
                + "\nKhach Hang : " + hoaDon.getTenKhachHang() + "\n\n");
        info.setFont(infoFont);
        document.add(info);

        // Tạo bảng danh sách sản phẩm
        PdfPTable table = new PdfPTable(4); // Số cột của bảng

        // Đặt tiêu đề cho các cột
        table.addCell("Ten San Pham");
        table.addCell("Don Gia");
        table.addCell("So Luong");
        table.addCell("Thanh Tien");

        // Thêm từng sản phẩm vào bảng
        for (HoaDonChiTietDTO chiTiet : hoaDonChiTietDTOs) {
            table.addCell(chiTiet.getTenSanPham());
            table.addCell(String.valueOf(chiTiet.getDonGia()));
            table.addCell(String.valueOf(chiTiet.getSoLuong()));
            table.addCell(String.valueOf(chiTiet.getDonGia() * chiTiet.getSoLuong()));
        }

        // Thêm bảng vào tài liệu
        document.add(table);

        // Thêm tổng cộng
        Paragraph total = new Paragraph("\nTong Cong: " + hoaDon.getThanhTien());
        total.setFont(infoFont);
        document.add(total);

        Paragraph tienKhachTra = new Paragraph("Tien Khach Tra: " + hoaDon.getTienKhachTra());
        tienKhachTra.setFont(infoFont);
        document.add(tienKhachTra);

        if (hoaDon.getMaVoucher() != null) {
            Paragraph vouCher = new Paragraph("Ma Voucher: " + hoaDon.getMaVoucher());
            vouCher.setFont(infoFont);
            document.add(vouCher);

            Paragraph tienDuocGiam = new Paragraph("Tien được giảm: " + (hoaDon.getThanhTien() - hoaDon.getTienSauGiamGia()));
            tienDuocGiam.setFont(infoFont);
            document.add(tienDuocGiam);
        }

        Paragraph tienSauGiamGia = new Paragraph("Tien cần thanh toán: " + hoaDon.getTienSauGiamGia());
        tienSauGiamGia.setFont(infoFont);
        document.add(tienSauGiamGia);
    }

    public static void openPDFFile(String filePath) {
        try {
            File file = new File(filePath);
            if (file.exists() && Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            } else {
                System.out.println("File not found or desktop operations not supported.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void truHangTonKhoTrongSanPham(List<ChiTietSanPham> listChiTietGioHang) {
//        
//    }
    public void truHangTonKhoTrongSanPham(List<ChiTietSanPham> listChiTietGioHang) {
        for (ChiTietSanPham chiTietSanPham : listChiTietGioHang) {
            hoaDonRepository.truSoLuongTrongSanPham(chiTietSanPham.getMaCTSP(), chiTietSanPham.getSoLuongTrongGioHang());
        }
    }

   

}
