package PhamDucTrongGiaoDien.gui;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmMonHoc extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(frmMonHoc.class.getName());

    private final DefaultTableModel model;
    
    public frmMonHoc() {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);   // Vô hiệu hóa nút X
        initComponents();
        setLocationRelativeTo(null);
        model = new DefaultTableModel(new Object[]{"Mã môn học", "Tên môn học", "Số tiết"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        tblMonHoc.setModel(model);
        tblMonHoc.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) fillFormFromRow();
        });
        loadData();
        clearForm();
    }
    
    private void loadData() {
        model.setRowCount(0);
        String sql = "SELECT MaMonHoc, TenMonHoc, SoTiet FROM MonHoc ORDER BY MaMonHoc";
        try (Connection con = PhamDucTrongGiaoDien.dal.DBConnection;
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getInt(3)});
            }
        } catch (SQLException ex) {
            showError(ex);
        }
    }

    private void fillFormFromRow() {
        int row = tblMonHoc.getSelectedRow();
        if (row < 0) return;
        txtMaMonHoc.setText(model.getValueAt(row, 0).toString());
        txtTenMonHoc.setText(model.getValueAt(row, 1).toString());
        txtSoTiet.setText(model.getValueAt(row, 2).toString());
        txtMaMonHoc.setEnabled(false);
        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
    }

    private void clearForm() {
        txtMaMonHoc.setText("");
        txtTenMonHoc.setText("");
        txtSoTiet.setText("");
        txtMaMonHoc.setEnabled(true);
        tblMonHoc.clearSelection();
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        txtMaMonHoc.requestFocus();
    }

    private boolean validateInput() {
        if (txtMaMonHoc.getText().trim().isEmpty() || txtTenMonHoc.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã và tên môn học không được để trống!");
            return false;
        }
        try {
            if (Integer.parseInt(txtSoTiet.getText().trim()) <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số tiết phải là số nguyên dương!");
            return false;
        }
        return true;
    }

    private void showError(SQLException ex) {
        JOptionPane.showMessageDialog(this, "Lỗi CSDL: " + ex.getMessage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnThoat = new javax.swing.JButton();
        lblMaMon = new javax.swing.JLabel();
        lblTenMon = new javax.swing.JLabel();
        lblSoTiet = new javax.swing.JLabel();
        txtMaMonHoc = new javax.swing.JTextField();
        txtTenMonHoc = new javax.swing.JTextField();
        txtSoTiet = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        lblTieuDe = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMonHoc = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(this::btnThoatActionPerformed);

        lblMaMon.setText("Mã môn học:");

        lblTenMon.setText("Tên môn học:");

        lblSoTiet.setText("Số tiết:");

        txtTenMonHoc.addActionListener(this::txtTenMonHocActionPerformed);

        btnThem.setText("Thêm");
        btnThem.addActionListener(this::btnThemActionPerformed);

        btnSua.setText("Sửa");
        btnSua.addActionListener(this::btnSuaActionPerformed);

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(this::btnXoaActionPerformed);

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(this::btnLamMoiActionPerformed);

        lblTieuDe.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblTieuDe.setForeground(new java.awt.Color(0, 51, 255));
        lblTieuDe.setText("QUẢN LÝ MÔN HỌC");

        tblMonHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã môn học", "Tên môn học", "Số tiết"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMonHoc);
        if (tblMonHoc.getColumnModel().getColumnCount() > 0) {
            tblMonHoc.getColumnModel().getColumn(0).setResizable(false);
            tblMonHoc.getColumnModel().getColumn(1).setResizable(false);
            tblMonHoc.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtSoTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTenMon)
                            .addComponent(lblMaMon)
                            .addComponent(lblSoTiet)
                            .addComponent(txtMaMonHoc)
                            .addComponent(txtTenMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLamMoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThoat)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTieuDe)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTieuDe)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(lblMaMon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(lblTenMon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(lblSoTiet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSoTiet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnLamMoi)
                    .addComponent(btnThoat))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void txtTenMonHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenMonHocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenMonHocActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (!validateInput()) return;
        String sql = "INSERT INTO MonHoc (MaMonHoc, TenMonHoc, SoTiet) VALUES (?, ?, ?)";
        try (Connection con = PhamDucTrongGiaoDien.dal.DBConnection;
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, txtMaMonHoc.getText().trim());
            ps.setString(2, txtTenMonHoc.getText().trim());
            ps.setInt(3, Integer.parseInt(txtSoTiet.getText().trim()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Thêm môn học thành công!");
            loadData();
            clearForm();
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 2627) JOptionPane.showMessageDialog(this, "Mã môn học đã tồn tại!");
            else showError(ex);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (!validateInput()) return;
        String sql = "UPDATE MonHoc SET TenMonHoc = ?, SoTiet = ? WHERE MaMonHoc = ?";
        try (Connection con = PhamDucTrongGiaoDien.dal.DBConnection;
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, txtTenMonHoc.getText().trim());
            ps.setInt(2, Integer.parseInt(txtSoTiet.getText().trim()));
            ps.setString(3, txtMaMonHoc.getText().trim());
            if (ps.executeUpdate() > 0) JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            loadData();
            clearForm();
        } catch (SQLException ex) {
            showError(ex);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int c = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa môn học này?",
                "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (c != JOptionPane.YES_OPTION) return;
        String sql = "DELETE FROM MonHoc WHERE MaMonHoc = ?";
        try (Connection con = PhamDucTrongGiaoDien.dal.DBConnection;
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, txtMaMonHoc.getText().trim());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
            loadData();
            clearForm();
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 547)
                JOptionPane.showMessageDialog(this, "Không thể xóa: môn học này đã có kết quả thi!");
            else showError(ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        loadData();
        clearForm();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new frmMonHoc().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMaMon;
    private javax.swing.JLabel lblSoTiet;
    private javax.swing.JLabel lblTenMon;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JTable tblMonHoc;
    private javax.swing.JTextField txtMaMonHoc;
    private javax.swing.JTextField txtSoTiet;
    private javax.swing.JTextField txtTenMonHoc;
    // End of variables declaration//GEN-END:variables
}
