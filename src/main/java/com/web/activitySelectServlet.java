package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.Activity;
import com.service.ActivityService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/activitySelectServlet")
public class activitySelectServlet extends HttpServlet {
    private ActivityService service = new ActivityService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();
        Activity activity = JSON.parseObject(params, Activity.class);
        activity.setName("%"+activity.getName()+"%");
        activity.setStartTime("%"+activity.getStartTime()+"%");
        activity.setEndTime("%"+activity.getEndTime()+"%");
        activity.setContent("%"+activity.getContent()+"%");

        List<Activity> activities = service.select(activity);
        String jsonString = JSON.toJSONString(activities);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
