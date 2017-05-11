/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eon;
import java.rmi.*;
/**
 *
 * @author prince
 */
public interface Eon_intf extends Remote {
    public String demo() throws RemoteException;
    public String credentials(String uname, String pwd) throws RemoteException;
    public String lect() throws RemoteException;
    public void doubt(String get) throws RemoteException;
}
