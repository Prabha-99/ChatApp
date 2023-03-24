
package Logic;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {
        // create a SessionFactory object
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        
        // create a LoginAuth object
        LoginAuth getUser = new LoginAuth(sessionFactory);
        
        // get all users
        List<Users> users = getUser.logAuth();
        
        // print all users
        for (Users user : users) {
            System.out.println("ID: " + user.getUserId() +
                               ", Name: " + user.getUserName() +
                               ", Email: " + user.getEmail()+
                               ", Nick_Name: " + user.getNickName()+
                               ", Password: " + user.getPassword()
                );
        }
        
        // close the SessionFactory object
        sessionFactory.close();
    }
}
