package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.EInformation;
import com.pojo.User;
import com.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addEInformationServlet")
public class addEInformationServlet extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();
        EInformation eInformation = JSON.parseObject(params, EInformation.class);
        EInformation eInformation1 = service.eSelectByUsername(eInformation.getUsername());
        if (eInformation1!=null){
            response.getWriter().write("failure");
        } else {
            service.addInformation(eInformation);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
