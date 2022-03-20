package ma.fstm.ilisi.recrutement.model.servise;

import ma.fstm.ilisi.recrutement.model.bo.ContratType;
import ma.fstm.ilisi.recrutement.model.bo.Offer;
import ma.fstm.ilisi.recrutement.model.bo.User;
import ma.fstm.ilisi.recrutement.model.dao.DAOoffer;

public class OffreServise
{
    public boolean Forward_Create(String profile, String description, String contratType, User user){
        if(profile.equals("")||description.equals("")||contratType.equals(""))return false;
        Offer offer=new Offer(description,profile,new ContratType(contratType),user);
        if(DAOoffer.getInstance().Create(offer)){
            user.getOffers().add(offer);
            return true;
        }
        return false;
    }
    public boolean Forward_Delete(int id,User user)
    {
        Offer offer=new Offer();
        offer.setId(id);
        if(!DAOoffer.getInstance().delete(offer))return false;
        user.getOffers().remove(offer);
        return true;
    }
    public boolean Forward_update(int id,String profile,String description,String contratType){
        if(profile.equals("")||description.equals("")||contratType.equals(""))return false;
        Offer o = new Offer(id,description,profile,new ContratType(contratType));
         DAOoffer.getInstance().update(o);
        return true;
    }

}
