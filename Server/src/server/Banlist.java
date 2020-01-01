/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author admin
 */
public class Banlist extends javax.swing.JDialog {

    String Name;
        ResultSet rs = null;

    public Banlist() {
        initComponents();
        Showdata();
        Showdata2();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BanList");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Web List"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Number", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Program List"));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Number", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jButton3.setText("Add Web List");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Add Program List");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String s = (String) JOptionPane.showInputDialog(
                null, "Ban Web name","Ban Web",
                JOptionPane.PLAIN_MESSAGE, null, null, null);
        if ((s != null) && (s.length() > 0)) {
            String query = "INSERT INTO `banweb`(`Co_Title`, `Co_Section`, `Name`) VALUES ('" + Login.Subject + "','" + Login.Section + "','" + s + "')";
            Query(query, "Inserted", 1);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String s = (String) JOptionPane.showInputDialog(
                null, "Ban Program name", "Ban Program",
                JOptionPane.PLAIN_MESSAGE, null, null, null);
        if ((s != null) && (s.length() > 0)) {
            String query = "INSERT INTO `banprogram`(`Co_Title`, `Co_Section`, `Name`) VALUES ('" + Login.Subject + "','" + Login.Section + "','" + s + "')";
            Query(query, "Inserted", 2);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int i = jTable1.getSelectedRow();
        TableModel t = jTable1.getModel();
        Name = t.getValueAt(i, 1).toString();
        if (evt.getClickCount() == 2) {
            String s = (String) JOptionPane.showInputDialog(
                    null, "Ban Web name", "Ban Web",
                    JOptionPane.PLAIN_MESSAGE, null, null, Name);
            if ((s != null) && (s.length() > 0)) {
                String query = "UPDATE `banweb` SET `Name`='" + s + "' WHERE `banweb`.`Co_Title`= '" + Login.Subject + "' AND `banweb`.`Co_Section`= '" + Login.Section + "' AND `banweb`.`Name` = '" + Name + "'";
                Query(query, "Update", 3);
            }

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int i = jTable2.getSelectedRow();
        TableModel t = jTable2.getModel();
        Name = t.getValueAt(i, 1).toString();
        if (evt.getClickCount() == 2) {
            String s = (String) JOptionPane.showInputDialog(
                    null, "Input Program name", "Ban Program",
                    JOptionPane.PLAIN_MESSAGE, null, null, Name);
            if ((s != null) && (s.length() > 0)) {
                String query = "UPDATE `banprogram` SET `Name`='" + s + "' WHERE `banprogram`.`Co_Title`= '" + Login.Subject + "' AND `banprogram`.`Co_Section`= '" + Login.Section + "' AND `banprogram`.`Name` = '" + Name + "'";
                Query(query, "Update", 4);
            }

        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int i = jTable1.getSelectedRow();
        TableModel t = jTable1.getModel();
        Name = t.getValueAt(i, 1).toString();
        System.out.println(Name);
        String query = "DELETE FROM `banweb` WHERE `Co_Title` = '" 
                + Login.Subject +"' AND `Co_Section` = '"
                + Login.Section +"' AND`Name` = '"+Name+"'";
        Query(query, "Update", 3);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int i = jTable2.getSelectedRow();
        TableModel t = jTable2.getModel();
        Name = t.getValueAt(i, 1).toString();
        System.out.println(Name);
        String query = "DELETE FROM `banprogram` WHERE `Co_Title` = '" 
                + Login.Subject +"' AND `Co_Section` = '"+ Login.Section 
                +"' AND`Name` = '"+Name+"'";
        Query(query, "Update", 4);
    }//GEN-LAST:event_jButton2ActionPerformed

    public void main() {
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Banlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Banlist().setVisible(true);
        });
    }

    public Connection getconnect() {
        Connection con;
        String url = "jdbc:mysql://localhost/controllab";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "");
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Editcourse.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Ban> BanWebList() {
        ArrayList<Ban> BanWebList = new ArrayList<>();
        Connection connection = getconnect();
        String sql = "SELECT * FROM `banweb` WHERE `Co_Title` = '" + Login.Subject + "' AND `Co_Section` = '" + Login.Section + "'";
        PreparedStatement pre;
        try {
            pre = connection.prepareStatement(sql);
            rs = pre.executeQuery();
            Ban ban;
            while (rs.next()) {
                ban = new Ban(rs.getString("Name"));
                BanWebList.add(ban);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Editcourse.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (connection != null) {
                    rs.close();
                    connection.close();
                }
            } catch (SQLException se) {
            }
        }
        return BanWebList;
    }

    private void Showdata() {
        ArrayList<Ban> list = BanWebList();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[2];
        for (int i = 0; i < list.size(); i++) {
            row[0] = i + 1;
            row[1] = list.get(i).getBan();
            model.addRow(row);
        }
    }

    public ArrayList<Ban> BanProgranmList() {
        ArrayList<Ban> BanProgranmList = new ArrayList<>();
        Connection connection = getconnect();
        String sql = "SELECT * FROM `banprogram` WHERE `Co_Title` = '" + Login.Subject + "' AND `Co_Section` = '" + Login.Section + "'";
        PreparedStatement pre;
        try {
            pre = connection.prepareStatement(sql);
            rs = pre.executeQuery();
            Ban ban;
            while (rs.next()) {
                ban = new Ban(rs.getString("Name"));
                BanProgranmList.add(ban);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Editcourse.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (connection != null) {
                    rs.close();
                    connection.close();
                }
            } catch (SQLException se) {
            }
        }
        return BanProgranmList;
    }

    private void Showdata2() {
        ArrayList<Ban> list = BanProgranmList();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        Object[] row = new Object[2];
        for (int i = 0; i < list.size(); i++) {
            row[0] = i + 1;
            row[1] = list.get(i).getBan();
            model.addRow(row);
        }
    }

    public void Query(String query, String message, int id) {
        Connection con = getconnect();
        Statement st;
        DefaultTableModel model1, model2;
        try {
            st = con.createStatement();
            if (st.executeUpdate(query) == 1) {
                model1 = (DefaultTableModel) jTable1.getModel();
                model2 = (DefaultTableModel) jTable2.getModel();
                JOptionPane.showMessageDialog(null, "Data " + message + " Successfully");
                switch (id) {
                    case 1:
                        model1.setRowCount(0);
                        Showdata();
                        break;
                    case 2:
                        model2.setRowCount(0);
                        Showdata2();
                        break;
                    case 3:
                        model1.setRowCount(0);
                        Showdata();
                        break;
                    case 4:
                        model2.setRowCount(0);
                        Showdata2();
                        break;
                    default:
                        break;
                }

            } else {
                JOptionPane.showMessageDialog(null, "Data " + message + " failed");
            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data " + message + " failed");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
