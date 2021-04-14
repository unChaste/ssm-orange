<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>
        #message {
            color: red;
        }
    </style>
</head>
<body>
<p id="message">
    ${message}
</p>
<form action="/user/login" method="post">
    <table>
        <caption>用户登陆</caption>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="text" name="password"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <a href="/user/edit-password">忘记密码</a>&nbsp;
                <a href="/user/register-form">立即注册</a>
            </td>
        </tr>
        <tr>
            <td colspan="2" style="alignment: center">
                <input type="submit" value="登陆"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
