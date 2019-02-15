/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupchat;
import Models.TaiKhoan;
import SQL.*;
import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.border.Border;

/**
 *
 * @author Boss Kha
 */
public class frmDangKy extends javax.swing.JFrame {

    /**
     * Creates new form frmDangKy
     */
    ConnectSQL cn = new ConnectSQL();
    public frmDangKy() {
        initComponents();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Icons/icon.png"));
        Image image = icon.getImage();
        setIconImage(image);
        JRootPane rp = this.getRootPane();
        rp.setDefaultButton(btn_DangKy);
    }

    String tdn, mk, mk2, mkc2;
    Object nick;
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_nick = new javax.swing.JLabel();
        txt_tdn = new javax.swing.JTextField();
        txt_nick = new javax.swing.JTextField();
        lbl_tdn = new javax.swing.JLabel();
        lbl_mk = new javax.swing.JLabel();
        lbl_mk2 = new javax.swing.JLabel();
        btn_DangKy = new javax.swing.JButton();
        btn_Dong = new javax.swing.JButton();
        lbl_mk1 = new javax.swing.JLabel();
        txt_MatKhau = new javax.swing.JPasswordField();
        txt_MatKhau2 = new javax.swing.JPasswordField();
        txt_MatKhauCap2 = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        lbl_title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lbl_nick.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_nick.setText("Nick name:");

        txt_tdn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tdnActionPerformed(evt);
            }
        });

        txt_nick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nickActionPerformed(evt);
            }
        });

        lbl_tdn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_tdn.setText("Tên đăng nhập: ");

        lbl_mk.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_mk.setText("Mật khẩu:");

        lbl_mk2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_mk2.setText("Nhập lại mật khẩu:");

        btn_DangKy.setBackground(new java.awt.Color(0, 40, 50));
        btn_DangKy.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_DangKy.setForeground(new java.awt.Color(255, 255, 255));
        btn_DangKy.setText("Đăng Ký");
        btn_DangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DangKyActionPerformed(evt);
            }
        });

        btn_Dong.setBackground(new java.awt.Color(0, 40, 50));
        btn_Dong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_Dong.setForeground(new java.awt.Color(255, 255, 255));
        btn_Dong.setText("Đóng");
        btn_Dong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DongActionPerformed(evt);
            }
        });

        lbl_mk1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_mk1.setText("Mật khẩu cấp 2:");

        jPanel2.setBackground(new java.awt.Color(0, 40, 50));
        jPanel2.setForeground(new java.awt.Color(86, 168, 227));

        lbl_title.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title.setText("Đăng ký tài khoản");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_title)
                .addGap(99, 99, 99))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btn_DangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btn_Dong, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_mk1)
                                .addGap(33, 33, 33)
                                .addComponent(txt_MatKhauCap2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_mk2)
                                .addGap(18, 18, 18)
                                .addComponent(txt_MatKhau2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_tdn)
                                    .addComponent(lbl_mk))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_tdn)
                                    .addComponent(txt_MatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_nick, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(txt_nick, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_tdn)
                    .addComponent(txt_tdn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_mk)
                    .addComponent(txt_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_mk2)
                    .addComponent(txt_MatKhau2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_mk1)
                    .addComponent(txt_MatKhauCap2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lbl_nick))
                    .addComponent(txt_nick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_Dong, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(btn_DangKy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_tdnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tdnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tdnActionPerformed

    private void txt_nickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nickActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nickActionPerformed

    private Border lineBorder = BorderFactory.createLineBorder(Color.RED);
    private void btn_DangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DangKyActionPerformed
        // TODO add your handling code here:
        tdn = txt_tdn.getText();
        mk = txt_MatKhau.getText();
        mk2 = txt_MatKhau2.getText();
        mkc2 = txt_MatKhauCap2.getText();
        nick = txt_nick.getText();
        TaiKhoan tk = new TaiKhoan();
        boolean check = cn.CheckTDN(tdn);
        if(check){
            txt_tdn.setBorder(lineBorder);
            JOptionPane.showMessageDialog(null, "Tên đăng nhập đã tồn tại!\nVui lòng chọn tên đăng nhập khác!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        else{
            if(mk.equals("")){
                txt_MatKhau.setBorder(lineBorder);
                JOptionPane.showMessageDialog(null, "Chưa nhập mật khẩu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            else if(!mk2.equals(mk)){
                txt_MatKhau2.setBorder(lineBorder);
                JOptionPane.showMessageDialog(null, "Nhập lại mật khẩu không đúng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            else if(mkc2.equals(mk)){
                txt_MatKhauCap2.setBorder(lineBorder);
                JOptionPane.showMessageDialog(null, "Mật khẩu cấp 2 không dược trùng với mật khẩu cấp 1", "Lỗi", JOptionPane.ERROR_MESSAGE);
                
            }
            else{
                cn.DangKyTK(tdn, mk, mkc2, nick);
                JOptionPane.showMessageDialog(this, "Đăng ký tài khoản thành công!");
                this.dispose();
            }
        }
        
        
    }//GEN-LAST:event_btn_DangKyActionPerformed

    private void btn_DongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DongActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_DongActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmDangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDangKy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDangKy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_DangKy;
    private javax.swing.JButton btn_Dong;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_mk;
    private javax.swing.JLabel lbl_mk1;
    private javax.swing.JLabel lbl_mk2;
    private javax.swing.JLabel lbl_nick;
    private javax.swing.JLabel lbl_tdn;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JPasswordField txt_MatKhau;
    private javax.swing.JPasswordField txt_MatKhau2;
    private javax.swing.JPasswordField txt_MatKhauCap2;
    private javax.swing.JTextField txt_nick;
    private javax.swing.JTextField txt_tdn;
    // End of variables declaration//GEN-END:variables
}
