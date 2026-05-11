/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package student_management_system;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class payment extends javax.swing.JFrame {

    Connection con=null;
    Statement st=null;
    String query=null;
    
   String date;
   String courseName=null;
   String courseID=null;
   String stcID=null;
   String courseFees=null;
    public payment() {
        initComponents();
        Connect();
        getDate();
        query="select stcId,month,dates,ammount from payment;";
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
    
    void getDate(){
        Date get_date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        date = dateFormat.format(get_date);
        txtDate.setText(date);
    }
    
   void getData(){
       
       try{
            query="select sc.stcId,c.monthlyFees from student_for_course as sc join course as c on sc.courseID=c.courseID where sc.stID='"+txtID.getText()+"' && sc.courseID='"+courseID+"'";
            st=con.createStatement();
            ResultSet result=st.executeQuery(query);

            while(result.next()){
                stcID=result.getString(1);
                courseFees=result.getString(2);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
   }
   
   void showData(){
        
        try{ 
            st=con.createStatement();
            ResultSet result=st.executeQuery(query);
            DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
            Object[] row;
            
            while(result.next()){
                row=new Object[5];
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
        labClose = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labBack = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        comCourse = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        comMonth = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        filterCourse = new javax.swing.JComboBox<>();
        filterMonth = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnFilter = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Payments");

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
                .addContainerGap(359, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(323, 323, 323)
                .addComponent(labClose)
                .addGap(33, 33, 33))
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
        jPanel2.add(labBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 37, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Student ID");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 70, -1));
        jPanel2.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 263, -1));

        comCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Business Analysist Degree Program", "Information Technology Degree Program", "Information Technology Diploma Program", "Information Technology NVQ leval 5 " }));
        comCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comCourseActionPerformed(evt);
            }
        });
        jPanel2.add(comCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 263, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Course");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 50, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Month");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, -1, -1));

        comMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOMBER", "NOVEMBER", "DECEMBER", " " }));
        comMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comMonthActionPerformed(evt);
            }
        });
        jPanel2.add(comMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 263, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Date");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 40, -1));
        jPanel2.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 263, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course For Student ID", "Month", "Date", "Ammount"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 345, 914, 259));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Student ID");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 240, 80, -1));

        filterCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Business Analysist Degree Program", "Information Technology Degree Program", "Information Technology Diploma Program", "Information Technology NVQ leval 5 " }));
        filterCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterCourseActionPerformed(evt);
            }
        });
        jPanel2.add(filterCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 263, -1));

        filterMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOMBER", "NOVEMBER", "DECEMBER", " " }));
        filterMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterMonthActionPerformed(evt);
            }
        });
        jPanel2.add(filterMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 263, -1));
        jPanel2.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, 211, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Course");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 50, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Month");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, -1, -1));

        btnAdd.setBackground(new java.awt.Color(51, 0, 102));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel2.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, 97, -1));

        btnSearch.setBackground(new java.awt.Color(51, 0, 102));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel2.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 309, 97, -1));

        btnFilter.setBackground(new java.awt.Color(51, 0, 102));
        btnFilter.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFilter.setForeground(new java.awt.Color(255, 255, 255));
        btnFilter.setText("Filter");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        jPanel2.add(btnFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 309, 97, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon("D:\\java project\\student_management_system\\pic\\reload.png")); // NOI18N
        jLabel12.setText("jLabel11");
        jLabel12.setPreferredSize(new java.awt.Dimension(30, 30));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(861, 305, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 920, 630));

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

    private void comCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comCourseActionPerformed
        courseID=null;
        try{
            query="select courseID from course where courseName='"+comCourse.getSelectedItem()+"';";
            st=con.createStatement();
            ResultSet result=st.executeQuery(query);

            while(result.next()){
                courseID=result.getString(1);   
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_comCourseActionPerformed

    private void comMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comMonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comMonthActionPerformed

    private void filterCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterCourseActionPerformed
        courseID=null;
        try{
            query="select courseID from course where courseName='"+filterCourse.getSelectedItem()+"';";
            st=con.createStatement();
            ResultSet result=st.executeQuery(query);

            while(result.next()){
                courseID=result.getString(1);   
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_filterCourseActionPerformed

    private void filterMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterMonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterMonthActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        int rowcount=jTable1.getRowCount();

        for(int i=0;i<rowcount;i++){
            model.removeRow(0);
        }
        query="select stcId,month,dates,ammount from payment;";
        showData();
        courseID=null;

    }//GEN-LAST:event_jLabel12MouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        getData();
        try{
        query="insert into payment(stcId,month,dates,ammount) values('"+stcID+"','"+comMonth.getSelectedItem()+"','"+date+"','"+courseFees+"')";
        st=con.createStatement();
        st.executeUpdate(query);
        JOptionPane.showMessageDialog(null,"Successfuly Add");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
         DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        int rowcount=jTable1.getRowCount();

        for(int i=0;i<rowcount;i++){
            model.removeRow(0);
        }
        query="select p.stcId,p.month,p.dates,p.ammount from payment as p join student_for_course as sc on p.stcId=sc.stcId  where sc.stID='"+txtSearch.getText()+"';";
        showData();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
         DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        int rowcount=jTable1.getRowCount();

        for(int i=0;i<rowcount;i++){
            model.removeRow(0);
        }
        
        String search =txtSearch.getText();
        if(search.isEmpty()){
            query="select p.stcId,p.month,p.dates,p.ammount from payment as p join student_for_course as sc on p.stcId=sc.stcId  where p.month='"+filterMonth.getSelectedItem()+"'&& sc.courseID ='"+courseID+"';";
        }
        else{
          query="select p.stcId,p.month,p.dates,p.ammount from payment as p join student_for_course as sc on p.stcId=sc.stcId  where p.month='"+filterMonth.getSelectedItem()+"'&& sc.courseID ='"+courseID+"' && sc.stID='"+txtSearch.getText()+"';";  
        }
        showData();
    }//GEN-LAST:event_btnFilterActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new payment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> comCourse;
    private javax.swing.JComboBox<String> comMonth;
    private javax.swing.JComboBox<String> filterCourse;
    private javax.swing.JComboBox<String> filterMonth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labBack;
    private javax.swing.JLabel labClose;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
