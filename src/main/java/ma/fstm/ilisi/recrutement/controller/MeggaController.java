package ma.fstm.ilisi.recrutement.controller;

import ma.fstm.ilisi.recrutement.model.bo.User;
import ma.fstm.ilisi.recrutement.model.servise.LoginProc;
import ma.fstm.ilisi.recrutement.model.servise.OffreServise;

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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String suf=request.getRequestURI();
        if(suf.equals(AppContext))
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
        if(suf.matches(AppContext+DeleteP+"/[0-9]+[.]do")){
            doDeleteOffre(request,response);
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

        }
        super.doPost(request,response);
    }


    private void GetOffersAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        User user= new LoginProc().VerifieAuthed(request,response);
        if (user != null) {
            request.getRequestDispatcher( "/Resources/JSP/AllOffersAdminPage.jsp").forward(request,response);
        }
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
        request.getRequestDispatcher("Resources/JSP/LoginPage.jsp").forward(request, response);
    }
    private void DoLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        new LoginProc().Logout(request);
        response.sendRedirect(AppContext+LoginT);
    }
    private void DoCreateOffre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
         String description = request.getParameter("login");
    }
    private void doDeleteOffre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        new OffreServise().Forward_Delete(get_ID_fromRequestURI(request.getRequestURI()));
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
}

