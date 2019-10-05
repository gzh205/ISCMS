<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/28
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息安全竞赛</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="/competition/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/competition/css/login/login.css">
</head>
<body class="bgColor">
	<!--导航begin-->
    <%@ include file="../common/nav.jsp" %>
    <!--导航end-->
    <div class="container">
    	<table class="table table-striped table-hover" style='text-align: center;'>
    		<%=session.getAttribute("data") %>
    	</table>
    </div>
    <!--引入jquery文件-->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>
    <!--引入bootstrap.js-->
    <script type="text/javascript" src="/competition/plugins/bootstrap/js/bootstrap.js" ></script>
    <script type="text/javascript" src="../../js/bgAnimation.js"></script>
    <script>
    	$("#webIndex").attr("class","active");
    </script>
</body>
</html>
