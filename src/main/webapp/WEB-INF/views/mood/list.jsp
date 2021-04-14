<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: hamsin
  Date: 2021/4/13
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>说说列表</title>
</head>
<body>
<h2>说说列表</h2>
<p><a href="/mood/add">发表说说</a></p>
<c:forEach var="mood" items="${moodList}">
    <p>
        用户：${mood.userNickname}<br/>
        内容：${mood.content}<br/>
        发表时间：<fmt:formatDate value="${mood.createTime}" pattern="yyyy-MM-dd hh:mm:ss"/><br/>
        点赞数:${mood.praiseNum}<br/>
        <c:if test="${mood.hasPraised}">
            <a href="/mood/unpraise?moodId=${mood.moodId}">取消点赞</a>
        </c:if>
        <c:if test="${not mood.hasPraised}">
            <a href="/mood/praise?moodId=${mood.moodId}">点赞</a>
        </c:if>
    </p>
</c:forEach>
</body>
</html>
