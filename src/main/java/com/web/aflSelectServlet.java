package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.Afl;
import com.service.AflService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/aflSelectServlet")
public class aflSelectServlet extends HttpServlet {
    private AflService service = new AflService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Afl> afls = service.selectAll();
        for (Afl afl : afls) {
            if ("0".equals(afl.getStatus())){
                afl.setStatus("申请中");
            } else if ("1".equals(afl.getStatus())) {
                afl.setStatus("已通过");
            } else {
                afl.setStatus("未通过");
            }
        }
        String jsonString = JSON.toJSONString(afls);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
