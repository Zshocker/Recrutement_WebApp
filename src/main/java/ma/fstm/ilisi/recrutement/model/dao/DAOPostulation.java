package ma.fstm.ilisi.recrutement.model.dao;

import ma.fstm.ilisi.recrutement.model.bo.Offer;
import ma.fstm.ilisi.recrutement.model.bo.Postulation;
import ma.fstm.ilisi.recrutement.model.dao.hib.FabricSession;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collection;
import java.util.List;

public class DAOPostulation implements IDAO<Postulation>
{
    private static DAOPostulation daoPostulation=null;
    private DAOPostulation(){
    }
    public static DAOPostulation getInstance()
    {
        if(daoPostulation==null)daoPostulation=new DAOPostulation();
        return daoPostulation;
    }
    public boolean Create(Postulation ofr){
        Session session= FabricSession.getSessionFactory().getCurrentSession();
        Transaction tx=session.beginTransaction();
        try
        {
            session.save(ofr);
            tx.commit();
            return true;
        }catch (HibernateException e){
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Collection<Postulation> Retrieve() {
        Session session= FabricSession.getSessionFactory().getCurrentSession();
        Transaction tx=session.beginTransaction();
        try
        {
            List offers= session.createQuery("from Postulation ").list();
            tx.commit();
            return offers;
        }catch (HibernateException e){
            tx.rollback();
            System.out.println(e);
            return null;
        }
    }

    @Override
    public void update(Postulation ofr) {
        Session session= FabricSession.getSessionFactory().getCurrentSession();
        Transaction tx=session.beginTransaction();
        try
        {
            session.update(ofr);
            tx.commit();
        }catch (HibernateException e)
        {
            tx.rollback();
            System.out.println(e);
        }
    }

    @Override
    public boolean delete(Postulation ofr)
    {
        Session session= FabricSession.getSessionFactory().getCurrentSession();
        Transaction tx=session.beginTransaction();
        try
        {
            session.delete(ofr);
            tx.commit();
            return true;
        }catch (HibernateException e)
        {
            tx.rollback();
            System.out.println(e);
            return false;
        }
    }
    public Postulation findByid(int id)
    {
        Session session= FabricSession.getSessionFactory().getCurrentSession();
        Transaction tx=session.beginTransaction();
        try
        {
            Postulation offer= session.get(Postulation.class,id);
            tx.commit();
            return offer;
        }catch (HibernateException e){
            tx.rollback();
            System.out.println(e);
            return null;
        }
    }

}
