package ma.fstm.ilisi.recrutement.model.dao;

import ma.fstm.ilisi.recrutement.model.bo.Offer;

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
    public boolean Create(Offer livre){
        return true;
    }

    @Override
    public Collection<Offer> Retrieve() {
        return null;
    }

    @Override
    public void update(Offer user) {

    }

    @Override
    public boolean delete(Offer user) {
        return false;
    }

    public List<Offer> getLivres(){
        return null;
    }
    public Offer findByid(int id)
    {
        return null;
    }
}
