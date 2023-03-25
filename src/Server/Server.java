package Server;

import pojos.ChatServices;
import pojos.ChatServicesImpl;
import pojos.NewHibernateUtil;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import org.hibernate.Session;




public class Server {
    public static void main(String[] args) {
        
        try{
            
            //Creating the RMI Registry
            Registry myReg=LocateRegistry.createRegistry(5000);
            
            //2. Binding the remote object
            ChatServices cs=new ChatServicesImpl();
            myReg.rebind("MyUserServer",cs);
            
            //To identify server is running
            System.out.println("Server is Running...");
            
        }catch(RemoteException e){
            System.out.println("Exception in creating registry..." + e.getMessage());
        }
    }
}
