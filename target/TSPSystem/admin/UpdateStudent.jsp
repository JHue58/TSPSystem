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
    <title>修改信息</title>
</head>
<body>
<form action="UpdateStudent?id=${student.id}" method="post">
    姓名：<input type="text" name="name" value="${student.name}"><br/>
    密码：<input type="text" value="${student.password}" name="password"><br/>
    证件号：<input type="text" name="idcard" value="${student.idcard}"><br/>
    生日： <input type="date" name="birthday" value="${student.birthday}"><br/>
    性别：<input type="radio" name="sex" value="1" ${student.sex?"checked":""}/>男
    <input type="radio" name="sex" value="0" ${student.sex?"":"checked"}/>女<br/>
    <input type="submit" value="修改"/>
</form>
</body>
</html>
