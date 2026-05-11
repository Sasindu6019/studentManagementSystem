/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student_management_system;

import java.sql.*;

/**
 *
 * @author Sasindu
 */
public class Connect_db {
    
    private Connection con=null;
    private Statement st=null;
    
    public void setConnection(Connection con){
        this.con=con;
    }
    public Connection getConnection(){
        return con;
    }
    
    public void setStatement(Statement st){
        this.st=st;
    }
    public Statement getStatement(){
        return st;
    }
    
}
