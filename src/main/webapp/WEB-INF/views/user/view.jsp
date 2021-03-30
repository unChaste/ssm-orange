<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看用户</title>
</head>
<body>
<input type="hidden" name="id" value="${user.id}"/>
<table border="1">
    <caption>查看用户</caption>
    <tr>
        <td>用户名：</td>
        <td>${user.username}</td>
    </tr>
    <tr>
        <td>密码：</td>
        <td>${user.password}</td>
    </tr>
    <tr>
        <td>昵称：</td>
        <td>${user.nickname}</td>
    </tr>
    <tr>
        <td>性别：</td>
        <td>${user.gender eq 1 ? '男' : (user.gender eq 2 ? '女' : '未知')}</td>
    </tr>
</table>
<a href="/user/list">返回</a>
</form>
</body>
</html>
