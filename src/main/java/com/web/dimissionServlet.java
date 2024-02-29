package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.Afl;
import com.pojo.Dimission;
import com.service.AflService;
import com.service.DimissionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/dimissionServlet")
public class dimissionServlet extends HttpServlet {
    private DimissionService service = new DimissionService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();
        Dimission dimission = JSON.parseObject(params, Dimission.class);

        service.addADimission(dimission);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
