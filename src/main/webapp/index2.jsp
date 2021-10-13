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
    <input type="text" name="keyWord">
    <input type="hidden" name="pageIndex" value="1">
    <input type="button" id="btn" value="查询">

<table border="1">
    <thead>
        <td>关键词</td>
        <td>搜索指数</td>
        <td>创建时间</td>
    </thead>

    <tbody id="tbody">

    </tbody>
</table>
<div id="div"></div>
</body>
</html>
<script src="${pageContext.request.contextPath}/statics/jquery-1.12.4.min.js"></script>
<script>
   
    $(function () {
        show(1);
        $("#btn").click(function () {
            show(1)
        })
    })
    function show(pageIndex) {
        var keyword=$("input[name=keyWord]").val();
        $.ajax({
            url:"${pageContext.request.contextPath}/getshow",
            dataType:"json",
            type:"post",
            data:{"pageIndex":pageIndex,"keyWord":keyword},
            success:function (result) {
                var list=result.list;
                var str="";
                for (var i=0;i<list.length;i++){
                    str+="<tr><td><a href='${pageContext.request.contextPath}/getbyid?id="+list[i].id+"'>"+list[i].keyWord+"</a>" +
                        "</td><td>"+list[i].searchSum+"</td><td>"+list[i].createDate+"</td></tr>"
                }
                $("#tbody").html(str);
               var div="";
                if(result.pageIndex>1){
                    div+="<a href='javascript:show(1)'>首页</a>";
                    div+="<a href='javascript:show("+(result.pageIndex-1)+")'>上一页</a>";
                }
                if (result.pageIndex<result.pageCount){
                    div+="<a href='javascript:show("+(result.pageIndex+1)+")'>下一页</a>";
                    div+="<a href='javascript:show("+(result.pageCount)+")'>末页</a>";
                }
                div+="第"+result.pageIndex+"页"+"     共"+result.pageCount+"页"
                $("#div").html(div);
            }

        })
    } 


</script>
