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
    <title>Account管理系统-用户管理</title>
</head>
<body>
<h1>用户管理</h1>
<%-- <div class="container negative">
     <div class="row">
         <div class="col nav0">
             <ul class="pagination-control">
                 <li>
                     <a href="http://localhost:8080/">首页</a>
                 </li>
                 <li>
                     <a href="http://localhost:8080/form">表单</a>
                 </li>
             </ul>
         </div>
     </div>
 </div>--%>
<ul>
    <li><a href="http://localhost:8080">首页</a></li>
    <div style="color:#0000F1">
        <li><a href="/account/add">增加用户</a></li>
        <li><a href="http://localhost:8080/account/get">查询用户</a></li>
        <li><a href="http://localhost:8080/account/update">修改用户</a></li>
        <li><a href="http://localhost:8080/account/del">删除用户</a></li>
    </div>
</ul>

<%-- <form action="/form" method="get">
     站点名: <input type="text" name="name"/>
     <br />
     网  址: <input type="text" name="url"/><br>
     <input type="submit" name="提交"/>
 </form>
--%>
<h4>获取时间的方法: ${requestScope.method}</h4>
        显示当前时间和日期:<br>
        <%-- 获取model中添加的time ，下面三种方式相同--%>
${requestScope.get("time")}<br>
</body>
</html>
