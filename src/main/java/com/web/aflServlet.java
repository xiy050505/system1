package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.Afl;
import com.service.AflService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/aflServlet")
public class aflServlet extends HttpServlet {
    private AflService service = new AflService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader br = request.getReader();
        String params = br.readLine();
        Afl afl = JSON.parseObject(params, Afl.class);

        String date = afl.getDate();
        String[] split = date.split("\"|T");

        afl.setStartTime(split[1]);
        afl.setEndTime(split[4]);

        service.addAfl(afl);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
