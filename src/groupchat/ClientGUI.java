package groupchat;

import SQL.ConnectSQL;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ClientGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private boolean connected;
    private Client client;
    private int defaultPort = 1500;
    private String defaultHost = "localhost";
    private String pathAvatar;
    Timer tm;

    public ClientGUI(String host, int port) {
        super("Chat Client");
        initComponents();
        defaultPort = port;
        defaultHost = host;
        ImageIcon icon = new ImageIcon(getClass().getResource("/Icons/icon.png"));
        Image image = icon.getImage();
        setIconImage(image);
        
        lbl_Name.setText("Tên: " + frmDangNhap.nickName);
        lbl_TrangThai.setText("Trạng thái: Đang hoạt động");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        txa_Chat.requestFocus();
       
        ConnectSQL cn = new ConnectSQL();
        pathAvatar = cn.getAvatar(frmDangNhap.nickName);
        if(pathAvatar != null){
            lbl_Avatar.setIcon(ResizeImage(pathAvatar, null));
        }
        else lbl_Avatar.setIcon(ResizeImage("./" + "src/Icons/default_avatar.png", null));
        
        
        tm = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConnectSQL cn = new ConnectSQL();
                txa_Online.setText(cn.getOnl());
            }
        });

    }

    void appendChat(String str) {
        txa_FrameChat.append(str);
        txa_FrameChat.setCaretPosition(txa_FrameChat.getText().length() - 1);
    }

    void connectionFailed() {
        lbl_Logout.setEnabled(false);
        lbl_Name.setText("Anonymous");
        lbl_TrangThai.setText("Đang bận");
        connected = false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlChatGroup = new javax.swing.JPanel();
        lbl_Avatar = new javax.swing.JLabel();
        lbl_Name = new javax.swing.JLabel();
        lbl_TrangThai = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txa_FrameChat = new javax.swing.JTextArea();
        lbl_Send = new javax.swing.JLabel();
        lbl_Sticker = new javax.swing.JLabel();
        lbl_More = new javax.swing.JLabel();
        lbl_Logout = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txa_Chat = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txa_Online = new javax.swing.JTextArea();
        lbl_EditName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(86, 168, 227));
        setName("frmClientGUI"); // NOI18N
        setPreferredSize(new java.awt.Dimension(645, 570));
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        pnlChatGroup.setBackground(new java.awt.Color(86, 168, 227));
        pnlChatGroup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlChatGroup.setMaximumSize(null);
        pnlChatGroup.setPreferredSize(new java.awt.Dimension(640, 560));

        lbl_Avatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/default_avatar.png"))); // NOI18N
        lbl_Avatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_Avatar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_AvatarMouseClicked(evt);
            }
        });

        lbl_Name.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_Name.setText("Tên:");

        lbl_TrangThai.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_TrangThai.setText("Trạng thái: ");

        txa_FrameChat.setEditable(false);
        txa_FrameChat.setColumns(20);
        txa_FrameChat.setLineWrap(true);
        txa_FrameChat.setRows(5);
        jScrollPane1.setViewportView(txa_FrameChat);

        lbl_Send.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/send.png"))); // NOI18N
        lbl_Send.setToolTipText("Gửi");
        lbl_Send.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_SendMouseClicked(evt);
            }
        });

        lbl_Sticker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Sticker.png"))); // NOI18N
        lbl_Sticker.setToolTipText("Biểu cảm");
        lbl_Sticker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_StickerMouseClicked(evt);
            }
        });

        lbl_More.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        lbl_More.setText("... ");
        lbl_More.setToolTipText("Đổi mật khẩu");
        lbl_More.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_MoreMouseClicked(evt);
            }
        });

        lbl_Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Logout.png"))); // NOI18N
        lbl_Logout.setToolTipText("Đăng xuất");
        lbl_Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_LogoutMouseClicked(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txa_Chat.setColumns(20);
        txa_Chat.setLineWrap(true);
        txa_Chat.setRows(5);
        txa_Chat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txa_ChatKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(txa_Chat);

        txa_Online.setColumns(20);
        txa_Online.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txa_Online.setRows(5);
        txa_Online.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Đang hoạt động", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        txa_Online.setMaximumSize(new java.awt.Dimension(172, 93));
        txa_Online.setMinimumSize(new java.awt.Dimension(172, 93));
        txa_Online.setRequestFocusEnabled(false);
        jScrollPane3.setViewportView(txa_Online);

        lbl_EditName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/edit.png"))); // NOI18N
        lbl_EditName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_EditNameMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlChatGroupLayout = new javax.swing.GroupLayout(pnlChatGroup);
        pnlChatGroup.setLayout(pnlChatGroupLayout);
        pnlChatGroupLayout.setHorizontalGroup(
            pnlChatGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChatGroupLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnlChatGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(5, 5, 5)
                .addGroup(pnlChatGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlChatGroupLayout.createSequentialGroup()
                        .addComponent(lbl_Send, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lbl_Sticker, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_More, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
            .addGroup(pnlChatGroupLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbl_Avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlChatGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlChatGroupLayout.createSequentialGroup()
                        .addComponent(lbl_Name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_EditName))
                    .addComponent(lbl_TrangThai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        pnlChatGroupLayout.setVerticalGroup(
            pnlChatGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChatGroupLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlChatGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlChatGroupLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(pnlChatGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Name)
                            .addComponent(lbl_EditName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_TrangThai))
                    .addComponent(lbl_Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnlChatGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addGroup(pnlChatGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlChatGroupLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlChatGroupLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(pnlChatGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Send, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Sticker, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlChatGroupLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbl_More, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlChatGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlChatGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean flag;
    private int x,y;
    
    private void lbl_LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_LogoutMouseClicked
        client.sendMessage(new ChatMessage(ChatMessage.LOGOUT, ""));
        ConnectSQL cn = new ConnectSQL();
        cn.logOut(frmDangNhap.nickName);
        tm.stop();
        this.dispose();
        Run.dangNhap();
        
    }//GEN-LAST:event_lbl_LogoutMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        String server = defaultHost;
        int port = defaultPort;
        String username = frmDangNhap.nickName;
        client = new Client(server, port, username, this);
        if (!client.start()) {
            return;
        }
        txa_Chat.setText("");
        connected = true;
        tm.start();
        
    }//GEN-LAST:event_formWindowOpened

    private void txa_ChatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txa_ChatKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            client.sendMessage(new ChatMessage(ChatMessage.MESSAGE, txa_Chat.getText()));
            evt.consume();
            txa_Chat.setText("");
        }
    }//GEN-LAST:event_txa_ChatKeyPressed

    private void lbl_SendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_SendMouseClicked
        client.sendMessage(new ChatMessage(ChatMessage.MESSAGE, txa_Chat.getText()));
        evt.consume();
        txa_Chat.setText("");
    }//GEN-LAST:event_lbl_SendMouseClicked

    private void lbl_StickerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_StickerMouseClicked
        JOptionPane.showConfirmDialog(this, "Tính năng gửi Sticker\n đang được phát triển!", "Thông báo", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_lbl_StickerMouseClicked

    private void lbl_MoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_MoreMouseClicked
        frmDoiMatKhau doiMk = new frmDoiMatKhau();
        doiMk.setVisible(true);
        doiMk.setLocationRelativeTo(this);
        
    }//GEN-LAST:event_lbl_MoreMouseClicked

    private ImageIcon ResizeImage(String imagePath, byte[] pic){
        ImageIcon myImage = null;
        if(imagePath != null)
        {
            myImage = new ImageIcon(imagePath);
        }else{
            myImage = new ImageIcon(pic);
        }
        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(lbl_Avatar.getWidth(), lbl_Avatar.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
     }
    
    private void lbl_AvatarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_AvatarMouseClicked
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
       
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg","png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            
            lbl_Avatar.setIcon(ResizeImage(path, null));
            ConnectSQL cn = new ConnectSQL();
            cn.setAvatar(frmDangNhap.nickName, path);
        }
        else{
            System.out.println("Không tìm được ảnh !");
        }
    }//GEN-LAST:event_lbl_AvatarMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        client.sendMessage(new ChatMessage(ChatMessage.LOGOUT, ""));
        ConnectSQL cn = new ConnectSQL();
        cn.logOut(frmDangNhap.nickName);
        tm.stop();
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

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
        flag=false;
    }//GEN-LAST:event_formMouseReleased

    private void lbl_EditNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_EditNameMouseClicked
        String name = JOptionPane.showInputDialog("Mời bạn nhập tên mới: ");
            if(name != null){
                int cfm = JOptionPane.showConfirmDialog(this, "Bạn vui lòng đăng nhập lại \nđể xác nhận các thay đổi!", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (cfm == 0){
                ConnectSQL cn = new ConnectSQL();
                cn.changeNickName(name, frmDangNhap.nick);
                lbl_Name.setText("Tên: "+name);
                client.sendMessage(new ChatMessage(ChatMessage.LOGOUT, ""));
                cn.logOut(frmDangNhap.nickName);
                tm.stop();
                this.dispose();
                Run.dangNhap();
                }    
            }
    }//GEN-LAST:event_lbl_EditNameMouseClicked

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
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        new ClientGUI("localhost", 1500);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_Avatar;
    private javax.swing.JLabel lbl_EditName;
    private javax.swing.JLabel lbl_Logout;
    private javax.swing.JLabel lbl_More;
    private javax.swing.JLabel lbl_Name;
    private javax.swing.JLabel lbl_Send;
    private javax.swing.JLabel lbl_Sticker;
    private javax.swing.JLabel lbl_TrangThai;
    private javax.swing.JPanel pnlChatGroup;
    private javax.swing.JTextArea txa_Chat;
    private javax.swing.JTextArea txa_FrameChat;
    private javax.swing.JTextArea txa_Online;
    // End of variables declaration//GEN-END:variables
}
