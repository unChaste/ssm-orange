<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<form action="/user/save" method="post">
    <table border="1">
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="text" name="password"/></td>
        </tr>
        <tr>
            <td>昵称：</td>
            <td><input type="text" name="nickname"/></td>
        </tr>
        <tr>
            <td>性别：</td>
            <td>男<input type="radio" name="gender" value="1"/>&nbsp:&nbsp;女<input type="radio" name="gender" value="2"/>
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
