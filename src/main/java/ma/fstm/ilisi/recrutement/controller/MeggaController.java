package ma.fstm.ilisi.recrutement.controller;

import ma.fstm.ilisi.recrutement.model.servise.LoginProc;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class MeggaController extends HttpServlet
{
    private static String AppContext="/demo1-1.0-SNAPSHOT";
    private static String LoginT="/login.do";
    private static String LogoutT="/logout.do";
    private static String Offers="/Admin/Offers.do";
    private static String CreateP="/Admin/Offers/Create.do";
    private static String DeleteP="/Admin/Offers/Delete.do";
    private static String UpdateP="/Admin/Offers/Update.do";
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





    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String log=request.getParameter("login");
        String pass=request.getParameter("pass");
        if(new LoginProc().Authentificate(request,log,pass))
        {
            response.sendRedirect(request.getContextPath() +"/");
        }else response.sendRedirect(AppContext+LoginT);
    }
    private void GetLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("Resources/JSP/LoginPage.jsp").forward(request, response);
    }
    private void DoLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        new LoginProc().Logout(request);
        response.sendRedirect(request.getContextPath() + "/login.do");
    }
    private void DoCreateOffre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}

