/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package student_management_system;

import java.awt.Image;
import java.io.FileOutputStream;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Sasindu
 */
public class StudenForCourse extends javax.swing.JFrame {
    
    Connection con=null;
    PreparedStatement pst=null;
   
    String StIdForCourse=null;
    String course=null;
    String stId=null;
    
    public StudenForCourse() {
        initComponents();
        Connect();
        showData();
    }

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
    void getData(){
        StIdForCourse=txtStIDForCourse.getText();
        stId=txtStudentID.getText();
        course=txtCourseID.getText();
    }
    void showData(){
        String query="select * from student_for_course";
        try{ 
            pst=con.prepareStatement(query);
            ResultSet result=pst.executeQuery();
            DefaultTableModel model=(DefaultTableModel)StudentForCourseTable.getModel();
            Object[] row;
            
            while(result.next()){
                row=new Object[3];
                row[0]=result.getString(1);
                row[1]=result.getString(2);
                row[2]=result.getString(3);
               model.addRow(row);     
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labClose = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labBack = new javax.swing.JLabel();
        coursepanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtStIDForCourse = new javax.swing.JTextField();
        txtStudentID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        StudentForCourseTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnAddCourse = new javax.swing.JButton();
        btnUpdateCourse = new javax.swing.JButton();
        btnDeleteCourse = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtCourseID = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Course For Students");

        labClose.setIcon(new javax.swing.ImageIcon("D:\\java project\\student_management_system\\pic\\close.png")); // NOI18N
        labClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(277, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(222, 222, 222)
                .addComponent(labClose)
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labClose)
                    .addComponent(jLabel1))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labBack.setIcon(new javax.swing.ImageIcon("D:\\java project\\student_management_system\\pic\\back.png")); // NOI18N
        labBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labBackMouseClicked(evt);
            }
        });
        jPanel2.add(labBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 14, 37, -1));

        coursepanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Student ID For Course");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Course  ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Student ID");

        txtStIDForCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStIDForCourseActionPerformed(evt);
            }
        });

        StudentForCourseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID For Course", "Student ID", "Course ID"
            }
        ));
        StudentForCourseTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StudentForCourseTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(StudentForCourseTable);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Search by Student ID");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(0, 0, 102));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnAddCourse.setBackground(new java.awt.Color(0, 0, 102));
        btnAddCourse.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddCourse.setForeground(new java.awt.Color(255, 255, 255));
        btnAddCourse.setText("Add ");
        btnAddCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCourseActionPerformed(evt);
            }
        });

        btnUpdateCourse.setBackground(new java.awt.Color(0, 0, 102));
        btnUpdateCourse.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdateCourse.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateCourse.setText("Update");
        btnUpdateCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCourseActionPerformed(evt);
            }
        });

        btnDeleteCourse.setBackground(new java.awt.Color(0, 0, 102));
        btnDeleteCourse.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDeleteCourse.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteCourse.setText("Delete");
        btnDeleteCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCourseActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Business Analysist Degree Program", "Information Technology Degree Program", "Information Technology Diploma Program", "Information Technology NVQ leval 5 " }));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Course ID ");

        jLabel11.setIcon(new javax.swing.ImageIcon("D:\\java project\\student_management_system\\pic\\reload.png")); // NOI18N
        jLabel11.setText("jLabel11");
        jLabel11.setPreferredSize(new java.awt.Dimension(30, 30));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout coursepanelLayout = new javax.swing.GroupLayout(coursepanel);
        coursepanel.setLayout(coursepanelLayout);
        coursepanelLayout.setHorizontalGroup(
            coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coursepanelLayout.createSequentialGroup()
                .addGroup(coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(coursepanelLayout.createSequentialGroup()
                        .addGroup(coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(coursepanelLayout.createSequentialGroup()
                                .addGap(331, 331, 331)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(coursepanelLayout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(coursepanelLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(coursepanelLayout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addGroup(coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, coursepanelLayout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(28, 28, 28))
                                .addGroup(coursepanelLayout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(101, 101, 101)))
                            .addGroup(coursepanelLayout.createSequentialGroup()
                                .addGroup(coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(coursepanelLayout.createSequentialGroup()
                                .addComponent(btnAddCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdateCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeleteCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtStudentID)
                                .addComponent(txtStIDForCourse)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCourseID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        coursepanelLayout.setVerticalGroup(
            coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coursepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtStIDForCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddCourse)
                    .addComponent(btnUpdateCourse)
                    .addComponent(btnDeleteCourse))
                .addGap(45, 45, 45)
                .addGroup(coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel2.add(coursepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 920, 550));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 920, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void labCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labCloseMouseClicked
        System.exit(EXIT_ON_CLOSE);
    }//GEN-LAST:event_labCloseMouseClicked

    private void labBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labBackMouseClicked
        this.setVisible(false);
        dashboard dash=new dashboard();
        dash.setVisible(true);
    }//GEN-LAST:event_labBackMouseClicked

    private void btnAddCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCourseActionPerformed
         getData();
        String query="insert into student_for_course(stcId,stID,courseID) values (?,?,?);";
        if(StIdForCourse.isEmpty()){JOptionPane.showMessageDialog(null,"Enter Student Id for Course");}
       else if(stId.isEmpty()){JOptionPane.showMessageDialog(null,"Enter Student Id");}
       else if(course.isEmpty()){JOptionPane.showMessageDialog(null,"Enter Course Id");}
       else{
           try{
                pst=con.prepareStatement(query);
                pst.setString(1, StIdForCourse);
                pst.setString(2, stId);
                pst.setString(3,course);
                pst.execute();
                JOptionPane.showMessageDialog(null,"Successfuly Add Student for Class");
           }
           catch(Exception e){
               JOptionPane.showMessageDialog(null,e);
           }
       }
    }//GEN-LAST:event_btnAddCourseActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
       DefaultTableModel model=(DefaultTableModel)StudentForCourseTable.getModel();
        int rowcount=StudentForCourseTable.getRowCount();

        for(int i=0;i<rowcount;i++){
            model.removeRow(0);
        }

        showData();

        txtSearch.setText(null);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       
        String query="select courseID from course where courseName='"+jComboBox1.getSelectedItem().toString()+"'";
        String id=null;
        try{
            Statement st=con.createStatement();
            ResultSet result=st.executeQuery(query);
            
                while(result.next()){
                        id=result.getString(1);
                }
            txtCourseID.setText(id);
        }
        catch(Exception e){
            
        }
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void StudentForCourseTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentForCourseTableMouseClicked
        String name=null;
        DefaultTableModel model=(DefaultTableModel)StudentForCourseTable.getModel();
        int index=StudentForCourseTable.getSelectedRow();
        
        txtStIDForCourse.setText(model.getValueAt(index,0).toString());
        txtStudentID.setText(model.getValueAt(index,1).toString());
        course=model.getValueAt(index,2).toString();
        txtCourseID.setText(course);
        String query="select courseName from course where courseID ='"+course+"'";
        try{ 
            pst=con.prepareStatement(query);
            ResultSet result=pst.executeQuery();
            while(result.next()){
                  name=result.getString(1);
            }
            jComboBox1.setSelectedItem(name);
        }
         catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            }
        
    }//GEN-LAST:event_StudentForCourseTableMouseClicked

    private void btnDeleteCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCourseActionPerformed
        StIdForCourse=txtSearch.getText();
        String quary="delete from student_for_course where stcId = '"+StIdForCourse+"';";
        
        int option = JOptionPane.showConfirmDialog(null,"Are you Sure to Delete","Delete",JOptionPane.YES_NO_OPTION);
        if(option==0){
            try{
                Statement st=con.createStatement();
                st.execute(quary);
                JOptionPane.showMessageDialog(null,"Successfuly Deleted");
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            }
        }
    }//GEN-LAST:event_btnDeleteCourseActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        DefaultTableModel model=(DefaultTableModel)StudentForCourseTable.getModel();
        int rowcount=StudentForCourseTable.getRowCount();
        
        for(int i=0;i<rowcount;i++){
            model.removeRow(0);
        }
        
        String searchquery="select * from student_for_course where stID = '"+txtSearch.getText()+"'";
        
        try{ 
            pst=con.prepareStatement(searchquery);
            ResultSet result=pst.executeQuery();
            Object[] row;
            
            while(result.next()){
                row=new Object[3];
                row[0]=result.getString(1);
                row[1]=result.getString(2);
                row[2]=result.getString(3);
                model.addRow(row);    
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtStIDForCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStIDForCourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStIDForCourseActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnUpdateCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCourseActionPerformed
        getData();
        String updateQuery="update student_for_course set stID=?,courseID=? where stcId=?;";
        if(StIdForCourse.isEmpty()){JOptionPane.showMessageDialog(null,"Enter Student Id for Course");}
       else if(stId.isEmpty()){JOptionPane.showMessageDialog(null,"Enter Student Id");}
       else if(course.isEmpty()){JOptionPane.showMessageDialog(null,"Enter Course Id");}
       else{
            try{
                pst=con.prepareStatement(updateQuery);
                pst.setString(1, stId);
                pst.setString(2, course);
                pst.setString(3, StIdForCourse);
                pst.execute();
                JOptionPane.showMessageDialog(null,"Successfuly Updated");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            
        }
       }
    }//GEN-LAST:event_btnUpdateCourseActionPerformed

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
            java.util.logging.Logger.getLogger(StudenForCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudenForCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudenForCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudenForCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudenForCourse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable StudentForCourseTable;
    private javax.swing.JButton btnAddCourse;
    private javax.swing.JButton btnDeleteCourse;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdateCourse;
    private javax.swing.JPanel coursepanel;
    public javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labBack;
    private javax.swing.JLabel labClose;
    private javax.swing.JTextField txtCourseID;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtStIDForCourse;
    private javax.swing.JTextField txtStudentID;
    // End of variables declaration//GEN-END:variables
}
