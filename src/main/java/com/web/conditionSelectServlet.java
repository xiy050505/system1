package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.EInformation;
import com.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/conditionSelectServlet")
public class conditionSelectServlet extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();
        EInformation eInformation = JSON.parseObject(params, EInformation.class);
        String username = eInformation.getUsername();
        eInformation.setUsername("%"+username+"%");

        String name = eInformation.getName();
        eInformation.setName("%"+name+"%");

        String cellphoneNumber = eInformation.getCellphoneNumber();
        eInformation.setCellphoneNumber("%"+cellphoneNumber+"%");

        String email = eInformation.getEmail();
        eInformation.setEmail("%"+email+"%");

        String address = eInformation.getAddress();
        eInformation.setAddress("%"+address+"%");

        String description = eInformation.getDescription();
        eInformation.setDescription("%"+description+"%");



        List<EInformation> eInformations = service.select(eInformation);
        String jsonString = JSON.toJSONString(eInformations);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
