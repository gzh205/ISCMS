<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
    <title>信息安全竞赛</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../../plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../../css/login/login.css">
	</head>

	<body class="bgColor">
		<!--导航begin-->
		<%@ include file="../common/nav.jsp"%>
		<!--导航end-->
    	<div class="container-fluid">
        <div class="row">
            <div id="login">
                <div class="form-horizontal" role="form">
                    <fieldset>
                        <legend>
                            <div>
                                <h3 id="login_text">修改密码</h3>
                            </div>
                        </legend>
                        <form action="/competition/sendemail" method="post">
                            <div class="form-group has-feedback">
                                <label class="col-sm-2 control-label lblWhite">请输入邮箱</label>
                                <div class="col-md-5">
                                    <input type="text" class="form-control" name="email" placeholder="请输入邮箱">
                                    <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                                    <c:if test="${param.error == 0}">
                                        <span class="alert-danger" style="background: transparent">请不要把这一项空着</span>
                                    </c:if>
                                </div>
                            </div>
                            <div class="form-group has-feedback">
                                <label class="col-sm-2 control-label lblWhite">验证码</label>
                                <div class="col-md-5" style="width: 200px;">
                                    <input type="text" class="form-control" name="kaptcha" placeholder="请输入验证码">
                                    <span class="glyphicon glyphicon-picture form-control-feedback"></span>
                                    <c:if test="${param.error == 1}">
                                        <span class="alert-danger" style="background: transparent">请证明您是人类</span>
                                    </c:if>
                                </div>
                                <img id="imgKap" title = "点我换一张" alt="" src="/competition/yzm" style="height: 35px; cursor:pointer;" onclick="changeVerifyCode();"/>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" class="btn btn-default">发送邮件</button>
                                </div>
                            </div>
                        </form>
                            <div style="border-top:white solid 1px; height: 10px;"></div>
                            <form action="/competition/changePwd" method="post">
                            <div class="form-group has-feedback">
                                <label class="col-sm-2 control-label lblWhite">邮箱验证码</label>
                                <div class="col-md-5">
                                    <input type="text" class="form-control" name="num" placeholder="请输入邮箱验证码">
                                    <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                                    <c:if test="${param.error == 2}">
                                        <span class="alert-danger" style="background: transparent">邮箱验证码错误</span>
                                    </c:if>
                                    <c:if test="${param.error == 4}">
                                        <span class="alert-danger" style="background: transparent">您的邮箱没有注册</span>
                                    </c:if>
                                </div>
                            </div>
                            <div class="form-group has-feedback">
                                <label class="col-sm-2 control-label lblWhite">新密码</label>
                                <div class="col-md-5">
                                    <input type="text" class="form-control" name="pwd1" placeholder="请输入新密码">
                                    <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                                    <c:if test="${param.error == 3}">
                                        <span class="alert-danger" style="background: transparent">两次密码不一致</span>
                                    </c:if>
                                </div>
                            </div>
                            <div class="form-group has-feedback">
                                <label class="col-sm-2 control-label lblWhite">确认新密码</label>
                                <div class="col-md-5">
                                    <input type="text" class="form-control" name="pwd2" placeholder="请再次输入新密码">
                                    <span class="glyphicon glyphicon-locke form-control-feedback"></span>
                                    <c:if test="${param.error == 3}">
                                        <span class="alert-danger" style="background: transparent">两次密码不一致</span>
                                    </c:if>
                                </div>
                            </div>
                            <div class="form-group">
                            	<div class="col-md-offset-2 col-md-2"><h4 style="color:white">请选择您的身份</h4></div>
	                            <div class="col-md-5">
	                                <div class="radio-inline">
	                                    <label style="color:white;">
	                                        <input type="radio" id="radio1" name="radioOptions" value="rdo1" checked="checked">
	                                        用户
	                                    </label>
	                                </div>
	                                <div class="radio-inline">
	                                    <label style="color:white;" >
	                                        <input type="radio" id="radio2" name="radioOptions" value="rdo2">
	                                        主板方
	                                    </label>
	                                </div>
	                            </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" class="btn btn-default">修改密码</button>
                                </div>
                                <c:if test="${param.error == 10}">
                                    <span class="alert-danger" style="background: transparent">密码修改成功</span>
                                </c:if>
                            </div>
                        </form>
                    </fieldset>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/competition/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../js/bgAnimation.js"></script>
	</body>
</html>
