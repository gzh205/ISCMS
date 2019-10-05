<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/18
  Time: 14:24
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
    <%@ include file="../common/nav.jsp"%>
    <!--导航end-->
    <div class="container">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-1" style="border:white solid 1px;width:50px;height: 50px;background: white;border-radius: 10px;"><label style="font-size: 30px;margin-top:4px;margin-left: 2px">1</label></div>
            <div class="col-md-2" style="border:white solid 1px;height: 3px;background: white;margin-top:25px;"></div>
            <div class="col-md-1" style="border:white solid 1px;width:50px;height: 50px;background: white;border-radius: 10px;"><label style="font-size: 30px;margin-top:4px;margin-left: 2px">2</label></div>
            <div class="col-md-2" style="border:white solid 1px;height: 3px;background: transparent;margin-top:25px;"></div>
            <div class="col-md-1" style="border:white solid 1px;width:50px;height: 50px;background: transparent;border-radius: 10px;"><label style="font-size: 30px;color: white;margin-top:4px;margin-left: 2px">3</label></div>
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
    <div class="container-fluid">
        <div class="row">
            <div id="login">
                <form action="/competition/createUser" method="post" class="form-horizontal" role="form">
                    <fieldset>
                        <legend>
                            <div>
                                <h3 id="login_text">用户注册</h3>
                            </div>
                        </legend>
                        <div class="form-group has-feedback">
                            <label for="firstname" class="col-sm-2 control-label lblWhite">您的邮箱</label>
                            <div class="col-md-5">
                                <input type="text" class="form-control" name="email" value="<%=request.getSession().getAttribute("regEmail") %>" disabled="true">
                                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                                <c:if test="${param.error == 0}">
                                    <span class="alert-danger" style="background: transparent">您的邮箱为空，请重新验证邮箱</span>
                                </c:if>
                                <c:if test="${param.error == 4}">
                                    <span class="alert-danger" style="background: transparent">您的邮箱已经注册过了!</span>
                                </c:if>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="lastname" class="col-sm-2 control-label lblWhite">请输入密码</label>
                            <div class="col-md-5">
                                <input type="password" class="form-control" name="pwd1" placeholder="请输入密码">
                                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                                <c:if test="${param.error == 1}">
                                    <span class="alert-danger" style="background: transparent">您的密码空，请重新输入密码</span>
                                </c:if>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="lastname" class="col-sm-2 control-label lblWhite">再次输入密码</label>
                            <div class="col-md-5">
                                <input type="password" class="form-control" name="pwd2" placeholder="请输入密码">
                                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                                <c:if test="${param.error == 2}">
                                    <span class="alert-danger" style="background: transparent">您的两次密码不一致</span>
                                </c:if>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="lastname" class="col-sm-2 control-label lblWhite">请输入用户名</label>
                            <div class="col-md-5">
                                <input type="password" class="form-control" name="uname" placeholder="请输入用户名">
                                <span class="glyphicon glyphicon-user form-control-feedback"></span>
                                <c:if test="${param.error == 3}">
                                    <span class="alert-danger" style="background: transparent">您输入的用户名为空</span>
                                </c:if>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="radio-inline">
                                    <label style="color:white;">
                                        <input type="radio" id="radio1" name="radioOptions" value="rdo1" checked="checked">
                                        用户注册
                                    </label>
                                </div>
                                <div class="radio-inline">
                                    <label style="color:white;">
                                        <input type="radio" id="radio2" name="radioOptions" value="rdo2">
                                        主板方注册
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">提交注册</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
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
