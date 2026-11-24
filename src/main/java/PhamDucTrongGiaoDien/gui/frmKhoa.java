package PhamDucTrongGiaoDien.gui;

import PhamDucTrongGiaoDien.dal.DBConnection;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmKhoa extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(frmKhoa.class.getName());

    private final DefaultTableModel model;
    private String maKhoaCu;

    public frmKhoa() {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);   // Vô hiệu hóa nút X
        initComponents();
        setLocationRelativeTo(null);

        // Cấu hình JTable: không cho sửa trực tiếp trên bảng
        model = new DefaultTableModel(new Object[]{"Mã Khoa", "Tên Khoa"}, 0) {
            @Override
            public boolean isCellEditable(int row, int col) { return false; }
        };
        tblKhoa.setModel(model);

        // Khi chọn dòng trong bảng → đổ dữ liệu lên ô nhập
        tblKhoa.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) fillFormFromSelectedRow();
        });

        loadData();
        clearForm();
    }

    // ===== Các hàm hỗ trợ =====

    private void loadData() {
        model.setRowCount(0);
        String sql = "SELECT MaKhoa, TenKhoa FROM Khoa ORDER BY MaKhoa";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("MaKhoa"), rs.getString("TenKhoa")});
            }
        } catch (SQLException ex) {
            showError(ex);
        }
    }

    private void fillFormFromSelectedRow() {
        int row = tblKhoa.getSelectedRow();
        if (row < 0) return;

        maKhoaCu = model.getValueAt(row, 0).toString();

        txtMaKhoa.setText(maKhoaCu);
        txtTenKhoa.setText(model.getValueAt(row, 1).toString());

        txtMaKhoa.setEnabled(true);
        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
    }

    private void clearForm() {
        txtMaKhoa.setText("");
        txtTenKhoa.setText("");
        txtMaKhoa.setEnabled(true);
        tblKhoa.clearSelection();
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        txtMaKhoa.requestFocus();
    }

    private boolean validateInput() {
        if (txtMaKhoa.getText().trim().isEmpty() || txtTenKhoa.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã khoa và tên khoa không được để trống!");
            return false;
        }
        return true;
    }
    
    private boolean isTenKhoaExists(String tenKhoa, String maKhoaCu) throws SQLException {
        String sql;

        if (maKhoaCu == null) {
            // Kiểm tra khi thêm mới
            sql = "SELECT COUNT(*) FROM Khoa "
                + "WHERE LOWER(LTRIM(RTRIM(TenKhoa))) = LOWER(?)";
        } else {
            // Kiểm tra khi sửa, loại trừ khoa đang sửa
            sql = "SELECT COUNT(*) FROM Khoa "
                + "WHERE LOWER(LTRIM(RTRIM(TenKhoa))) = LOWER(?) "
                + "AND MaKhoa <> ?";
        }

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, tenKhoa.trim());

            if (maKhoaCu != null) {
                ps.setString(2, maKhoaCu);
            }

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }

        return false;
    }

    private void showError(SQLException ex) {
        JOptionPane.showMessageDialog(this, "Lỗi CSDL: " + ex.getMessage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnThoat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhoa = new javax.swing.JTable();
        lblTieuDe = new javax.swing.JLabel();
        lblMaKhoa = new javax.swing.JLabel();
        txtMaKhoa = new javax.swing.JTextField();
        lblTenKhoa = new javax.swing.JLabel();
        txtTenKhoa = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(this::btnThoatActionPerformed);

        tblKhoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã Khoa", "Tên Khoa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblKhoa);

        lblTieuDe.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblTieuDe.setForeground(new java.awt.Color(0, 51, 255));
        lblTieuDe.setText("QUẢN LÝ KHOA");

        lblMaKhoa.setText("Mã khoa:");

        lblTenKhoa.setText("Tên khoa:");

        txtTenKhoa.addActionListener(this::txtTenKhoaActionPerformed);

        btnThem.setText("Thêm");
        btnThem.addActionListener(this::btnThemActionPerformed);

        btnSua.setText("Sửa");
        btnSua.addActionListener(this::btnSuaActionPerformed);

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(this::btnXoaActionPerformed);

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(this::btnLamMoiActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTenKhoa)
                            .addComponent(lblMaKhoa)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtTenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMaKhoa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(lblTieuDe))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLamMoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThoat)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTieuDe)
                .addGap(18, 18, 18)
                .addComponent(lblMaKhoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lblTenKhoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnLamMoi)
                    .addComponent(btnThoat))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void txtTenKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKhoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKhoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (!validateInput()) return;

        try {
            if (isTenKhoaExists(txtTenKhoa.getText(), null)) {
                JOptionPane.showMessageDialog(this,
                        "Tên khoa đã tồn tại!",
                        "Thông báo",
                        JOptionPane.WARNING_MESSAGE);
                txtTenKhoa.requestFocus();
                return;
            }

            String sql = "INSERT INTO Khoa (MaKhoa, TenKhoa) VALUES (?, ?)";

            try (Connection con = DBConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, txtMaKhoa.getText().trim());
                ps.setString(2, txtTenKhoa.getText().trim());
                ps.executeUpdate();

                JOptionPane.showMessageDialog(this, "Thêm khoa thành công!");
                loadData();
                clearForm();
            }

        } catch (SQLException ex) {
            if (ex.getErrorCode() == 2627 || ex.getErrorCode() == 2601) {
                JOptionPane.showMessageDialog(this, "Mã khoa đã tồn tại!");
            } else {
                showError(ex);
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (!validateInput()) return;

        try {
            // Kiểm tra tên khoa trùng với khoa khác
            if (isTenKhoaExists(txtTenKhoa.getText(), maKhoaCu)) {
                JOptionPane.showMessageDialog(this,
                        "Tên khoa đã tồn tại!",
                        "Thông báo",
                        JOptionPane.WARNING_MESSAGE);
                txtTenKhoa.requestFocus();
                return;
            }

            String sql = "UPDATE Khoa SET MaKhoa = ?, TenKhoa = ? WHERE MaKhoa = ?";

            try (Connection con = DBConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, txtMaKhoa.getText().trim());
                ps.setString(2, txtTenKhoa.getText().trim());
                ps.setString(3, maKhoaCu);

                int n = ps.executeUpdate();

                if (n > 0) {
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                }

                loadData();
                clearForm();
            }

        } catch (SQLException ex) {
            switch (ex.getErrorCode()) {
                case 2627, 2601 -> JOptionPane.showMessageDialog(this, "Mã khoa mới đã tồn tại!");
                case 547 -> JOptionPane.showMessageDialog(this,
                        "Không thể đổi mã khoa vì đang được tham chiếu bởi dữ liệu sinh viên!");
                default -> showError(ex);
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc muốn xóa khoa này?", "Xác nhận",
                JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        String sql = "DELETE FROM Khoa WHERE MaKhoa = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, txtMaKhoa.getText().trim());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Xóa thành công!");
            loadData();
            clearForm();
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 547) {       // Vi phạm khóa ngoại
                JOptionPane.showMessageDialog(this,
                        "Không thể xóa: khoa này còn sinh viên!");
            } else {
                showError(ex);
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        loadData();
        clearForm();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new frmKhoa().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMaKhoa;
    private javax.swing.JLabel lblTenKhoa;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JTable tblKhoa;
    private javax.swing.JTextField txtMaKhoa;
    private javax.swing.JTextField txtTenKhoa;
    // End of variables declaration//GEN-END:variables
}
