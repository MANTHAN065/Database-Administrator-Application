/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manthan-pc
 */

import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.*;


public class img2 {

    public static void main(String[] args) throws Exception {
    // Select file
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    fileChooser.showOpenDialog(null);
    File selectedFile = fileChooser.getSelectedFile();

    // Insert image
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost/manthan", "root", "user");
    String INSERT_PICTURE = "insert into image(img) values (?)";
    conn.setAutoCommit(false);
    FileInputStream fis = new FileInputStream(selectedFile);
    PreparedStatement ps = conn.prepareStatement(INSERT_PICTURE);
    ps.setBinaryStream(1, fis, (int) selectedFile.length());
    ps.executeUpdate();
    conn.commit();
    ps.close();
    fis.close();
    conn.close();
    
    
     BufferedImage bufferedImage = ImageIO.read(selectedFile);
    ImageIcon imageIcon = new ImageIcon(bufferedImage);
    JLabel label = new JLabel();
    label.setIcon(imageIcon);
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(label);
    frame.pack();
    frame.setVisible(true);
}
}