
package pojos;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ChatServices extends Remote {
    
    public void sendMessage(String message)throws RemoteException;//Method for send Messages to the Server from Client
    public String receiveMessage()throws RemoteException;//Method for Receive Messages from Server to Client
    
}
