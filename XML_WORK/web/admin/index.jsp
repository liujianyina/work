<%@ page import="java.util.List" %>
<%@ page import="com.ljy.xml_work.domain.Student" %>
<%--
  Created by IntelliJ IDEA.
  User: 刘剑银
  Date: 2017/6/10
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理中心</title>
    <link rel="stylesheet" href="/css/app.css"/>
    <script src="/js/ajax.js" type="text/javascript" charset="UTF-8"></script>
</head>
<body onload="setLocation()">

<header>
    <div id="user">
        <p id="user_name">当前用户名：<span
                style="font-weight: bolder;color: cornflowerblue;font-family: '楷体';font-size: 22px">${CURRENT_USER_NAME}</span>
            <a href="/admin/loginOut">
                <button>注销</button>
            </a>
        </p>
    </div>

    <div id="">
        <div>
            <h1>基于XML的学生管理系统</h1>
        </div>
        <div id="search">
            <form method="post" action="/admin/search">
                <input type="text" name="keyword" id="keyword" onkeyup="getMoreContext()"
                       onblur="clearContent()" onfocus="getMoreContext()" autocomplete="off"/>
                <input type="submit" value="搜索" class="index_button"/>
            </form>
        </div>
        <div id="show">
            <ul id="show_ul">
            </ul>
        </div>
    </div>
</header>

<hr/>

<div id="content">
    <table border="1px">
        <tr>
            <th>学生姓名</th>
            <th>性别</th>
            <th>系别</th>
            <th>成绩</th>
            <th>操作</th>
        </tr>

        <%
            List<Student> allStudent = (List<Student>) session.getAttribute("allStudent");
        %>

        <%
            for (Student student : allStudent) {%>

        <tr>
            <td><%=student.getName()%>
            </td>
            <td><%=student.getSex()%>
            </td>
            <td><%=student.getDepartment()%>
            </td>
            <td><%=student.getGrade()%>
            </td>
            <td>
                <a href="/admin/delete?id=<%=student.getId()%>">删除</a>
                <a href="/admin/update?id=<%=student.getId()%>">修改</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <div id="footer">
        <a href="inster.jsp">
            <button>插入</button>
        </a>
    </div>
</div>
</body>
</html>
