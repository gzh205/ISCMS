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
    	String dat = "";
    	List<Signup> arrSign = new SignupDaoImpl().userComSignup(request.getParameter("info"));
    	if(arrSign.isEmpty()){
    		dat = "<tbody><td colspan='2'>什么也没有</td></tbody>";
    	}else{
    		for(Signup s:arrSign){
    			dat += "<tr class='trStyle' style='text-align: center;' onclick=\"location.href='/competition/jsp/competition/review.jsp?id="+ s.getId() +"'\"><td style='text-align: center;'>" + s.getuEmail() + "</td><td style='text-align: center;'>";
    			if(s.getIsValid()==1)
    				dat += "审核通过";
    			else if(s.getIsValid()==0)
    				dat += "未审核";
    			else
    				dat += "审核未通过";
    			dat += "</td></tr>";
    		}
    	}
    %>
    <div class="container">
		<table class="table table-striped table-hover" style="width:95%;margin-left:25px;margin-top:25px">
			<thead>
				<tr>
					<th style='text-align: center;color:white;'>用户邮箱</th>
					<th style='text-align: center;color:white;'>是否审核</th>
				</tr>
			</thead>
			<tbody>
				<%=dat %>
			</tbody>
		</table>
    </div>
    <!--引入jquery文件-->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js" type="text/javascript"></script>
    <!--引入bootstrap.js-->
    <script type="text/javascript" src="/competition/plugins/bootstrap/js/bootstrap.js" ></script>
    <script type="text/javascript" src="../../js/bgAnimation.js"></script>
    <script>
        $("#webIndex").attr("class","active");
    </script>
  </body>
</html>
