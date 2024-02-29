package com.web;

import com.pojo.EInformation;
import com.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/eInformationSelectServlet")
public class eInformationSelectServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        EInformation einformation = userService.eSelectByUsername(username);

        request.setAttribute("username",username);
        request.setAttribute("eInformation",einformation);

        request.getRequestDispatcher("/eInformation.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
