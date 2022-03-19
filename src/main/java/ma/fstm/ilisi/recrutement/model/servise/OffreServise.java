package ma.fstm.ilisi.recrutement.model.servise;

import ma.fstm.ilisi.recrutement.model.bo.ContratType;
import ma.fstm.ilisi.recrutement.model.bo.Offer;
import ma.fstm.ilisi.recrutement.model.dao.DAOoffer;

public class OffreServise
{
    public boolean Forward_Create(String profile,String description,String contratType){
        if(profile.equals("")||description.equals("")||contratType.equals(""))return false;
        Offer offer=new Offer(description,profile,new ContratType(contratType));
        DAOoffer.getInstance().Create(offer);
        return true;
    }
}
