package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.Attendance;
import com.service.AttendanceService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/attendanceServlet")
public class attendanceServlet extends HttpServlet {
    private AttendanceService service = new AttendanceService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader br = request.getReader();
        String params = br.readLine();

        Attendance attendance = JSON.parseObject(params, Attendance.class);
        HttpSession session = request.getSession();
        session.setAttribute("attendance",attendance);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
