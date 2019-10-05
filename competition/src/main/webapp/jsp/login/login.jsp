<%--
  Created by IntelliJ IDEA.
  User: success
  Date: 2019/1/9 0009
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>信息安全竞赛</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../../plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../../css/login/login.css">
</head>
<body class="bgColor">
	<%
		Cookie[] cookies = null;
		cookies = request.getCookies();
		String e = "";//email
		String p = "";//password
		if(cookies!=null){
			for(int i=0;i<cookies.length;i++){
				if(cookies[i].getName().equals("name")){
					e = cookies[i].getValue();
				}else if(cookies[i].getName().equals("pwd")){
					p = cookies[i].getValue();
				}
			}
		}
	%>
    <!--导航begin-->
        <%@ include file="../common/nav.jsp"%>
    <!--导航end-->
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-7">
                <div class="col-md-4"></div>
                <div class="col-md-6">
                    <label style="font-size: 20px;color: white;margin-top:100px;">
                        为了宣传信息安全知识，培养大学生的创新意识、团队合作精神，
                        提高大学生的信息安全技术水平和综合设计能力，
                        促进高等学校信息安全专业课程体系、教学内容和方法的改革，
                        在教育部高等教育司、工业和信息化部信息安全协调司的指导下，
                        教育部高等学校信息安全类专业教学指导委员会决定开展全国大学生信息安全竞赛。
                    </label>
                </div>
            </div>
            <div id="login" class="col-md-5" style="width: 500px">
                <form action="/competition/logincl" method="post" class="form-horizontal" role="form">
                    <fieldset>
                        <legend>
                            <div>
                                <h3 id="login_text">用户登录入口</h3>
                            </div>
                        </legend>
                        <div class="form-group has-feedback">
                            <label for="firstname" class="col-sm-2 control-label blackFont" style="color:white">邮箱</label>
                            <div class="col-md-9">
                                <input style="background: transparent;color:white;" type="text" class="form-control" name="email" placeholder="请输邮箱" value="<%=e %>">
                                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                                <c:if test="${param.error == 0}">
                                    <span class="alert-danger" style="background: transparent">您输入的邮箱有误</span>
                                </c:if>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="lastname" class="col-sm-2 control-label blackFont" style="color:white">密码</label>
                            <div class="col-md-9">
                                <input style="background: transparent;color:white;" type="password" class="form-control" name="pwd" placeholder="请输入密码" value="<%=p %>">
                                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                                <c:if test="${param.error == 1}">
                                    <span class="alert-danger" style="background: transparent">您的密码与账号不匹配</span>
                                </c:if>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="lastname" class="col-sm-2 control-label blackFont" style="color:white">验证码</label>
                            <div class="col-md-9" style="width: 180px;">
                                <input style="background: transparent;color:white;" type="text" class="form-control" name="kaptcha" placeholder="请输入验证码">
                                <span class="glyphicon glyphicon-picture form-control-feedback"></span>
                                <c:if test="${param.error == 2}">
                                    <span class="alert-danger" style="background: transparent">请证明您是人类</span>
                                </c:if>
                            </div>
                            <img id="imgKap" title = "点我换一张" alt="" src="/competition/yzm" style="height: 35px; cursor:pointer;" onclick="changeVerifyCode()"/>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="radio-inline">
                                    <label style="color:white;">
                                        <input type="radio" id="radio1" name="radioOptions" value="rdo1" checked="checked">
                                        用户登录
                                    </label>
                                </div>
                                <div class="radio-inline">
                                    <label style="color:white;" >
                                        <input type="radio" id="radio2" name="radioOptions" value="rdo2">
                                        主板方登录
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
	                        <div class="row">
	                            <div class="col-md-offset-2 col-md-5">
	                                <button type="submit" class="btn btn-default">登录</button>
	                            </div>
	                            <div class="col-md-5">
	                            	<a href="forgetPwd.jsp">忘记密码？</a>
	                            </div>
	                        </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../../plugins/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../js/bgAnimation.js"></script>
    <script type="text/javascript">
        //选中登录菜单
        $("#webLogin").attr("class","active");
        //点击切换验证码
        function changeVerifyCode(){
            $("#imgKap").attr("src","/competition/yzm?"+Math.floor(Math.random()*100));
        }
    </script>
</body>
</html>
