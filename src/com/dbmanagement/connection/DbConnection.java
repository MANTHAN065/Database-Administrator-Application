/*
 * DbConnection.java
 *
 * Created on February 24, 2010, 4:13 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.dbmanagement.connection;

import com.dbmanagement.bean.DataBaseInformation;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author bishnu
 */
public class DbConnection {
    
    private static Connection con = null;
    private static  Statement st = null;
    /** Creates a new instance of DbConnection */
    public DbConnection() {
    }
    

    
    
    
    public static Connection getConnection(DataBaseInformation dataBaseInformation) {
       
        //String buildUrl = "jdbc:mysql://localhost:3306/manthan?user=root&password=admin";
        String buildUrl = dataBaseInformation.getUrl()+dataBaseInformation.getDatabaseName()+"?user="+dataBaseInformation.getUser()+"&password="+dataBaseInformation.getPassword();
        try {
            Class.forName(dataBaseInformation.getDriver()).newInstance();            
            con = DriverManager.getConnection(buildUrl);
        } catch (Exception e) {
            System.out.println("Not Connected "+e);
        }
        return con;
    }
    
    
    // declare a method to create a Statement
    
 /*   public static Statement getStatement() throws Exception {
        Statement st = null;
        //Connection con = getConnection();
        //st = con.createStatement();
        return st;
    }*/
    
      // declare a method to create a Statement
    
    public static Statement getStatement(DataBaseInformation dataBaseInformation) throws Exception {
        Connection con = getConnection(dataBaseInformation);
        st = con.createStatement();
        return st;
    }
    
        
    public  static DatabaseMetaData getDatabaseMetaData(DataBaseInformation databaseInformation)throws Exception {
        Connection con = getConnection(databaseInformation);
        DatabaseMetaData dbmd =con.getMetaData();
        return  dbmd;
    }
    
    
    public  static void closeAll()throws Exception {
       if(con!=null){
           con.close();
           st.close();
       }       
    }
}
