package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.Afl;
import com.service.AflService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/aflUpdateServlet")
public class aflUpdateServlet extends HttpServlet {
    private AflService service = new AflService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String result = request.getParameter("result");

        BufferedReader br = request.getReader();
        String params = br.readLine();
        String[] split = params.split("\"");
        String username = split[29];
        String startTime = split[17];
        if ("yes".equals(result)){
            service.updateByUsername("1",username,startTime);
        } else {
            service.updateByUsername("2",username,startTime);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
