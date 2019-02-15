
package SQL;

import Models.TaiKhoan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javax.swing.JOptionPane;

public class ConnectSQL {
    private Connection cn;
    public ConnectSQL(){
        try{
            cn = DriverManager.getConnection("jdbc:sqlserver://NGUYENHIEP\\MSSQLSERVER2014:1433;databaseName=GroupChat;user=sa;password=sa2014");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Kết nối thất bại nhé!");
        }        
    }
public boolean CheckLogin(TaiKhoan tk)
    {
        boolean check = false;
        String sql;
            sql = "Select * From taikhoan Where tentk = '"+tk.getTdn()+"' AND mk='"+tk.getMk()+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                check = true; 
            }
            if (check = true){
                st.executeUpdate("UPDATE taikhoan SET online = 'true' WHERE tentk = '"+tk.getTdn()+"'"); 
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi đăng nhập !");
        }
        return check; 
    }
    public boolean CheckTDN(String tdn){
        String sql;
            sql = "Select * From taikhoan Where tentk = '"+tdn+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                return true;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }
    public int LVTK(TaiKhoan tk)
    {
        int lvtk =0;
        String sql;
            sql = "Select lv From taikhoan Where tentk = '"+tk.getTdn()+"' AND mk='"+tk.getMk()+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                lvtk = rs.getInt(1);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return lvtk; 
    }    
    public TaiKhoan GetTaiKhoan(String name, String pass){
        TaiKhoan td = null;
        String sql;
            sql = "SELECT * FROM taikhoan Where tentk = '"+name+"' AND mk='"+pass+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
               td  = new TaiKhoan( rs.getString(1), rs.getString(2), rs.getInt(3));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return td;
    }
    public void DangKyTK(String tdn, String mk, String mkc2, Object nick){
        try{
            Statement st = cn.createStatement();
            int rows = st.executeUpdate("insert into taikhoan values('"+tdn+"','"+mk+"',2,'"+mkc2+"',N'"+nick+"', 'false', 'null')");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
    }
    public String RandomPass(){
        Random ran = new Random();
        int top = 4;
        char data = ' ';
        String dat = "";
        for (int i=0; i<=top; i++) {
          data = (char)(ran.nextInt(25)+97);
          dat = data + dat;
        }
        return dat;
    }
    
    public void QuenMK(String tdn, String newpass){
        try{
            Statement st = cn.createStatement();
            int rows = st.executeUpdate("UPDATE taikhoan SET mk = '"+newpass+"' WHERE tentk = '"+tdn+"'");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }    
    }
    
    public boolean CheckQuenMK(String tdn, String mkc2){
        boolean check=false;
        String sql;
            sql = "SELECT * FROM taikhoan Where tentk = '"+tdn+"' AND mkc2='"+mkc2+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                return true;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean CheckMKCu(String tdn, String mk){
        boolean check=false;
        String sql;
            sql = "SELECT * FROM taikhoan Where tentk = '"+tdn+"' AND mk='"+mk+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                return true;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    public String getNickName (String tdn){
        String nickName = null;
        String sql;
            sql = "SELECT * FROM taikhoan Where tentk = '"+tdn+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
               nickName  = rs.getString(5);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }        
        return nickName;
    }
    
    public String getOnl (){
        String online = "";
        String sql;
            sql = "SELECT nick FROM taikhoan Where online='True' and tentk <> 'admin' "; 
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                online += "- " + rs.getString(1) +"\n";
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }        
        return online;
    }
    
    public void logOut (String nick){
        try{
            Statement st = cn.createStatement();
            st.executeUpdate("UPDATE taikhoan SET online='false' WHERE nick=N'"+nick+"'"); 
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }  
    }
    
    public String getAvatar (String nick){
        String pathAvatar = null;
        String sql = "SELECT * FROM taikhoan WHERE nick=N'"+nick+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
               pathAvatar  = rs.getString(7);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }  
        return pathAvatar;
    }
    
    public void setAvatar (String nick, String path){
        try{
            Statement st = cn.createStatement();
            st.executeUpdate("UPDATE taikhoan SET avatar='"+path+"' WHERE nick=N'"+nick+"'"); 
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }  
    }
    
    public void changeNickName (String nickName, String tdn){
        try{
            Statement st = cn.createStatement();
            st.executeUpdate("UPDATE taikhoan SET nick=N'"+nickName+"' WHERE tentk='"+tdn+"'"); 
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }  
    }
}
