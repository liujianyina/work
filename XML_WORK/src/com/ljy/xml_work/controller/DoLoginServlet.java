package com.ljy.xml_work.controller;

import com.ljy.xml_work.utils.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 刘剑银 on 2017/6/10.
 */
@WebServlet("/doLogin")
public class DoLoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        String code = req.getParameter("code");

        HttpSession session = req.getSession();

        String rcode = (String) session.getAttribute("code");

        if (!code.equals(rcode)) {
            session.setAttribute("message", "验证码错误");

            resp.sendRedirect("index.jsp");

        } else if (username.equals("刘剑银") && password.equals("admin")) { //验证通过

            session.setAttribute(Constant.CURRENT_USER_NAME, username);

            resp.sendRedirect("/admin/showStudentInfo");
        } else {

            session.setAttribute("message", "用户名或密码错误");

            resp.sendRedirect("index.jsp");
        }

    }
}
