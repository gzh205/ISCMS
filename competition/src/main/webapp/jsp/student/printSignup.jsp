<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.Signup" %>
<%@ page import="dao.impl.SignupDaoImpl" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
    <title>信息安全竞赛</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="/competition/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/competition/css/login/login.css">
    <link rel="stylesheet" type="text/css" href="/competition/css/common/paper.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <meta name="format-detection" content="telephone=no">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,700,900|Roboto+Condensed:400,300,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="../../css/demo.css">
    <link rel="stylesheet" href="../../css/dropify.css">
</head>
<body class="bgColor">
    <!--导航begin-->
    <%@ include file="../common/nav.jsp"%>
    <!--导航end-->
    <%
		Signup s = new SignupDaoImpl().getData(Integer.parseInt(request.getParameter("id")));
	%>
    <div class="container">
        <div class="paper">
			<form id="tbl">
				<table class="table table-bordered" style="width:95%;margin-left:25px;margin-top:25px">
					<h1>提交报名申请</h1>
					<tbody style="text-align:center">
						<tr>
							<td style="width:20%"><div><h5>竞赛名称</h5></div></td>
							<td>
							<div class="row">
							<div class="col-md-12">
								<h5 style="width:95%"><%=s.getcInfo() %></h5>
							</div>
							</div>
							</td>
							<td rowspan="3" style="width:200px">
								 <div class="row">
					                <div class="col-md-12" id="hiddenarea">
					                    <img src="<%=s.getcImg() %>" style="width:100%;height:250px;" />  
					                </div>
					            </div>
							</td>			
						</tr>
						<tr>
							<td><div><h5>报名编号</h5></div></td>
							<td>
							<div class="row">
							<div class="col-md-12">
								<h5 style="width:95%"><%=s.getId() %></h5>
							</div>
							</div>
							</td>
						</tr>
						<tr>
							<td><div><h5>真实姓名</h5></div></td>
							<td>
							<div class="row">
							<div class="col-md-12">
								<h5 style="width:95%"><%=s.getName() %></h5>
							</div>
							</div>
							</td>
						</tr>
						<tr>
							<td>							
							<div><h5>身份证号码</h5></div>
							</td>
							<td colspan="2">
							<div class="row">
							<div class="col-md-12">
								<h5 style="width:95%"><%=s.getcNumber() %></h5>
							</div>
							</div>
							<c:if test="${param.error == 2}">
			                    <span class="alert-danger" style="background: transparent">您必须输入正确的身份证号码</span>
			                </c:if>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
			<div><input id="btnSub" style="margin-left:50%;" type="button" value="打印报名表" onclick="btnPrint()" /></div>
		</div>
    </div>
    <!--引入jquery文件-->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="https://ciphertrick.com/demo/jquerysession/js/jquerysession.js"></script>
    <!--引入bootstrap.js-->
    <script type="text/javascript" src="/competition/plugins/bootstrap/js/bootstrap.js" ></script>
    <script src="http://www.jq22.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="../../js/dropify.js"></script>
    <script src="../../js/uploadData.js"></script>
    <script type="text/javascript" src="../../js/bgAnimation.js"></script>
    <script>
    	$("#webForeignCompetition").attr("class","active");
    	function btnPrint(){
			var newstr = document.getElementById("tbl").innerHTML;
			var oldstr = document.body.innerHTML;
			document.body.innerHTML = newstr;
			window.print();
			document.body.innerHTML = oldstr;
			return false;
    	}
    </script>
</body>
</html>