
package Logic;

import Interfaces.LoginForm;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class LoginAuth {
    
    private final  SessionFactory sessionFactory;
    private final LoginForm loginForm;

    public LoginAuth(SessionFactory sessionFactory, LoginForm loginForm) {
        this.sessionFactory = sessionFactory;
        this.loginForm = loginForm;
    }

    
    
   
    public synchronized boolean logAuth(){
        
        Session session=sessionFactory.openSession();
        
        String email =loginForm.getEmail();
        String password =loginForm.getPassword();
           
            Query query = session.createQuery("from Users where email=:email and password=:password");
            query.setParameter("email", email);
            query.setParameter("password", password);
            List<Users> users = query.list();
            
            
            if (users.size() == 1) {
                return true;
            } else {
                return false;
            }
            
    }
     
    
}
