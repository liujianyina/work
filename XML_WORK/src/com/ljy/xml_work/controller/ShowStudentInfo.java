package com.ljy.xml_work.controller;

import com.ljy.xml_work.domain.Student;
import com.ljy.xml_work.utils.XMLUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by 刘剑银 on 2017/6/10.
 */
@WebServlet("/admin/showStudentInfo")
public class ShowStudentInfo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Student> allStudent = XMLUtils.getAllStudent();

        HttpSession session = req.getSession();
        session.setAttribute("allStudent", allStudent);

        resp.sendRedirect("/admin/index.jsp");

    }

}
