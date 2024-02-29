package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.Attendance;
import com.service.AttendanceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

@WebServlet("/attendance1Servlet")
public class attendance1Servlet extends HttpServlet {
    private AttendanceService service = new AttendanceService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Attendance attendance = (Attendance) session.getAttribute("attendance");
        String year = attendance.getYear();
        String month = attendance.getMonth();

        Calendar calendar = Calendar.getInstance();
        int year1 = calendar.get(Calendar.YEAR);
        int lastYear = year1 - 1;

        String username = request.getParameter("username");
        Attendance attendance1 = service.attendanceSelect(username, year, month);


        request.setAttribute("attendance",attendance1);
        request.setAttribute("year",year);
        request.setAttribute("year1",year1);
        request.setAttribute("month",month);
        request.setAttribute("lastYear",lastYear);
        request.getRequestDispatcher("/attendance1.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
