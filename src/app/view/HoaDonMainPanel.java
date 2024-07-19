package app.view;//GEN-FIRST:event_btnInHoaDonActionPerformed
//GEN-LAST:event_btnInHoaDonActionPerformed
import app.dto.HoaDonChiTietDTO;
import app.dto.HoaDonDTO;
import app.model.HoaDon;
import app.service.HoaDonChiTietService;
import app.service.HoaDonService;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author admin
 */
public class HoaDonMainPanel extends javax.swing.JPanel {

    private HoaDonService hoaDonService = new HoaDonService();

    private HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietService();

    private DefaultTableModel defaultTableModelHoaDon;

    private DefaultTableModel defaultTableModelHoaDonChiTiet;

    private DefaultTableModel defaultTableModelLichSuHoaDon;
    
    private int idNhanVien = -1;
    
    /**
     * Creates new form HoaDonPanel
     */
    int rowTblHoaDon = -1;
    
    public HoaDonMainPanel() {
        initComponents();

        defaultTableModelHoaDon = (DefaultTableModel) tblHoaDon.getModel();

        defaultTableModelHoaDonChiTiet = (DefaultTableModel) tblHoaDonChiTiet.getModel();

        cboHinhThucThanhToan.removeAllItems();
        cboHinhThucThanhToan.addItem("Chọn");
        cboHinhThucThanhToan.addItem("TIEN_MAT");
        cboHinhThucThanhToan.addItem("CHUYEN_KHOAN");

        cboTrangThai.removeAllItems();
        cboTrangThai.addItem("Chọn");
        cboTrangThai.addItem("Đã Thanh Toán");
        cboTrangThai.addItem("Chưa Thanh Toán");
        cboTrangThai.addItem("Đã Hủy");

        fillTableHoaDon(hoaDonService.findAllHoaDon());

    }

    void fillTableHoaDon(List<HoaDonDTO> listHoaDon) {
        int i = 1;
        defaultTableModelHoaDon.setRowCount(0);
        for (HoaDonDTO hoaDon : listHoaDon) {
            defaultTableModelHoaDon.addRow(new Object[]{
                hoaDon.getHoaDonId(),
                hoaDon.getMaHoaDon(),
                hoaDon.getId_NhanVien(),
                hoaDon.getTenKhachHang(),
                hoaDon.getSdtKhachHang(),
                hoaDon.getNgayTao(),
                hoaDon.getNgayTao(),
                hoaDon.getThanhTien(),
                hoaDon.getTienKhachTra(),
                hoaDon.getTienThuaLai(),
                hoaDon.getGhiChu(),
                hoaDon.getTrangThaiThanhToan() == 1 ? "Đã thanh toán" : "Chưa thanh toán" ,
                hoaDon.getHinhThucThanhToan(),
                hoaDon.getMaVoucher() == null ? "None" : hoaDon.getMaVoucher()
            });
        }
    }

    private static void writeExcel(List<HoaDonDTO> listHoaDon) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Data");
        int rowNum = 0;

        // Create header row with meaningful column titles
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("ID Hóa Đơn");
        headerRow.createCell(1).setCellValue("ID Khách Hàng");
        headerRow.createCell(2).setCellValue("ID Nhân Viên");
        headerRow.createCell(3).setCellValue("Mã Hóa Đơn");
        headerRow.createCell(4).setCellValue("Tên Người Nhận");
        headerRow.createCell(5).setCellValue("Địa Chỉ Người Nhận");
        headerRow.createCell(6).setCellValue("Tiền Khách Trả");
        headerRow.createCell(7).setCellValue("Tiền Thừa/Lãi");
        headerRow.createCell(8).setCellValue("Thành Tiền");
        headerRow.createCell(9).setCellValue("Trạng Thái Xóa");
        headerRow.createCell(10).setCellValue("Ngày Tạo");
        headerRow.createCell(11).setCellValue("Ngày Sửa Cuối");
        headerRow.createCell(12).setCellValue("Ghi Chú");
        headerRow.createCell(13).setCellValue("Tên Nhân Viên");
        headerRow.createCell(14).setCellValue("Tên Khách Hàng");
        headerRow.createCell(15).setCellValue("Số Điện Thoại Khách Hàng");
        headerRow.createCell(16).setCellValue("Hình Thức Thanh Toán");

        // Populate data rows
        for (HoaDonDTO data : listHoaDon) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(data.getHoaDonId());
            row.createCell(1).setCellValue(data.getId_KhachHang());
            row.createCell(2).setCellValue(data.getId_NhanVien());
            row.createCell(3).setCellValue(data.getMaHoaDon());
            row.createCell(4).setCellValue(data.getTenNguoiNhan());
            row.createCell(5).setCellValue(data.getDiaChi());
            row.createCell(6).setCellValue(data.getTienKhachTra().toString());
            row.createCell(7).setCellValue(data.getTienThuaLai().toString());
            row.createCell(8).setCellValue(data.getThanhTien().toString());
            row.createCell(9).setCellValue(data.isTrangThaiXoa());
            row.createCell(10).setCellValue(data.getNgayTao());
            row.createCell(11).setCellValue(data.getNgaySuaCuoi());
            row.createCell(12).setCellValue(data.getGhiChu());
            row.createCell(13).setCellValue(data.getTenNhanVien());
            row.createCell(14).setCellValue(data.getTenKhachHang());
            row.createCell(15).setCellValue(data.getSdtKhachHang());
            row.createCell(16).setCellValue(data.getHinhThucThanhToan());
        }

        LocalDateTime currentDateTime = LocalDateTime.now();

        // Định dạng ngày giờ thành chuỗi theo ý muốn
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String formattedDateTime = currentDateTime.format(formatter);

        // Tạo tên file sử dụng ngày giờ hiện tại
        String fileName = "data_" + formattedDateTime + ".xlsx";
        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void fillTableHoaDonChiTiet(List<HoaDonChiTietDTO> hoaDonChiTietDTOs) {
        int i = 1;
        defaultTableModelHoaDonChiTiet.setRowCount(0);
        for (HoaDonChiTietDTO hoaDonChiTietDTO : hoaDonChiTietDTOs) {
            defaultTableModelHoaDonChiTiet.addRow(new Object[]{
                i++,
                hoaDonChiTietDTO.getId_CTSP(),
                hoaDonChiTietDTO.getId_HoaDon(),
                hoaDonChiTietDTO.getTenSanPham(),
                hoaDonChiTietDTO.getSoLuong(),
                hoaDonChiTietDTO.getGiaBan(),
                hoaDonChiTietDTO.getGiaBan() * hoaDonChiTietDTO.getSoLuong(),
                hoaDonChiTietDTO.getNgayTao()
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboTrangThai = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cboHinhThucThanhToan = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        dateTuNgay = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        dateDenNgay = new com.toedter.calendar.JDateChooser();
        btnXuatDanhSach = new javax.swing.JButton();
        btnInHoaDon = new javax.swing.JButton();
        btnLoc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnReload = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDonChiTiet = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("HÓA ĐƠN");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 0));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("Tìm Kiếm");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Trạng Thái");

        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Hình Thức Thanh Toán");

        cboHinhThucThanhToan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboHinhThucThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboHinhThucThanhToanActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Từ");

        dateTuNgay.setDateFormatString("yyyy-MM-dd");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Đến");

        dateDenNgay.setDateFormatString("yyyy-MM-dd");

        btnXuatDanhSach.setText("Xuất Danh Sách");
        btnXuatDanhSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatDanhSachActionPerformed(evt);
            }
        });

        btnInHoaDon.setText("In Hóa Đơn");
        btnInHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHoaDonActionPerformed(evt);
            }
        });

        btnLoc.setText("Lọc");
        btnLoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLocMouseClicked(evt);
            }
        });
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        tblHoaDon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã Hóa Đơn", "ID Nhân Viên", "Tên Khách Hàng", "Số ĐT", "Ngày Tạo", "Ngày Thanh Toán", "Tổng Tiền", "Tiền Khách Trả", "Tiền Thừa lại", "GHi Chú", "Trạng Thái", "Hình Thức TT", "Mã Voucher"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        btnReload.setText("Refesh");
        btnReload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReloadMouseClicked(evt);
            }
        });
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cboHinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addGap(12, 12, 12)
                                .addComponent(dateTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnXuatDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnInHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnReload, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnXuatDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnInHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(2, 2, 2)))
                    .addComponent(btnReload, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboHinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addComponent(dateTuNgay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateDenNgay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("HÓA ĐƠN");

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblHoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "ID CTSP", "ID Hóa Đơn", "Tên Sản Phẩm", "Số Lượng", "Gía", "Tổng tiền", "Ngày Tạo"
            }
        ));
        jScrollPane2.setViewportView(tblHoaDonChiTiet);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1232, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel9.setText("HÓA ĐƠN CHI TIẾT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel3))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Hóa Đơn", jPanel2);

        jLabel1.setText("Tab1");
        jTabbedPane1.addTab("", jLabel1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jTabbedPane1)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(581, 581, 581)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {                                          
        fillTableHoaDon(hoaDonService.findAllHoaDon());
        defaultTableModelHoaDonChiTiet.setRowCount(0);
    }                                         

    private void btnReloadMouseClicked(java.awt.event.MouseEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void tblHoaDonMouseEntered(java.awt.event.MouseEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {                                       
        rowTblHoaDon = tblHoaDon.getSelectedRow();

        String maHoaDon = tblHoaDon.getValueAt(rowTblHoaDon, 0).toString();
        //        HoaDonDTO hoaDon = hoaDonService.findHoaDonByMaHoaDon(maHoaDon);
        //        if (hoaDon == null) {
            //            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra.");
            //            return;
            //        }
        //        Integer idHoaDon = hoaDon.getHoaDonId();

        List<HoaDonChiTietDTO> hoaDonChiTietDTOList = hoaDonChiTietService.getHoaDonChiTietDTO(Integer.valueOf(maHoaDon));

        if (hoaDonChiTietDTOList == null || hoaDonChiTietDTOList.isEmpty()) {
            defaultTableModelHoaDonChiTiet.setRowCount(0);
            return;
        }
        fillTableHoaDonChiTiet(hoaDonChiTietDTOList);
    }                                      

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // Lọc theo ngày + lọc theo tháng năm ...
        String trangThai = cboTrangThai.getSelectedItem().toString();

        String hinhThucThanhToan = cboHinhThucThanhToan.getSelectedItem().toString();

        if (trangThai == "Chọn") {
            trangThai = null;
        }
        if (hinhThucThanhToan == "Chọn") {
            hinhThucThanhToan = null;
        }

        Date tuNgay = dateTuNgay.getDate();

        Date denNgay = dateDenNgay.getDate();

        if ( tuNgay != null && denNgay != null && tuNgay.compareTo(denNgay) > 0) {
            System.out.println("Ngày bắt đầu lớn hơn ngày kết thúc");
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu không được lớn hơn ngày kết thúc");
            return;
        } else if ( tuNgay != null && denNgay != null && tuNgay.compareTo(denNgay) < 0) {
            List<HoaDonDTO> hoaDonDTOs = hoaDonService.locTheoGiaTri(trangThai, hinhThucThanhToan, tuNgay, denNgay);
            fillTableHoaDon(hoaDonDTOs);
            return;
        } else {
            List<HoaDonDTO> hoaDonDTOs = hoaDonService.locTheoGiaTri(trangThai, hinhThucThanhToan, tuNgay, denNgay);
            fillTableHoaDon(hoaDonDTOs);
            return;
        }
    }                                      

    private void btnLocMouseClicked(java.awt.event.MouseEvent evt) {                                    
        String hinhThucThanhToan = cboHinhThucThanhToan.getSelectedItem().toString();
        Date tuNgay = dateTuNgay.getDate();
        Date denNgay = dateDenNgay.getDate();

        System.out.println(hinhThucThanhToan);
        System.out.println(tuNgay);
        System.out.println(denNgay);
    }                                   

    private void btnInHoaDonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if (tblHoaDonChiTiet.getRowCount() <= 0) {
            return;
        }
        if (rowTblHoaDon < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Hóa Đơn");
            return;
        }
        rowTblHoaDon = tblHoaDon.getSelectedRow();
        String maHoaDon = (String) tblHoaDon.getValueAt(rowTblHoaDon, 1);
        
        hoaDonService.inHoaDonRaPDF(maHoaDon);
        
        
    }                                           

    private void btnXuatDanhSachActionPerformed(java.awt.event.ActionEvent evt) {                                                
        try {
            writeExcel(hoaDonService.findAllHoaDon());
            JOptionPane.showMessageDialog(this, "Xuất Dữ Liệu ra Exel thành công");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Xuất danh sách thất bại");
        }
    }                                               

    private void cboHinhThucThanhToanActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
    }                                                    


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnInHoaDon;
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnXuatDanhSach;
    private javax.swing.JComboBox<String> cboHinhThucThanhToan;
    private javax.swing.JComboBox<String> cboTrangThai;
    private com.toedter.calendar.JDateChooser dateDenNgay;
    private com.toedter.calendar.JDateChooser dateTuNgay;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDonChiTiet;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration                   
}
