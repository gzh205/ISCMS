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
    	String str = "<tr>";
    	List<Signup> list = new SignupDaoImpl().getCompeteList(request.getParameter("info"));
    	for(int i=0;i<list.size();i++){
    		if(i%5==0&&i>0){
    			str += "</tr><tr>";
    		}
    		str += "<td><div class='row'><img style='width:20%;height:20%;' src='"+list.get(i).getcImg()+"' /></div><div class='row'><h5>姓名:"+list.get(i).getName()+"<h5></div><div class='row'><h5>身份证号:"+list.get(i).getcNumber()+"</h5></div><div class='row'><h5>邮箱:"+list.get(i).getuEmail()+"</h5></div></td>";
    	}
    	str += "</td>";
	%>
    <div class="container">
        <div class="paper">
			<form id="tbl" method="post" action="/competition/changeSignupInfo" entype="multipart/form-data">
				<table class="table table-bordered" style="width:95%;margin-left:25px;margin-top:25px">
					<div style="text-align: center;"><h1>考生信息显示</h1></div>
					<tbody style="text-align:center">
						<%=str %>
					</tbody>
				</table>
			</form>
			<div class="row" style="text-align:center;">
				<input type="button" onclick="btnPrint()" value="打印考生信息" ></input>
			</div>
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
    	$("#webIndex").attr("class","active");
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