package com.ljy.xml_work.filter;

import com.ljy.xml_work.utils.Constant;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 刘剑银 on 2017/6/10.
 */
@WebFilter("/admin/*")
public class ValidFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        HttpSession session = request.getSession();
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (session.getAttribute(Constant.CURRENT_USER_NAME) == null) {  //没有登录

            session.setAttribute("message", "您没有登录");

            response.sendRedirect("/index.jsp");
        } else {

            filterChain.doFilter(request, response);

        }

    }

    @Override
    public void destroy() {

    }
}
