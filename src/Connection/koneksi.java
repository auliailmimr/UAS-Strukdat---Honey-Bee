package Connection;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class koneksi {

    private static Connection mysqlkonek;

    public static void main(String[] args) throws SQLException {
        koneksiDB();
    }

    public static Connection koneksiDB() throws SQLException {
        if (mysqlkonek == null) {
            try {
                String DB = "jdbc:mysql://localhost:3308/honeybee"; // alamat local host
                String user = "root"; // user database
                String pass = ""; // password database
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                mysqlkonek = (Connection) DriverManager.getConnection(DB, user, pass);
                //JOptionPane.showMessageDialog(null, "Koneksi Sukses");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Koneksi Gagal");
            }
        }
        return mysqlkonek;
    }

    public static Object GetConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}