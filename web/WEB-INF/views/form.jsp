<%--
  Created by IntelliJ IDEA.
  User: zhangp
  Date: 2017/7/7
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spring MVC教程--表单处理</title>
</head>
<body>
    <h1>使用 GET 方法读取数据</h1>
    <ul>
        <li><a href="/home">首页</a></li>
    </ul>
    <ul>
        <li>
            <p>
                <b>名称:</b>
                <%=request.getParameter("name")%>
            </p>
        </li>
        <li>
            <p>
                <b>网址:</b>
                <%=request.getParameter("url")%>
            </p>
        </li>
    </ul>
</body>
</html>
