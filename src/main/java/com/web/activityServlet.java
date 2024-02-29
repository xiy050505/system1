package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.Activity;
import com.service.ActivityService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/activityServlet")
public class activityServlet extends HttpServlet {
    private ActivityService service = new ActivityService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Activity> activities = service.selectAll();
        HttpSession session = request.getSession();
        session.setAttribute("activities",activities);
        for (Activity activity : activities) {
            Integer count = service.selectByName(activity.getName());
            activity.setCount(String.valueOf(count));
        }

        String jsonString = JSON.toJSONString(activities);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
