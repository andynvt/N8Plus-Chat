
package groupchat;

import Models.TaiKhoan;


public class Run {
    
    public static frmDangNhap frmDangNhap;
    public static TaiKhoan tk;
  
    
    public static void main(String[] args) {
        dangNhap();
    }
    public static void dangNhap(){
        frmDangNhap frm = new frmDangNhap();
        frm.setTitle("Đăng Nhập - N8+ GroupChat");
        frm.setDefaultCloseOperation(frmDangNhap.EXIT_ON_CLOSE);
        frm.pack();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);     
    }     
}