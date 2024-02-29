package com.web;

import com.pojo.Afl;
import com.service.AflService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/checkAflServlet")
public class checkAflServlet extends HttpServlet {
    private AflService service = new AflService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        List<Afl> afls = service.selectAllByUsername(username);
        for (Afl afl : afls) {
            if ("0".equals(afl.getStatus())){
                afl.setStatus("申请中");
            } else if ("1".equals(afl.getStatus())){
                afl.setStatus("已通过");
            } else {
                afl.setStatus("未通过");
            }
        }
        request.setAttribute("afls",afls);
        request.getRequestDispatcher("/eCheckAfl.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
