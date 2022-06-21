<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11219
  Date: 2022/6/19
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师管理</title>
    <style>
        .button {
            font: bold 11px Arial;
            text-decoration: none;
            background-color: #EEEEEE;
            color: #333333;
            padding: 2px 6px 2px 6px;
            border-top: 1px solid #CCCCCC;
            border-right: 1px solid #333333;
            border-bottom: 1px solid #333333;
            border-left: 1px solid #CCCCCC;
        }
        table { text-align: center;

        }
    </style>
</head>
<body>

<table>
    <tr>
        <th>工号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>所属专业</th>
    </tr>
    <c:forEach items="${teachers}" var="teacher">
        <tr>
            <td>${teacher.id}</td>
            <td><a href="TeacherSelect?id=${teacher.id}">${teacher.name}</a></td>
            <td>${teacher.sex?"男":"女"}</td>
            <td>${teacher.major}</td>
            <td><a href="DeleteTeacher?id=${teacher.id}" onclick="return confirm('确认删除？')">删除</a></td>
        </tr>
    </c:forEach>

</table>
</br>
<a href="admin/AddTeacher.html" class="button">添加</a>
<a href="Hello.jsp" class="button">返回</a>

</body>
</html>
