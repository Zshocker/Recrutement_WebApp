package ma.fstm.ilisi.recrutement.model.dao;

import ma.fstm.ilisi.recrutement.model.bo.Offer;
import ma.fstm.ilisi.recrutement.model.dao.hib.FabricSession;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collection;
import java.util.List;

public class DAOoffer implements IDAO<Offer>
{
    private static DAOoffer daooffre=null;
    private DAOoffer(){
    }
    public static DAOoffer getInstance()
    {
        if(daooffre==null)daooffre=new DAOoffer();
        return daooffre;
    }
    public boolean Create(Offer ofr){
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
    public Collection<Offer> Retrieve() {
        Session session= FabricSession.getSessionFactory().getCurrentSession();
        Transaction tx=session.beginTransaction();
        try
        {
            List offers= session.createQuery("from Offer ").list();
            tx.commit();
            return offers;
        }catch (HibernateException e){
            tx.rollback();
            System.out.println(e);
            return null;
        }
    }

    @Override
    public void update(Offer ofr) {
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
    public boolean delete(Offer ofr)
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
    public Offer findByid(int id)
    {
        Session session= FabricSession.getSessionFactory().getCurrentSession();
        Transaction tx=session.beginTransaction();
        try
        {
            Offer offer= session.get(Offer.class,id);
            tx.commit();
            return offer;
        }catch (HibernateException e){
            tx.rollback();
            System.out.println(e);
            return null;
        }
    }
}
