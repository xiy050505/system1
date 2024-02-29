package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.EInformation;
import com.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/eInformationUpdateServlet")
public class eInformationUpdateServlet extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader br = request.getReader();
        String params = br.readLine();

        EInformation eI = JSON.parseObject(params, EInformation.class);

        EInformation eI1 = service.eSelectByUsername(eI.getUsername());
        if (eI1==null){
            service.addInformation(eI);
        } else {
            service.updateInformation(eI);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
