<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/21
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息安全竞赛</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="/competition/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/competition/css/login/login.css">
    <style>
        .showItem:hover{
            border: white solid 1px;
            cursor: pointer;
        }
        .titleFont{
            color: white;
            font-size: 20px;
            margin-top: 10px;
        }
        .timeFont label{
            color: white;
            font-size: 10px;
            margin-top: 20px;
        }
        .setPage label{
            color: white;
            font-size: 15px;
        }
    </style>
</head>
<body class="bgColor">
    <!--导航begin-->
    <%@ include file="../common/nav.jsp"%>
    <!--导航end-->
    <div class="container" style="border: white solid 1px;">
        <%=session.getAttribute("cInfo") %>
        <div style="height: 10px;border-bottom:white solid 1px;"></div>
        <form id="searchForm" style="height: 50px;" action="/competition/competeInfo" method="post">
            <div style="height: 13px;"></div>
            <div class="row" style="">
                <div class="col-md-2"></div>
                <div class="col-md-1">
                    <a href="javascript:void(0);" class="turnPage" onclick="turnTopPage()">上一页</a>
                </div>
                <div class="col-md-6 setPage" style="text-align: center;">
                    <label><%=session.getAttribute("pointer") %></label>
                    <label>/</label>
                    <label><%=session.getAttribute("max") %></label>
                    <label>页</label>
                </div>
                <div class="col-md-1">
                    <a href="javascript:void(0);" class="turnPage" onclick="turnBottomPage()" >下一页</a>
                </div>
                <div class="col-md-2"></div>
            </div>
        </form>
    </div>
    <!--引入jquery文件-->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js" type="text/javascript"></script>
    <!--引入bootstrap.js-->
    <script type="text/javascript" src="/competition/plugins/bootstrap/js/bootstrap.js" ></script>
    <script type="text/javascript" src="../../js/bgAnimation.js"></script>
    <script>
        $("#webLocalCompetition").attr("class","active");
        function turnTopPage() {
            window.location.href = "/competition/competeInfo?webPageState=up";
        }
        function turnBottomPage() {
            window.location.href = "/competition/competeInfo?webPageState=down";
        }
        function selectedItem(index) {
            window.location.href = "/competition/competeInfo?webPageState=selectedIndex&selectedIndex="+index;
        }
    </script>
</body>
</html>
