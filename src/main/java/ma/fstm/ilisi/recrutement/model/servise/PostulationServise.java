package ma.fstm.ilisi.recrutement.model.servise;

import ma.fstm.ilisi.recrutement.model.bo.ContratType;
import ma.fstm.ilisi.recrutement.model.bo.Offer;
import ma.fstm.ilisi.recrutement.model.bo.User;
import ma.fstm.ilisi.recrutement.model.dao.DAOoffer;

import javax.servlet.http.Part;
import java.io.IOException;

public class PostulationServise
{
    private void saveFile(Part cv,String chemin) throws IOException {
      cv.write(chemin);
    }
    public boolean Forward_Create(String nom, String prenom, String email, Part cv,Part lettre,int id){
        if(nom.equals("")||prenom.equals("")||email.equals("")||cv==null || id==0)return false;
        String cheminCv="./Res";
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

}
