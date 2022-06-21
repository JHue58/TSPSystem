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
<form action="UpdateTopic?id=${topic.id}" method="post">
    课题名称：<input type="text" name="name" value="${topic.name}"><br/>
    课题性质：<br/>
    <input type="radio" name="properties" value="A" ${topic.properties eq "A"?"checked":""}>产品性质<br/>
    <input type="radio" name="properties" value="B" ${topic.properties eq "B"?"checked":""}>工程技术研究<br/>
    <input type="radio" name="properties" value="C" ${topic.properties eq "C"?"checked":""}>软件开发<br/>
    <input type="radio" name="properties" value="D" ${topic.properties eq "D"?"checked":""}>研究论文或调研报告<br/>
    <input type="radio" name="properties" value="E" ${topic.properties eq "E"?"checked":""}>其他<br/>
    课题来源：<br/>
    <input type="radio" name="source" value="A" ${topic.source eq "A"?"checked":""}>自然（社会）科学基金与省（部）、市级以上科研课题<br/>
    <input type="radio" name="source" value="B" ${topic.source eq "B"?"checked":""}>企、事业单位委托课题<br/>
    <input type="radio" name="source" value="C" ${topic.source eq "C"?"checked":""}>院、系级基金课题<br/>
    <input type="radio" name="source" value="D" ${topic.source eq "D"?"checked":""}>自拟课题<br/>
    预计工作量：<select name="workload">
    <option value="0" ${topic.workload eq "0"?"selected":""}>---请选择---</option>>
    <option value="1" ${topic.workload eq "1"?"selected":""}>小</option>
    <option value="2" ${topic.workload eq "2"?"selected":""}>适中</option>
    <option value="3" ${topic.workload eq "3"?"selected":""}>大</option>
</select><br/>
    难易度：<select name="level">
    <option value="0" ${topic.level eq "0"?"selected":""}>---请选择---</option>>
    <option value="1" ${topic.level eq "1"?"selected":""}>小</option>
    <option value="2" ${topic.level eq "2"?"selected":""}>适中</option>
    <option value="3" ${topic.level eq "3"?"selected":""}>大</option>
</select><br/>
    课题简介：<textarea name="description">${topic.description}</textarea><br/>
    课题任务和对学生的要求：<textarea name="mission">${topic.mission}</textarea><br/>
    <input type="submit" value="修改"/>
</form>
</body>
</html>
