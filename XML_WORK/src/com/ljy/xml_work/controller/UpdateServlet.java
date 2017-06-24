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
@WebServlet("/admin/update")
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        List<Student> allStudent = XMLUtils.getAllStudent();

        HttpSession session = req.getSession();

        for (Student student : allStudent) {
            if (id.equals((student.getId() + "").trim())) {
                session.setAttribute("student", student);
                break;
            }
        }
        resp.sendRedirect("/admin/update.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String department = req.getParameter("department");
        String grade = req.getParameter("grade");
        Student student = new Student(-1, name, sex, department, Integer.parseInt(grade));
        XMLUtils.update(id, student);
        resp.sendRedirect("/admin/showStudentInfo");
    }
}
