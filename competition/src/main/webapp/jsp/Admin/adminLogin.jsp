<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/9
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>信息安全竞赛</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="/competition/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/competition/css/login/login.css">
</head>
<body class="bgColor">
	<!--导航begin-->
    <%@ include file="../common/anav.jsp"%>
    <!--导航end-->
    <div class="container-fluid">
        <div class="row">
            <div id="login">
                <form action="/competition/adminLog" method="post" class="form-horizontal" role="form">
                    <fieldset>
                        <legend>
                            <div>
                                <h3 id="login_text">管理员登录</h3>
                            </div>
                        </legend>
                        <div class="form-group has-feedback">
                            <label for="firstname" class="col-sm-2 control-label">管理员ID</label>
                            <div class="col-md-5">
                                <input type="text" class="form-control" name="aID" placeholder="请输入管理员ID">
                                <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                <c:if test="${param.error == 0}">
                                    <span class="alert-danger" style="background: transparent">无此管理员</span>
                                </c:if>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="lastname" class="col-sm-2 control-label">请输入密码</label>
                            <div class="col-md-5">
                                <input type="password" class="form-control" name="pwd" placeholder="请输入密码">
                                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                                <c:if test="${param.error == 1}">
                                    <span class="alert-danger" style="background: transparent">您的密码错误，请重新输入密码</span>
                                </c:if>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">登录</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/competition/plugins/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
