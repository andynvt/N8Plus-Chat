/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupchat;

import Models.*;
import SQL.*;
import java.awt.Color;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.border.Border;


public class frmDangNhap extends javax.swing.JFrame {
    
    ConnectSQL cn = new ConnectSQL();
    public static String nickName;
    public static String nick;
    public frmDangNhap() {
        initComponents();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Icons/icon.png"));
        Image image = icon.getImage();
        setIconImage(image);
        JRootPane rp = this.getRootPane();
        rp.setDefaultButton(btn_DangNhap);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_Main = new javax.swing.JPanel();
        lbl_name = new javax.swing.JLabel();
        lbl_TenDangNhap = new javax.swing.JLabel();
        lbl_MatKhau = new javax.swing.JLabel();
        txt_TenDangNhap = new javax.swing.JTextField();
        txt_MatKhau = new javax.swing.JPasswordField();
        btn_DangNhap = new javax.swing.JButton();
        btn_Thoat = new javax.swing.JButton();
        lbl_TaoTK = new javax.swing.JLabel();
        lbl_QuenMatKhau = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        pn_Main.setBackground(new java.awt.Color(255, 255, 255));
        pn_Main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 40, 50), 3));

        lbl_name.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_name.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/main banner.png"))); // NOI18N

        lbl_TenDangNhap.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_TenDangNhap.setText("Tên đăng nhập: ");

        lbl_MatKhau.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_MatKhau.setText("Mật khẩu:");

        txt_TenDangNhap.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_TenDangNhap.setToolTipText("");
        txt_TenDangNhap.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txt_MatKhau.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_MatKhau.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_DangNhap.setBackground(new java.awt.Color(0, 40, 50));
        btn_DangNhap.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_DangNhap.setForeground(new java.awt.Color(255, 255, 255));
        btn_DangNhap.setText("Đăng Nhập");
        btn_DangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DangNhapActionPerformed(evt);
            }
        });

        btn_Thoat.setBackground(new java.awt.Color(0, 40, 50));
        btn_Thoat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_Thoat.setForeground(new java.awt.Color(255, 255, 255));
        btn_Thoat.setText("Thoát");
        btn_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThoatActionPerformed(evt);
            }
        });

        lbl_TaoTK.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_TaoTK.setForeground(new java.awt.Color(0, 40, 50));
        lbl_TaoTK.setText("Tạo tài khoản");
        lbl_TaoTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_TaoTKMouseClicked(evt);
            }
        });

        lbl_QuenMatKhau.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_QuenMatKhau.setForeground(new java.awt.Color(0, 40, 50));
        lbl_QuenMatKhau.setText("Quên mật khẩu?");
        lbl_QuenMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_QuenMatKhauMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pn_MainLayout = new javax.swing.GroupLayout(pn_Main);
        pn_Main.setLayout(pn_MainLayout);
        pn_MainLayout.setHorizontalGroup(
            pn_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_MainLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pn_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_MainLayout.createSequentialGroup()
                        .addComponent(lbl_MatKhau)
                        .addGap(57, 57, 57)
                        .addComponent(txt_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pn_MainLayout.createSequentialGroup()
                        .addGroup(pn_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_name)
                            .addGroup(pn_MainLayout.createSequentialGroup()
                                .addGroup(pn_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pn_MainLayout.createSequentialGroup()
                                        .addComponent(lbl_TaoTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(17, 17, 17))
                                    .addComponent(lbl_QuenMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(pn_MainLayout.createSequentialGroup()
                                        .addComponent(lbl_TenDangNhap)
                                        .addGap(1, 1, 1)))
                                .addGap(18, 18, 18)
                                .addComponent(txt_TenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30))
                    .addGroup(pn_MainLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btn_DangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(39, 39, 39)
                        .addComponent(btn_Thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))))
        );
        pn_MainLayout.setVerticalGroup(
            pn_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_MainLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbl_name)
                .addGap(36, 36, 36)
                .addGroup(pn_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_MainLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbl_TenDangNhap))
                    .addComponent(txt_TenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(pn_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_MatKhau))
                .addGap(15, 15, 15)
                .addGroup(pn_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Thoat, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(btn_DangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addComponent(lbl_TaoTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addComponent(lbl_QuenMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_Main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_Main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Border lineBorder = BorderFactory.createLineBorder(Color.RED);
    private Border nullBorder = BorderFactory.createLineBorder(Color.BLACK);
    public void setNullBorder(){
        txt_MatKhau.setBorder(nullBorder);
        txt_TenDangNhap.setBorder(nullBorder);
    }
    
    private void btn_DangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DangNhapActionPerformed
        // TODO add your handling code here:
        String tdn, mk;
        tdn = txt_TenDangNhap.getText();
        mk = String.valueOf(this.txt_MatKhau.getPassword());
        TaiKhoan tk = new TaiKhoan();
        tk.setTdn(tdn); tk.setMk(mk);
        boolean check = cn.CheckLogin(tk);
        int lv = cn.LVTK(tk);
        if(tdn.equals("") || mk.equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ các trường!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            setNullBorder();
            if(tdn.equals(""))
               txt_TenDangNhap.setBorder(lineBorder);
            if(mk.equals(""))
               txt_MatKhau.setBorder(lineBorder);
        }
        else{
            if(check == true){
                if(lv==1){
                   Run.tk = cn.GetTaiKhoan(tdn, mk);
                    this.setVisible(false);
                    ServerGUI frmServer = new ServerGUI(1500);
                }
                if(lv==2){
                    Run.tk = cn.GetTaiKhoan(tdn, mk);
                    this.setVisible(false);
                    nickName = cn.getNickName(tdn);
                    nick = tk.getTdn();
                    ClientGUI frmClient = new ClientGUI("localhost", 1500);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng", "Lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
            }
        } 
    }//GEN-LAST:event_btn_DangNhapActionPerformed

    private void lbl_TaoTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_TaoTKMouseClicked
        // TODO add your handling code here:
        frmDangKy frm = new frmDangKy();
        frm.setDefaultCloseOperation(frmDangNhap.HIDE_ON_CLOSE);
        frm.pack();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
        
    }//GEN-LAST:event_lbl_TaoTKMouseClicked

    private boolean flag;
    private int x,y;
    
    private void lbl_QuenMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_QuenMatKhauMouseClicked
        // TODO add your handling code here:
        frmQuenMatKhau frm = new frmQuenMatKhau();
        frm.setDefaultCloseOperation(frmQuenMatKhau.HIDE_ON_CLOSE);
        frm.pack();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
       
    }//GEN-LAST:event_lbl_QuenMatKhauMouseClicked

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
       if (flag) {
            this.setLocation(evt.getXOnScreen() - x, evt.getYOnScreen() - y);
        }
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        flag = true;
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        flag = false;
    }//GEN-LAST:event_formMouseReleased

    private void btn_ThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThoatActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_ThoatActionPerformed

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
            java.util.logging.Logger.getLogger(frmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmDangNhap frm = new frmDangNhap();
                frm.setDefaultCloseOperation(frmDangNhap.EXIT_ON_CLOSE);
                frm.pack();
                frm.setLocationRelativeTo(null);
                frm.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_DangNhap;
    private javax.swing.JButton btn_Thoat;
    private javax.swing.JLabel lbl_MatKhau;
    private javax.swing.JLabel lbl_QuenMatKhau;
    private javax.swing.JLabel lbl_TaoTK;
    private javax.swing.JLabel lbl_TenDangNhap;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JPanel pn_Main;
    private javax.swing.JPasswordField txt_MatKhau;
    private javax.swing.JTextField txt_TenDangNhap;
    // End of variables declaration//GEN-END:variables
}
