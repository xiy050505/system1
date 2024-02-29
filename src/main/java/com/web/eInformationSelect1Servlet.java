package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.EInformation;
import com.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/eInformationSelect1Servlet")
public class eInformationSelect1Servlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader br = request.getReader();
        String params = br.readLine();
        EInformation eInformation = JSON.parseObject(params, EInformation.class);
        String currentRow = eInformation.getCurrentRow();
        String[] split = currentRow.split("\"");
        String username = split[23];
        EInformation einformation = userService.eSelectByUsername(username);

        HttpSession session = request.getSession();
        session.setAttribute("username",username);
        session.setAttribute("eInformation",einformation);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
