package ma.fstm.ilisi.recrutement.controller;

import ma.fstm.ilisi.recrutement.model.servise.LoginProc;
import ma.fstm.ilisi.recrutement.model.bo.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ShowPanier extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user= new LoginProc().VerifieAuthed(request,response);
        if (user != null) {
            request.setAttribute("userName",user.getName());
            request.setAttribute("comment",request.getParameter("comment"));
            request.getRequestDispatcher( "/Resources/JSP/ShowPanier.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user= new LoginProc().VerifieAuthed(req,resp);
        if (user != null)
        {
            String[] values=req.getParameterValues("livres[]");
            for (String id : values)
            {

            }
            req.getRequestDispatcher( "/Resources/JSP/ShowPanier.jsp").forward(req,resp);
        }
    }
}
