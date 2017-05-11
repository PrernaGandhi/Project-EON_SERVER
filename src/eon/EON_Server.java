/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eon;
import java.rmi.*;
import java.rmi.registry.*;
/**
 *
 * @author prince
 */
public class EON_Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.println("Server starting");
       try{
            LocateRegistry.createRegistry(1099);
            System.setProperty("java.rmi.server.hostname", "192.168.1.1");
            Eon_intf request_obj = new Server_Def();
            Naming.rebind("rmi://localhost:1099/eon",request_obj);
            System.out.println("Running on localhost @ port 1099");
	}
        catch(Exception e){
            System.out.println(e);
	}
       new login().setVisible(true);
    }
    
}
