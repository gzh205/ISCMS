<%@page import="entity.User"%>
<%@page import="dao.impl.UserDaoImpl"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>信息安全竞赛</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="/competition/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/competition/css/login/login.css">
  </head>
  
  <body class="bgColor">
  <%
  	String email = request.getParameter("email");
  	User u = new UserDaoImpl().getData(email);
   %>
    <%@ include file="../common/anav.jsp"%>
    <div class="container">
    	<div class="paper">
    		<form action="/competition/userInfoChange" method="post" class="form-horizontal" role="form">
                    <fieldset>
                        <legend>
                            <div>
                                <h3 id="login_text">用户信息修改</h3>
                            </div>
                        </legend>
                        <div class="form-group has-feedback">
                            <label for="firstname" class="col-sm-2 control-label blackFont">参赛者邮箱</label>
                            <div class="col-md-9">
                                <input style="background: transparent;" type="text" class="form-control" name="email" value="<%=u.getUemail() %>" readonly="readonly"/>
                                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="lastname" class="col-sm-2 control-label blackFont">密码</label>
                            <div class="col-md-9">
                                <input style="background: transparent;" type="password" class="form-control" name="pwd" value="<%=u.getUpassword() %>"/>
                                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="lastname" class="col-sm-2 control-label blackFont">参赛者姓名</label>
                            <div class="col-md-9" style="width: 180px;">
                                <input style="background: transparent;" type="text" class="form-control" name="name" value="<%=u.getUname() %>"/>
                                <span class="glyphicon glyphicon-user form-control-feedback"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">修改</button>
                            </div>
                        </div>
                        <c:if test="${param.error == 0}">
                            <span class="alert-danger" style="background: transparent">您有为输入的项</span>
                        </c:if>
                    </fieldset>
                </form>
    	</div>
    </div>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/competition/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript">
    	$("#user").attr("class","active");
    </script>
  </body>
</html>
