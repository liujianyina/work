package com.ljy.xml_work.controller;

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
@WebServlet("/admin/delete")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        XMLUtils.deleteStudent(id);
        resp.sendRedirect("/admin/showStudentInfo");
    }
}
