package com.ljy.xml_work.controller;

import com.ljy.xml_work.domain.Student;
import com.ljy.xml_work.utils.XMLUtils;
import net.sf.json.JSONArray;

import javax.rmi.CORBA.Stub;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘剑银 on 2017/6/23.
 */
@WebServlet("/admin/search")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        String keyword = req.getParameter("keyword");

        resp.getWriter().write(JSONArray.fromObject(getInfo(keyword)).toString());
    }

    /**
     * 获取到姓名包含keyword的所有学生的信息
     *
     * @param keyword
     * @return
     */
    private List<String> getInfo(String keyword) {

        List<String> returnList = new ArrayList<>();

        List<Student> allStudent = XMLUtils.getAllStudent();

        for (Student student : allStudent) {
            if (student.getName().contains(keyword)) {
                returnList.add(student.getName());
            }
        }
        return returnList;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");

        List<Student> allStudent = XMLUtils.getAllStudent();

        HttpSession session = req.getSession();

        for (Student student : allStudent) {
            if (keyword.equals((student.getName() + "").trim())) {
                session.setAttribute("student", student);
                break;
            }
        }
        resp.sendRedirect("/admin/update.jsp");
    }
}
