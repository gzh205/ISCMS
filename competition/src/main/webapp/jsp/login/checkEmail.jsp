<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/17
  Time: 16:41
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
            <div class="col-md-2" style="border:white solid 1px;height: 3px;background: transparent;margin-top:25px;"></div>
            <div class="col-md-1" style="border:white solid 1px;width:50px;height: 50px;background: transparent;border-radius: 10px;"><label style="font-size: 30px;color: white;margin-top:4px;margin-left: 2px">2</label></div>
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
                <div class="form-horizontal" role="form">
                    <fieldset>
                        <legend>
                            <div>
                                <h3 id="login_text">用户注册</h3>
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
                            <form action="/competition/checkemail" method="post">
                            <div class="form-group has-feedback">
                                <label class="col-sm-2 control-label lblWhite">邮箱验证码</label>
                                <div class="col-md-5">
                                    <input type="text" class="form-control" name="num" placeholder="请输入邮箱验证码">
                                    <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                                    <c:if test="${param.error == 2}">
                                        <span class="alert-danger" style="background: transparent">邮箱验证码错误</span>
                                    </c:if>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" class="btn btn-default">验证邮箱</button>
                                </div>
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
    <script type="text/javascript">
        //选中注册菜单
        $("#webRegister").attr("class","active");
        //点击切换验证码
        function changeVerifyCode(){
            $("#imgKap").attr("src","/competition/yzm?"+Math.floor(Math.random()*100));
        }
    </script>
</body>
</html>
