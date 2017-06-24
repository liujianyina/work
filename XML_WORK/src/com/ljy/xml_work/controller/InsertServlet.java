package com.ljy.xml_work.controller;

import com.ljy.xml_work.domain.Student;
import com.ljy.xml_work.utils.XMLUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 刘剑银 on 2017/6/10.
 */
@WebServlet("/admin/insert")
public class InsertServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");

        String sex = req.getParameter("sex");

        String department = req.getParameter("department");

        String grade = req.getParameter("grade");

        Student student = new Student((XMLUtils.getAllStudent().size() + 1),
                name, sex, department, Integer.parseInt(grade));

        XMLUtils.addStudent(student);

        resp.sendRedirect("/admin/showStudentInfo");

    }
}
