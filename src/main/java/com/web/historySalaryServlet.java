package com.web;

import com.pojo.Salary;
import com.service.SalaryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/historySalaryServlet")
public class historySalaryServlet extends HttpServlet {
    private SalaryService service = new SalaryService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        List<Salary> salarys = service.selectAllByUsername(username);
        request.setAttribute("salarys",salarys);
        request.getRequestDispatcher("/historySalary.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
