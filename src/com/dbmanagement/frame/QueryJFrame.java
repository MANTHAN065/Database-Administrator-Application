/*
 * QueryJFrame.java
 *
 * Created on February 26, 2010, 1:26 AM
 */

package com.dbmanagement.frame;

import com.dbmanagement.bean.DataBaseInformation;
import com.dbmanagement.common.CommonHelper;
import com.dbmanagement.connection.ConnectionHelper;
import com.dbmanagement.main.MainWindow;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author  bishnu
 */
public class QueryJFrame extends javax.swing.JFrame {
    
    private DataBaseInformation databaseInformation;
    MainWindow parent;
    public Vector recordsVector=new Vector();
    public String[][] recordsList;
    public  Vector heading;
    public boolean ascending = false;
    protected MyTableModel tableModel;
    /** Creates new form QueryJFrame */
    public QueryJFrame(MainWindow parent) {
        
        
        
        setTitle("Run Query");
        initComponents();
        setDefaultLookAndFeelDecorated(true);
        CommonHelper.setFrameInCenter(this);
        getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        this.parent=parent;
        pnlBottomRunQuery.setVisible(false);
        databaseInformation=parent.getDatabaseInformation();
        pack();
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        pnlTopRunQuery = new javax.swing.JPanel();
        lblTypeQuery = new javax.swing.JLabel();
        txtQuery = new javax.swing.JTextArea();
        btnRunQuery = new javax.swing.JButton();
        pnlBottomRunQuery = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        myTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        lblTypeQuery.setFont(new java.awt.Font("Verdana", 1, 12));
        lblTypeQuery.setText("Type Your Query:");

        txtQuery.setColumns(20);
        txtQuery.setRows(5);

        btnRunQuery.setFont(new java.awt.Font("Verdana", 1, 12));
        btnRunQuery.setForeground(new java.awt.Color(0, 0, 102));
        btnRunQuery.setText("Run Query");
        btnRunQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleRunQuery(evt);
            }
        });

        javax.swing.GroupLayout pnlTopRunQueryLayout = new javax.swing.GroupLayout(pnlTopRunQuery);
        pnlTopRunQuery.setLayout(pnlTopRunQueryLayout);
        pnlTopRunQueryLayout.setHorizontalGroup(
            pnlTopRunQueryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopRunQueryLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlTopRunQueryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTopRunQueryLayout.createSequentialGroup()
                        .addComponent(txtQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(btnRunQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTypeQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pnlTopRunQueryLayout.setVerticalGroup(
            pnlTopRunQueryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopRunQueryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTypeQuery)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopRunQueryLayout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(btnRunQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                handleSorting(evt);
            }
        });

        myTable.setFont(new java.awt.Font("Verdana", 0, 11));
        myTable.setForeground(new java.awt.Color(0, 51, 51));
        myTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(myTable);

        javax.swing.GroupLayout pnlBottomRunQueryLayout = new javax.swing.GroupLayout(pnlBottomRunQuery);
        pnlBottomRunQuery.setLayout(pnlBottomRunQueryLayout);
        pnlBottomRunQueryLayout.setHorizontalGroup(
            pnlBottomRunQueryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBottomRunQueryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        pnlBottomRunQueryLayout.setVerticalGroup(
            pnlBottomRunQueryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBottomRunQueryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Verdana", 1, 12));
        jButton1.setForeground(new java.awt.Color(0, 0, 102));
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleOk(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlBottomRunQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlTopRunQuery, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(23, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(677, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTopRunQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(pnlBottomRunQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void handleSorting(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_handleSorting
// TODO add your handling code here:
        //  DefaultTableModel mymodel=myTable.getModel();
        
        TableColumnModel colModel = myTable.getColumnModel();
        int columnModelIndex = colModel.getColumnIndexAtX(evt.getX());
        int modelIndex = colModel.getColumn(columnModelIndex).getModelIndex();
        System.out.println("ColIndx: "+columnModelIndex);
        int mColIndex = 0;
        
        //   sortColumn(new javax.swing.table.DefaultTableModel(recordsList,heading.toArray() ), mColIndex, ascending);
        if(!ascending) {
            ascending=true;
        } else {
            ascending=false;
        }
    }//GEN-LAST:event_handleSorting
    
    private void handleOk(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleOk
// TODO add your handling code here:
        this.setVisible(false);
        parent.setVisible(true);
    }//GEN-LAST:event_handleOk
    
    
    
    private void handleRunQuery(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleRunQuery
        String query=this.txtQuery.getText();
        if(!CommonHelper.isStringEmptyOrNull(query)){
            heading=new Vector();
            List tableRecordsList=new ArrayList();
            String sql=query;
            databaseInformation.setTableName(sql);
            try{
                recordsList=ConnectionHelper.getRecordsList(databaseInformation,sql,heading);
                if(recordsList!=null) {
                    myTable.setModel(new javax.swing.table.DefaultTableModel(recordsList,heading.toArray() ));
                    pnlBottomRunQuery.setVisible(true);
                    databaseInformation.setJtable(myTable);
                    pack();
                    tableRecordsList=Arrays.asList(recordsList);
                    recordsVector=new Vector(tableRecordsList);
                    MyTableModel tableModel = new MyTableModel(recordsVector,myTable,databaseInformation);
                    JTableHeader header = myTable.getTableHeader();
                    header.setUpdateTableInRealTime(true);
                    header.addMouseListener(tableModel.new ColumnListener(myTable));
                    header.setReorderingAllowed(true);
                }
            } catch (Exception ex) {
                System.out.println("Exception "+ex);
            }
            
        }else{
            
            JOptionPane.showMessageDialog(null,"Please enter your Query!!");
        }
    }//GEN-LAST:event_handleRunQuery
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRunQuery;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTypeQuery;
    private javax.swing.JTable myTable;
    private javax.swing.JPanel pnlBottomRunQuery;
    private javax.swing.JPanel pnlTopRunQuery;
    private javax.swing.JTextArea txtQuery;
    // End of variables declaration//GEN-END:variables
    
}


class MyTableModel extends AbstractTableModel {
    protected int sortCol = 0;
    DataBaseInformation databaseInformationForShorting;
    protected boolean isSortAsc = true;
    protected JTable table;
    protected int m_result = 0;
    protected int columnsCount = 3;
    Vector vector = new Vector();
    String sql1=null;
    boolean order=true;
    int columnId;
    public MyTableModel(Vector recordsVector,JTable mytable,DataBaseInformation databaseInformation) {
        databaseInformationForShorting=databaseInformation;
        sql1=databaseInformationForShorting.getTableName();
        table=mytable;
        vector.removeAllElements();
        vector=recordsVector;
    }
    
    public int getRowCount() {
        return vector == null ? 0 : vector.size();
    }
    
    public int getColumnCount() {
        return columnsCount;
    }
    public String getColumnName(int column,String colName) {
        String str = colName;
        if (column == sortCol)
            str += isSortAsc ? " >>" : " <<";
        return str;
    }
    
    public boolean isCellEditable(int nRow, int nCol) {
        return false;
    }
    
    public Object getValueAt(int nRow, int nCol) {
        if (nRow < 0 || nRow >= getRowCount())
            return "";
        if(nCol>1){
            return "";
        }
        return vector.elementAt(nRow);
    }
    
    public String getTitle() {
        return "data ";
    }
    
    class ColumnListener extends MouseAdapter {
        protected JTable table;
        
        public ColumnListener(JTable t) {
            table = t;
            int rows=t.getRowCount();
        }
        
        public void mouseClicked(MouseEvent e) {
            String sortingsql=null;
            table=databaseInformationForShorting.getJtable();
            sql1=databaseInformationForShorting.getTableName();
            TableColumnModel colModel = table.getColumnModel();
            int columnModelIndex = colModel.getColumnIndexAtX(e.getX());
             int modelIndex=0;
            if(columnModelIndex>=0 && columnModelIndex<colModel.getColumnCount()) {
             modelIndex = colModel.getColumn(columnModelIndex)
            .getModelIndex();
            String colName=table.getColumnName(columnModelIndex);
            columnsCount=table.getColumnCount();
            if(columnId!=columnModelIndex) {
                order=true;
                columnId=columnModelIndex;
            } else {
                if(order) {
                    order=false;
                } else {
                    order=true;
                }
            }
            if (modelIndex < 0)
                return;
            if (sortCol == modelIndex)
                isSortAsc = !isSortAsc;
            else
                sortCol = modelIndex;          
            
            Vector heading=new Vector();
            if(order) {
                sortingsql=sql1+" ORDER BY "+ colName +" ASC ";
            } else {
                sortingsql=sql1+" ORDER BY "+ colName +" DESC ";
            }
            
            try{
                String[][] recordsList=ConnectionHelper.getRecordsList(databaseInformationForShorting,sortingsql,heading);
                table.setModel(new javax.swing.table.DefaultTableModel(recordsList,heading.toArray() ));
                table.repaint();
                 if(columnModelIndex>=0 && columnModelIndex<colModel.getColumnCount()) {
                 TableColumn column = colModel.getColumn(columnModelIndex);
                 column.setHeaderValue(getColumnName(columnModelIndex,colName));             
                 table.getTableHeader().repaint();
                 }
            } catch (Exception ex) {
                System.out.println("Exception "+ex);
            }
            }
        }
    }
}