<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<form action="/user/list" method="get">
    昵称：<input type="text" name="nickname"/><input type="submit" value="提交"/>
    <a href="/user/add">添加</a>
</form>
<table border="1">
    <caption>用户列表</caption>
    <tr>
        <th>编号</th>
        <th>昵称</th>
        <th>用户名</th>
        <th>性别</th>
        <th>操作</th>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.nickname}</td>
            <td>${user.username}</td>
            <td>
                <c:choose>
                    <c:when test="${user.gender eq 1}">男</c:when>
                    <c:when test="${user.gender eq 2}">女</c:when>
                    <c:otherwise>未知</c:otherwise>
                </c:choose>
            </td>
            <td>
                <a href="/user/view?id=${user.id}">查看</a>&nbsp;
                <a href="/user/edit?id=${user.id}">修改</a>&nbsp;
                <a href="/user/delete?id=${user.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
