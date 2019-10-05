<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息安全竞赛</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="/competition/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/competition/css/login/login.css">
    <link rel="stylesheet" type="text/css" href="/competition/css/common/paper.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <meta name="format-detection" content="telephone=no">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,700,900|Roboto+Condensed:400,300,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="../../css/demo.css">
    <link rel="stylesheet" href="../../css/dropify.css">
</head>
<body class="bgColor">
	<%
		session.setAttribute("userType", "null");
	 %>
	<!--导航begin-->
    <%@ include file="./jsp/common/nav.jsp"%>
    <!--导航end-->
    <div class="container" style="background-image: url(./imgs/compete/indexBack.png);background-repeat:round;height:650px;">
    	<div class="row" style="text-align:center;margin-top:100px;color:white">
    		<h3>欢迎使用信息安全竞赛管理系统</h3>
    	</div>
    	<div class="row" style="text-align:center;margin-top:50px;color:white">
    		<h5>点击上方的导航栏可以进行登录、注册、竞赛信息查询、报名、查看报名结果和创建竞赛等操作</h5>
    	</div>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="./js/bgAnimation.js"></script>
</body>
</html>