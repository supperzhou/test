<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/10/6
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/show" method="post">
    关键词：<input type="text" name="keyWord" value="${param.keyWord}">
    <input type="hidden" name="pageIndex" value="1">
    <input type="submit" value="提交">
</form>
<table border="1">
    <tr>
        <td>关键词</td>
        <td>搜索指数</td>
        <td>创建时间</td>
    </tr>
    <c:forEach items="${page.list}" var="p">
        <tr>
            <td><a href="javascript:void(0)">${p.keyWord}</a></td>
            <td>${p.searchSum}</td>
            <td>${p.createDate}</td>
        </tr>
    </c:forEach>
</table>
<c:if test="${page.pageIndex!=1}">
    <a href="javascript:topage(1)">首页</a>
    <a href="javascript:topage(${page.pageIndex-1})">上一页</a>
</c:if>
<c:if test="${page.pageIndex!=page.pageCount}">
    <a href="javascript:topage(${page.pageIndex+1})">下一页</a>
    <a href="javascript:topage(${page.pageCount})">尾页</a>
</c:if>
</body>
</html>
<script src="${pageContext.request.contextPath}/statics/jquery-1.12.4.min.js"></script>
<script>
    function topage(pageIndex) {
        $("input[name=pageIndex]").val(pageIndex);
        $("form").submit();
    }
</script>
