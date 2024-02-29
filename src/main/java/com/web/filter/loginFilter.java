package com.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class loginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;

        String[] urls = {"/index.html", "/elogin.jsp", "/eLoginServlet", "/img/", "/css/","/mlogin.jsp","/mLoginServlet"};
        String requestUrl = req.getRequestURL().toString();
        for (String url : urls) {
            if (requestUrl.contains(url)) {
                chain.doFilter(request, response);
                return;
            }
        }

        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        Object manager = session.getAttribute("manager");

        if (user != null) {
            chain.doFilter(request, response);
        } else if (manager != null) {
            chain.doFilter(request, response);
        } else {
            request.getRequestDispatcher("/index.html").forward(request, response);
        }


    }
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }


}
