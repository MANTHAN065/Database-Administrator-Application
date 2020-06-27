/*
 * ConnectionHelper.java
 *
 * Created on February 25, 2010, 11:53 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.dbmanagement.connection;

import com.dbmanagement.bean.DataBaseInformation;
import com.dbmanagement.bean.User;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author bishnu
 */
public class ConnectionHelper {
    
    /** Creates a new instance of ConnectionHelper */
    public ConnectionHelper() {
    }
    
    // method to check the mysql connection
    public static boolean checkConnection(DataBaseInformation dataBaseInformation) {
        boolean  status=false;
        Connection con = null;
        try {
            con =DbConnection.getConnection(dataBaseInformation);
            if(con!=null) {
                status=true;
            }
        } catch (Exception e) {
            System.out.println("Not Connected "+e);
        }
        return status;
    }
    
    // method to get result by executing a sql statement
    public static ResultSet getResultSet(DataBaseInformation databaseInformation,String sql) {
        ResultSet rst=null;
        try {
            Statement st=DbConnection.getStatement(databaseInformation);
            rst=st.executeQuery(sql);
        } catch (Exception ex) {
            System.out.println("Exception "+ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        
        return  rst;
        
    }
    
    // method to get all records list of a selected table
    public static String[][]  getRecordsList(DataBaseInformation databaseInformation,String sql, Vector heading)throws Exception {
        String [][] records=null;
        ResultSet rst=null;
        // Statement st=DbConnection.getStatement(databaseInformation);
        try{
            rst=getResultSet(databaseInformation,sql);
            if(rst!=null) {
                ResultSetMetaData rsmd=rst.getMetaData();
                int cols=rsmd.getColumnCount();
                //Populate heading vector//
                for(int colIdx=1;colIdx<=cols; colIdx++){
                    String colName = rsmd.getColumnName(colIdx);
                    heading.addElement(colName);
                }
                rst.last();
                int rows=rst.getRow();
                rst.beforeFirst();
                int i=0;
                records = new String[rows][cols];
                while(rst.next()) {
                    int k=1;
                    for(int j=0;j<cols;j++){
                        records[i][j]=rst.getString(k);
                        k++;
                    }
                    i++;
                }
            }
        } catch (Exception ex) {
            System.out.println("Exception "+ex);
            
        } finally{
            rst.close();
        }
        return records;
    }
    
    
    
    public static String[][]  getRecordsListForAddRow(DataBaseInformation databaseInformation,String sql, Vector heading)throws Exception {
        String [][] records=null;
        ResultSet rst=null;
        // Statement st=DbConnection.getStatement(databaseInformation);
        try{
            rst=getResultSet(databaseInformation,sql);
            if(rst!=null) {
                ResultSetMetaData rsmd=rst.getMetaData();
                int cols=rsmd.getColumnCount();
                //Populate heading vector//
                for(int colIdx=1;colIdx<=cols; colIdx++){
                    String colName = rsmd.getColumnName(colIdx);
                    heading.addElement(colName);
                }
                rst.last();
                int rows=rst.getRow();
                rst.beforeFirst();
                int i=0;
                records = new String[rows+1][cols];
                while(rst.next()) {
                    int k=1;
                    for(int j=0;j<cols;j++){
                        records[i][j]=rst.getString(k);
                        k++;
                    }
                    i++;
                }
            }
        } catch (Exception ex) {
            System.out.println("Exception "+ex);
            
        } finally{
            rst.close();
        }
        return records;
    }
    
    
    
    public static String[][]  getColumnNameList(DataBaseInformation databaseInformation,String sql)throws Exception {
        String [][] records=null;
        ResultSet rst=null;
        // Statement st=DbConnection.getStatement(databaseInformation);
        try{
            rst=getResultSet(databaseInformation,sql);
            if(rst!=null) {
                ResultSetMetaData rsmd=rst.getMetaData();
                int cols=rsmd.getColumnCount();
                //Populate heading vector//
                int i=0;
                records = new String[cols][6];
                for(int colIdx=1;colIdx<=cols; colIdx++){
                    String tableName=rsmd.getTableName(colIdx);
                    String columnName=rsmd.getColumnName(colIdx);
                    String colName = rsmd.getColumnName(colIdx);
                    String colType=rsmd.getColumnTypeName(colIdx);
                    int len=rsmd.getColumnDisplaySize(colIdx);
                    int allownull=rsmd.isNullable(colIdx);
                    
                    records[i][0]=colName;
                    records[i][1]=colType;
                    records[i][2]=String.valueOf(len);
                    if(allownull==1) {
                        records[i][4]="true";
                    } else {
                        records[i][4]="false";
                    }
                    
                    
                    String pkcolumnName =null;
                    ResultSet rs1=null;
                    Connection conn=DbConnection.getConnection(databaseInformation);
                    DatabaseMetaData meta = conn.getMetaData();
                    rs1 = meta.getPrimaryKeys(null, null, tableName);
                    while (rs1.next()) {
                        pkcolumnName = rs1.getString("COLUMN_NAME");
                        
                        if(columnName.equals(pkcolumnName)) {
                            records[i][5]="true";
                            break;
                        } else {
                            records[i][5]="false";
                        }
                    }
                    i++;
                    
                }
            }
        } catch (Exception ex) {
            System.out.println("Exception "+ex);
            
        } finally{
            rst.close();
        }
        return records;
    }
    
    
    
    public static String[][]  getColumnNameListForAddRow(DataBaseInformation databaseInformation,String sql)throws Exception {
        String [][] records=null;
        ResultSet rst=null;
        // Statement st=DbConnection.getStatement(databaseInformation);
        try{
            rst=getResultSet(databaseInformation,sql);
            if(rst!=null) {
                ResultSetMetaData rsmd=rst.getMetaData();
                int cols=rsmd.getColumnCount();
                //Populate heading vector//
                int i=0;
                records = new String[cols+1][6];
                for(int colIdx=1;colIdx<=cols; colIdx++){
                    String colName = rsmd.getColumnName(colIdx);
                    String colType=rsmd.getColumnTypeName(colIdx);
                    int len=rsmd.getColumnDisplaySize(colIdx);
                    int allownull=rsmd.isNullable(colIdx);
                    
                    records[i][0]=colName;
                    records[i][1]=colType;
                    records[i][2]=String.valueOf(len);
                    if(allownull==1) {
                        records[i][4]="true";
                    } else {
                        records[i][4]="false";
                    }
                    i++;
                    
                    
                }
            }
        } catch (Exception ex) {
            System.out.println("Exception "+ex);
            
        } finally{
            rst.close();
        }
        return records;
    }
    
    
    // method to get all tables name of a particular database
    public  static ArrayList getTableName(DataBaseInformation databaseInformation)throws Exception {
        
        ArrayList tableNameList=new ArrayList();
        try {
            DatabaseMetaData dbmd = DbConnection.getDatabaseMetaData(databaseInformation);
            String[] types = {"TABLE"};
            java.sql.ResultSet resultSet = dbmd.getTables(null, null, "%", types);
            while (resultSet.next()) {
                String tableName = resultSet.getString(3);
                String tableCatalog = resultSet.getString(1);
                String tableSchema = resultSet.getString(2);
                tableNameList.add(tableName);
            }
        } catch (SQLException e) {
        }
        return  tableNameList;
    }
    
    // method is work for create a new table
    public static  int createNewTable(DataBaseInformation databaseInformation,String sql){
        int i=0;
        try{
            Statement st=DbConnection.getStatement(databaseInformation);
            i= st.executeUpdate(sql);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            i=-1;
        }
        return  i;
    }
    
    // function is work for insert, update and delete records in db table as update query
    public static  int tableUpdateQuery(DataBaseInformation databaseInformation,String sql){
        int i=0;
        try{
            Statement st=DbConnection.getStatement(databaseInformation);
            i= st.executeUpdate(sql);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            i=-1;
        }
        return  i;
    }
}
