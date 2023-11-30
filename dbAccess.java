
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class dbAccess extends javax.swing.JFrame {

    int pInsertVer;
    int pUpdateVer;
    int pDeleteVer;
    int uInsertVer;
    int uUpdateVer;
    int uDeleteVer;
    static private Connection con;
    static private PreparedStatement pst;
    static protected ResultSet rs;

    public static void Connect() {
        try {
            String connectionUrl = "jdbc:mysql://127.0.0.1:3306/uniproject";
            con = DriverManager.getConnection(connectionUrl, "root", "");
            Statement stmt = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getpId() {
        try {
            pst = con.prepareStatement("Select pId from products");
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(dbAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dbpInsert(String name, String price, String quantity, String description) {

        try {

            try {
                pst = con.prepareStatement("INSERT INTO products (pName,pPrice,pQty, pDescription) VALUES (?,?,?,?)");
            } catch (SQLException ex) {
                Logger.getLogger(dbAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
            pst.setString(1, name);
            pst.setString(2, price);
            pst.setString(3, quantity);
            pst.setString(4, description);
            pInsertVer = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(dbAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dbpUpdate(String name, String price, String quantity,String description, String id) {
        try {
            pst = con.prepareStatement("UPDATE products SET pName=?,pPrice=?,pQty=?,pDescription=? where pId=?");

            pst.setString(1, name);
            pst.setString(2, price);
            pst.setString(3, quantity);
            pst.setString(4, description);
            pst.setString(5, id);

            pUpdateVer = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(dbAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dbpDelete(String id) {
        try {
            pst = con.prepareStatement("DELETE FROM products WHERE pId=?");
            pst.setString(1, id);
            pDeleteVer = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(dbAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dbpRead(javax.swing.JTable jT) {
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM products");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();

            DefaultTableModel df = (DefaultTableModel) jT.getModel();
            df.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();
                for (int a = 1; a <= q; a++) {
                    v2.add(rs.getString("pId"));
                    v2.add(rs.getString("pName"));
                    v2.add(rs.getString("pPrice"));
                    v2.add(rs.getString("pQty"));
                    v2.add(rs.getString("pDescription"));
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //USER TABLE

    public void getuId() {
        try {
            pst = con.prepareStatement("Select uId from users");
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(dbAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void dbuInsert(String uname, String pass, String email,String ccard,String address) {

        try {
            pst = con.prepareStatement("INSERT INTO users (uName,uPass,uEmail,uCC,uAddress) VALUES (?,?,?,?,?)");
            
            pst.setString(1, uname);
            pst.setString(2, pass);
            pst.setString(3, email);
            pst.setString(4, ccard);
            pst.setString(5, address);
            
            uInsertVer = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(dbAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dbuUpdate(String uname, String pass, String email, String ccard, String address, String uid) {
        try {
            pst = con.prepareStatement("UPDATE users SET uName=?,uPass=?,uEmail=?,uCC=?,uAddress=? where uId=?");

            pst.setString(1, uname);
            pst.setString(2, pass);
            pst.setString(3, email);
            pst.setString(4, ccard);
            pst.setString(5, address);
            pst.setString(6, uid);

            uUpdateVer = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(dbAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dbuDelete(String uid) {
        try {
            pst = con.prepareStatement("DELETE FROM users WHERE uId=?");
            pst.setString(1, uid);
            uDeleteVer = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(dbAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dbuRead(javax.swing.JTable jT) {
        try {
            int p;
            pst = con.prepareStatement("SELECT * FROM users");
            rs = pst.executeQuery();
            ResultSetMetaData rss1 = rs.getMetaData();
            p = rss1.getColumnCount();

            DefaultTableModel df1 = (DefaultTableModel) jT.getModel();
            df1.setRowCount(0);
            while (rs.next()) {
                Vector v3 = new Vector();
                for (int i = 1; i <= p; i++) {
                    v3.add(rs.getString("uId"));
                    v3.add(rs.getString("uName"));
                    v3.add(rs.getString("uPass"));
                    v3.add(rs.getString("uEmail"));
                    v3.add(rs.getString("uCC"));
                    v3.add(rs.getString("uAddress"));
                }
                df1.addRow(v3);
            }
        } catch (SQLException ex) {
            Logger.getLogger(productForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}