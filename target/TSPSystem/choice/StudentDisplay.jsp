<%--
  Created by IntelliJ IDEA.
  User: 11219
  Date: 2022/6/20
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>${student.name}信息</title>
</head>
<body>

    姓名：<input type="text" disabled name="name" value="${student.name}"><br/>
    学号：<input type="text" disabled name="name" value="${student.id}"><br/>
    证件号：<input type="text" disabled name="idcard" value="${student.idcard}"><br/>
    生日： <input type="date" disabled name="birthday" value="${student.birthday}"><br/>
    性别：<input type="radio" disabled name="sex" value="1" ${student.sex?"checked":""}/>男
    <input type="radio" disabled name="sex" value="0" ${student.sex?"":"checked"}/>女<br/>

</body>
</html>
