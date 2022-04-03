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
        try {
            Offer offer=user.getOffers().stream().filter(offer1 -> offer1.getId()==id).findFirst().get();
            if(!DAOoffer.getInstance().delete(offer))return false;
            user.getOffers().remove(offer);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean Forward_update(int id,String profile,String description,String contratType,User user){
        if(profile.equals("")||description.equals("")||contratType.equals(""))return false;
        try {
        Offer offer=user.getOffers().stream().filter(offer1 -> offer1.getId()==id).findFirst().get();
        offer.setDescription(description);
        offer.setProfile(profile);
        offer.setType(new ContratType(contratType));
         DAOoffer.getInstance().update(offer);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    public Offer get(int id) {
        return DAOoffer.getInstance().findById(id);
    }
    public Offer getWithPost(int id) {
        return DAOoffer.getInstance().findByIdLoadPost(id);
    }
}
