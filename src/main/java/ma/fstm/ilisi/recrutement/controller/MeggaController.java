package ma.fstm.ilisi.recrutement.controller;

import ma.fstm.ilisi.recrutement.model.bo.User;
import ma.fstm.ilisi.recrutement.model.servise.LoginProc;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class MeggaController extends HttpServlet
{
    public static String AppContext="/demo1-1.0-SNAPSHOT";
    public static String LoginT="/login.do";
    public static String LogoutT="/logout.do";
    public static String Offers="/Admin/Offers.do";
    public static String CreateP="/Admin/Offers/Create.do";
    public static String DeleteP="/Admin/Offers/Delete.do";
    public static String UpdateP="/Admin/Offers/Update.do";
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
        if(suf.equals(AppContext+CreateP)){

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
}

