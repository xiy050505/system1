package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.Activity;
import com.service.ActivityService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/activityUpdate1Servlet")
public class activityUpdate1Servlet extends HttpServlet {
    private ActivityService service =  new ActivityService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();
        Activity activity = JSON.parseObject(params, Activity.class);
        String startTime = activity.getStartTime();
        String endTime = activity.getEndTime();
        if (startTime.compareTo(endTime)>=0){
            response.getWriter().write("dateError");
        } else {
            service.updateByName(activity);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
