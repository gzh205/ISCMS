<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/23
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息安全竞赛</title>
</head>
<body>
    <%
        request.getSession().setAttribute("userName",null);
        request.getSession().setAttribute("userEmail",null);
        request.getSession().setAttribute("userType","null");
        response.sendRedirect("login.jsp");
    %>
</body>
</html>
