<%--
  Created by IntelliJ IDEA.
  User: 11219
  Date: 2022/6/20
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>欢迎${sessionScope.student.name}同学</title>
</head>
<body>
<h3>欢迎您！${sessionScope.student.name}同学</h3>
<a href="IsTopic">查看选题</a>
<a href="admin/StudentSetPassword.html">修改密码</a><br/>
<a href="Logout">注销登录</a>
</body>
</html>
