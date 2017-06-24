<%@ page import="com.ljy.xml_work.domain.Student" %><%--
  Created by IntelliJ IDEA.
  User: 刘剑银
  Date: 2017/6/10
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
</head>
<body>

<div id="Main">
    <h3>修改学生信息</h3>
    <form action="/admin/update" method="post">
        <%
            Student student = (Student) session.getAttribute("student");
        %>
        <input type="hidden" name="id" value="<%=student.getId()%>"/>
        <p>姓名：<input type="text" name="name" value="<%=student.getName()%>"/></p>
        <p>性别：
            <%
                if (student.getSex().trim().equals("男")) {%>
            <select name="sex" style="width: 170px;height: 25px;">
                <option value="男">男</option>
                <option value="女">女</option>
            </select>
            <%
                }
            %>

            <%
                if (student.getSex().trim().equals("女")) {%>
            <select name="sex" style="width: 170px;height: 25px;">
                <option value="女">女</option>
                <option value="男">男</option>
            </select>
            <%
                }
            %>
        </p>
        <p>
            系别：<input type="text" name="department" value="<%=student.getDepartment()%>"/>
        </p>
        <p>
            成绩：<input type="text" name="grade" value="<%=student.getGrade()%>"/>
        </p>
        <p>
            <input type="submit" value="确认修改" class="MyButton"/>
        </p>

    </form>
</div>
</body>
</html>