
public class businessLogic extends dbAccess {

    public void pCreate(String pname, String price, String qty, String desc) {
        dbpInsert(pname, price, qty, desc);
    }

    public void pUpdate(String name, String price, String qty, String desc, String id) {
        dbpUpdate(name, price, qty, desc, id);
    }

    public void pDelete(String id) {
        dbpDelete(id);
    }

    public void uCreate(String uname, String upass, String uemail, String ucc, String uaddress) {
        dbuInsert(uname, upass, uemail, ucc, uaddress);
    }

    public void uUpdate(String uname, String upass, String uemail, String ucc, String uaddress, String uid) {
        dbuUpdate(uname, upass, uemail, ucc, uaddress, uid);
    }

    public void uDelete(String uid) {
        dbuDelete(uid);
    }

    public void gProdId() {
        getpId();
    }

    public void gUserId() {
        getuId();
    }
    public void pRead(javax.swing.JTable jT){
        dbpRead(jT);
    }
     public void uRead(javax.swing.JTable jT){
         dbuRead(jT);
     }
}
