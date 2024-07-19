package app.view;

import app.model.KhuyenMai;
import app.model.Voucher;
import app.service.KhuyenMaiService;
import app.service.VoucherService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.Constant;

public class KhuyenMaiMainPanel extends javax.swing.JPanel {

    private VoucherService ss = new VoucherService();
    private DefaultTableModel dtm = new DefaultTableModel();
    private List<Voucher> listKM = new ArrayList<>();
    private int index = -1;

    public KhuyenMaiMainPanel() {
        initComponents();
        cboLoaiGiamInsert.removeAllItems();
        cboLoaiGiamInsert.addItem("Dành Cho Khách Hàng");
        cboLoaiGiamInsert.addItem("Dành Cho Tất Cả");

        fillTable(ss.getAll());
    }

    private void fillTable(List<Voucher> m) {
        dtm = (DefaultTableModel) tblQLPGG.getModel();
        dtm.setRowCount(0);
        for (Voucher x : m) {
            dtm.addRow(x.toDataRow());
        }
    }

    private void showData(int index) {
        txtMa.setText(tblQLPGG.getValueAt(index, 1).toString());
        txtTen.setText(tblQLPGG.getValueAt(index, 2).toString());
        txtGtriAD.setText(tblQLPGG.getValueAt(index, 4).toString());
        try {
            Date date1 = new SimpleDateFormat("yyyy-MM-dd")
                    .parse(tblQLPGG.getValueAt(index, 5).toString());
            dataTuNgay.setDate(date1);
            Date date2 = new SimpleDateFormat("yyyy-MM-dd")
                    .parse(tblQLPGG.getValueAt(index, 6).toString());
            dataDenNgay.setDate(date2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        cboLoaiGiamInsert.setSelectedItem(tblQLPGG.getValueAt(index, 3).toString());

    }

    Voucher readForm() {
        String ma, ten, loai;
        ma = txtMa.getText().trim();
        if (ma == null || ma.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Mã không được để trống");
            return null;
        }
        if (!Constant.checkDoDaiCuaChuoi(ma)) {
            JOptionPane.showMessageDialog(this, "Độ dài của mã không hợp lệ. Từ 3-50 kí tự !");
            return null;
        }
        ten = txtTen.getText().trim();
        if (ten == null || ten.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Tên không được để trống");
            return null;
        }
        if (!Constant.checkDoDaiCuaChuoi(ten)) {
            JOptionPane.showMessageDialog(this, "Độ dài của tên không hợp lệ. Từ 3-50 kí tự !");
            return null;
        }
        if (txtGtriAD.getText() == null || txtGtriAD.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Gía trị không được để trống");
            return null;
        }
        int gtri = 0;
        try {
            gtri = Integer.parseInt(txtGtriAD.getText().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gía trị không hợp lệ !");
            return null;
        }
        if (gtri > 99) {
            JOptionPane.showMessageDialog(this,
                    "Gía trị giảm giá không thể vượt quá 99%");
            return null;
        }
        if (gtri < 1) {
            JOptionPane.showMessageDialog(this,
                    "Gía trị giảm giá không thể thấp hơn 1%");
            return null;
        }

        loai = cboLoaiGiamInsert.getSelectedItem().toString();
        Date start_Date = dataTuNgay.getDate();
        if (start_Date == null) {
            JOptionPane.showMessageDialog(this,
                    "Ngày bắt đầu không hợp lệ !");
            return null;
        }
        Date end_Date = dataDenNgay.getDate();
        if (end_Date == null) {
            JOptionPane.showMessageDialog(this,
                    "Ngày bắt đầu không hợp lệ !");
            return null;
        }
        if (end_Date.getTime() < start_Date.getTime()) {
            JOptionPane.showMessageDialog(this,
                    "Ngày kết thúc phải sau ngày bắt đầu!");
            return null;
        }

        Date currentDate = new Date();
        try {
            if (end_Date.before(currentDate)) {
                JOptionPane.showMessageDialog(this,
                        "Ngày kết thúc không hợp lệ!");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Voucher(ten, ma, loai, start_Date, end_Date, gtri);
    }

    private boolean kiemTraChuoi(String chuoiChinhQuy, String ChuoiKiemTra) {
        if (ChuoiKiemTra.equals("")) {
            JOptionPane.showMessageDialog(this, "không được để trống ô nhập");
            return false;
        }
        if (ChuoiKiemTra.matches(chuoiChinhQuy)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        cboLoaiGiamInsert = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtGtriAD = new javax.swing.JTextField();
        dataTuNgay = new com.toedter.calendar.JDateChooser();
        dataDenNgay = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        LamMoiForm = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQLPGG = new javax.swing.JTable();
        txtTimkiem = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lamMoiTable = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "QUẢN LÝ PHIẾU GIẢM GIÁ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Mã voucher: ");

        jLabel2.setText("Loại giảm giá: ");

        jLabel3.setText("Tên voucher: ");

        cboLoaiGiamInsert.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dành Cho Khách Hàng", "Dành Cho Tất Cả" }));
        cboLoaiGiamInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiGiamInsertActionPerformed(evt);
            }
        });

        jLabel5.setText("Giá trị được áp dụng (%) : ");

        jLabel6.setText("Ngày bắt đầu: ");

        jLabel7.setText("Ngày kết thúc: ");

        dataTuNgay.setDateFormatString("yyyy-MM-dd");

        dataDenNgay.setDateFormatString("yyyy-MM-dd");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        LamMoiForm.setText("Làm mới");
        LamMoiForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LamMoiFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LamMoiForm, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnThem)
                .addGap(27, 27, 27)
                .addComponent(btnSua)
                .addGap(18, 18, 18)
                .addComponent(LamMoiForm)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboLoaiGiamInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtMa))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel3)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dataDenNgay, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(txtTen)
                    .addComponent(txtGtriAD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(dataTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(cboLoaiGiamInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtGtriAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(dataDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phiếu giảm giá", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel8.setText("Tìm kiếm theo mã: ");

        tblQLPGG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã", "Tên", "Loại giảm", "Giá trị được áp dụng", "Ngày bắt đầu", "Ngày kết thúc"
            }
        ));
        tblQLPGG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLPGGMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblQLPGG);

        jButton1.setText("Tìm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lamMoiTable.setText("Làm mới");
        lamMoiTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lamMoiTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(36, 36, 36)
                .addComponent(lamMoiTable)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1061, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(lamMoiTable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblQLPGGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLPGGMouseClicked
        // TODO add your handling code here:
        int row = tblQLPGG.getSelectedRow();
        showData(row);

    }//GEN-LAST:event_tblQLPGGMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (Constant.NHAN_VIEN.getVaiTro().equalsIgnoreCase("Nhân viên")) {
            JOptionPane.showMessageDialog(this, "Chỉ Quản lý mới có quyền thêm voucher");
            return;
        }
        int check = JOptionPane.showConfirmDialog(this, "Bạn chắn chắn ?");
        if (check != JOptionPane.YES_OPTION) {
            return;
        }

        // Check Ma Khuyến mãi đã tồn tại chưa
        Voucher voucherExits = this.readForm();
        if (voucherExits == null) {
            return;
        }
        Voucher voucher = ss.findKhuyenMaiByMaKhuyenMai(this.readForm().getMa());
        if (voucher != null) {
            JOptionPane.showMessageDialog(this, "Mã voucher đã tồn tại");
            return;
        }

        if (ss.AddKM(this.readForm()) > 0) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            this.fillTable(ss.getAll());
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại ");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (Constant.NHAN_VIEN.getVaiTro().equalsIgnoreCase("Nhân viên")) {
            JOptionPane.showMessageDialog(this, "Chỉ Quản lý mới có quyền thêm voucher");
            return;
        }
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa không");

        if (check != JOptionPane.YES_OPTION) {
            return;
        }
        index = tblQLPGG.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "bạn chưa chọn sửa");
        } else {

            String ma = tblQLPGG.getValueAt(index, 1).toString();

            Voucher km = readForm();
            if (km == null) {
                return;
            }
            if (ss.updateKM(ma, km) > 0) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                this.fillTable(ss.getAll());
            } else {
                JOptionPane.showConfirmDialog(this, "Sửa thất bại");
            }
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void cboLoaiGiamInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiGiamInsertActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboLoaiGiamInsertActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (!kiemTraChuoi("^[a-zA-Z0-9 ]{1,19}$", txtTimkiem.getText())) {
            JOptionPane.showMessageDialog(this, "mã voucher là chữ ko dấu ít hơn 20 kí tự");
            return;
        }
        fillTable(ss.timKiemTheoMa(txtTimkiem.getText()));


    }//GEN-LAST:event_jButton1ActionPerformed

    private void LamMoiFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LamMoiFormActionPerformed
        txtMa.setText("");
        txtTen.setText("");
        txtGtriAD.setText("");
        dataTuNgay.setDate(null);
        dataDenNgay.setDate(null);
        

    }//GEN-LAST:event_LamMoiFormActionPerformed

    private void lamMoiTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lamMoiTableActionPerformed
        fillTable(ss.getAll());
        txtTimkiem.setText("");
    }//GEN-LAST:event_lamMoiTableActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LamMoiForm;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cboLoaiGiamInsert;
    private com.toedter.calendar.JDateChooser dataDenNgay;
    private com.toedter.calendar.JDateChooser dataTuNgay;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lamMoiTable;
    private javax.swing.JTable tblQLPGG;
    private javax.swing.JTextField txtGtriAD;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables
}
