package ma.fstm.ilisi.recrutement.model.dao.hib;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FabricSession
{
    private static SessionFactory sessionFactory;
    private FabricSession(){
    }
    public static SessionFactory getSessionFactory(){
        if(sessionFactory==null){
            try
            {
                sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            }catch (Throwable exception){
                System.err.println(exception);
            }
        }
        return sessionFactory;
    }
}
