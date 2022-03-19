package ma.fstm.ilisi.recrutement.controller;

import ma.fstm.ilisi.recrutement.model.servise.LoginProc;
import ma.fstm.ilisi.recrutement.model.bo.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ShoppingServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user= new LoginProc().VerifieAuthed(request,response);
        if (user != null) {
            request.setAttribute("userName",user.getName());
            request.getRequestDispatcher( "/Resources/JSP/ShoppingPage.jsp").forward(request,response);
        }

    }


}
