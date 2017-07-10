<%--
  Created by IntelliJ IDEA.
  User: zhangp
  Date: 2017/7/7
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Account 数据保存表单</title>
</head>
<body>
    <form action="account.jsp" method="get">
        站点名: <input type="text" name="name"/>
        <br />
        网  址: <input type="text" name="url"/>
        <input type="submit" name="提交"/>
    </form>

    <h4>获取时间的方法: ${requestScope.name}</h4>
        显示当前时间和日期:<br>
        <%-- 获取model中添加的time ，下面三种方式相同--%>
        ${requestScope.time}<br>
</body>
</html>
