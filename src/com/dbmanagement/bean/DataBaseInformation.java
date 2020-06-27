/*
 * DataBaseInformation.java
 *
 * Created on February 27, 2010, 9:53 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.dbmanagement.bean;

import javax.swing.JTable;
import com.dbmanagement.main.db;
/**
 *
 * @author bishnu
 */
public class DataBaseInformation {
    public static db d;
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://169.254.89.139:3306/";
    private static String databaseName = d.jTextField99.getText();
    
    private String user=null;
    private String password =null;
    private  String tableName=null;
    private  JTable jtable;
    /** Creates a new instance of DataBaseInformation */
    public DataBaseInformation() {
        
    }

    /**
     * Getter for property user.
     * @return Value of property user.
     */
    public String getUser() {
        return this.user;
    }

    /**
     * Setter for property user.
     * @param user New value of property user.
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Getter for property password.
     * @return Value of property password.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Setter for property password.
     * @param password New value of property password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter for property driver.
     * @return Value of property driver.
     */
    public String getDriver() {
        return this.driver;
    }

  
    /**
     * Getter for property url.
     * @return Value of property url.
     */
    public String getUrl() {
        return this.url;
    }


    /**
     * Getter for property databaseName.
     * @return Value of property databaseName.
     */
    public String getDatabaseName() {
        return this.databaseName;
    }

    static {
    }

    /**
     * Getter for property tableName.
     * @return Value of property tableName.
     */
    public String getTableName() {
        return this.tableName;
    }

    /**
     * Setter for property tableName.
     * @param user New value of property tableName.
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * Getter for property jtable.
     * @return Value of property jtable.
     */
    public JTable getJtable() {
        return this.jtable;
    }

    /**
     * Setter for property jtable.
     * @param jtable New value of property jtable.
     */
    public void setJtable(JTable jtable) {
        this.jtable = jtable;
    }
   
}
