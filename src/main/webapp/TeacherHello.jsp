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
    <title>欢迎${sessionScope.teacher.name}老师</title>
</head>
<body>
<h3>欢迎您！${sessionScope.teacher.name}老师</h3>
<a href="TopicListSelect">课题管理</a>
<a href="admin/TeacherSetPassword.html">修改密码</a><br/>
<a href="Logout">注销登录</a>
</body>
</html>
