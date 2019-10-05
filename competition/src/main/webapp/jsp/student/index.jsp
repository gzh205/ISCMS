<%--
  Created by IntelliJ IDEA.
  User: success
  Date: 2019/1/12 0012
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>信息安全竞赛</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="/competition/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/competition/css/login/login.css">
</head>
<body class="bgColor">
    <%@ include file="../common/nav.jsp"%>
    <!--轮播begin-->
    <div id="myCarousel" class="carousel slide" style="Height: 500px">
        <!-- 轮播（Carousel）指标 -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <!-- 轮播（Carousel）项目 -->
        <div class="carousel-inner" style="Height: 500px">
            <div class="item active">
                <img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1547534945182&di=e0fc45987bec889645076a63179eceae&imgtype=0&src=http%3A%2F%2Fbannerdesign.cn%2Fwp-content%2Fuploads%2F2015%2F02%2F20150204014336322.jpg" alt="First slide">
            </div>
            <div class="item">
                <img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1547534943832&di=01af4c44ae7483c0444935bfef2f94ac&imgtype=0&src=http%3A%2F%2Fimg2.3lian.com%2F2014%2Ff6%2F122%2Fd%2F28.jpg" alt="Second slide">
            </div>
            <div class="item">
                <img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1547534942258&di=ec6bff236ec86b57a3184e8bc8bc4e4c&imgtype=0&src=http%3A%2F%2Fabc.2008php.com%2F2014_Website_appreciate%2F2014-09-16%2F20140916104757.jpg" alt="Third slide">
            </div>
        </div>
        <!-- 轮播（Carousel）导航 -->
        <a class="carousel-control left" href="#myCarousel"
           data-slide="prev"> <span _ngcontent-c3="" aria-hidden="true" class="glyphicon glyphicon-chevron-left"></span></a>
        <a class="carousel-control right" href="#myCarousel"
           data-slide="next"> <span _ngcontent-c3="" aria-hidden="true" class="glyphicon glyphicon-chevron-right"></span> </a>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/competition/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script>
        //选中首页菜单
        $("#webIndex").attr("class","active");
    </script>
</body>
</html>
