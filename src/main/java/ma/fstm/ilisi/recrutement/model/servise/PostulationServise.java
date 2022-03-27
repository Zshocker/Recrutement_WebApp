package ma.fstm.ilisi.recrutement.model.servise;

import ma.fstm.ilisi.recrutement.model.bo.ContratType;
import ma.fstm.ilisi.recrutement.model.bo.Offer;
import ma.fstm.ilisi.recrutement.model.bo.Postulation;
import ma.fstm.ilisi.recrutement.model.bo.User;
import ma.fstm.ilisi.recrutement.model.dao.DAOPostulation;
import ma.fstm.ilisi.recrutement.model.dao.DAOoffer;

import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;
import java.util.Date;

public class PostulationServise
{
    private boolean CreateFile(Part part,String che){
        BufferedOutputStream outputStream;
        BufferedInputStream bufferedInputStream;
        try {
            outputStream = new BufferedOutputStream(new FileOutputStream(che));
            bufferedInputStream = new BufferedInputStream(part.getInputStream());
            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = bufferedInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            outputStream.flush();
            outputStream.close();
            bufferedInputStream.close();
            return true;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean Forward_Create(String nom, String prenom, String email, Part cv,Part lettre,int id){
        if(nom.equals("")||prenom.equals("")||email.equals("")||cv==null || id==0)return false;
        Postulation post=new Postulation();
        post.setNom(nom);
        post.setPrenom(prenom);
        post.setDatepost(new Date());
        post.setOffer(new OffreServise().get(id));
        String cheminCv="C:/Resources/Documents/"+nom+"_"+prenom+"_CV.pdf";
        if(!CreateFile(cv,cheminCv))return false;
        post.setCv(cheminCv);
        String cheminLetter="C:/Resources/Documents/"+nom+"_"+prenom+"_letter.pdf";
        if(!CreateFile(lettre,cheminLetter))return false;
        post.setLettre(cheminLetter);
        return DAOPostulation.getInstance().Create(post);
    }
}
