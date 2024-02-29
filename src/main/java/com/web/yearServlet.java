package com.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Calendar;

@WebServlet("/yearServlet")
public class yearServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int lastYear = year - 1;
        request.setAttribute("username", username);
        request.setAttribute("year", String.valueOf(year));
        request.setAttribute("lastYear",String.valueOf(lastYear));
        request.getRequestDispatcher("/attendance.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
