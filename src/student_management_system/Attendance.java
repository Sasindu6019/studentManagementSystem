/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package student_management_system;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.sql.*;
import javax.swing.table.DefaultTableModel;




public class Attendance extends javax.swing.JFrame implements Runnable,ThreadFactory{

    WebcamPanel panal=null;
    Webcam webcam=null;
    Executor ex=Executors.newSingleThreadExecutor(this);
    String stcID=null;
    Timer timer;
    String date;
    String time;
    String status =null;
    Connection con=null;
    PreparedStatement pst=null;
    String query=null;
    String courseID=null;
    
    public Attendance() {
        initComponents();
        dateAndTimePicker();
        Connect();
        query="select s.stID,s.stName,c.courseName,a.attendanceDate,a.times from attendance as a join student_for_course as sc on a.stcID=sc.stcId join students as s on sc.stID=s.stID join course as c on sc.courseID=c.courseID;";
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
    void dateAndTimePicker(){
            Date getDate =new Date();
            SimpleDateFormat dateFormate=new SimpleDateFormat("yyyy-MM-dd");
            date = dateFormate.format(getDate);
            txtDate.setText(date);
            
            Timer timer=new Timer(0,new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    Date geTime = new Date();
                    SimpleDateFormat timeFormate=new SimpleDateFormat("HH:mm:ss ");
                    time = timeFormate.format(geTime);
                    txtTime.setText(time);
                }
                   
            });
            
            timer.start();         
    }
    
    void webcam(){
    
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0);
        webcam.setViewSize(size);
        
        
        panal = new WebcamPanel(webcam);
        panal.setPreferredSize(size);
        panal.setFPSDisplayed(true);
        
        jPanel6.add(panal,new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,470,300));
        
        ex.execute(this);
        
    }
    
    public void run(){
        do{
                try{
                    Thread.sleep(100);
                }
                catch(Exception e){JOptionPane.showMessageDialog(null,e);}
                
                Result  result=null;
                BufferedImage image=null;
                
                if(webcam.isOpen()){
                    if((image=webcam.getImage())==null){
                        continue;
                    }
                }
                
                LuminanceSource sourse =new BufferedImageLuminanceSource(image);
                BinaryBitmap bitmap=new BinaryBitmap(new HybridBinarizer(sourse));
                
            try {
                result= new MultiFormatReader().decode(bitmap);
            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null,e);
            }
            
            if(result !=null){
                stcID=result.getText().toString();
                status="Present";
            }
            txtStIDForCourse.setText(stcID);
            txtStatus.setText(status);
        }
        
        while(true);   
    }
    @Override
    public Thread newThread(Runnable r){
        Thread t = new Thread(r,"Thread");
        t.setDaemon(true);
        return t;
    }
    
    void insertStatment(){
        query="insert into attendance(stcID,statuses,attendanceDate,times) values('"+stcID+"','"+status+"','"+date+"','"+time+"');"; 
        try{
            Statement st=con.createStatement();
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Successfully Marked");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
        
    }
    void showData(){
        
        try{ 
            pst=con.prepareStatement(query);
            ResultSet result=pst.executeQuery();
            DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
            Object[] row;
            
            while(result.next()){
                row=new Object[5];
                row[0]=result.getString(1);
                row[1]=result.getString(2);
                row[2]=result.getString(3);
                row[3]=result.getString(4);
                row[4]=result.getString(5);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnMarkAttendance = new javax.swing.JButton();
        btnViewAttendance = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtId = new javax.swing.JTextField();
        fromDate = new com.toedter.calendar.JDateChooser();
        toDate = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnFilter = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnScan1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtStIDForCourse = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        btnMark = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\java project\\student_management_system\\pic\\close.png")); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Attendence");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(378, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(268, 268, 268)
                .addComponent(jLabel2)
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(0, 12, Short.MAX_VALUE))
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
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 37, -1));

        btnMarkAttendance.setBackground(new java.awt.Color(0, 0, 102));
        btnMarkAttendance.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMarkAttendance.setForeground(new java.awt.Color(255, 255, 255));
        btnMarkAttendance.setText("Mark Attendance");
        btnMarkAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarkAttendanceActionPerformed(evt);
            }
        });
        jPanel2.add(btnMarkAttendance, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, 30));

        btnViewAttendance.setBackground(new java.awt.Color(0, 0, 102));
        btnViewAttendance.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnViewAttendance.setForeground(new java.awt.Color(255, 255, 255));
        btnViewAttendance.setText("View Attendance");
        btnViewAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAttendanceActionPerformed(evt);
            }
        });
        jPanel2.add(btnViewAttendance, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, -1, 30));

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(500, 300));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student Name", "Course Name", "Date", "Time"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 177, 833, 288));
        jPanel3.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(673, 77, 192, -1));
        jPanel3.add(fromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 77, 152, -1));
        jPanel3.add(toDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 77, 152, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("From Date");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 49, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("To Date");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 49, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Student ID");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(673, 49, -1, -1));

        btnFilter.setBackground(new java.awt.Color(0, 0, 102));
        btnFilter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFilter.setForeground(new java.awt.Color(255, 255, 255));
        btnFilter.setText("Filter");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        jPanel3.add(btnFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, -1, 30));

        btnSearch.setBackground(new java.awt.Color(0, 0, 102));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel3.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, -1, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Course");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 49, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Business Analysist Degree Program", "Information Technology Degree Program", "Information Technology Diploma Program", "Information Technology NVQ leval 5 " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 77, 263, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon("D:\\java project\\student_management_system\\pic\\reload.png")); // NOI18N
        jLabel12.setText("jLabel11");
        jLabel12.setPreferredSize(new java.awt.Dimension(30, 30));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 140, -1, -1));

        jTabbedPane1.addTab("", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        btnScan1.setBackground(new java.awt.Color(0, 0, 102));
        btnScan1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnScan1.setForeground(new java.awt.Color(255, 255, 255));
        btnScan1.setText("Scan");
        btnScan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScan1ActionPerformed(evt);
            }
        });

        jPanel6.setPreferredSize(new java.awt.Dimension(470, 300));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Status");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Date");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Time");

        txtTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimeActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Student ID ");

        txtStIDForCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStIDForCourseActionPerformed(evt);
            }
        });

        txtStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStatusActionPerformed(evt);
            }
        });

        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });

        btnMark.setBackground(new java.awt.Color(0, 0, 102));
        btnMark.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMark.setForeground(new java.awt.Color(255, 255, 255));
        btnMark.setText("Mark Attendance");
        btnMark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtStIDForCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(btnMark))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(btnScan1)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btnScan1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStIDForCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMark)))
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("", jPanel4);

        jPanel2.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 920, 490));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 920, 640));

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

    private void btnMarkAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarkAttendanceActionPerformed
        
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnMarkAttendanceActionPerformed

    private void btnViewAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAttendanceActionPerformed
        
        jTabbedPane1.setSelectedIndex(0);
        webcam.close();
    }//GEN-LAST:event_btnViewAttendanceActionPerformed

    private void btnScan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScan1ActionPerformed
        webcam();
        
    }//GEN-LAST:event_btnScan1ActionPerformed

    private void txtTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimeActionPerformed

    private void txtStIDForCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStIDForCourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStIDForCourseActionPerformed

    private void txtStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStatusActionPerformed

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateActionPerformed

    private void btnMarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarkActionPerformed
        if(stcID != null){
                insertStatment();
        }
    }//GEN-LAST:event_btnMarkActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
       DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        int rowcount=jTable1.getRowCount();

        for(int i=0;i<rowcount;i++){
            model.removeRow(0);
        }
        
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String from_date= dateFormat.format(fromDate.getDate());
        String to_date= dateFormat.format(toDate.getDate());
        String stId=txtId.getText();
        if(stId.isEmpty() && courseID==null){
            query="select s.stID,s.stName,c.courseName,a.attendanceDate,a.times from attendance as a join student_for_course as sc on a.stcID=sc.stcId join students as s on sc.stID=s.stID join course as c on sc.courseID=c.courseID where a.attendanceDate between '"+from_date+"' and '"+to_date+"' ;";
        }
        else if(stId.isEmpty()){
           query="select s.stID,s.stName,c.courseName,a.attendanceDate,a.times from attendance as a join student_for_course as sc on a.stcID=sc.stcId join students as s on sc.stID=s.stID join course as c on sc.courseID=c.courseID where a.attendanceDate between '"+from_date+"' and '"+to_date+"' and c.courseID='"+courseID+"' ;"; 
        }
        else{
            query="select s.stID,s.stName,c.courseName,a.attendanceDate,a.times from attendance as a join student_for_course as sc on a.stcID=sc.stcId join students as s on sc.stID=s.stID join course as c on sc.courseID=c.courseID where a.attendanceDate between '"+from_date+"' and '"+to_date+"' and c.courseID='"+courseID+"' and s.stID='"+stId+"';";
        }
        showData();
    }//GEN-LAST:event_btnFilterActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        int rowcount=jTable1.getRowCount();

        for(int i=0;i<rowcount;i++){
            model.removeRow(0);
        }
        query="select s.stID,s.stName,c.courseName,a.attendanceDate,a.times from attendance as a join student_for_course as sc on a.stcID=sc.stcId join students as s on sc.stID=s.stID join course as c on sc.courseID=c.courseID where s.stID='"+txtId.getText()+"';";
        showData();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        int rowcount=jTable1.getRowCount();

        for(int i=0;i<rowcount;i++){
            model.removeRow(0);
        }
        query="select s.stID,s.stName,c.courseName,a.attendanceDate,a.times from attendance as a join student_for_course as sc on a.stcID=sc.stcId join students as s on sc.stID=s.stID join course as c on sc.courseID=c.courseID;";
        showData();
        courseID=null;
        
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
      try{ 
            query="select courseID from course where courseName='"+jComboBox1.getSelectedItem().toString()+"'";
            pst=con.prepareStatement(query);
            ResultSet result=pst.executeQuery();
            
            while(result.next()){
                  courseID=result.getString(1); 
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Attendance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnMark;
    private javax.swing.JButton btnMarkAttendance;
    private javax.swing.JButton btnScan1;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnViewAttendance;
    private com.toedter.calendar.JDateChooser fromDate;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser toDate;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtStIDForCourse;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtTime;
    // End of variables declaration//GEN-END:variables
}
