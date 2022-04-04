package ma.fstm.ilisi.recrutement.model.servise;

import ma.fstm.ilisi.recrutement.controller.MeggaController;
import ma.fstm.ilisi.recrutement.model.bo.ContratType;
import ma.fstm.ilisi.recrutement.model.bo.Offer;
import ma.fstm.ilisi.recrutement.model.bo.Postulation;
import ma.fstm.ilisi.recrutement.model.bo.User;
import ma.fstm.ilisi.recrutement.model.dao.DAOPostulation;
import ma.fstm.ilisi.recrutement.model.dao.DAOoffer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;
import java.util.Date;

public class PostulationServise
{
    public static final String filesPath="C:/Resources/Documents/";
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
        String nameCV=nom+"_"+prenom+"_CV.pdf";
        String cheminCv=filesPath+nameCV;
        if(!CreateFile(cv,cheminCv))return false;
        post.setCv(nameCV);
        String nameLetter=nom+"_"+prenom+"_letter.pdf";
        String cheminLetter=filesPath+nameLetter;
        if(!CreateFile(lettre,cheminLetter))return false;
        post.setLettre(nameLetter);
        return DAOPostulation.getInstance().Create(post);
    }
    public Postulation detailoffers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession se = request.getSession(false);

        if(se!=null)
        {
            Postulation postulation=(Postulation) se.getAttribute("postulations");
            if(postulation!=null) return  postulation;
        }
        response.sendRedirect(MeggaController.AppContext + MeggaController.Offers);
        return null;
    }

    public void DownloadFile(HttpServletResponse response,String fileName) throws IOException {
        File file = new File(filesPath+fileName);
        OutputStream outStream = null;
        FileInputStream inputStream = null;
        if (file.exists()) {
            response.setContentType("application/octet-stream");
            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"", file.getName());
            response.setHeader(headerKey, headerValue);
            try {
                outStream = response.getOutputStream();
                inputStream = new FileInputStream(file);
                byte[] buffer = new byte[1024];
                int bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outStream.write(buffer, 0, bytesRead);
                }
                outStream.flush();
            } catch(IOException ioExObj) {
                System.out.println("Exception While Performing The I/O Operation?= " + ioExObj.getMessage());
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outStream != null) {
                    outStream.close();
                }
            }
        } else {
            response.setContentType("text/html");
            response.getWriter().println("<h3>File "+ fileName +" Is Not Present .....!</h3>");
        }
    }


}
