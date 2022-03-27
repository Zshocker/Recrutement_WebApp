package ma.fstm.ilisi.recrutement.controller;

import ma.fstm.ilisi.recrutement.model.bo.User;
import ma.fstm.ilisi.recrutement.model.dao.DAOoffer;
import ma.fstm.ilisi.recrutement.model.servise.LoginProc;
import ma.fstm.ilisi.recrutement.model.servise.OffreServise;
import ma.fstm.ilisi.recrutement.model.servise.PostulationServise;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MeggaController extends HttpServlet
{
    public static String AppContext="/demo1-1.0-SNAPSHOT";
    public static String LoginT="/login.do";
    public static String LogoutT="/logout.do";
    public static String Offers="/Admin/Offers.do";
    public static String CreateP="/Admin/Offers/Create.do";
    public static String DeleteP="/Admin/Offers/Delete";
    public static String UpdateP="/Admin/Offers/Update";
    public static String OffersU="/Offers.do";
    public static String Inscrip="/Inscription.do";
    public static String Postulate="/Offers/Postulate";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String suf=request.getRequestURI();
        if(suf.equals(AppContext+"/"))
        {
            response.sendRedirect(AppContext+LoginT);
            return;
        }
        if(suf.equals(AppContext+LoginT))
        {
            GetLogin(request,response);
            return;
        }
        if(suf.equals(AppContext+LogoutT))
        {
            DoLogout(request,response);
            return;
        }
        if(suf.equals(AppContext+Offers)){
            GetOffersAdmin(request,response);
            return;
        }
        if(suf.equals(AppContext+CreateP)){
            GetCreateP(request, response);
            return;
        }
        if(suf.matches(AppContext+DeleteP+"/[0-9]+[.]do"))
        {
            doDeleteOffre(request,response);
            return;
        }
        if(suf.matches(AppContext+UpdateP+"/[0-9]+[.]do"))
        {
            getUpdate(request,response);
            return;
        }
        if(suf.equals(AppContext+OffersU)){
            if(new LoginProc().verifieAuth(request))GetOffersAdmin(request, response);
            else GetOffers(request,response);
        }
        if (suf.equals(AppContext+Inscrip)){
            GetInscription(request,response);
            return;
        }
        if(suf.matches(AppContext+Postulate+"/[0-9]+[.]do"))
        {
            getPostulatePage(request,response);
            return;
        }
        response.setStatus(404);
        response.getWriter().println("<h1>404: NOT FOUND</h1>");
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String suf=request.getRequestURI();
        if(suf.equals(AppContext+LoginT))
        {
            doLogin(request,response);
            return;
        }
        if(suf.equals(AppContext+LogoutT))
        {
            DoLogout(request,response);
            return;
        }
        if(suf.equals(AppContext+CreateP))
        {
            DoCreateOffre(request,response);
            return;
        }
        if(suf.matches(AppContext+UpdateP+"/[0-9]+[.]do")){
            DoUpdate(request, response);
            return;
        }
        if(suf.equals(AppContext+Inscrip))
        {
            DoInscription(request,response);
            return;
        }
        if(suf.matches(AppContext+Postulate+"/[0-9]+[.]do"))
        {
            doPostulate(request,response);
            return;
        }
        super.doPost(request,response);
    }

    private void doPostulate(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException
    {
        int id=get_ID_fromRequestURI(request.getRequestURI());
        String nom=request.getParameter("nom");
        String prenom=request.getParameter("prenom");
        String email=request.getParameter("email");
        Part cv=request.getPart("cv");
        Part letter=request.getPart("letter");
        if(new PostulationServise().Forward_Create(nom,prenom,email,cv,letter,id))
        {
            response.sendRedirect(AppContext+Offers);
        }else response.sendRedirect(AppContext+Postulate+"/"+id+".do");
    }

    private void getPostulatePage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        getServletContext().getRequestDispatcher( "/Resources/JSP/PostulatePage.jsp").forward(request, response);
    }

    private void GetOffersAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if (!new LoginProc().verifieAuth(request)) {
            response.sendRedirect(AppContext+LoginT);
            return;
        }
        LoginProc service=new LoginProc();
        request.setAttribute("offers",service.VerifieAuthed(request,response).getOffers());
        getServletContext().getRequestDispatcher( "/Resources/JSP/AllOffersAdminPage.jsp").forward(request,response);
    }
    private void GetOffers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setAttribute("offers", DAOoffer.getInstance().Retrieve());
        getServletContext().getRequestDispatcher( "/Resources/JSP/AllOffersPage.jsp").forward(request,response);
    }
    private void GetInscription(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        getServletContext().getRequestDispatcher( "/Resources/JSP/InscriptionPage.jsp").forward(request,response);
    }


    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String log=request.getParameter("login");
        String pass=request.getParameter("pass");
        if(new LoginProc().Authentificate(request,log,pass))
        {
            response.sendRedirect(AppContext+Offers);
        }else response.sendRedirect(AppContext+LoginT);
    }
    private void GetLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        getServletContext().getRequestDispatcher("/Resources/JSP/LoginPage.jsp").forward(request, response);
    }
    private void DoLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        new LoginProc().Logout(request);
        response.sendRedirect(AppContext+LoginT);
    }
    private void GetCreateP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if(!new LoginProc().verifieAuth(request)){ response.sendRedirect(AppContext+LoginT);
        return;
        }

        getServletContext().getRequestDispatcher( "/Resources/JSP/creation.jsp").forward(request, response);
    }


    private void DoCreateOffre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        User user= new LoginProc().VerifieAuthed(request,response);
        if (user==null) {
            response.sendRedirect(AppContext+LoginT);
            return;
        }
         String description = request.getParameter("description");
         String profile = request.getParameter("profile");
         String type = request.getParameter("type");
         if(new OffreServise().Forward_Create(profile,description,type,user)){
             response.sendRedirect(AppContext+Offers);
         }else  response.sendRedirect(AppContext+CreateP);

    }
    private void DoInscription(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        String email = request.getParameter("email");
        if(new LoginProc().Inscription(request,login,pass,email,name)){
            response.sendRedirect(AppContext+OffersU);
        }else response.sendRedirect(AppContext+Inscrip);

    }
    private void doDeleteOffre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        User user= new LoginProc().VerifieAuthed(request,response);
        if (user==null) {
            response.sendRedirect(AppContext+LoginT);
            return;
        }
        new OffreServise().Forward_Delete(get_ID_fromRequestURI(request.getRequestURI()),user);
        response.sendRedirect(AppContext+Offers);
    }
    private void DoUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        User user= new LoginProc().VerifieAuthed(request,response);
        if (user==null) {
            response.sendRedirect(AppContext+LoginT);
            return;
        }
        String description = request.getParameter("description");
        String profile = request.getParameter("profile");
        String type = request.getParameter("type");
       if( new OffreServise().Forward_update( get_ID_fromRequestURI(request.getRequestURI()),profile,description,type,user)){
           response.sendRedirect(AppContext+Offers);
       }
       response.sendRedirect(AppContext+LoginT);
    }
    private int get_ID_fromRequestURI(String string){
        Matcher matcher = Pattern.compile("[0-9]+").matcher(string);
        int id = 0;
        while(matcher.find())
        {
            id=Integer.parseInt(matcher.group());
        }
        return id;
    }
    private void getUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        if (new LoginProc().verifieAuth(request)) {
            request.setAttribute( "id", get_ID_fromRequestURI(request.getRequestURI()));
            getServletContext().getRequestDispatcher("/Resources/JSP/updatePAge.jsp").forward(request,response);
            return;
        }
        response.sendRedirect(AppContext+LoginT);
    }
}

