<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/29
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息安全竞赛</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="/competition/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/competition/css/login/login.css">
    <style type="text/css">
	.box{
		width: 200px;
		height: 80px;
		margin: 200px auto;
		border: 1px solid red;
	}
	.box>ul{
		clear: both;
		overflow: hidden;
		margin-left: 20px;
	}
	.box>ul>li{
		width: 4px;
		height: 40px;
		margin: 20px 5px 0 0px;
		background: skyblue;
		float: left;
		position: relative;
	}
	</style>
</head>
<body class="bgColor">
    <!--导航begin-->
		<%@ include file="../common/nav.jsp"%>
    <!--导航end-->
    <div class="container">
	    <div class="tab-pane text-center active" style="background:white">
			<%=(session.getAttribute("otherCompete")==null)?("什么也没有"):(session.getAttribute("otherCompete")) %>
		</div>
	</div>
    <!--引入jquery文件-->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>
    <!--引入bootstrap.js-->
    <script type="text/javascript" src="/competition/plugins/bootstrap/js/bootstrap.js" ></script>
    <script type="text/javascript" src="../../js/bgAnimation.js"></script>
    <script>
    	$("#webForeignCompetition").attr("class","active");
		$(function(){
			big($(".box>ul>li"));
		})
		var i=-1;
		function big(obj){
			var li_len=obj.length;
			var li_h=obj.height();
		 	var a_h=li_h+40;
			setInterval(function(){
			i++;
			if(i==li_len){
				i=0;
			}
			obj.eq(i).animate({
				"height":a_h,
				"top":-20+"px"
			},800);
			obj.eq(i-1).animate({
				"height":li_h,
				"top":0
			},800)　　　　　　
			},200)　　　　
		}
    </script>
</body>
</html>
