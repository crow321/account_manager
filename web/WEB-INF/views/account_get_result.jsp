<%@ page import="com.jump.account.base.vo.Page" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jump.account.base.entity.Account" %>    <%--
      Created by IntelliJ IDEA.
      User: zhangp
      Date: 2017/7/10
      Time: 10:10
      To change this template use File | Settings | File Templates.
    --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Account管理系统-用户管理 查询结果</title>
</head>
<body>
<h1>用户管理 -- 查询 -- 结果</h1>
<div style="color: coral">
    <ul>
        <li>
            <a href="/home">首页</a>
        </li>
        <li>
            <a href="/account">用户管理</a>

        </li>
        <li>
            <a href="/account/get">返回上级</a>
        </li>
    </ul>
</div>
<c:if test="${isGetEmpty}">
    <p>没有查询匹配信息</p>
    <span>请重新输入查询信息</span>
</c:if>
<div style="color: black"></div>
<table border="1">
    <c:forEach var="acc" items="${accountList}">
        <tr>
            <th>账号名称</th>
            <td>${acc.name}</td>
        </tr>
        <tr>
            <th>账号ID</th>
            <td>${acc.id}</td>
        </tr>
        <tr>
            <th>描述</th>
            <td>${acc.message}</td>
        </tr>
        <tr>
            <th>URL地址</th>
            <td>${acc.url}</td>
        </tr>
        <tr>
            <th>登录名称</th>
            <td>${acc.userName}</td>
        </tr>

        <tr>
            <th>用户密码</th>
            <td>${acc.password}</td>
        </tr>
        <tr>
            <th>保存时间</th>
            <td>${acc.time}</td>
        </tr>
        <tr>
            <th>**********</th>
            <th>**********</th>
        </tr>
    </c:forEach>
</table>
</div>

</body>
</html>
