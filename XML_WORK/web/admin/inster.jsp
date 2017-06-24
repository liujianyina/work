<%--
  Created by IntelliJ IDEA.
  User: 刘剑银
  Date: 2017/6/10
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>插入</title>
    <link rel="stylesheet" type="text/css" href="../css/common.css"/>
</head>
<body>
<div id="Main">
    <h3>插入新学生</h3>
    <form action="/admin/insert" method="post">
        <p>姓名：<input type="text" name="name"/></p>
        <p>性别：
            <select name="sex" style="width: 170px;height: 25px;">
                <option value="男">男</option>
                <option value="女">女</option>
            </select>
        </p>
        <p>
            系别：<input type="text" name="department"/>
        </p>
        <p>
            成绩：<input type="text" name="grade"/>
        </p>
        <p>
            <input type="reset" value="重置" class="MyButton"/>
            <input type="submit" value="提交" class="MyButton"/>
        </p>
    </form>
</div>
</body>
</html>
