/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Lenovo
 */
public class Login extends javax.swing.JFrame {

    Connection con = null;
    Statement st = null;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        // mengambil ukuran layar
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();

        // membuat titik x dan y
        int x = layar.width / 2 - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;

        this.setLocation(x, y);
    }

    private void hapuslayar() {
        txt_username.setText("");
        txt_password.setText("");
        txt_username.setEnabled(true);
        txt_password.setEnabled(true);
    }

    private void CekLogin() {
        try {
            if (txt_username.getText().equals("") || txt_password.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Data Tidak Boleh Kosong",
                        "Pesan", JOptionPane.ERROR_MESSAGE);
                txt_username.requestFocus();
                hapuslayar();
            } else {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3308/honeybee", "root", "");
                st = con.createStatement();
                String sql = ("SELECT * FROM  tabel_user WHERE username = '" + txt_username.getText()
                        + "' AND password = '" + String.valueOf(txt_password.getText()) + "'");
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Berhasil Login");
                    this.dispose();
                    new Peraturan().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Username dan Password Salah\n"
                            + "Atau Akun Belum Terdaftar", "Login Gagal", JOptionPane.ERROR_MESSAGE);
                    hapuslayar();
//                    this.setVisible(false);
//                    new Registrasi().setVisible(true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bt_daftar = new javax.swing.JButton();
        bt_masuk = new javax.swing.JButton();
        txt_password = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 167, 230, 36));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("  MASUK");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 62, 147, -1));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
        jLabel3.setText("Username");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 139, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 102));
        jLabel4.setText("Password");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 218, -1, -1));

        bt_daftar.setBackground(new java.awt.Color(255, 153, 51));
        bt_daftar.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        bt_daftar.setForeground(new java.awt.Color(0, 51, 102));
        bt_daftar.setText("DAFTAR");
        bt_daftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_daftarActionPerformed(evt);
            }
        });
        getContentPane().add(bt_daftar, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 372, 140, 45));

        bt_masuk.setBackground(new java.awt.Color(255, 153, 51));
        bt_masuk.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        bt_masuk.setForeground(new java.awt.Color(0, 51, 102));
        bt_masuk.setText("MASUK");
        bt_masuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_masukActionPerformed(evt);
            }
        });
        getContentPane().add(bt_masuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 372, 140, 45));
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 241, 230, 36));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/WhatsApp Image 2022-12-10 at 08.40.37.jpeg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/TV - 1.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_daftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_daftarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Registrasi().setVisible(true);
    }//GEN-LAST:event_bt_daftarActionPerformed

    private void bt_masukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_masukActionPerformed
        // TODO add your handling code here:
        CekLogin();

//        this.setVisible(false);
//        new Peraturan().setVisible(true);
    }//GEN-LAST:event_bt_masukActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_daftar;
    private javax.swing.JButton bt_masuk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}