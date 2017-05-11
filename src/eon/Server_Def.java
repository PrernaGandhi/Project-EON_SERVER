/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eon;
import static eon.lecture.lec;
import java.rmi.*;
import java.rmi.server.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author prince
 */
public class Server_Def extends UnicastRemoteObject implements Eon_intf {
    public static int i = 0;
    public static String dbt = "";
    Server_Def() throws RemoteException{
        super();
    }
    public String demo(){
    System.out.println("Connection number:" + (++i));
    return "Connection established with server";
    }

    public String credentials(String uname, String pwd) throws RemoteException {
        try{
            Class.forName("java.sql.DriverManager");
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) DriverManager.getConnection
                            ("jdbc:mysql://localhost:3306/eon", "root", "root");
            Statement stmt = (Statement) con.createStatement();
            String query = "Select id,password from login where id='"+uname+"' and password='"+pwd+"' ;";
            ResultSet rs = stmt.executeQuery(query);
            String usr = "";
            String pass = "";
            while(rs.next())
            {
                usr = rs.getString("id");
                pass = rs.getString("password");
            }


            if ((usr.equals(uname)) && (pass.equals(pwd)))
            {
                return (usr+" connected with db");
            }
            else {
                return "Username/Password not matched with DATABASE";
            }

        }   
        catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String lect() {
        
        return lec;
    }
    
    public void doubt(String get){
        dbt = get;
        
    }
    
}
