
package Logic;

import Interfaces.LoginForm;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class LoginAuth {
    private final SessionFactory sessionFactory;
    

    public LoginAuth(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        
    }

    
    
    public List<Users> logAuth(){
        Session session =sessionFactory.openSession();
        
        
        String email ="jenna@gmail.com";
        String password ="jenna@123";
        
        Query query=session.createQuery("FROM Users where email=:email and password=:password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        List<Users> users=query.list();
        
        session.close();
        return users;
        
//        if(users.size() == 1) {
//                return true;
//            } else {
//                return false;
//            }
    }
}
