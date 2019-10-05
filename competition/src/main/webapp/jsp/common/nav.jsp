<%--
  Created by IntelliJ IDEA.
  User: success
  Date: 2019/1/8 0008
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!--LOGO及搜索框begin-->
<div class="container">
	<div class="row">
	    <div class="col-md-8" style="margin-left: 10%;height: 100px;margin-top:50px;">
	    	<div class="row">
	    		<div class="col-md-3">
		        <label style="color: red;font-size: 50px;">信息</label>
		        </div>
		        <div class="col-md-3">
		        <label style="color:gray;font-size:50px;">安全</label>
		        </div>
		    </div>
	    </div>
	    <div style="col-md-4">
	    	<div style="height:100px"></div>
	    	<form action="/competition/searchCtrl" method="post" class="form-horizontal" role="form">
	    		<input type="text" name="strSearch">
	    		<input type="submit" value="查询"/>
	    	</form>
	    </div>
    </div>
</div>
<!--LOGO及搜索框end-->
<!--导航begin-->
<div class="container-fluid">
    <div class="row">
        <nav class="navbar navbar-inverse" role="navigation" style="border: black solid 0px;background: transparent;border-top: black solid 1px;">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target="#example-navbar-collapse">
                        <span class="sr-only">切换导航</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand">系统工具</a>
                </div>
                <div class="collapse navbar-collapse" id="example-navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li id="webIndex"><a href="/competition/displayCompete">查看报名情况</a></li>
                        <li id="webLocalCompetition"><a href="/competition/competeInfo?webPageState=init">本站竞赛</a></li>
                        <li id="webForeignCompetition"><a href="<%=(session.getAttribute("userType")!=null&&session.getAttribute("userType").equals("org")?"/competition/jsp/competition/createCompete.jsp":"/competition/oCompete?op=init") %>"><%=(session.getAttribute("userType").equals("org")?"添加竞赛":"外部竞赛") %></a></li>
                        <li id="webStudy"><a href="http://www.ciscn.cn/home">学习资料</a></li>
                        <li id="webAboutUs"><a href="/competition/index.jsp">关于我们</a></li>
                    </ul>
                    <ul class="nav navbar-nav pull-right">
                        <li><label id="lblWelcome"></label></li>
                        <li id="webLogin" style="border-right: black solid 1px;"><a id="aLogin" href="<%=(session.getAttribute("userName")==null?"/competition/jsp/login/login.jsp":"/competition/jsp/login/logout.jsp") %>" data-container="body" data-toggle="popover" data-placement="bottom" data-content="若成功登录，则点击此处可以退出登录" data-trigger="hover" ><%=(session.getAttribute("userName")==null?"登录":("欢迎您，"+session.getAttribute("userName")))%></a></li>
                        <li id="webRegister"><a href="/competition/jsp/login/checkEmail.jsp">注册</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>
<!--导航end-->
<!--侧边栏begin-->
<div id="rightContext" class="rightMenu" onmouseover="ContactOver()" onmouseout="ContactLeave()">
    <div style="background-image: url(/competition/imgs/prj/suspend.png);width: 160px;height: 198px;">
        <div style="z-index: 11;width: 160px;height: 80px;cursor: pointer;" onclick="window.location.href = 'tencent://message/?v=3&uin=1709889720&site=qq&menu=yes';"></div>
        <div style="z-index: 11;width: 160px;height: 120px;cursor: pointer;" onclick="alert('请拨打电话:xxxxxxxx');"></div>
    </div>
</div>

<!--侧边栏end-->
<script type="text/javascript">
    var st;
    var over = false;
    var leave = false;
    function ContactOver() {
        clearInterval(st);
        st = setInterval(function() {
        	if(parseInt($("#rightContext").css("right"))<0)
        		$("#rightContext").css("right",parseInt($("#rightContext").css("right"))+10+"px");
        	if(parseInt($("#rightContext").css("right"))>=0 || leave == true) {
                clearInterval(st);
            }            
        }, 50)
    }
    function ContactLeave() {
        clearInterval(st);
        st = setInterval(function () {
        	$("#rightContext").css("right", parseInt($("#rightContext").css("right")) - 10 + "px");
        	if (parseInt($("#rightContext").css("right")) <= -120 || over == true) {
                clearInterval(st);
            }            
        }, 50)
    }
</script>