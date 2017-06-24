<%--
  Created by IntelliJ IDEA.
  User: 刘剑银
  Date: 2017/6/8
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <script src="js/action.js" type="text/javascript"></script>
</head>
<body>
<div id="Main">
    <h3>管理员登录</h3>
    <p style="color: red">${message}</p>
    <form action="/doLogin" method="post">
        <p>用户名：<input type="text" name="username" value="刘剑银" style="height: 30px;padding: 3px;"/></p>
        <p>密　码：<input type="password" name="password" value="admin" style="height: 30px;padding: 3px;"/></p>
        <p>
            验证码：<input type="text" name="code" maxlength="4"  style="width: 75px;height: 30px;padding: 3px;"/>
            <img src="/getCode" style="vertical-align: middle" onclick="reser(this)"></p>
        <p>
            <input type="reset" value="重置" class="MyButton"/>
            <input type="submit" value="登录" class="MyButton"/>
        </p>
    </form>
</div>
</body>
</html>
