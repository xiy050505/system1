package com.web;

import com.pojo.Activity;
import com.service.ActivityService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/activityUpdateServlet")
public class activityUpdateServlet extends HttpServlet {
    private ActivityService service = new ActivityService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();
        String[] split = params.split("\"");
        String name = split[17];
        Activity activity = service.selectByNameActivity(name);
        HttpSession session = request.getSession();
        session.setAttribute("activity1",activity);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
