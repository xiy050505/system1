package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.User;
import com.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/eHomepageServlet")
public class eHomepageServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        request.setAttribute("username",username);
        request.getRequestDispatcher("/eHomepage.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
