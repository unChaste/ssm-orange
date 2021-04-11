<%--
  Created by IntelliJ IDEA.
  User: hamsin
  Date: 2021/4/11
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p style="color: red">${message}</p>
<form action="/user/update-password" method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <td>
                <input type="text" name="username" value="${username}"/>
            </td>
        </tr>
        <tr>
            <td>问题：</td>
            <td>
                <input type="text" name="question" value="${question}"/>
            </td>
        </tr>
        <tr>
            <td>答案：</td>
            <td>
                <input type="text" name="answer">
            </td>
        </tr>
        <tr>
            <td>新密码：</td>
            <td>
                <input type="password" name="newPassword"/>
            </td>
        </tr>
        <tr>
            <td>新密码确认：</td>
            <td>
                <input type="password" name="newPasswordTwo"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="修改密码">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
