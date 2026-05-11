/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package student_management_system;

import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
/**
 *
 * @author Sasindu
 */
public class registerStudent extends javax.swing.JFrame {

    Connection con=null;
    PreparedStatement pst=null;
    
    String stName=null;
    String stID=null;
    String gender=null;
    String IDNumber=null;
    String contactNumber=null;
    String Email=null;
    String Address=null;
    
    
    ResultSet result=null;
    String path=null;
    
    
    
    public registerStudent() {
        initComponents();
        Connect();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        radioMale = new javax.swing.JRadioButton();
        radioFemale = new javax.swing.JRadioButton();
        txtStName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtIdNum = new javax.swing.JTextField();
        txtContact = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        labImage = new javax.swing.JLabel();
        btnAddPhoto = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtStID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("STUDENT MANAGEMENT SYSTEM");

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\java project\\student_management_system\\pic\\close.png")); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(129, 129, 129)
                .addComponent(jLabel2)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 90));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Student ID");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("E-mail");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Address");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Contact Number");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("ID Number");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        buttonGroup1.add(radioMale);
        radioMale.setText("Male");
        jPanel2.add(radioMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 52, -1));

        buttonGroup1.add(radioFemale);
        radioFemale.setText("Female");
        jPanel2.add(radioFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, -1, -1));
        jPanel2.add(txtStName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 311, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Gender");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));
        jPanel2.add(txtIdNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 311, -1));

        txtContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactActionPerformed(evt);
            }
        });
        jPanel2.add(txtContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 311, -1));
        jPanel2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 311, -1));
        jPanel2.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 311, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon("D:\\java project\\student_management_system\\pic\\back.png")); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 14, 37, -1));

        labImage.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 102), 1, true));
        labImage.setPreferredSize(new java.awt.Dimension(200, 200));
        jPanel2.add(labImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, -1, -1));

        btnAddPhoto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddPhoto.setText("Add Photo");
        btnAddPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPhotoActionPerformed(evt);
            }
        });
        jPanel2.add(btnAddPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 370, -1, -1));

        btnSave.setBackground(new java.awt.Color(0, 0, 102));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 440, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Student Name");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));
        jPanel2.add(txtStID, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 310, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 920, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    void Connect(){
        
        String url="jdbc:mysql://localhost:3306/student_management_system";
        String password="";
        String user="root";
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connect_db dbcon= new Connect_db();
        dbcon.setConnection(DriverManager.getConnection(url,user,password));
        con=dbcon.getConnection();
        }
        catch(Exception e){
          JOptionPane.showMessageDialog(null,e);  
        }
    }
    
    void statment(){
  
           String quary="insert into students(stID,stName,gender,IDNumber,ContactNumber,email,address,stImage) values (?,?,?,?,?,?,?,?);   ";
           
           try{
           pst=con.prepareStatement(quary);
           pst.setString(1, stID);
           pst.setString(2, stName);
           pst.setString(3, gender);
           pst.setString(4, IDNumber);
           pst.setString(5, contactNumber);
           pst.setString(6, Email);
           pst.setString(7, Address);
           InputStream is= new FileInputStream(new File(path));
           pst.setBlob(8,is);
           pst.execute();
           JOptionPane.showMessageDialog(null,"Successfuly Registered");
           }
           catch(Exception e){
              JOptionPane.showMessageDialog(null,e); 
           }
           
    }
    
    void getData(){
            stName=txtStName.getText();
            stID=txtStID.getText();
            IDNumber=txtIdNum.getText();
            contactNumber=txtContact.getText();
            Email=txtEmail.getText();
            Address=txtAddress.getText();
            
            if(radioMale.isSelected()){ gender="Male";}
            if(radioFemale.isSelected()){gender="Female";}
            
            
    }
    
    void validation(){
        String emailPattern="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,}$)";
        String contactNumberPattern="\\d{10}";
        
        if(stName.isEmpty()){JOptionPane.showMessageDialog(null,"Enter Student Name");}
       else if(stID.isEmpty()){JOptionPane.showMessageDialog(null,"Enter Student ID");}
       else if(gender==null){JOptionPane.showMessageDialog(null,"Please Select Male or Female ");}
       else if(IDNumber.isEmpty()){JOptionPane.showMessageDialog(null,"Enter ID Number");}
       else if((Email.isEmpty())||(!contactNumber.matches(contactNumberPattern))){JOptionPane.showMessageDialog(null,"Enter Valid Contact Number");}
       else if((Email.isEmpty())||(!Email.matches(emailPattern))){JOptionPane.showMessageDialog(null,"Enter Valid Email Address ");}
       else if(Address.isEmpty()){JOptionPane.showMessageDialog(null,"Enter Valid Email Address ");}
       else{
             statment();  
       }
    }
    private void txtContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContactActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                txtStName.setText(null);
                txtStID.setText(null);
                txtIdNum.setText(null);
                txtContact.setText(null);
                txtEmail.setText(null);
                txtAddress.setText(null);
                if(radioMale.isSelected()){
                   radioMale.setSelected(false);
                }
                if(radioFemale.isSelected()){
                    radioFemale.setSelected(false);
                }
                labImage.setIcon(null);
                
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       System.exit(EXIT_ON_CLOSE);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        this.setVisible(false);
        dashboard dash=new dashboard();
        dash.setVisible(true);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void btnAddPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPhotoActionPerformed
        JFileChooser chooser=new JFileChooser();
        chooser.showOpenDialog(null);
        File file=chooser.getSelectedFile();
        String path=file.getAbsolutePath();
        
        try{
            BufferedImage bi = ImageIO.read(new File(path));
            Image img =bi.getScaledInstance(200,200,Image.SCALE_SMOOTH);
            ImageIcon icon=new ImageIcon(img);
            labImage.setIcon(icon);
            this.path=path;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e); 
        }
    }//GEN-LAST:event_btnAddPhotoActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        getData();
        validation();
        
    }//GEN-LAST:event_btnSaveActionPerformed

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
            java.util.logging.Logger.getLogger(registerStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registerStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registerStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registerStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registerStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPhoto;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labImage;
    private javax.swing.JRadioButton radioFemale;
    private javax.swing.JRadioButton radioMale;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIdNum;
    private javax.swing.JTextField txtStID;
    private javax.swing.JTextField txtStName;
    // End of variables declaration//GEN-END:variables
}
