<%--
  Created by IntelliJ IDEA.
  User: 26018
  Date: 2024/2/25
  Time: 0:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="css/login.css" rel="stylesheet">
</head>

<body>
<div id="loginDiv" style="height: 350px">
    <form action="/system/eLoginServlet" method="post" id="form">
        <h1 id="loginMsg">登录</h1>
        <div id="errorMsg">${login_Msg}</div>
        <p>用户名:<input id="username" name="username" placeholder="请输入您的用户名" ></p>
        <p>密码:<input id="password" name="password" placeholder="请输入您的密码" ></p>
        <div id="subDiv">
            <input type="submit" class="button" value="登录">
        </div>
    </form>
</div>

</body>
</html>


</html>
