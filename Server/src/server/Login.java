package server;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JDialog {

    Connection con = null;
    ResultSet rec = null;
    String url = "jdbc:mysql://localhost/controllab";
    boolean confirm = false;

    static String Teacherusername, Subject, Section;
    public Login() {
        initComponents();
        findcombo1();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");

        jButton1.setText("login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPasswordField1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(125, 125, 125))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void findcombo1() {
        String sql = " SELECT DISTINCT Co_Title FROM  Course ";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "");
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            ((JLabel) jComboBox1.getRenderer()).setHorizontalAlignment(JLabel.RIGHT);
            ((JLabel) jComboBox2.getRenderer()).setHorizontalAlignment(JLabel.RIGHT);
            while (rs.next()) {
                String Title = rs.getString("Co_Title");
                jComboBox1.addItem(Title);
            }
        } catch (ClassNotFoundException | SQLException ex) {
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException se) {
            }
        }
    }

    private void findcombo2() {
        String sql2 = "SELECT Co_Section FROM  Course " + " WHERE Co_Title = ? ";
        if (jComboBox1.getSelectedItem() != null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(url, "root", "");
                PreparedStatement pre = con.prepareStatement(sql2);
                pre.setString(1, jComboBox1.getSelectedItem().toString());
                ResultSet rs = pre.executeQuery();
                jComboBox2.removeAllItems();
                while (rs.next()) {
                    String Section1 = rs.getString("Co_Section");
                    jComboBox2.addItem(Section1);
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Addsubject.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException se) {
                }
            }
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String Username = jTextField1.getText();
        String Password = String.valueOf(jPasswordField1.getPassword());
        String sql = "SELECT Te_Username FROM  teacher " + " WHERE Te_Username = ? " 
                + " AND Te_Password = ? ";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "");
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, Username);
            pre.setString(2, Password);
            rec = pre.executeQuery();
            if (rec.next()) {
                if (rec.getString("Te_Username").equals("Admin")) {
                    System.out.println("Admin");
                    dispose();
                    Admin a = new Admin();
                    a.main();
                }else{
                    sql = "SELECT * FROM  Course WHERE Te_Username = ? "
                            + "AND Co_Title = ? AND Co_Section = ? ";
                    pre = con.prepareStatement(sql);
                    pre.setString(1, Username);
                    pre.setString(2, jComboBox1.getSelectedItem().toString());
                    pre.setString(3, jComboBox2.getSelectedItem().toString());
                    rec = pre.executeQuery();
                    if (rec.next()) {
                        JOptionPane.showMessageDialog(null, "Success");
                        Teacherusername = Username;
                        Subject = jComboBox1.getSelectedItem().toString();
                        Section = jComboBox2.getSelectedItem().toString();
                        confirm = true;
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Subject or Section Incorect");
                    }
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Username or Password Incorrect");
            }

        } catch (HeadlessException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Addsubject.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    System.out.println("close");
                    rec.close();
                    con.close();
                }
            } catch (SQLException se) {
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        findcombo2();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
