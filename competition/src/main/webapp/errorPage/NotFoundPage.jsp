<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isErrorPage="true" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <title>link</title>
    <link href="127.0.0.1:8080/competition/css/login/login.css" />
    <style type="text/css">
    .bgColor{
	    background: -webkit-linear-gradient(#333, black); /* Safari 5.1 - 6.0 */
	    background: -o-linear-gradient(#333, black); /* Opera 11.1 - 12.0 */
	    background: -moz-linear-gradient(#333, black); /* Firefox 3.6 - 15 */
	    background: linear-gradient(#333, black); /* 鏍囧噯鐨勮娉曪紙蹇呴』鏀惧湪鏈�鍚庯級 */
	}
	.rightMenu{
	    position: sticky;
	    right: -120px;
	    z-index: 10;
	    border-radius: 10px 0px 0px 10px;
	    position: fixed;
	}
    </style>
</head>
<body class="bgColor">
    <%@ include file="../jsp/common/nav.jsp" %>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-offset-3">
				<h1 style="color:white;">我们找不到您想看的页面</h1>
			</div>
		</div>
	    <div class="row">
	    	<div class="col-md-offset-2 col-md-8" style="height:600px;">
	        	<embed style="height:100%;width:100%;" type="application/x-shockwave-flash" pluginspage="http://www.adobe.com/go/getflashplayer" id="gameobj" name="gameobj" width="100%" height="100%" src="http://flash.7k7k.com/cms/cms10/20160827/1110547956/back2back.swf" allowscriptaccess="never" allownetworking="internal" wmode="window" quality="high">
	    	</div>
	    </div>
	    <div class="row" style="height:200px;">
	    
	    </div>
	</div>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="127.0.0.1:8080/competition/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="127.0.0.1:8080/competition/js/bgAnimation.js"></script>
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
</body>
</html>