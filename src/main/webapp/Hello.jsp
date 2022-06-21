<%--
  Created by IntelliJ IDEA.
  User: 11219
  Date: 2022/6/19
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
<head>
    <title>Hello</title>
</head>
<body>
<h3>欢迎您！${sessionScope.user.username}</h3>
<a href="TeacherListSelect">老师管理</a>
<a href="StudentListSelect">学生管理</a><br/>
<a href="Logout">注销登录</a>
</body>
</html>
