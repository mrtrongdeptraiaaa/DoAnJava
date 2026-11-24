package PhamDucTrongGiaoDien.gui;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class frmSinhVien extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(frmSinhVien.class.getName());

    private final DefaultTableModel model;
    private static final DateTimeFormatter DATE_FMT =
        DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
    
    public frmSinhVien() {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);   // Vô hiệu hóa nút X
        initComponents();
        setLocationRelativeTo(null);
        model = new DefaultTableModel(
                new Object[]{"Mã SV", "Họ SV", "Tên SV", "Ngày sinh", "Phái", "Mã Khoa"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        tblSinhVien.setModel(model);
        tblSinhVien.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) fillFormFromRow();
        });
        loadCombo(cboMaKhoa, "SELECT MaKhoa FROM Khoa ORDER BY MaKhoa");
        loadData();
        clearForm();
    }

    private void loadCombo(JComboBox<String> cbo, String sql) {
        cbo.removeAllItems();
        try (Connection con = PhamDucTrongGiaoDien.dal.DBConnection;
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) cbo.addItem(rs.getString(1));
        } catch (SQLException ex) {
            showError(ex);
        }
    }

    private void loadData() {
        model.setRowCount(0);
        String sql = "SELECT MaSinhVien, HoSinhVien, TenSinhVien, NgaySinh, Phai, MaKhoa "
                   + "FROM SinhVien ORDER BY MaSinhVien";
        try (Connection con = PhamDucTrongGiaoDien.dal.DBConnection;
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString(1), rs.getString(2), rs.getString(3),
                    rs.getDate(4).toLocalDate().format(DATE_FMT),
                    rs.getString(5), rs.getString(6)
                });
            }
        } catch (SQLException ex) {
            showError(ex);
        }
    }

    private void fillFormFromRow() {
        int row = tblSinhVien.getSelectedRow();
        if (row < 0) return;
        txtMaSinhVien.setText(model.getValueAt(row, 0).toString());
        txtHoSinhVien.setText(model.getValueAt(row, 1).toString());
        txtTenSinhVien.setText(model.getValueAt(row, 2).toString());
        txtNgaySinh.setText(model.getValueAt(row, 3).toString());
        if ("Nam".equals(model.getValueAt(row, 4))) rdoNam.setSelected(true);
        else rdoNu.setSelected(true);
        cboMaKhoa.setSelectedItem(model.getValueAt(row, 5).toString());
        txtMaSinhVien.setEnabled(false);
        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
    }

    private void clearForm() {
        txtMaSinhVien.setText("");
        txtHoSinhVien.setText("");
        txtTenSinhVien.setText("");
        txtNgaySinh.setText("");
        rdoNam.setSelected(true);
        if (cboMaKhoa.getItemCount() > 0) cboMaKhoa.setSelectedIndex(0);
        txtMaSinhVien.setEnabled(true);
        tblSinhVien.clearSelection();
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        txtMaSinhVien.requestFocus();
    }

    private boolean validateInput() {
        if (txtMaSinhVien.getText().trim().isEmpty() || txtHoSinhVien.getText().trim().isEmpty()
                || txtTenSinhVien.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ mã, họ và tên!");
            return false;
        }
        try {
            getNgaySinh();
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Ngày sinh phải theo định dạng dd/MM/yyyy (ví dụ 10/05/2003)!");
            return false;
        }
        if (cboMaKhoa.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn mã khoa!");
            return false;
        }
        return true;
    }

    private LocalDate getNgaySinh() {
        return LocalDate.parse(txtNgaySinh.getText().trim(), DATE_FMT);
    }

    private String getPhai() {
        return rdoNam.isSelected() ? "Nam" : "Nữ";
    }

    private void showError(SQLException ex) {
        JOptionPane.showMessageDialog(this, "Lỗi CSDL: " + ex.getMessage());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngPhai = new javax.swing.ButtonGroup();
        lblTieuDe = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSinhVien = new javax.swing.JTable();
        lblMaSV = new javax.swing.JLabel();
        txtMaSinhVien = new javax.swing.JTextField();
        lblHoSV = new javax.swing.JLabel();
        txtHoSinhVien = new javax.swing.JTextField();
        lblTen = new javax.swing.JLabel();
        txtTenSinhVien = new javax.swing.JTextField();
        lblNgaySinh = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        lblPhai = new javax.swing.JLabel();
        lblMaKhoa = new javax.swing.JLabel();
        cboMaKhoa = new javax.swing.JComboBox<>();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTieuDe.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblTieuDe.setForeground(new java.awt.Color(0, 51, 255));
        lblTieuDe.setText("QUẢN LÝ SINH VIÊN");

        btnThem.setText("Thêm");
        btnThem.addActionListener(this::btnThemActionPerformed);

        btnSua.setText("Sửa");
        btnSua.addActionListener(this::btnSuaActionPerformed);

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(this::btnXoaActionPerformed);

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(this::btnLamMoiActionPerformed);

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(this::btnThoatActionPerformed);

        tblSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã sinh viên", "Họ sinh viên", "Tên sinh viên", "Ngày sinh", "Phái", "Mã Khoa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSinhVien);

        lblMaSV.setText("Mã sinh viên:");

        lblHoSV.setText("Họ sinh viên:");

        lblTen.setText("Tên:");

        lblNgaySinh.setText("Ngày sinh:");

        lblPhai.setText("Phái:");

        lblMaKhoa.setText("Mã khoa:");

        cboMaKhoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CNTT", "QTKD", "NNT" }));

        btngPhai.add(rdoNam);
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");
        rdoNam.addActionListener(this::rdoNamActionPerformed);

        btngPhai.add(rdoNu);
        rdoNu.setText("Nữ");
        rdoNu.addActionListener(this::rdoNuActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTieuDe)
                .addGap(182, 182, 182))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblMaSV)
                    .addComponent(jScrollPane1)
                    .addComponent(txtMaSinhVien)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHoSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHoSV)
                            .addComponent(lblNgaySinh))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTen)
                            .addComponent(txtTenSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLamMoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThoat))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPhai)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdoNam)
                                .addGap(45, 45, 45)
                                .addComponent(rdoNu)))
                        .addGap(136, 136, 136)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMaKhoa)
                            .addComponent(cboMaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTieuDe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMaSV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHoSV)
                    .addComponent(lblTen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNgaySinh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhai)
                    .addComponent(lblMaKhoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdoNam)
                        .addComponent(rdoNu))
                    .addComponent(cboMaKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (!validateInput()) return;
        String sql = "INSERT INTO SinhVien (MaSinhVien, HoSinhVien, TenSinhVien, NgaySinh, Phai, MaKhoa) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = PhamDucTrongGiaoDien.dal.DBConnection;
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, txtMaSinhVien.getText().trim());
            ps.setString(2, txtHoSinhVien.getText().trim());
            ps.setString(3, txtTenSinhVien.getText().trim());
            ps.setDate(4, java.sql.Date.valueOf(getNgaySinh()));
            ps.setString(5, getPhai());
            ps.setString(6, cboMaKhoa.getSelectedItem().toString());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Thêm sinh viên thành công!");
            loadData();
            clearForm();
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 2627) JOptionPane.showMessageDialog(this, "Mã sinh viên đã tồn tại!");
            else showError(ex);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (!validateInput()) return;
        String sql = "UPDATE SinhVien SET HoSinhVien = ?, TenSinhVien = ?, NgaySinh = ?, Phai = ?, MaKhoa = ? "
                   + "WHERE MaSinhVien = ?";
        try (Connection con = PhamDucTrongGiaoDien.dal.DBConnection;
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, txtHoSinhVien.getText().trim());
            ps.setString(2, txtTenSinhVien.getText().trim());
            ps.setDate(3, java.sql.Date.valueOf(getNgaySinh()));
            ps.setString(4, getPhai());
            ps.setString(5, cboMaKhoa.getSelectedItem().toString());
            ps.setString(6, txtMaSinhVien.getText().trim());
            if (ps.executeUpdate() > 0) JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            loadData();
            clearForm();
        } catch (SQLException ex) {
            showError(ex);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int c = JOptionPane.showConfirmDialog(this, "Xóa sinh viên này (kèm kết quả thi)?",
                "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (c != JOptionPane.YES_OPTION) return;
        String maSV = txtMaSinhVien.getText().trim();
        try (Connection con = PhamDucTrongGiaoDien.dal.DBConnection()) {
            con.setAutoCommit(false);                       // xóa 2 bảng trong 1 giao dịch
            try (PreparedStatement p1 = con.prepareStatement("DELETE FROM KetQua WHERE MaSinhVien = ?");
                 PreparedStatement p2 = con.prepareStatement("DELETE FROM SinhVien WHERE MaSinhVien = ?")) {
                p1.setString(1, maSV);
                p1.executeUpdate();
                p2.setString(1, maSV);
                p2.executeUpdate();
                con.commit();
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
            } catch (SQLException ex) {
                con.rollback();
                throw ex;
            }
            loadData();
            clearForm();
        } catch (SQLException ex) {
            showError(ex);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        loadData();
        clearForm();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void rdoNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNamActionPerformed
        
    }//GEN-LAST:event_rdoNamActionPerformed

    private void rdoNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNuActionPerformed
        
    }//GEN-LAST:event_rdoNuActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new frmSinhVien().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup btngPhai;
    private javax.swing.JComboBox<String> cboMaKhoa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHoSV;
    private javax.swing.JLabel lblMaKhoa;
    private javax.swing.JLabel lblMaSV;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JLabel lblPhai;
    private javax.swing.JLabel lblTen;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblSinhVien;
    private javax.swing.JTextField txtHoSinhVien;
    private javax.swing.JTextField txtMaSinhVien;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtTenSinhVien;
    // End of variables declaration//GEN-END:variables
}
