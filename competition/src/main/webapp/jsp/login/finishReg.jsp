<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/22
  Time: 23:22
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
    <%@ include file="../common/nav.jsp"%>
    <!--导航end-->
    <div class="container">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-1" style="border:white solid 1px;width:50px;height: 50px;background: white;border-radius: 10px;"><label style="font-size: 30px;margin-top:4px;margin-left: 2px">1</label></div>
            <div class="col-md-2" style="border:white solid 1px;height: 3px;background: white;margin-top:25px;"></div>
            <div class="col-md-1" style="border:white solid 1px;width:50px;height: 50px;background: white;border-radius: 10px;"><label style="font-size: 30px;margin-top:4px;margin-left: 2px">2</label></div>
            <div class="col-md-2" style="border:white solid 1px;height: 3px;background: white;margin-top:25px;"></div>
            <div class="col-md-1" style="border:white solid 1px;width:50px;height: 50px;background: white;border-radius: 10px;"><label style="font-size: 30px;margin-top:4px;margin-left: 2px">3</label></div>
        </div>
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-3" style="margin-left: -35px;">
                <label style="color: white">setp1:验证邮箱</label>
            </div>
            <div class="col-md-3" style="margin-left: -45px;">
                <label style="color: white">setp2:填写信息</label>
            </div>
            <div class="col-md-2" style="margin-left: -50px;">
                <label style="color: white">setp3:完成注册</label>
            </div>
        </div>
    </div>
    <div class="container">
        <div style="text-align: center;margin-top:200px;">
            <label style="font-size:30px;color: white;">您已完成注册，点击此处</label>
            <a href="login.jsp" style="font-size:30px;">登录</a>
        </div>
    </div>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/competition/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../js/bgAnimation.js"></script>
    <script>
        //选中注册菜单
        $("#webRegister").attr("class","active");
    </script>
</body>
</html>
