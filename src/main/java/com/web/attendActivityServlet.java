package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.Activity;
import com.service.ActivityService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/attendActivityServlet")
public class attendActivityServlet extends HttpServlet {
    private ActivityService service = new ActivityService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();
        Activity activity = JSON.parseObject(params, Activity.class);
        String currentRow = activity.getCurrentRow();
        String[] split = currentRow.split("\"");
        String endTime = split[15];
        String name = split[7];
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String today = format.format(date);
        Activity activity1 = service.selectByNameAndUsername(activity.getUsername(), name);
        if (activity1 == null) {
            if (today.compareTo(endTime)<0){
                service.addAttendMenu(activity.getUsername(), name);
                response.getWriter().write("success");
            }
            else {
                response.getWriter().write("timeOut");
            }
        } else {
            response.getWriter().write("failure");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
