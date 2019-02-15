package Models;

/**
 *
 * @author ANDY
 */
public class TaiKhoan {
    private int  lv;



    public void setLv(int lv) {
        this.lv = lv;
    }

    public void setTdn(String tdn) {
        this.tdn = tdn;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public void setMk2(String mk2) {
        this.mk2 = mk2;
    }
    public void setnick(String nick) {
        this.nick = nick;
    }

    public int getLv() {
        return lv;
    }

    public String getTdn() {
        return tdn;
    }

    public String getMk() {
        return mk;
    }
    public String getMk2() {
        return mk2;
    }
    public Object getnick() {
        return nick;
    }
    private Object nick;
    private String tdn, mk, mk2;
    public TaiKhoan(){
        lv=0;
        tdn = mk = "";
    }
    public TaiKhoan(String tdn, String mk, int lv){
        this.lv = lv;
        this.tdn = tdn;
        this.mk = mk;
    }
    
    
}
