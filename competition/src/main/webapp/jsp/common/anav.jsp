<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/9
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<style>

</style>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--LOGO及搜索框begin-->
<div class="container">
    <div class="title" style="margin-left: 10%;height: 100px;margin-top:50px;">
        <label style="color: red;font-size: 50px";>信息</label>
        <label style="color: gray;font-size: 50px;">安全</label>
    </div>
</div>
<!--LOGO及搜索框end-->
<!--导航begin-->
<div class="container-fluid">
    <div class="row">
        <nav class="navbar navbar-default" role="navigation" style="border: black solid 0px;background: transparent;border-top: black solid 1px;">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target="#example-navbar-collapse">
                        <span class="sr-only">切换导航</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        
                    </button>
                </div>
                <div class="collapse navbar-collapse" id="example-navbar-collapse">
                	<%=(session.getAttribute("userType").equals("admin"))?"<ul class='nav navbar-nav'><li id='user'><a href='/competition/userInfoAdmin?op=init'>参赛者管理</a></li><li id='orgainzer'><a href='/competition/orgInfoAdmin?op=init'>主办方管理</a></li><li id='compete'><a href='/competition/comInfoAdmin?op=init'>竞赛信息管理</a></li><li id='infomation'><a href='/competition/sinInfoAdmin?op=init'>报名信息管理</a></li></ul>":"您还没有登录"%>
                </div>
            </div>
        </nav>
    </div>
</div>
<!--导航end-->
</body>
</html>
