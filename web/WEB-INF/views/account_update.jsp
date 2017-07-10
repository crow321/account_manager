<%@ page import="com.jump.account.base.entity.Account" %>    <%--
      Created by IntelliJ IDEA.
      User: zhangp
      Date: 2017/7/10
      Time: 10:10
      To change this template use File | Settings | File Templates.
    --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account管理系统-用户管理 修改</title>
</head>
<body>
<h1>用户管理 -- 修改</h1>
<div style="color: coral">
    <ul>
        <li>
            <a href="/home">首页</a>
        </li>
        <li>
            <a href="/account">用户管理</a>
        </li>
    </ul>
</div>

<div style="color: black">
    <form action="/account/update">
        <%--名 称: <span><input type="text" name="name"/></span><br>
        网 址: <span><input type="text" name="url"/></span><br>
        描 述: <span><input type="text" name="message"/></span><br>--%>
        账号名称: <span><input type="text" name="name"/></span><br>
        用户名: <span><input type="text" name="userName"/></span><br>
        密 码: <span><input type="text" name="password"/></span><br>
        <input type="submit" value="修改"/>
        <input type="submit" value="取消"/>
    </form>
</div>

</body>
</html>
