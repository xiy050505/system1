package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.Afl;
import com.pojo.Dimission;
import com.service.AflService;
import com.service.DimissionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/dimissionSelectServlet")
public class dimissionSelectServlet extends HttpServlet {
    private DimissionService service = new DimissionService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Dimission> dimissions = service.selectAll();
        for (Dimission dimission : dimissions) {
            if ("0".equals(dimission.getStatus())){
                dimission.setStatus("申请中");
            } else if ("1".equals(dimission.getStatus())) {
                dimission.setStatus("已通过");
            } else {
                dimission.setStatus("未通过");
            }
        }
        String jsonString = JSON.toJSONString(dimissions);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
