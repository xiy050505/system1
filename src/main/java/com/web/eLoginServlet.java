package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.User;
import com.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/eLoginServlet")
public class eLoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);

        User user1 = userService.eLogin(user);


        if (user1 != null) {
            if ("0".equals(user1.getStatus())) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user1);

                String contextPath = request.getContextPath();
                response.sendRedirect(contextPath + "/eHomepage.jsp");
            } else {
                request.setAttribute("login_Msg", "用户名或密码错误");
                request.getRequestDispatcher("/elogin.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("login_Msg", "用户名或密码错误");
            request.getRequestDispatcher("/elogin.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
