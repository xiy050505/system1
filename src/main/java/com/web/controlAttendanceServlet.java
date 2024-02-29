package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.Attendance;
import com.service.AttendanceService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/controlAttendanceServlet")
public class controlAttendanceServlet extends HttpServlet {
    private AttendanceService service = new AttendanceService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();
        Attendance attendance = JSON.parseObject(params, Attendance.class);
        String date = attendance.getDate();
        String[] split = date.split("-");
        attendance.setYear(split[0]);
        attendance.setMonth(split[1]);
        Attendance attendance1 = service.attendanceSelect(attendance.getUsername(), attendance.getYear(), attendance.getMonth());
        if (attendance1 == null) {
            response.getWriter().write("failure");
        } else {
            if ("late".equals(attendance.getType())) {
                String late = attendance1.getLate();
                int late1 = Integer.parseInt(late) + 1;
                service.updateTypeLate(String.valueOf(late1), attendance.getUsername(), attendance.getYear(), attendance.getMonth());
            } else if ("early".equals(attendance.getType())) {
                String early = attendance1.getEarly();
                int early1 = Integer.parseInt(early) + 1;
                service.updateTypeEarly(String.valueOf(early1), attendance.getUsername(), attendance.getYear(), attendance.getMonth());
            } else if ("absence".equals(attendance.getType())) {
                String absence = attendance1.getAbsence();
                int absence1 = Integer.parseInt(absence) + 1;
                service.updateTypeAbsence(String.valueOf(absence1), attendance.getUsername(), attendance.getYear(), attendance.getMonth());
            } else {
                String afl = attendance1.getAfl();
                int afl1 = Integer.parseInt(afl) + 1;
                service.updateTypeAfl(String.valueOf(afl1), attendance.getUsername(), attendance.getYear(), attendance.getMonth());
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        this.doGet(request, response);
    }
}
