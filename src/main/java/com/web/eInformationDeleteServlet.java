package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.EInformation;
import com.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/eInformationDeleteServlet")
public class eInformationDeleteServlet extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader br = request.getReader();
        String params = br.readLine();
        EInformation eInformation = JSON.parseObject(params, EInformation.class);
        String currentRow = eInformation.getCurrentRow();
        String[] split = currentRow.split("\"");
        String username = split[23];
        service.deleteByUsername(username);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
