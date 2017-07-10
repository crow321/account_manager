<%--
  Created by IntelliJ IDEA.
  User: zhangp
  Date: 2017/7/4
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.Date, java.io.*,javax.servlet.*" %>
<%--引入包>--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spring MVC Hibernate教程--Account管理系统--首页</title>
</head>

<body>
<h1> 首页 </h1>
<%-- 在首页创建连接 --%>
<ul>
    <li><a href="/account/">用户管理</a></li>
</ul>
<%--脚本程序的语法格式：<% java代码片段 %> --%>
<%
    int count = 10;
    String s = "Your IP address is " + request.getRemoteAddr();
%>
<%-- 引用上面定义的变量: <%=变量名%> --%>
<p>count: <%=count%>
</p>
<p><%=s%>
</p>

<h4>获取时间的方法: ${requestScope.name}<h4>
    显示当前时间和日期:<br>
    <%-- 获取model中添加的time ，下面三种方式相同--%>
    ${requestScope.time}<br>
    <%--${requestScope.get("time")}<br>--%>
    <%--${time}--%>
</body>

</html>
