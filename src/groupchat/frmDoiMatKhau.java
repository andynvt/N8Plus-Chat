/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupchat;

import Models.TaiKhoan;
import java.awt.Image;
import SQL.*;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.border.Border;


public class frmDoiMatKhau extends javax.swing.JFrame {

    ConnectSQL cn = new ConnectSQL();
    public frmDoiMatKhau() {
        initComponents();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Icons/icon.png"));
        Image image = icon.getImage();
        setIconImage(image);
        JRootPane rp = this.getRootPane();
        rp.setDefaultButton(btn_DoiMatKhau);
        txt_tdn.setText(tdn);
        txt_tdn.setEditable(false);
        
    }

    String mkc, tdn = frmDangNhap.nick , newpass="", mkm, mkm2;
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbl_title = new javax.swing.JLabel();
        txt_tdn = new javax.swing.JTextField();
        lbl_mkc = new javax.swing.JLabel();
        txt_MatKhauCu = new javax.swing.JPasswordField();
        btn_DoiMatKhau = new javax.swing.JButton();
        lbl_tdn = new javax.swing.JLabel();
        lbl_MKMoi = new javax.swing.JLabel();
        txt_MKMoi = new javax.swing.JPasswordField();
        lbl_MKMoi2 = new javax.swing.JLabel();
        txt_MKMoi2 = new javax.swing.JPasswordField();
        btn_DoiMKMoi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 40, 50), 3));

        jPanel2.setBackground(new java.awt.Color(0, 40, 50));
        jPanel2.setForeground(new java.awt.Color(86, 168, 227));

        lbl_title.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title.setText("Đổi mật khẩu");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_title)
                .addGap(110, 110, 110))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txt_tdn.setToolTipText("");
        txt_tdn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_tdn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tdnActionPerformed(evt);
            }
        });

        lbl_mkc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_mkc.setText("Mật khẩu cũ:");

        txt_MatKhauCu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_DoiMatKhau.setBackground(new java.awt.Color(0, 40, 50));
        btn_DoiMatKhau.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_DoiMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        btn_DoiMatKhau.setText("Đổi Mật Khẩu ");
        btn_DoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DoiMatKhauActionPerformed(evt);
            }
        });

        lbl_tdn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_tdn.setText("Tên đăng nhập:");

        lbl_MKMoi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_MKMoi.setText("Mật khẩu mới:");

        txt_MKMoi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_MKMoi2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_MKMoi2.setText("Nhập lại mật khẩu mới:");

        txt_MKMoi2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_DoiMKMoi.setBackground(new java.awt.Color(0, 40, 50));
        btn_DoiMKMoi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_DoiMKMoi.setForeground(new java.awt.Color(255, 255, 255));
        btn_DoiMKMoi.setText("Đóng");
        btn_DoiMKMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DoiMKMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_mkc)
                            .addComponent(lbl_tdn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_tdn, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(txt_MatKhauCu)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_MKMoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_MKMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_MKMoi2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_MKMoi2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_DoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btn_DoiMKMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_tdn)
                    .addComponent(txt_tdn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_mkc)
                    .addComponent(txt_MatKhauCu, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_MKMoi)
                    .addComponent(txt_MKMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_MKMoi2)
                    .addComponent(txt_MKMoi2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_DoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_DoiMKMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_tdnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tdnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tdnActionPerformed
    private Border lineBorder = BorderFactory.createLineBorder(Color.RED);
    private Border nullBorder = BorderFactory.createLineBorder(Color.BLACK);
    public void setNullBorder(){
        txt_MKMoi.setBorder(nullBorder);
        txt_MKMoi2.setBorder(nullBorder);
        txt_MatKhauCu.setBorder(nullBorder);
        txt_tdn.setBorder(nullBorder);
    }
    private void btn_DoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DoiMatKhauActionPerformed
        TaiKhoan tk = new TaiKhoan();
        String newpass="", newpass2="";
        tdn = txt_tdn.getText();
        mkc = txt_MatKhauCu.getText();
        mkm = txt_MKMoi.getText();
        mkm2 = txt_MKMoi2.getText();
        newpass = txt_MKMoi2.getText();
        boolean check = cn.CheckMKCu(tdn, mkc);
        
        if(tdn.equals("") || mkc.equals("") || mkm.equals("") || mkm2.equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ các trường!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            setNullBorder();
            if(tdn.equals(""))
               txt_tdn.setBorder(lineBorder);
            if(mkc.equals(""))
               txt_MatKhauCu.setBorder(lineBorder);
            if(mkm.equals(""))
               txt_MKMoi.setBorder(lineBorder); 
            if(mkm2.equals(""))
               txt_MKMoi2.setBorder(lineBorder);
            
        }
        else if (!check){
            setNullBorder();
            JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu cấp cũ không chính xác!\nVui lòng thử lại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        else{
            if(mkm.equals("")){
                txt_MKMoi.setBorder(lineBorder);
                JOptionPane.showMessageDialog(null, "Chưa nhập mật khẩu mới!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            else if(!mkm2.equals(mkm)){
                txt_MKMoi2.setBorder(lineBorder);
                JOptionPane.showMessageDialog(null, "Nhập lại mật khẩu mới không đúng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            else{
                cn.QuenMK(tdn, newpass); 
                JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công!");
                this.dispose();
            }
            
        }
        
       // JOptionPane.showMessageDialog(null, "Mật khẩu mới của bạn là:\n"+newpass+"\nHãy đăng nhập sau đó đổi lại mật khẩu!", "Thông tin", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btn_DoiMatKhauActionPerformed

    private void btn_DoiMKMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DoiMKMoiActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_DoiMKMoiActionPerformed
    private boolean flag;
    private int x,y;
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        if (flag) {
            this.setLocation(evt.getXOnScreen() - x, evt.getYOnScreen() - y);
        }
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        flag = true;
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        // TODO add your handling code here:
        flag = false;
    }//GEN-LAST:event_formMouseReleased

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
            java.util.logging.Logger.getLogger(frmDoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDoiMatKhau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_DoiMKMoi;
    private javax.swing.JButton btn_DoiMatKhau;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_MKMoi;
    private javax.swing.JLabel lbl_MKMoi2;
    private javax.swing.JLabel lbl_mkc;
    private javax.swing.JLabel lbl_tdn;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JPasswordField txt_MKMoi;
    private javax.swing.JPasswordField txt_MKMoi2;
    private javax.swing.JPasswordField txt_MatKhauCu;
    private javax.swing.JTextField txt_tdn;
    // End of variables declaration//GEN-END:variables
}
