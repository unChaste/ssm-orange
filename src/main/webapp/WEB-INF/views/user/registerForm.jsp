<%--
  Created by IntelliJ IDEA.
  User: hamsin
  Date: 2021/4/11
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
<p style="color: red">${message}</p>
<form action="/user/register" method="post">
    <table>
        <caption>用户注册</caption>
        <tr>
            <td>用户名：</td>
            <td>
                <input type="text" name="username"/>
            </td>
        </tr>
        <tr>
            <td>昵称：</td>
            <td>
                <input type="text" name="nickname"/>
            </td>
        </tr>
        <tr>
            <td>性别：</td>
            <td>
                男<input type="radio" name="gender" value="1"/>&nbsp;女<input type="radio" name="gender" value="2"/>
            </td>
        </tr>
        <tr>
            <td>问题：</td>
            <td>
                <input type="text" name="question"/>
            </td>
        </tr>
        <tr>
            <td>答案：</td>
            <td>
                <input type="text" name="answer"/>
            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>
                <input type="password" name="password"/>
            </td>
        </tr>
        <tr>
            <td>密码确认：</td>
            <td>
                <input type="password" name="passwordTwo"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="注册"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
