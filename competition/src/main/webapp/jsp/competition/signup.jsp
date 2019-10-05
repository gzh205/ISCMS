<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/28
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@page import="entity.Compete"%>
<%@page import="dao.impl.CompeteDaoImpl"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    	Compete c = new CompeteDaoImpl().getData(request.getParameter("info"));
    %>
    <div class="container">
        <div class="paper">
			<form method="post" action="/competition/usersignup" entype="multipart/form-data">
				<table class="table table-bordered" style="width:95%;margin-left:25px;margin-top:25px">
					<h1>提交报名申请</h1>
					<tbody style="text-align:center">
						<tr>
							<td><div>竞赛名称</div></td>
							<td>
							<div class="row">
							<div class="col-md-12">
								<input name="cInfo" style="width:95%" type="text" value="<%=c.getcInfo() %>" readonly="readonly" />
							</div>
							</div>
							</td>
							<td rowspan="3" style="width:200px">
								 <div class="row">
					                <div class="col-md-12" id="hiddenarea">
					                    <input name="img" style="width:95%;height:95%;" type="file" id="input-file-now" class="dropify" value="" />
					                    <input type="button" onclick="btnOnclick()" value="上传图片"></input>			   
					                </div>
					            </div>
							</td>			
						</tr>
						<tr>
							<td><div>用户邮箱</div></td>
							<td>
							<div class="row">
							<div class="col-md-12">
								<input style="width:95%" type="text" value="<%=session.getAttribute("userEmail") %>" readonly="readonly"/>
							</div>
							</div>
							</td>
						</tr>
						<tr>
							<td><div>真实姓名</div></td>
							<td>
							<div class="row">
							<div class="col-md-12">
								<input style="width:95%" type="text" name="cName" />
							</div>
							</div>
							</td>
						</tr>
						<tr>
							<td>							
							<div>身份证号码</div>
							</td>
							<td>
							<div class="row">
							<div class="col-md-12">
								<input style="width:95%" type="text" name="cNumber"/>
							</div>
							</div>
							<c:if test="${param.error == 2}">
			                    <span class="alert-danger" style="background: transparent">您必须输入正确的身份证号码</span>
			                </c:if>
							</td>
						</tr>
					</tbody>
				</table>
				<c:if test="${param.error == 0}">
                    <span class="alert-danger" style="background: transparent">您还有没填完的项</span>
                </c:if>
                <c:if test="${param.error == 3}">
                    <span class="alert-danger" style="background: transparent">您还有没有上传图片</span>
                </c:if>
                <c:if test="${param.error == 1}">
			    	<span class="alert-danger" style="background: transparent">您还没有登录</span>
			    </c:if>
				<div><input id="btnSub" style="margin-left:50%;" type="submit" value="提交" disabled="disabled" /></div>
			</form>
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
        $(document).ready(function(){
            // Basic
            $('.dropify').dropify();

            // Translated
            $('.dropify-fr').dropify({
                messages: {
                    default: 'Glissez-déposez un fichier ici ou cliquez',
                    replace: 'Glissez-déposez un fichier ou cliquez pour remplacer',
                    remove:  'Supprimer',
                    error:   'Désolé, le fichier trop volumineux'
                }
            });

            // Used events
            var drEvent = $('#input-file-events').dropify();

            drEvent.on('dropify.beforeClear', function(event, element){
                return confirm("Do you really want to delete \"" + element.file.name + "\" ?");
            });

            drEvent.on('dropify.afterClear', function(event, element){
                alert('File deleted');
            });

            drEvent.on('dropify.errors', function(event, element){
                console.log('Has Errors');
            });

            var drDestroy = $('#input-file-to-destroy').dropify();
            drDestroy = drDestroy.data('dropify')
            $('#toggleDropify').on('click', function(e){
                e.preventDefault();
                if (drDestroy.isDropified()) {
                    drDestroy.destroy();
                } else {
                    drDestroy.init();
                }
            })
        });
		function btnOnclick(){
        	var data = $('#imgUpload').attr('src');
        	console.log(data);
        	$.post("/competition/upImg", {"image": data},function(data){});
        	$("#btnSub").removeAttr("disabled");
        }
    </script>
</body>
</html>
