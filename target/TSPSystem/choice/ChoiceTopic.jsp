<%--
  Created by IntelliJ IDEA.
  User: 11219
  Date: 2022/6/20
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>选择课题</title>
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

        table {
            text-align: center;

        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>课题名称</th>
        <th>课题简介</th>
    </tr>
    <c:forEach items="${topics}" var="topic">
        <tr>
            <td>${topic.name}</td>
            <td>${topic.description}</td>
            <
            <td>${topic.student == -1? "<a href='TopicDisplay?id=".concat(topic.id).concat("'}>查看</a>"):"已被选"}</td>
            >
        </tr>
    </c:forEach>

</table>
</br>
<a href="StudentHello.jsp" class="button">返回</a>
</body>
</html>
