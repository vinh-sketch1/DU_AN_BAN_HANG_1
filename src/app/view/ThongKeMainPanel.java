package app.view;

import app.model.KhachHang;
import app.model.Thongke;
import app.service.DBConnect;
import app.service.ThongKeService;
import java.awt.Color;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartPanel;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.jfree.chart.plot.CategoryPlot;

public class ThongKeMainPanel extends javax.swing.JPanel {

    private ThongKeService ss = new ThongKeService();

    private List<Thongke> TK = new ArrayList<>();

    public ThongKeMainPanel() {
        initComponents();
        this.fillTable(ss.getAll());
        tongNgay();
        tongNam();
        tongThang();
        fillTop5KH();
        if (ss.getNam() != null || ss.getThang() != null) {
            addCbo(ss.getNam(), cboNam);
            addCbo(ss.getThang(), cboThang);
            bieuDo(Integer.parseInt(cboThang.getSelectedItem().toString()), Integer.parseInt(cboNam.getSelectedItem().toString()));
        }

    }

    private void fillTable(List<Thongke> t) {
        DefaultTableModel dtm = (DefaultTableModel) tbl_thongke.getModel();
        dtm.setRowCount(0);
        for (Thongke x : t) {
            dtm.addRow(new Object[]{
                x.getMaChiTietSanPham(),
                x.getTen(),
                x.getSoLuong(),
                x.getTongTien()
            });
        }
    }

    private void tongNgay() {
        DecimalFormat x = new DecimalFormat();
        lbl_dtngay.setText(x.format(ss.sumDay()) + " VND");
    }

    private void tongNam() {
        DecimalFormat x = new DecimalFormat();
        lbl_dtnam1.setText(x.format(ss.sumYear()) + " " + "VND");
    }

    private void tongThang() {
        DecimalFormat x = new DecimalFormat();
        lbl_dtthnag.setText(x.format(ss.sumMonth()) + " " + "VND");
    }

    private void thongKeTheoKhoangNgay() {
        Date kt = dataDenNgay.getDate();
        Date bd = dataDenNgay.getDate();
        if (bd != null || kt != null) {
            // Kiểm tra định dạng ngày
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String selectedDateString = dateFormat.format(bd);
            String selectedDateString1 = dateFormat.format(kt);

            try {
                // Kiểm tra tính hợp lệ bằng cách so sánh chuỗi định dạng và giá trị ngày thực tế
                Date parsedDate = dateFormat.parse(selectedDateString);
                Date parsedDate1 = dateFormat.parse(selectedDateString1);

                if (bd.equals(parsedDate) && kt.equals(parsedDate1)) {
                    // Ngày hợp lệ
                    JOptionPane.showMessageDialog(this, "Ngày đã chọn: " + selectedDateString + "đến" + selectedDateString1, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                // Ngày không hợp lệ
                JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày hợp lệ! yyyy-MM-dd1", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Ngày không hợp lệ
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày hợp lệ! yyyy-MM-dd", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String ngayBD = sdf.format(dataTuNgay.getDate());
        String ngayKT = sdf.format(dataDenNgay.getDate());

        System.out.println(ngayBD + ngayKT);
        lblSoLuongHD.setText(ss.demSoLuongHD(ngayBD, ngayKT));
        lblCTSPDaBan.setText(ss.soLuongCacSPDaBan(ngayBD, ngayKT));
        lblTongTien.setText(ss.tongTienDaBan(ngayBD, ngayKT));
    }

    private void fillTop5KH() {
        DefaultTableModel dtmtop = (DefaultTableModel) tblTop5KH.getModel();
        dtmtop.setRowCount(0);
        List<KhachHang> top5KH = new ArrayList<>();
        top5KH = ss.top5Kh();
        for (KhachHang kh : top5KH) {
            dtmtop.addRow(new Object[]{kh.getMaKH(), kh.getHoTen(), kh.getSdt(), kh.getSoLuongHDMua(), kh.getTongTienMua()});
        }
    }

    private void bieuDo(int thang, int nam) {
        try {
            Connection connection = DBConnect.getConnection();

            // Thực hiện truy vấn SQL
            String sql = "select day(ngaytao)as [Ngày], sum(thanhTien) As [tongtien] from HoaDon where month(ngaytao) = ? and year(ngaytao) = ?" + " group by day(ngaytao) ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, thang);
            ps.setInt(2, nam);
            ResultSet resultSet = ps.executeQuery();

            // Tạo dữ liệu cho biểu đồ
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            List<Integer> allDays = new ArrayList<>();

            SimpleDateFormat sdf = new SimpleDateFormat("dd");
            int ngayHienTai = Integer.parseInt(sdf.format(new Date()));

            for (int i = 1; i <= ngayHienTai; i++) {
                dataset.addValue(0, "Tổng Tiền", "" + i);
            }

            while (resultSet.next()) {
                int day = resultSet.getInt(1);
                double tongTien = resultSet.getDouble(2);

                dataset.addValue(tongTien, "Tổng Tiền", String.valueOf(day));

                // Xóa ngày đã tồn tại trong danh sách
                allDays.remove(Integer.valueOf(day));
            }

            // Tạo biểu đồ Line Chart
            JFreeChart chart = ChartFactory.createLineChart(
                    "Biểu Đồ Thể Hiện Doanh Thu Trong Ngày Theo Tháng", // Tiêu đề biểu đồ
                    "Day", // Nhãn trục x
                    "Tiền VND", // Nhãn trục y
                    dataset, // Dữ liệu
                    PlotOrientation.VERTICAL, // Hướng biểu đồ
                    true, // Hiển thị legend
                    true, // Hiển thị tooltips
                    false // Không hiển thị URLs
            );

            // Tùy chỉnh đường dữ liệu
            chart.getCategoryPlot().getRenderer().setSeriesPaint(0, Color.RED);

            // Tùy chỉnh trục x
            CategoryAxis domainAxis = chart.getCategoryPlot().getDomainAxis();
            domainAxis.setLowerMargin(0.0);
            domainAxis.setUpperMargin(0.0);
            domainAxis.setCategoryMargin(0.0);

            // Hiển thị biểu đồ trong một cửa sổ    
            CategoryPlot plot = chart.getCategoryPlot();
            plot.setBackgroundPaint(Color.WHITE); // Thiết lập màu nền là màu trắng
            ChartPanel bieuDo = new ChartPanel(chart);
            panelBieudo.removeAll();
            panelBieudo.add(bieuDo);
            panelBieudo.repaint();
            panelBieudo.revalidate();

            // Đóng kết nối cơ sở dữ liệu
            resultSet.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
        }
    }

    private void addCbo(List<String> list, JComboBox md) {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (String string : list) {
            dcbm.addElement(string);
        }
        md.setModel(dcbm);
    }

    private void lamMoi() {
        tongNgay();
        tongNam();
        tongThang();
        addCbo(ss.getNam(), cboNam);
        addCbo(ss.getThang(), cboThang);
        bieuDo(Integer.parseInt(cboThang.getSelectedItem().toString()), Integer.parseInt(cboNam.getSelectedItem().toString()));
        fillTop5KH();
        fillTable(ss.getAll());
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

    public void sendmailngay(String a, String b) throws MessagingException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date ngay = new Date();
        String StringNgay1 = sdf1.format(ngay);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String StringNgay2 = sdf2.format(ngay);
//    trường dữ liệu cần gửi
        String tongDoanhThuNgay = ss.tongTienDaBan(StringNgay1, StringNgay2);
        String tongDonHangNgay = ss.demSoLuongHD(StringNgay1, StringNgay2);
        String tongCTSPDaBanNgay = ss.soLuongCacSPDaBan(StringNgay1, StringNgay2);

// Thông tin tài khoản email
        String host = "smtp.gmail.com";
        String port = "587";
        String username = "congldph46544@fpt.edu.vn";
        String password = "s p a i g v r y g p z b d g q n";

        // Thông tin người gửi và người nhận
        String fromEmail = "congldph46544@fpt.edu.vn";
        String toEmail = "duycongib192@gmail.com";

        // Cấu hình properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Xác thực tài khoản email
        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };

        // Tạo session
        Session session = Session.getInstance(properties, authenticator);

        try {
            // Tạo đối tượng MimeMessage
            MimeMessage message = new MimeMessage(session);

            // Thiết lập thông tin người gửi và người nhận
            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            // Thiết lập tiêu đề email
            message.setSubject("Báo Cáo Thống Kê " + StringNgay1);

            // Thiết lập nội dung email    
            String Htmlcode = "<h3 >Kính Gửi Sếp !  </h3>";
            String Htmlcode1 = "<h4>Tình hình doanh thu, số lượng sản phẩm bán được, số lượng đơn hàng "
                    + "bán được như sau : </h4>";//b=hôm nay
            String Htmlcode2 = "<h3 >Ngày: " + StringNgay1 + " </h3>";
            String Htmlcode3 = " <h3>Doanh Thu: </h3>";
            String Htmlcode4 = " Tổng Doanh Thu: " + tongDoanhThuNgay + "<br>";
            String Htmlcode5 = " <h3>Đơn Bán: </h3>";
            String Htmlcode6 = " Tổng Đơn Bán: " + tongDonHangNgay + "<br>";
            String Htmlcode7 = "<h3>Sản Phẩm Bán: </h3>";
            String Htmlcode8 = " Tổng Sản Phẩm Bán: " + tongCTSPDaBanNgay + "<br>";
            message.setContent(Htmlcode + Htmlcode1 + Htmlcode2 + Htmlcode3 + Htmlcode4 + Htmlcode5 + Htmlcode6 + Htmlcode7 + Htmlcode8, "text/html;charset=UTF-8");
            JOptionPane.showMessageDialog(this, "Đã gửi!");

            // Gửi email
            Transport.send(message);

            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
        }

        //body mail
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        panelBieudo = new java.awt.Panel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTop5KH = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_thongke = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboThang = new javax.swing.JComboBox<>();
        cboNam = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_timkiem = new javax.swing.JTextField();
        myButton1 = new swing.MyButton();
        panelGradiente5 = new swing.PanelGradiente();
        jLabel1 = new javax.swing.JLabel();
        lbl_dtngay = new javax.swing.JLabel();
        panelGradiente6 = new swing.PanelGradiente();
        lbl_dtthnag = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelGradiente7 = new swing.PanelGradiente();
        jLabel5 = new javax.swing.JLabel();
        lbl_dtnam1 = new javax.swing.JLabel();
        panelGradiente1 = new swing.PanelGradiente();
        dataTuNgay = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        dataDenNgay = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblSoLuongHD = new javax.swing.JLabel();
        lblCTSPDaBan = new javax.swing.JLabel();
        myButton4 = new swing.MyButton();
        myButton2 = new swing.MyButton();
        myButton3 = new swing.MyButton();

        setPreferredSize(new java.awt.Dimension(1300, 790));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51)));

        panelBieudo.setPreferredSize(new java.awt.Dimension(700, 500));
        panelBieudo.setLayout(new java.awt.CardLayout());

        tblTop5KH.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        tblTop5KH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "maKH", "Họ Tên", "SĐT", "SLHD", "Tổng Tiền"
            }
        ));
        jScrollPane2.setViewportView(tblTop5KH);
        if (tblTop5KH.getColumnModel().getColumnCount() > 0) {
            tblTop5KH.getColumnModel().getColumn(0).setMaxWidth(50);
            tblTop5KH.getColumnModel().getColumn(3).setMaxWidth(40);
        }

        tbl_thongke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Chi tiết sản phẩm", "Tên sản phẩm", "Số lượng bán", "Tổng tiền"
            }
        ));
        jScrollPane1.setViewportView(tbl_thongke);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tháng:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Năm: ");

        cboThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboThang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboThangItemStateChanged(evt);
            }
        });

        cboNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboNam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboNamItemStateChanged(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Danh sách số lượng bán và doanh thu trên từng CTSP:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Top 5 khách hàng tiềm năng:");

        myButton1.setText("Tìm Kiếm theo mã CTSP");
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBieudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbl_timkiem, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(panelBieudo, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelGradiente5.setColorPrimario(new java.awt.Color(204, 204, 0));
        panelGradiente5.setColorSecundario(new java.awt.Color(0, 102, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tổng Doanh Thu Ngày");
        panelGradiente5.add(jLabel1);
        jLabel1.setBounds(20, 20, 240, 27);

        lbl_dtngay.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbl_dtngay.setForeground(new java.awt.Color(255, 255, 255));
        lbl_dtngay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_dtngay.setText("123");
        lbl_dtngay.setToolTipText("");
        panelGradiente5.add(lbl_dtngay);
        lbl_dtngay.setBounds(30, 70, 181, 40);

        panelGradiente6.setColorPrimario(new java.awt.Color(204, 204, 0));
        panelGradiente6.setColorSecundario(new java.awt.Color(0, 102, 51));

        lbl_dtthnag.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbl_dtthnag.setForeground(new java.awt.Color(255, 255, 255));
        lbl_dtthnag.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_dtthnag.setText("123");
        lbl_dtthnag.setToolTipText("");
        panelGradiente6.add(lbl_dtthnag);
        lbl_dtthnag.setBounds(40, 70, 181, 40);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tổng Doanh Thu Tháng");
        panelGradiente6.add(jLabel2);
        jLabel2.setBounds(20, 20, 250, 27);

        panelGradiente7.setColorPrimario(new java.awt.Color(204, 204, 0));
        panelGradiente7.setColorSecundario(new java.awt.Color(0, 102, 51));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tổng Doanh Thu Năm");
        panelGradiente7.add(jLabel5);
        jLabel5.setBounds(16, 20, 210, 27);

        lbl_dtnam1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbl_dtnam1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_dtnam1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_dtnam1.setText("123");
        lbl_dtnam1.setToolTipText("");
        panelGradiente7.add(lbl_dtnam1);
        lbl_dtnam1.setBounds(30, 70, 181, 40);

        dataTuNgay.setDateFormatString("yyyy-MM-dd");
        panelGradiente1.add(dataTuNgay);
        dataTuNgay.setBounds(10, 10, 140, 22);

        jLabel4.setText("Đến");
        panelGradiente1.add(jLabel4);
        jLabel4.setBounds(150, 10, 37, 16);

        dataDenNgay.setDateFormatString("yyyy-MM-dd");
        panelGradiente1.add(dataDenNgay);
        dataDenNgay.setBounds(180, 10, 130, 22);

        jLabel7.setText("Số lượng CTSP đã bán:");
        panelGradiente1.add(jLabel7);
        jLabel7.setBounds(10, 80, 140, 16);

        jLabel10.setText("Tổng tiền sau giảm giá: ");
        panelGradiente1.add(jLabel10);
        jLabel10.setBounds(10, 120, 140, 16);
        panelGradiente1.add(lblTongTien);
        lblTongTien.setBounds(170, 120, 90, 16);

        jLabel12.setText("Số lượng Hóa đơn: ");
        panelGradiente1.add(jLabel12);
        jLabel12.setBounds(10, 50, 120, 16);
        panelGradiente1.add(lblSoLuongHD);
        lblSoLuongHD.setBounds(160, 50, 90, 20);
        panelGradiente1.add(lblCTSPDaBan);
        lblCTSPDaBan.setBounds(160, 80, 110, 20);

        myButton4.setText("Thống kê Theo Khoảng Ngày");
        myButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton4ActionPerformed(evt);
            }
        });
        panelGradiente1.add(myButton4);
        myButton4.setBounds(10, 160, 200, 23);

        myButton2.setText("Gửi thống kê trong ngày cho sếp");
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });

        myButton3.setText("Làm mới thống kê");
        myButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelGradiente5, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelGradiente6, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(panelGradiente7, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(myButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(panelGradiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelGradiente5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelGradiente6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelGradiente7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(myButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panelGradiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 52, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboThangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboThangItemStateChanged
        // TODO add your handling code here:
        int thang = Integer.parseInt(cboThang.getSelectedItem().toString());
        int nam = Integer.parseInt(cboNam.getSelectedItem().toString());
        bieuDo(thang, nam);
    }//GEN-LAST:event_cboThangItemStateChanged

    private void cboNamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboNamItemStateChanged
        // TODO add your handling code here:
        int thang = Integer.parseInt(cboThang.getSelectedItem().toString());
        int nam = Integer.parseInt(cboNam.getSelectedItem().toString());
        bieuDo(thang, nam);
    }//GEN-LAST:event_cboNamItemStateChanged

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        // TODO add your handling code here:
        String tim = lbl_timkiem.getText().trim();
        if (!kiemTraChuoi("^[a-zA-Z0-9 ]{1,19}$", tim)) {
            JOptionPane.showMessageDialog(this, "mã CTSP là chữ ko dấu ít hơn 20 kí tự");
            return;
        }
        fillTable(ss.timTheoMa(tim));
    }//GEN-LAST:event_myButton1ActionPerformed

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
        try {
            // TODO add your handling code here:
            sendmailngay("ngay", "a");
        } catch (MessagingException ex) {
            Logger.getLogger(ThongKeMainPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_myButton2ActionPerformed

    private void myButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton3ActionPerformed
        // TODO add your handling code here:
        lamMoi();
    }//GEN-LAST:event_myButton3ActionPerformed

    private void myButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton4ActionPerformed
        // TODO add your handling code here:
        thongKeTheoKhoangNgay();
    }//GEN-LAST:event_myButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cboNam;
    private javax.swing.JComboBox<String> cboThang;
    private com.toedter.calendar.JDateChooser dataDenNgay;
    private com.toedter.calendar.JDateChooser dataTuNgay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCTSPDaBan;
    private javax.swing.JLabel lblSoLuongHD;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lbl_dtnam1;
    private javax.swing.JLabel lbl_dtngay;
    private javax.swing.JLabel lbl_dtthnag;
    private javax.swing.JTextField lbl_timkiem;
    private swing.MyButton myButton1;
    private swing.MyButton myButton2;
    private swing.MyButton myButton3;
    private swing.MyButton myButton4;
    private java.awt.Panel panelBieudo;
    private swing.PanelGradiente panelGradiente1;
    private swing.PanelGradiente panelGradiente5;
    private swing.PanelGradiente panelGradiente6;
    private swing.PanelGradiente panelGradiente7;
    private javax.swing.JTable tblTop5KH;
    private javax.swing.JTable tbl_thongke;
    // End of variables declaration//GEN-END:variables
}
