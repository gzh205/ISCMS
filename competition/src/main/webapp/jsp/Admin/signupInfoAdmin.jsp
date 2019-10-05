<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <head>
    <title>信息安全竞赛</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="/competition/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/competition/css/login/login.css">
  </head>
  </head>
  
  <body class="bgColor">
    <%@ include file="../common/anav.jsp"%>
    <div class="container">
    <table class="table table-striped table-hover" style='text-align: center;'>
    	<thead>
			<tr>
				<th style='text-align: center;'>编号</th>
				<th style='text-align: center;'>竞赛信息</th>
				<th style='text-align: center;'>用户邮箱</th>
				<th style='text-align: center;'>身份证号</th>
				<th style='text-align: center;' colspan='2'>操作</th>
			</tr>
		</thead>
		<tbody>
		<%=session.getAttribute("dat") %>
		</tbody>
    </table>
    <div style="text-align:center;">
    	<a href='/competition/comInfoAdmin?op=xls'>导出为excel</a>
    </div>
    </div>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/competition/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript">
    	$("#infomation").attr("class","active");
    </script>
  </body>
</html>
