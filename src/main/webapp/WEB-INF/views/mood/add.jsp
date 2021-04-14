<%--
  Created by IntelliJ IDEA.
  User: hamsin
  Date: 2021/4/13
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发表说说</title>
</head>
<body>
<h2>发表说说</h2>
<form action="/mood/save" method="post">
    <table>
        <tr>
            <td>说说内容：</td>
            <td><input type="text" name="content"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="发表说说"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
