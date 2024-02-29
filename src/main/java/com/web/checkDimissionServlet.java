package com.web;

import com.pojo.Dimission;
import com.service.DimissionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/checkDimissionServlet")
public class checkDimissionServlet extends HttpServlet {
    private DimissionService service = new DimissionService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        List<Dimission> dimissions = service.selectAllByUsername(username);
        for (Dimission dimission : dimissions) {
            if ("0".equals(dimission.getStatus())){
                dimission.setStatus("申请中");
            } else if ("1".equals(dimission.getStatus())){
                dimission.setStatus("已通过");
            } else {
                dimission.setStatus("未通过");
            }
        }
        request.setAttribute("dimissions",dimissions);
        request.getRequestDispatcher("/eCheckDimission.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
