package com.web;

import com.service.AflService;
import com.service.DimissionService;
import com.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/dimissionUpdateServlet")
public class dimissionUpdateServlet extends HttpServlet {
    private DimissionService service = new DimissionService();
    private UserService service1 = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String result = request.getParameter("result");

        BufferedReader br = request.getReader();
        String params = br.readLine();
        String[] split = params.split("\"");
        String username = split[17];
        if ("yes".equals(result)){
            service1.updateByUsername("1",username);
            service.updateByUsername("1",username);
        } else {
            service.updateByUsername("2",username);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
