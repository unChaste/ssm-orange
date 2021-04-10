<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传与下载</title>
    <style>
        #msg {
            color: red;
        }
    </style>
</head>
<body>
<h2>文件上传</h2>
<p id="msg">${message}</p>
<p>
<form action="/file/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <input type="submit" value="上传"/>
</form>
</p>
<h2>文件下载</h2>
<p>
    <c:forEach var="filename" items="${fileList}">
        <a href="/file/download?filename=${filename}">${filename}</a><br/>
    </c:forEach>
</p>
</body>
</html>