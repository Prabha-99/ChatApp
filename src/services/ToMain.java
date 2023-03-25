
package services;

import pojos.Users;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ToMain {
    
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    
    
    public List<Users> getUserDetails(){
        
        Session session =sessionFactory.openSession();
        Query query=session.createQuery("FROM Users");
        List<Users> users=query.list();
        
        session.close();
        
        return users;
        
        
        
    }
}
