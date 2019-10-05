<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/22
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="tools.ShowArray" %>
<%@ page import="entity.Compete" %>
<%@ page import="dao.impl.CompeteDaoImpl" %>
<%@ page import="entity.Organizer" %>
<%@ page import="dao.impl.OrganizerDaoImpl" %>
<html>
<head>
    <title>信息安全竞赛</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="/competition/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/competition/css/login/login.css">
</head>
<body class="bgColor">
	<%
		request.setCharacterEncoding("utf-8");
   		String url = "";
   		String text = "";
   		String sess = session.getAttribute("userType").toString();
   		Compete c = null;
   		String oInfo = "";
   		if(sess.equals("user")){
   			c = new CompeteDaoImpl().getData(session.getAttribute("comInfo").toString());
   			oInfo = new OrganizerDaoImpl().getData(c.getoEmail()).getOinfo();
   			if(ShowArray.isAfterToday(c.getcTime())==false){
   				text = "报名截止";
   				url = "#";
   			}else{
	   			text = "点击报名";
	   			url = session.getAttribute("comInfo").toString();
   			}
   		}else{
   			c = new CompeteDaoImpl().getData(session.getAttribute("comInfo").toString());
   			text = "只有登录后的用户才能够报名";
   			url = "#";
   		}
   	%>
    <!--导航begin-->
    <%@ include file="../common/nav.jsp"%>
    <!--导航end-->
    <div class="container">
        <img src="<%=c.getcImg() %>" style="border: white solid 1px; border-radius: 10px 10px 10px 10px;">
            <legend>
                <div class="row">
                    <label class="lblWhite"><%=c.getcInfo() %></label>
                </div>
            </legend>
            <div class="row">
                <label class="lblWhite" style="font-size: 20px;"><%=c.getcRemark() %></label>
            </div>
            <div class="row">
                <label class="lblWhite" style="font-size: 20px;">报名费用：<%=c.getcFee() %></label>
            </div>
            <div class="row">
                <label class="lblWhite" style="font-size: 20px;">主办方：<%=oInfo %></label>
            </div>
        </img>
        <div style="text-align: center">
        	
            <a href='/competition/jsp/competition/signup.jsp?info=<%=url %>' style='color:white"'><%=text %></a>
        </div>
    </div>
    <!--引入jquery文件-->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js" type="text/javascript"></script>
    <!--引入bootstrap.js-->
    <script type="text/javascript" src="/competition/plugins/bootstrap/js/bootstrap.js" ></script>
    <script type="text/javascript" src="../../js/bgAnimation.js"></script>
</body>
</html>
