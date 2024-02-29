package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.Register;
import com.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader br = request.getReader();
        String params = br.readLine();
        Register register = JSON.parseObject(params, Register.class);

        HttpSession session = request.getSession();
        String checkCode = (String) session.getAttribute("checkCode");
        if (service.selectByUsername(register.getUsername()) != null) {
            response.getWriter().write("usernameRepeat");
        } else {
            if (!(checkCode.equalsIgnoreCase(register.getCheckCode()))) {
                response.getWriter().write("checkCodeFailure");
            } else {
                if (!(register.getPassword().equals(register.getRpassword()))) {
                    response.getWriter().write("passwordFailure");
                } else {
                    service.register(register.getUsername(), register.getPassword(),"0");
                    response.getWriter().write("success");
                }
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
