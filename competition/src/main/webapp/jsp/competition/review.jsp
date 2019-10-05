<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="entity.Signup"%>
<%@page import="dao.impl.SignupDaoImpl"%>
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
    <!--导航begin-->
    <%@ include file="../common/nav.jsp"%>
    <!--导航end-->
    <%
    	Signup s = new SignupDaoImpl().getData(Integer.parseInt(request.getParameter("id")));
    %>
    <div class="container" style="background:white">
		<div class="paper">
		<form method="post" action="/competition/review">
				<table class="table table-bordered" style="width:95%;margin-left:25px;margin-top:25px">
					<h1>审核创建竞赛申请</h1>
					<tbody style="text-align:center">
						<tr>
							<td><div>竞赛名称</div></td>
							<td>
							<div class="row">
							<div class="col-md-12">
								<input style="width:95%" type="text" name="cInfo" value="<%=s.getcInfo() %>" readonly="readonly"/>
							</div>
							</div>
							</td>
							<td rowspan="3" style="width:200px">
								 <div class="row">
					                <img src="<%=s.getcImg() %>" style="width:100%;height:250px;" />
					            </div>
							</td>			
						</tr>
						<tr>
							<td><div>身份证号码</div></td>
							<td>
							<div class="row">
							<div class="col-md-12">
								<input style="width:95%" type="text" value="<%=s.getcNumber() %>" readonly="readonly" />
							</div>
							</div>
							</td>
						</tr>
						<tr>
							<td>							
							<div>竞赛id号</div>
							</td>
							<td>
							<div class="row">
							<div class="col-md-12">
								<input type="text" value="<%=s.getId() %>" readonly="readonly" name="id" />
							</div>
							</div>
							</td>
						</tr>
						<tr style="height:150px">
							<td>是否通过审核</td>
							<td colspan="2"><input type="radio" name="isValid">审核通过</input>
							<input type="radio" name="isValid">审核不通过</input></td>
						</tr>			
					</tbody>
				</table>
				<div><input style="margin-left:50%;" type="submit" value="提交"/></div>
			</form>
		</div>
	</div>
  </body>
</html>
