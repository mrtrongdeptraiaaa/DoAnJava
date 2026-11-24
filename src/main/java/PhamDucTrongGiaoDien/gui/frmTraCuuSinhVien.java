package PhamDucTrongGiaoDien.gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class frmTraCuuSinhVien extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(frmTraCuuSinhVien.class.getName());

    public frmTraCuuSinhVien() {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);   // Vô hiệu hóa nút X
        initComponents();
        setLocationRelativeTo(null);
        loadDanhSachKhoa();
        lstKhoa.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) showThongTinKhoa();
        });
    }

    private void loadDanhSachKhoa() {
        DefaultListModel<String> model = new DefaultListModel<>();
        try (Connection con = PhamDucTrongGiaoDien.dal.DBConnection;
            PreparedStatement ps = con.prepareStatement("SELECT MaKhoa FROM Khoa ORDER BY MaKhoa");
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) model.addElement(rs.getString(1));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi CSDL: " + ex.getMessage());
        }
        lstKhoa.setModel(model);
    }

    private void showThongTinKhoa() {
        String maKhoa = lstKhoa.getSelectedValue();
        if (maKhoa == null) return;
        String sql = "SELECT k.TenKhoa, COUNT(s.MaSinhVien) AS SoSV "
                + "FROM Khoa k LEFT JOIN SinhVien s ON k.MaKhoa = s.MaKhoa "
                + "WHERE k.MaKhoa = ? GROUP BY k.TenKhoa";
        try (Connection con = PhamDucTrongGiaoDien.dal.DBConnection;
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maKhoa);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    lblMaKhoaKQ.setText(maKhoa);
                    lblTenKhoaKQ.setText(rs.getString("TenKhoa"));
                    lblSoSinhVienKQ.setText(String.valueOf(rs.getInt("SoSV")));
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi CSDL: " + ex.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTieuDe = new javax.swing.JLabel();
        btnThoat1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstKhoa = new javax.swing.JList<>();
        lblMaKhoaKQ = new javax.swing.JLabel();
        lblTenKhoaKQ = new javax.swing.JLabel();
        lblSoSinhVienKQ = new javax.swing.JLabel();
        lblMaKhoa = new javax.swing.JLabel();
        lblTenKhoa = new javax.swing.JLabel();
        lblSoSinhVien = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTieuDe.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblTieuDe.setForeground(new java.awt.Color(51, 51, 255));
        lblTieuDe.setText("TRA CỨU SINH VIÊN THEO KHOA");

        btnThoat1.setText("Thoát");
        btnThoat1.addActionListener(this::btnThoat1ActionPerformed);

        jLabel1.setText("Danh sách:");

        jScrollPane1.setViewportView(lstKhoa);

        lblMaKhoaKQ.setText("....");

        lblTenKhoaKQ.setText("....");

        lblSoSinhVienKQ.setText("....");

        lblMaKhoa.setText("Mã Khoa:");

        lblTenKhoa.setText("Tên Khoa:");

        lblSoSinhVien.setText("Số Sinh Viên:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSoSinhVien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSoSinhVienKQ)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(lblTieuDe))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTenKhoa)
                                    .addComponent(lblMaKhoa))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnThoat1)
                                        .addGap(167, 167, 167))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblTenKhoaKQ)
                                            .addComponent(lblMaKhoaKQ))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap(35, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTieuDe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaKhoaKQ)
                    .addComponent(lblMaKhoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenKhoaKQ)
                    .addComponent(lblTenKhoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSoSinhVien)
                    .addComponent(lblSoSinhVienKQ))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(btnThoat1)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoat1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnThoat1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new frmTraCuuSinhVien().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThoat1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMaKhoa;
    private javax.swing.JLabel lblMaKhoaKQ;
    private javax.swing.JLabel lblSoSinhVien;
    private javax.swing.JLabel lblSoSinhVienKQ;
    private javax.swing.JLabel lblTenKhoa;
    private javax.swing.JLabel lblTenKhoaKQ;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JList<String> lstKhoa;
    // End of variables declaration//GEN-END:variables
}
