package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.EInformation;
import com.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/checkEInformationServlet")
public class checkEInformationServlet extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EInformation> eInformations = service.selectAll();

        String jsonString = JSON.toJSONString(eInformations);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
