package Form;

import Config.DbConn;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class orderList extends javax.swing.JFrame {
    
    private Connection conn;
    DefaultTableModel model;
    ResultSet rs = null;

    public orderList() {
        initComponents();
        load_table();
    }

    private void load_table() {
        try {
            Object[] tbl_title = {"Order ID", "Name", "Product", "Amount", "Details", "Status"};
            model = new DefaultTableModel(null, tbl_title);
            tbl_order.setModel(model);
            
            conn = DbConn.getConnection();
            Statement sm = conn.createStatement();
            model.getDataVector().removeAllElements();
            
            rs = sm.executeQuery("SELECT * FROM custOrder");
            while (rs.next()) {
                Object[] data = {
                    rs.getString("orderID"),
                    rs.getString("name"),
                    rs.getString("product"),
                    rs.getString("pAmount"),
                    rs.getString("oDetails"),
                    rs.getString("oStatus")
                };
                model.addRow(data);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void searchData(String key) {
        try {
            Object[] tbl_title = {"Order ID", "Name", "Product", "Amount", "Details", "Status"};
            model = new DefaultTableModel(null, tbl_title);
            tbl_order.setModel(model);
            
            conn = DbConn.getConnection();
            Statement sm = conn.createStatement();
            model.getDataVector().removeAllElements();
            
            rs = sm.executeQuery("SELECT * FROM custorder WHERE orderID LIKE '%"+key+"%' OR name LIKE '%"+key+"%'");
            while (rs.next()) {
                Object[] data = {
                    rs.getString("orderID"),
                    rs.getString("name"),
                    rs.getString("product"),
                    rs.getString("pAmount"),
                    rs.getString("oDetails"),
                    rs.getString("oStatus")
                };
                model.addRow(data);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void searchData1(String key1) {
        try {
            Object[] tbl_title = {"Order ID", "Name", "Product", "Amount", "Details", "Status"};
            model = new DefaultTableModel(null, tbl_title);
            tbl_order.setModel(model);
            
            conn = DbConn.getConnection();
            Statement sm = conn.createStatement();
            model.getDataVector().removeAllElements();
            
            rs = sm.executeQuery("SELECT * FROM custorder WHERE oStatus LIKE '%"+key1+"%'");
            while (rs.next()) {
                Object[] data = {
                    rs.getString("orderID"),
                    rs.getString("name"),
                    rs.getString("product"),
                    rs.getString("pAmount"),
                    rs.getString("oDetails"),
                    rs.getString("oStatus")
                };
                model.addRow(data);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_order = new javax.swing.JTable();
        b_clist = new javax.swing.JButton();
        b_newo = new javax.swing.JButton();
        r_process = new javax.swing.JRadioButton();
        r_deliver = new javax.swing.JRadioButton();
        b_update = new javax.swing.JButton();
        t_search = new javax.swing.JTextField();
        c_search = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tbl_order.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Name", "Product", "Amount", "Details", "Status"
            }
        ));
        tbl_order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_orderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_order);

        b_clist.setText("Customer List");
        b_clist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_clistActionPerformed(evt);
            }
        });

        b_newo.setText("New Order");
        b_newo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_newoActionPerformed(evt);
            }
        });

        buttonGroup1.add(r_process);
        r_process.setText("Processing");

        buttonGroup1.add(r_deliver);
        r_deliver.setText("Delivering");

        b_update.setText("Update");
        b_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_updateActionPerformed(evt);
            }
        });

        t_search.setText("Search by Order ID or Name");
        t_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_searchMouseClicked(evt);
            }
        });
        t_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_searchActionPerformed(evt);
            }
        });
        t_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_searchKeyTyped(evt);
            }
        });

        c_search.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Search by Status", "Processing", "Delivering" }));
        c_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(b_newo)
                        .addGap(18, 18, 18)
                        .addComponent(b_clist)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(b_update)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(r_process, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(r_deliver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(t_search)
                    .addComponent(c_search, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_clist)
                    .addComponent(b_newo))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(t_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(c_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(r_process)
                .addGap(5, 5, 5)
                .addComponent(r_deliver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b_update)
                .addGap(66, 66, 66))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_newoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_newoActionPerformed
        this.setVisible(false);
        new orderMgmt().setVisible(true);
    }//GEN-LAST:event_b_newoActionPerformed

    private void b_clistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_clistActionPerformed
        this.setVisible(false);
        new customerList().setVisible(true);
    }//GEN-LAST:event_b_clistActionPerformed

    private void t_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_searchActionPerformed

    private void t_searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_searchKeyTyped
        String key = t_search.getText();
        System.out.println(key);
        
        if (key != "") {
            searchData(key);
        } else {
            load_table();
        }
    }//GEN-LAST:event_t_searchKeyTyped

    private void t_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_searchMouseClicked
        t_search.setText("");
    }//GEN-LAST:event_t_searchMouseClicked

    private void c_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_searchActionPerformed
        String key1 = (String) c_search.getSelectedItem();
        System.out.println(key1);

        if (key1 != "") {
            searchData1(key1);
        } else {
            load_table();
        }
    }//GEN-LAST:event_c_searchActionPerformed

    private void tbl_orderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_orderMouseClicked

    }//GEN-LAST:event_tbl_orderMouseClicked

    private void b_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_updateActionPerformed
        int column = 0;
        int selectedRow = tbl_order.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select the data you want to update.");
            return;
        } 
        
        String orderID = tbl_order.getModel().getValueAt(selectedRow, column).toString();
        r_process.setActionCommand("Processing");
        r_deliver.setActionCommand("Delivering");
        
        try {
            String sql = "UPDATE custorder SET oStatus = '"+buttonGroup1.getSelection().getActionCommand()+"' WHERE orderID = ?";
            conn = DbConn.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, orderID);
            
            int rowUpdated = ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Status successfully updated.");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to update status." + e.getMessage());                    
        }
        load_table();
    }//GEN-LAST:event_b_updateActionPerformed

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
            java.util.logging.Logger.getLogger(orderList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(orderList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(orderList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(orderList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new orderList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_clist;
    private javax.swing.JButton b_newo;
    private javax.swing.JButton b_update;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> c_search;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton r_deliver;
    private javax.swing.JRadioButton r_process;
    private javax.swing.JTextField t_search;
    private javax.swing.JTable tbl_order;
    // End of variables declaration//GEN-END:variables
}
