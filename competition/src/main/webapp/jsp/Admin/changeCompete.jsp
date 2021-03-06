<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="entity.Compete"%>
<%@page import="dao.impl.CompeteDaoImpl"%>
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
  	String info = request.getParameter("info");
  	Compete c = new CompeteDaoImpl().getData(info);
   	%>
    <%@ include file="../common/anav.jsp"%>
    <div class="container">
    	<div class="paper">
    		<form action="/competition/comInfoChange" method="post" class="form-horizontal" role="form">
                    <fieldset>
                        <legend>
                            <div>
                                <h3 id="login_text">竞赛信息修改</h3>
                            </div>
                        </legend>
                        <div class="form-group has-feedback">
                            <label for="firstname" class="col-sm-2 control-label blackFont">竞赛名称</label>
                            <div class="col-md-9">
                                <input style="background: transparent;" type="text" class="form-control" name="info" value="<%=c.getcInfo() %>" readonly="readonly"/>
                                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="lastname" class="col-sm-2 control-label blackFont">比赛时间</label>
                            <div class="col-md-9">
                                <input style="background: transparent;" type="date" class="form-control" name="time" value="<%=c.getcTime() %>"/>
                                <span class="glyphicon glyphicon-calendar form-control-feedback"></span>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="lastname" class="col-sm-2 control-label blackFont">报名费用</label>
                            <div class="col-md-9">
                                <input style="background: transparent;" type="text" class="form-control" name="fee" value="<%=c.getcFee() %>"/>
                                <span class="glyphicon glyphicon-user form-control-feedback"></span>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label for="lastname" class="col-sm-2 control-label blackFont">备注</label>
                            <div class="col-md-9">
                                <input style="background: transparent;" type="text" class="form-control" name="remark" value="<%=c.getcRemark() %>"/>
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
    	$("#compete").attr("class","active");
    </script>
  </body>
</html>
