/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dbmanagement.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Manthan-pc
 */
public class admin extends javax.swing.JFrame {

    /**
     * Creates new form table
     */public Connection con=null;
       public Statement st=null;
     public admin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("info?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        infoQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT i FROM Info i");
        infoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : infoQuery.getResultList();
        infoQuery1 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT i FROM Info i");
        infoList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : infoQuery1.getResultList();
        infoQuery2 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT i FROM Info i");
        infoList2 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : infoQuery2.getResultList();
        infoQuery3 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT i FROM Info i");
        infoList3 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : infoQuery3.getResultList();
        infoQuery4 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT i FROM Info i");
        infoList4 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : infoQuery4.getResultList();
        infoQuery5 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT i FROM Info i");
        infoList5 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : infoQuery5.getResultList();
        infoQuery6 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT i FROM Info i");
        infoList6 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : infoQuery6.getResultList();
        infoQuery7 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT i FROM Info i");
        infoList7 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : infoQuery7.getResultList();
        infoQuery8 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT i FROM Info i");
        infoList8 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : infoQuery8.getResultList();
        infoQuery9 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT i FROM Info i");
        infoList9 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : infoQuery9.getResultList();
        infoQuery10 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT i FROM Info i");
        infoList10 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : infoQuery10.getResultList();
        entityManager0 = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("info?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        entityManager2 = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("info?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        infoQuery11 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT i FROM Info i");
        infoList11 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : infoQuery11.getResultList();
        infoQuery12 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT i FROM Info i");
        infoList12 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : infoQuery12.getResultList();
        infoQuery13 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT i FROM Info i");
        infoList13 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : infoQuery13.getResultList();
        infoQuery14 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT i FROM Info i");
        infoList14 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : infoQuery14.getResultList();
        infoQuery15 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT i FROM Info i");
        infoList15 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : infoQuery15.getResultList();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, infoList15, jTable2);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${username}"));
        columnBinding.setColumnName("Username");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${password}"));
        columnBinding.setColumnName("Password");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${email}"));
        columnBinding.setColumnName("Email");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${contactNo}"));
        columnBinding.setColumnName("Contact No");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${gender}"));
        columnBinding.setColumnName("Gender");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${confPassword}"));
        columnBinding.setColumnName("Conf Password");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);

        jScrollPane1.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(398, 398, 398)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 // TODO add your handling code here:
         int t = 0;
        
        Object m = jTable2.getValueAt(jTable2.getSelectedRow(),jTable2.getSelectedColumn());
      String col=  jTable2.getColumnName(jTable2.getSelectedColumn());
      String value=(String) m;
      System.out.println(value);
        try
        {    
	
                Class.forName("com.mysql.jdbc.Driver");
             con=DriverManager.getConnection("jdbc:mysql://169.254.89.139:3306/info","root","user");
             st=con.createStatement();
             System.out.println("Connection created");
            }
                catch(ClassNotFoundException e)
                {
                    System.out.println("completed");
            }       catch (SQLException e) {
                System.out.println("fail in connection");
        } 
        
       String del="delete from info where "+col+"=\""+value+"\"";
       // String sql="insert into user_info values('"+username+"','"+password+"')";
        try{ t=st.executeUpdate(del); jTable2.remove(jTable2.getSelectedRow()); System.out.println("delete performed");
       
        
        }
        catch(Exception e){ e.getMessage();}
        System.out.println(del+",,"+col+",,"+value+",,"+t);
       //this.setVisible(false);
        getContentPane().removeAll();
        initComponents();
        
        JOptionPane.showMessageDialog(this,"deleted successfully");
                // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager entityManager;
    private javax.persistence.EntityManager entityManager0;
    private javax.persistence.EntityManager entityManager2;
    private java.util.List<com.dbmanagement.main.Info> infoList;
    private java.util.List<com.dbmanagement.main.Info> infoList1;
    private java.util.List<com.dbmanagement.main.Info> infoList10;
    private java.util.List<com.dbmanagement.main.Info> infoList11;
    private java.util.List<com.dbmanagement.main.Info> infoList12;
    private java.util.List<com.dbmanagement.main.Info> infoList13;
    private java.util.List<com.dbmanagement.main.Info> infoList14;
    private java.util.List<com.dbmanagement.main.Info> infoList15;
    private java.util.List<com.dbmanagement.main.Info> infoList2;
    private java.util.List<com.dbmanagement.main.Info> infoList3;
    private java.util.List<com.dbmanagement.main.Info> infoList4;
    private java.util.List<com.dbmanagement.main.Info> infoList5;
    private java.util.List<com.dbmanagement.main.Info> infoList6;
    private java.util.List<com.dbmanagement.main.Info> infoList7;
    private java.util.List<com.dbmanagement.main.Info> infoList8;
    private java.util.List<com.dbmanagement.main.Info> infoList9;
    private javax.persistence.Query infoQuery;
    private javax.persistence.Query infoQuery1;
    private javax.persistence.Query infoQuery10;
    private javax.persistence.Query infoQuery11;
    private javax.persistence.Query infoQuery12;
    private javax.persistence.Query infoQuery13;
    private javax.persistence.Query infoQuery14;
    private javax.persistence.Query infoQuery15;
    private javax.persistence.Query infoQuery2;
    private javax.persistence.Query infoQuery3;
    private javax.persistence.Query infoQuery4;
    private javax.persistence.Query infoQuery5;
    private javax.persistence.Query infoQuery6;
    private javax.persistence.Query infoQuery7;
    private javax.persistence.Query infoQuery8;
    private javax.persistence.Query infoQuery9;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
