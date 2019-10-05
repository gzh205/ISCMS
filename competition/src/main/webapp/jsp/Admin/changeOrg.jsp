<%@page import="entity.Organizer"%>
<%@page import="dao.impl.OrganizerDaoImpl"%>
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
  	Organizer u = new OrganizerDaoImpl().getData(email);
   %>
    <%@ include file="../common/anav.jsp"%>
    <div class="container">
    	<div class="paper">
    		<form action="/competition/orgInfoChange" method="post" class="form-horizontal" role="form">
                    <fieldset>
                        <legend>
                            <div>
                                <h3 id="login_text">主办方信息修改</h3>
                            </div>
                        </legend>
                        <div class="form-group has-feedback">
                            <label for="firstname" class="col-sm-2 control-label blackFont">主办方邮箱</label>
                            <div class="col-md-9">
                                <input style="background: transparent;" type="text" class="form-control" name="email" value="<%=u.getOemail() %>" readonly="readonly"/>
                                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="lastname" class="col-sm-2 control-label blackFont">主办方密码</label>
                            <div class="col-md-9">
                                <input style="background: transparent;" type="password" class="form-control" name="pwd" value="<%=u.getOpassword() %>"/>
                                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="lastname" class="col-sm-2 control-label blackFont">主办方信息</label>
                            <div class="col-md-9">
                                <input style="background: transparent;" type="text" class="form-control" name="name" value="<%=u.getOinfo() %>"/>
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
    	$("#orgainzer").attr("class","active");
    </script>
  </body>
</html>