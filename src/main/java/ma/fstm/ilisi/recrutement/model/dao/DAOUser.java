package ma.fstm.ilisi.recrutement.model.dao;

import ma.fstm.ilisi.recrutement.model.bo.User;
import ma.fstm.ilisi.recrutement.model.dao.hib.FabricSession;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class DAOUser implements IDAO<User>{
    private static DAOUser daoUser=null;
    public static DAOUser getDAOUser(){
       if(daoUser==null)daoUser=new DAOUser();
       return  daoUser;
    }
    private DAOUser(){

    }
    @Override
    public boolean Create(User user)
    {
        Session session= FabricSession.getSessionFactory().getCurrentSession();
        Transaction tx=session.beginTransaction();
        try {
           session.save(user);
           tx.commit();
           return true;
        }catch (HibernateException e){
            tx.rollback();
            System.err.println(e);
            return false;
        }
    }

    @Override
    public Collection<User> Retrieve() {
        Session session= FabricSession.getSessionFactory().getCurrentSession();
        Transaction tx=session.beginTransaction();
        List<User> users;
        try {
            users=session.createQuery("from User ").list();
            tx.commit();
            return users;
        } catch (HibernateException e) {
            tx.rollback();
          return null;
        }
    }

    @Override
    public void update(User user) {
        Session session= FabricSession.getSessionFactory().getCurrentSession();
        Transaction tx=session.beginTransaction();
        try {
            session.update(user);
            tx.commit();
        }catch (HibernateException e){
            tx.rollback();
            System.err.println(e);
        }
    }

    @Override
    public boolean delete(User user)
    {
        Session session= FabricSession.getSessionFactory().getCurrentSession();
        Transaction tx=session.beginTransaction();
        try {
            session.delete(user);
            tx.commit();
            return true;
        }catch (HibernateException e){
            tx.rollback();
            System.err.println(e);
            return false;
        }
    }
    public User Authenticate(String login,String passHashe)
    {
        Session session= FabricSession.getSessionFactory().getCurrentSession();
        Transaction tx=session.beginTransaction();
        User user=null;
        try
        {
            return (User) session.createQuery("from User user where user.login="+login+" and user.passhash="+passHashe).list().get(0);
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }


}
