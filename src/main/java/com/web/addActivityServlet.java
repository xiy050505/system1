package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.Activity;
import com.service.ActivityService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addActivityServlet")
public class addActivityServlet extends HttpServlet {
    private ActivityService service = new ActivityService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();
        Activity activity = JSON.parseObject(params, Activity.class);
        Activity activity1 = service.selectByNameActivity(activity.getName());
        if (activity.getStartTime().compareTo(activity.getEndTime())>=0){
            response.getWriter().write("dateError");
        } else {
            if (activity1!=null){
                response.getWriter().write("failure");
            } else {
                service.addAll(activity);
            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
