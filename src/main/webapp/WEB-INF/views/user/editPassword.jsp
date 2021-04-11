<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
</head>
<body>
<p style="color: red">
    ${message}
</p>
<form action="/user/edit-password-two" method="get">
    <table>
        <tr>
            <td>用户名：</td>
            <td>
                <input type="text" name="username"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="确定"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
