package PhamDucTrongGiaoDien.gui;

import javax.swing.JOptionPane;
import PhamDucTrongGiaoDien.dal.DBConnection;
import java.sql.*;

public class frmFormChinh extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(frmFormChinh.class.getName());

    public frmFormChinh() {
        initComponents();
        setLocationRelativeTo(null);
        initLogic();
    }
    
    private void initLogic() {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);   // Vô hiệu hóa nút X
        setLocationRelativeTo(null);
        capNhatTrangThai(false);   // Chưa đăng nhập: khóa Quản lý và Tra cứu
}

// Bật/tắt menu và chuyển giữa màn hình đăng nhập và màn hình thành công
private void capNhatTrangThai(boolean daDangNhap) {
    mnuQuanLy.setEnabled(daDangNhap);
    mnuTraCuu.setEnabled(daDangNhap);
    mnuQuayLaiDangNhap.setEnabled(daDangNhap);   // Chỉ bật khi đã đăng nhập
    pnlDangNhap.setVisible(!daDangNhap);
    pnlThanhCong.setVisible(daDangNhap);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlThanhCong = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlDangNhap = new javax.swing.JPanel();
        txtMatKhau = new javax.swing.JPasswordField();
        btnDangNhap = new javax.swing.JButton();
        lblTieuDe = new javax.swing.JLabel();
        lblTenDangNhap = new javax.swing.JLabel();
        txtTenDangNhap = new javax.swing.JTextField();
        lblMatKhau = new javax.swing.JLabel();
        mnuMain = new javax.swing.JMenuBar();
        mnuHeThong = new javax.swing.JMenu();
        mnuQuayLaiDangNhap = new javax.swing.JMenuItem();
        mniThoat = new javax.swing.JMenuItem();
        mnuQuanLy = new javax.swing.JMenu();
        mniKhoa = new javax.swing.JMenuItem();
        mniMonHoc = new javax.swing.JMenuItem();
        mniSinhVien = new javax.swing.JMenuItem();
        mniKetQua = new javax.swing.JMenuItem();
        mnuTraCuu = new javax.swing.JMenu();
        mniTraCuu = new javax.swing.JMenuItem();
        mnuTroGiup = new javax.swing.JMenu();
        mniGioiThieu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlThanhCong.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Đăng Nhập Thành Công!");
        pnlThanhCong.add(jLabel1);
        jLabel1.setBounds(61, 80, 283, 28);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Bạn có thể truy cập vào Menu Quản lý và Tra Cứu");
        pnlThanhCong.add(jLabel2);
        jLabel2.setBounds(34, 126, 345, 17);

        txtMatKhau.setText("123456");
        txtMatKhau.addActionListener(this::txtMatKhauActionPerformed);

        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.addActionListener(this::btnDangNhapActionPerformed);

        lblTieuDe.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblTieuDe.setForeground(new java.awt.Color(51, 51, 255));
        lblTieuDe.setText("ĐĂNG NHẬP HỆ THỐNG ");

        lblTenDangNhap.setText("Tên đăng nhập:");

        txtTenDangNhap.setText("admin");
        txtTenDangNhap.addActionListener(this::txtTenDangNhapActionPerformed);

        lblMatKhau.setText("Mật khẩu:");

        javax.swing.GroupLayout pnlDangNhapLayout = new javax.swing.GroupLayout(pnlDangNhap);
        pnlDangNhap.setLayout(pnlDangNhapLayout);
        pnlDangNhapLayout.setHorizontalGroup(
            pnlDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDangNhapLayout.createSequentialGroup()
                .addGroup(pnlDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDangNhapLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(pnlDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblMatKhau)
                            .addComponent(lblTenDangNhap)
                            .addComponent(txtTenDangNhap)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlDangNhapLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(lblTieuDe)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDangNhapLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnDangNhap)
                .addGap(155, 155, 155))
        );
        pnlDangNhapLayout.setVerticalGroup(
            pnlDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDangNhapLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblTieuDe)
                .addGap(26, 26, 26)
                .addComponent(lblTenDangNhap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lblMatKhau)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnDangNhap)
                .addGap(31, 31, 31))
        );

        mnuHeThong.setText("Hệ thống");

        mnuQuayLaiDangNhap.setText("Quay Lại Đăng Nhập");
        mnuQuayLaiDangNhap.addActionListener(this::mnuQuayLaiDangNhapActionPerformed);
        mnuHeThong.add(mnuQuayLaiDangNhap);

        mniThoat.setText("Thoát");
        mniThoat.addActionListener(this::mniThoatActionPerformed);
        mnuHeThong.add(mniThoat);

        mnuMain.add(mnuHeThong);

        mnuQuanLy.setText("Quản lý");

        mniKhoa.setText("Quản lý khoa");
        mniKhoa.addActionListener(this::mniKhoaActionPerformed);
        mnuQuanLy.add(mniKhoa);

        mniMonHoc.setText("Quản lý môn học");
        mniMonHoc.addActionListener(this::mniMonHocActionPerformed);
        mnuQuanLy.add(mniMonHoc);

        mniSinhVien.setText("Quản lý sinh viên");
        mniSinhVien.addActionListener(this::mniSinhVienActionPerformed);
        mnuQuanLy.add(mniSinhVien);

        mniKetQua.setText("Quản lý kết quả");
        mniKetQua.addActionListener(this::mniKetQuaActionPerformed);
        mnuQuanLy.add(mniKetQua);

        mnuMain.add(mnuQuanLy);

        mnuTraCuu.setText("Tra cứu");

        mniTraCuu.setText("Tra cứu sinh viên");
        mniTraCuu.addActionListener(this::mniTraCuuActionPerformed);
        mnuTraCuu.add(mniTraCuu);

        mnuMain.add(mnuTraCuu);

        mnuTroGiup.setText("Trợ giúp");

        mniGioiThieu.setText("Giới thiệu");
        mniGioiThieu.addActionListener(this::mniGioiThieuActionPerformed);
        mnuTroGiup.add(mniGioiThieu);

        mnuMain.add(mnuTroGiup);

        setJMenuBar(mnuMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlThanhCong, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlThanhCong, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniThoatActionPerformed
        int chon = JOptionPane.showConfirmDialog(
            this,
            "Bạn có muốn thoát chương trình?",
            "Xác nhận",
            JOptionPane.YES_NO_OPTION
        );

        if (chon == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_mniThoatActionPerformed

    private void mniKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniKhoaActionPerformed
        frmKhoa f = new frmKhoa();
        f.setLocationRelativeTo(this);
        f.setVisible(true);
    }//GEN-LAST:event_mniKhoaActionPerformed

    private void mniMonHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniMonHocActionPerformed
        frmMonHoc f = new frmMonHoc();
        f.setLocationRelativeTo(this);
        f.setVisible(true);
    }//GEN-LAST:event_mniMonHocActionPerformed

    private void mniSinhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSinhVienActionPerformed
        frmSinhVien f = new frmSinhVien();
        f.setLocationRelativeTo(this);
        f.setVisible(true);
    }//GEN-LAST:event_mniSinhVienActionPerformed

    private void mniKetQuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniKetQuaActionPerformed
        frmKetQua f = new frmKetQua();
        f.setLocationRelativeTo(this);
        f.setVisible(true);
    }//GEN-LAST:event_mniKetQuaActionPerformed

    private void mniTraCuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTraCuuActionPerformed
        frmTraCuuSinhVien f = new frmTraCuuSinhVien();
        f.setLocationRelativeTo(this);
        f.setVisible(true);
    }//GEN-LAST:event_mniTraCuuActionPerformed

    private void mniGioiThieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniGioiThieuActionPerformed
        JOptionPane.showMessageDialog(this,
            JOptionPane.INFORMATION_MESSAGE
        );
    }//GEN-LAST:event_mniGioiThieuActionPerformed

    private void txtMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatKhauActionPerformed

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        String user = txtTenDangNhap.getText().trim();
        String pass = new String(txtMatKhau.getPassword());

        if (user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ tên đăng nhập và mật khẩu!");
            return;
        }

        String sql = "SELECT 1 FROM TaiKhoan WHERE TenDangNhap = ? AND MatKhau = ?";
        try (Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, user);
            ps.setString(2, pass);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    capNhatTrangThai(true);
                    txtMatKhau.setText("");
                    txtTenDangNhap.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Sai tên đăng nhập hoặc mật khẩu!");
                    txtMatKhau.setText("");
                    txtMatKhau.requestFocus();
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi kết nối CSDL: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void txtTenDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenDangNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenDangNhapActionPerformed

    private void mnuQuayLaiDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuQuayLaiDangNhapActionPerformed
        txtTenDangNhap.setText("");
        txtMatKhau.setText("");
        capNhatTrangThai(false);   // Khóa Quản lý và Tra cứu, hiện lại form đăng nhập
    }//GEN-LAST:event_mnuQuayLaiDangNhapActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new frmFormChinh().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JLabel lblTenDangNhap;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JMenuItem mniGioiThieu;
    private javax.swing.JMenuItem mniKetQua;
    private javax.swing.JMenuItem mniKhoa;
    private javax.swing.JMenuItem mniMonHoc;
    private javax.swing.JMenuItem mniSinhVien;
    private javax.swing.JMenuItem mniThoat;
    private javax.swing.JMenuItem mniTraCuu;
    private javax.swing.JMenu mnuHeThong;
    private javax.swing.JMenuBar mnuMain;
    private javax.swing.JMenu mnuQuanLy;
    private javax.swing.JMenuItem mnuQuayLaiDangNhap;
    private javax.swing.JMenu mnuTraCuu;
    private javax.swing.JMenu mnuTroGiup;
    private javax.swing.JPanel pnlDangNhap;
    private javax.swing.JPanel pnlThanhCong;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTenDangNhap;
    // End of variables declaration//GEN-END:variables
}
