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
        
        lblName.setText("Tên: " + frmDangNhap.nickName);
        lblTrangThai.setText("Trạng thái: Đang hoạt động");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        txaChat.requestFocus();
       
        ConnectSQL cn = new ConnectSQL();
        pathAvatar = cn.getAvatar(frmDangNhap.nickName);
        if(pathAvatar != null){
            lblAvatar.setIcon(ResizeImage(pathAvatar, null));
        }
        else lblAvatar.setIcon(ResizeImage("./" + "src/Icons/default_avatar.png", null));
        
        
        tm = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConnectSQL cn = new ConnectSQL();
                txaOnline.setText(cn.getOnl());
            }
        });

    }

    void appendChat(String str) {
        txaFrameChat.append(str);
        txaFrameChat.setCaretPosition(txaFrameChat.getText().length() - 1);
    }

    void connectionFailed() {
        lblLogout.setEnabled(false);
        lblName.setText("Anonymous");
        lblTrangThai.setText("Đang bận");
        connected = false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlChatGroup = new javax.swing.JPanel();
        lblAvatar = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblTrangThai = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaFrameChat = new javax.swing.JTextArea();
        lblSend = new javax.swing.JLabel();
        lblSticker = new javax.swing.JLabel();
        lblMore = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaChat = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaOnline = new javax.swing.JTextArea();
        lblEditName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(86, 168, 227));
        setName("frmClientGUI"); // NOI18N
        setUndecorated(true);
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
        pnlChatGroup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 40, 50), 2));
        pnlChatGroup.setMaximumSize(null);
        pnlChatGroup.setPreferredSize(new java.awt.Dimension(640, 560));

        lblAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/default_avatar.png"))); // NOI18N
        lblAvatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblAvatar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAvatarMouseClicked(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblName.setText("Tên:");

        lblTrangThai.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTrangThai.setText("Trạng thái: ");

        txaFrameChat.setColumns(20);
        txaFrameChat.setLineWrap(true);
        txaFrameChat.setRows(5);
        jScrollPane1.setViewportView(txaFrameChat);

        lblSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/send.png"))); // NOI18N
        lblSend.setToolTipText("Gửi");
        lblSend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSendMouseClicked(evt);
            }
        });

        lblSticker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Sticker.png"))); // NOI18N
        lblSticker.setToolTipText("Biểu cảm");
        lblSticker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStickerMouseClicked(evt);
            }
        });

        lblMore.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        lblMore.setText("... ");
        lblMore.setToolTipText("Đổi mật khẩu");
        lblMore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMoreMouseClicked(evt);
            }
        });

        lblLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Logout.png"))); // NOI18N
        lblLogout.setToolTipText("Đăng xuất");
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txaChat.setColumns(20);
        txaChat.setLineWrap(true);
        txaChat.setRows(5);
        txaChat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txaChatKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(txaChat);

        txaOnline.setColumns(20);
        txaOnline.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txaOnline.setRows(5);
        txaOnline.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Đang hoạt động", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        txaOnline.setMaximumSize(new java.awt.Dimension(172, 93));
        txaOnline.setMinimumSize(new java.awt.Dimension(172, 93));
        txaOnline.setRequestFocusEnabled(false);
        jScrollPane3.setViewportView(txaOnline);

        lblEditName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/edit.png"))); // NOI18N
        lblEditName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEditNameMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlChatGroupLayout = new javax.swing.GroupLayout(pnlChatGroup);
        pnlChatGroup.setLayout(pnlChatGroupLayout);
        pnlChatGroupLayout.setHorizontalGroup(
            pnlChatGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChatGroupLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnlChatGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(5, 5, 5)
                .addGroup(pnlChatGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlChatGroupLayout.createSequentialGroup()
                        .addComponent(lblSend, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblSticker, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMore, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
            .addGroup(pnlChatGroupLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlChatGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlChatGroupLayout.createSequentialGroup()
                        .addComponent(lblName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblEditName))
                    .addComponent(lblTrangThai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        pnlChatGroupLayout.setVerticalGroup(
            pnlChatGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChatGroupLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlChatGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlChatGroupLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(pnlChatGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName)
                            .addComponent(lblEditName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTrangThai))
                    .addComponent(lblLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(lblSend, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSticker, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlChatGroupLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblMore, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
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
    
    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        client.sendMessage(new ChatMessage(ChatMessage.LOGOUT, ""));
        ConnectSQL cn = new ConnectSQL();
        cn.logOut(frmDangNhap.nickName);
        tm.stop();
        this.dispose();
        Run.dangNhap();
        
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        String server = defaultHost;
        int port = defaultPort;
        String username = frmDangNhap.nickName;
        client = new Client(server, port, username, this);
        if (!client.start()) {
            return;
        }
        txaChat.setText("");
        connected = true;
        tm.start();
        
    }//GEN-LAST:event_formWindowOpened

    private void txaChatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaChatKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            client.sendMessage(new ChatMessage(ChatMessage.MESSAGE, txaChat.getText()));
            evt.consume();
            txaChat.setText("");
        }
    }//GEN-LAST:event_txaChatKeyPressed

    private void lblSendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSendMouseClicked
        client.sendMessage(new ChatMessage(ChatMessage.MESSAGE, txaChat.getText()));
        evt.consume();
        txaChat.setText("");
    }//GEN-LAST:event_lblSendMouseClicked

    private void lblStickerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStickerMouseClicked
        JOptionPane.showConfirmDialog(this, "Tính năng gửi Sticker\n đang được phát triển!", "Thông báo", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_lblStickerMouseClicked

    private void lblMoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMoreMouseClicked
        frmDoiMatKhau doiMk = new frmDoiMatKhau();
        doiMk.setVisible(true);
        doiMk.setLocationRelativeTo(this);
        
    }//GEN-LAST:event_lblMoreMouseClicked

    private ImageIcon ResizeImage(String imagePath, byte[] pic){
        ImageIcon myImage = null;
        if(imagePath != null)
        {
            myImage = new ImageIcon(imagePath);
        }else{
            myImage = new ImageIcon(pic);
        }
        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(lblAvatar.getWidth(), lblAvatar.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
     }
    
    private void lblAvatarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAvatarMouseClicked
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
       
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg","png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            
            lblAvatar.setIcon(ResizeImage(path, null));
            ConnectSQL cn = new ConnectSQL();
            cn.setAvatar(frmDangNhap.nickName, path);
        }
        else{
            System.out.println("Không tìm được ảnh !");
        }
    }//GEN-LAST:event_lblAvatarMouseClicked

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

    private void lblEditNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditNameMouseClicked
        String name = JOptionPane.showInputDialog("Mời bạn nhập tên mới: ");
        if(name != null){
            ConnectSQL cn = new ConnectSQL();
            cn.changeNickName(name, frmDangNhap.nick);
            lblName.setText("Tên: "+name);
        }
    }//GEN-LAST:event_lblEditNameMouseClicked

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
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblEditName;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblMore;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSend;
    private javax.swing.JLabel lblSticker;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JPanel pnlChatGroup;
    private javax.swing.JTextArea txaChat;
    private javax.swing.JTextArea txaFrameChat;
    private javax.swing.JTextArea txaOnline;
    // End of variables declaration//GEN-END:variables
}
