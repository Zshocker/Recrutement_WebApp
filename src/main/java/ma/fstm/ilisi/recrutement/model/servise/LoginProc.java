package ma.fstm.ilisi.recrutement.model.servise;

import ma.fstm.ilisi.recrutement.controller.MeggaController;
import ma.fstm.ilisi.recrutement.model.bo.User;
import ma.fstm.ilisi.recrutement.model.dao.DAOUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginProc
{
    public boolean Authentificate(HttpServletRequest request, String login,String pass)
    {
        String passHashe= User.HashPass(pass,"MD5");
        User user= DAOUser.getDAOUser().Authenticate(login, passHashe);
        if(user!=null){
            HttpSession session=request.getSession(true);
            session.setAttribute("user",user);
            return true;
        }
        return false;
    }
    public void Logout(HttpServletRequest request){
        HttpSession session= request.getSession(false);
        if(session!=null)session.invalidate();
    }
    public User VerifieAuthed(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession se=request.getSession(false);
        if(se!=null)
        {
            User user=(User) se.getAttribute("user");
            if(user!=null)return  user;
        }
        response.sendRedirect(MeggaController.AppContext + MeggaController.LoginT);
        return null;

    }
    public boolean verifieAuth(HttpServletRequest request)
    {
        HttpSession se=request.getSession(false);
        if(se!=null)
        {
            User user=(User) se.getAttribute("user");
            if(user!=null)return true;
        }
        return false;
    }
}
