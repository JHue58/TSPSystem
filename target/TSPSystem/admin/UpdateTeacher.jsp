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
<form action="UpdateTeacher?id=${teacher.id}" method="post">
    姓名：<input type="text" name="name" value="${teacher.name}"><br/>
    密码：<input type="text" value="${teacher.password}" name="password"><br/>
    证件号：<input type="text" name="idcard" value="${teacher.idcard}"><br/>
    所属专业: <input type="text" name="major" value="${teacher.major}"><br/>
    生日： <input type="date" name="birthday" value="${teacher.birthday}"><br/>
    性别：<input type="radio" name="sex" value="1" ${teacher.sex?"checked":""}/>男
    <input type="radio" name="sex" value="0" ${teacher.sex?"":"checked"}/>女<br/>
    学历：<select name="edu">
    <option value="0">---请选择---</option>>
    <option value="1" ${teacher.edu eq "1"?"selected":""}>本科</option>
    <option value="2" ${teacher.edu eq "2"?"selected":""}>研究生</option>
    <option value="3" ${teacher.edu eq "3"?"selected":""}>博士</option>
</select><br/>
    <input type="submit" value="修改"/>
</form>
</body>
</html>
