package Server;

import ChatService.ChatServices;
import ChatService.ChatServicesImpl;
import ChatService.NewHibernateUtil;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import org.hibernate.Session;




public class Server {
    public static void main(String[] args) {
        
        try{
            
            //Creating the RMI Registry
            Registry myReg=LocateRegistry.createRegistry(5000);
            
            //Creating a Session Object using Hibernate Utility Class 
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            
            //2. Binding the remote object
            ChatServices cs=new ChatServicesImpl();
            myReg.rebind("MyUserServer",cs);
            
            //To identify server is running
            System.out.println("Server is Running...");
            
        }catch(Exception e){
            System.out.println("Exception in creating registry..." + e.getMessage());
        }
    }
}
