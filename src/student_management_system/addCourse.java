/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package student_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sasindu
 */
public class addCourse extends javax.swing.JFrame {
        
        Connection con=null;
        PreparedStatement pst=null;
        String query=null;
        
        String cName=null;
        String cID=null;
        String cDuration=null;
        int cFees=0;
  
    public addCourse() {
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
        
            cName=txtCourseName.getText();
            cID=txtCourseID.getText();
            cDuration=txtDuration.getText();
            cFees=Integer.parseInt(txtFees.getText());
    }
    
    void validation(){
        
        if(txtCourseName.getText().isEmpty()){JOptionPane.showMessageDialog(null,"Enter Course Name ");}
        else if(txtCourseID.getText().isEmpty()){JOptionPane.showMessageDialog(null,"Enter Course ID");}
        else if(txtDuration.getText().isEmpty()){JOptionPane.showMessageDialog(null,"Enter Course Duration");}
        else if(txtFees.getText().isEmpty()){JOptionPane.showMessageDialog(null,"Enter Course Fees");}
    }

    void showData(){
        String allSelectquery="select * from course";
        query=allSelectquery;
        try{ 
            pst=con.prepareStatement(query);
            ResultSet result=pst.executeQuery();
            DefaultTableModel model=(DefaultTableModel)courseTable.getModel();
            Object[] row;
            
            while(result.next()){
                row=new Object[8];
                row[0]=result.getString(1);
                row[1]=result.getString(2);
                row[2]=result.getString(3);
                row[3]=result.getString(4);
                
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
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        coursepanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCourseName = new javax.swing.JTextField();
        txtCourseID = new javax.swing.JTextField();
        txtFees = new javax.swing.JTextField();
        txtDuration = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        courseTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtSearchByCourseID = new javax.swing.JTextField();
        btnSearchCourse = new javax.swing.JButton();
        btnAddCourse = new javax.swing.JButton();
        btnUpdateCourse = new javax.swing.JButton();
        btnDeleteCourse = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add Course");

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
                .addContainerGap(338, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(312, 312, 312)
                .addComponent(jLabel2)
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 60));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon("D:\\java project\\student_management_system\\pic\\back.png")); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 14, 37, -1));

        coursepanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Course Name ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Course ID ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Monthly Fees ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Course Duration ");

        courseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course ID", "Course Name", "Monthly Fees", "Course Duration"
            }
        ));
        courseTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courseTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(courseTable);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Search by Course ID or Name");

        btnSearchCourse.setBackground(new java.awt.Color(0, 0, 102));
        btnSearchCourse.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSearchCourse.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchCourse.setText("Search");
        btnSearchCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchCourseActionPerformed(evt);
            }
        });

        btnAddCourse.setBackground(new java.awt.Color(0, 0, 102));
        btnAddCourse.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddCourse.setForeground(new java.awt.Color(255, 255, 255));
        btnAddCourse.setText("Add Course");
        btnAddCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCourseActionPerformed(evt);
            }
        });

        btnUpdateCourse.setBackground(new java.awt.Color(0, 0, 102));
        btnUpdateCourse.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdateCourse.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateCourse.setText("Update Course");
        btnUpdateCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCourseActionPerformed(evt);
            }
        });

        btnDeleteCourse.setBackground(new java.awt.Color(0, 0, 102));
        btnDeleteCourse.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDeleteCourse.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteCourse.setText("Delete Course");
        btnDeleteCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCourseActionPerformed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon("D:\\java project\\student_management_system\\pic\\reload.png")); // NOI18N
        jLabel11.setText("jLabel11");
        jLabel11.setPreferredSize(new java.awt.Dimension(30, 30));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(0, 0, 102));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout coursepanelLayout = new javax.swing.GroupLayout(coursepanel);
        coursepanel.setLayout(coursepanelLayout);
        coursepanelLayout.setHorizontalGroup(
            coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coursepanelLayout.createSequentialGroup()
                .addGroup(coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, coursepanelLayout.createSequentialGroup()
                            .addGap(137, 137, 137)
                            .addComponent(jLabel9)
                            .addGap(45, 45, 45)
                            .addComponent(txtSearchByCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(44, 44, 44)
                            .addComponent(btnSearchCourse)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, coursepanelLayout.createSequentialGroup()
                            .addGap(89, 89, 89)
                            .addGroup(coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(coursepanelLayout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, coursepanelLayout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtFees, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, coursepanelLayout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, coursepanelLayout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(71, 71, 71)
                                    .addComponent(txtCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(131, 131, 131)
                            .addGroup(coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnUpdateCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAddCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDeleteCourse, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnClear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(coursepanelLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        coursepanelLayout.setVerticalGroup(
            coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coursepanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(coursepanelLayout.createSequentialGroup()
                        .addGroup(coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtFees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(coursepanelLayout.createSequentialGroup()
                        .addComponent(btnAddCourse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdateCourse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteCourse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClear)))
                .addGap(68, 68, 68)
                .addGroup(coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtSearchByCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchCourse)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.add(coursepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 840, 550));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 920, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(EXIT_ON_CLOSE);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        this.setVisible(false);
        dashboard dash=new dashboard();
        dash.setVisible(true);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        DefaultTableModel model=(DefaultTableModel)courseTable.getModel();
        int rowcount=courseTable.getRowCount();

        for(int i=0;i<rowcount;i++){
            model.removeRow(0);
        }

        showData();

        txtSearchByCourseID.setText(null);
        txtCourseName.setText(null);
        txtCourseID.setText(null);
        txtDuration.setText(null);
        txtFees.setText(null);
        
    }//GEN-LAST:event_jLabel11MouseClicked

    private void btnAddCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCourseActionPerformed
        validation();
        getData();
        String insertQuery="insert into course(courseID,courseName,monthlyFees,courseDuration) values (?,?,?,?);";
        query=insertQuery;
        try{
            pst=con.prepareStatement(query);
        
                pst.setString(1, cID);
                pst.setString(2, cName);
                pst.setInt(3, cFees);
                pst.setString(4, cDuration);
                pst.execute();
                JOptionPane.showMessageDialog(null,"Successfuly Registered");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            
        }
        
        StudenForCourse add=new StudenForCourse();
        add.jComboBox1.addItem(cName);
    }//GEN-LAST:event_btnAddCourseActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtSearchByCourseID.setText(null);
        txtCourseName.setText(null);
        txtCourseID.setText(null);
        txtDuration.setText(null);
        txtFees.setText(null);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnDeleteCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCourseActionPerformed
       cID=txtCourseID.getText();
        String quary="delete from course where courseID = '"+cID+"';";
        
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

    private void btnUpdateCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCourseActionPerformed
        validation();
        getData();
        String updateQuery="update course set courseName=?,monthlyFees=?,courseDuration=? where courseID=?;";
        query=updateQuery;
        try{
            pst=con.prepareStatement(query);
                pst.setString(1, cName);
                pst.setInt(2, cFees);
                pst.setString(3, cDuration);
                pst.setString(4, cID);
                pst.execute();
                JOptionPane.showMessageDialog(null,"Successfuly Updated");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            
        }
    }//GEN-LAST:event_btnUpdateCourseActionPerformed

    private void courseTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseTableMouseClicked
        DefaultTableModel model=(DefaultTableModel)courseTable.getModel();
        int rownumber =courseTable.getSelectedRow();
        
        txtCourseID.setText(model.getValueAt(rownumber,0).toString());
        txtCourseName.setText(model.getValueAt(rownumber,1).toString());
        txtFees.setText(model.getValueAt(rownumber,2).toString()); 
        txtDuration.setText(model.getValueAt(rownumber,3).toString());
    }//GEN-LAST:event_courseTableMouseClicked

    private void btnSearchCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchCourseActionPerformed
        DefaultTableModel model=(DefaultTableModel)courseTable.getModel();
        int rowcount=courseTable.getRowCount();
        
        for(int i=0;i<rowcount;i++){
            model.removeRow(0);
        }
        
        String searchquery="select * from course where courseID = '"+txtSearchByCourseID.getText()+"' or courseName='"+txtSearchByCourseID.getText()+"'";
        query=searchquery;
        try{ 
            pst=con.prepareStatement(query);
            ResultSet result=pst.executeQuery();
            Object[] row;
            
            while(result.next()){
                row=new Object[8];
                row[0]=result.getString(1);
                row[1]=result.getString(2);
                row[2]=result.getString(3);
                row[3]=result.getString(4);
                model.addRow(row);    
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_btnSearchCourseActionPerformed

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
            java.util.logging.Logger.getLogger(addCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addCourse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCourse;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDeleteCourse;
    private javax.swing.JButton btnSearchCourse;
    private javax.swing.JButton btnUpdateCourse;
    private javax.swing.JTable courseTable;
    private javax.swing.JPanel coursepanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCourseID;
    private javax.swing.JTextField txtCourseName;
    private javax.swing.JTextField txtDuration;
    private javax.swing.JTextField txtFees;
    private javax.swing.JTextField txtSearchByCourseID;
    // End of variables declaration//GEN-END:variables
}
