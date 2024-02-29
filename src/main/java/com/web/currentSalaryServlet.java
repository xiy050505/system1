package com.web;

import com.pojo.Salary;
import com.service.SalaryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Calendar;

@WebServlet("/currentSalaryServlet")
public class currentSalaryServlet extends HttpServlet {
    private SalaryService service = new SalaryService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        String username = request.getParameter("username");
        Salary salary = service.selectCurrentSalary(username, String.valueOf(month));

        request.setAttribute("salary",salary);
        request.getRequestDispatcher("/currentSalary.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
