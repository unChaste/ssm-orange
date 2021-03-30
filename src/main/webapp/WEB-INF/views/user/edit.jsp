<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户</title>
</head>
<body>
<form action="/user/update" method="post">
    <input type="hidden" name="id" value="${user.id}"/>
    <table border="1">
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username" value="${user.username}"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="text" name="password" value="${user.password}"/></td>
        </tr>
        <tr>
            <td>昵称：</td>
            <td><input type="text" name="nickname" value="${user.nickname}"/></td>
        </tr>
        <tr>
            <td>性别：</td>
            <td>男<input type="radio" name="gender" ${user.gender eq 1 ? 'checked' : ''} value="1"/>&nbsp:&nbsp;
                女<input type="radio" name="gender" ${user.gender eq 2 ? 'checked' : ''} value="2"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input type="submit" value="提交"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
