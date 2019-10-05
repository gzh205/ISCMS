<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
	<div class="container" style="background:white">
		<div class="paper">
			<form method="post" action="/competition/createCompete" entype="multipart/form-data">
				<table class="table table-bordered" style="width:95%;margin-left:25px;margin-top:25px">
					<h1>提交创建竞赛申请</h1>
					<tbody style="text-align:center">
						<tr>
							<td><div>竞赛名称</div></td>
							<td>
							<div class="row">
							<div class="col-md-12">
								<input style="width:95%" type="text" name="cInfo" placeholder="请输入竞赛名称"/>
							</div>
							</div>
							<c:if test="${param.error == 1}">
			                    <span class="alert-danger" style="background: transparent">竞赛名称不能重复</span>
			                </c:if>
							</td>
							<td rowspan="3" style="width:200px">
								 <div class="row">
					                <div class="col-md-12" id="hiddenarea">
					                    <input name="img" style="width:95%;height:95%;" type="file" id="input-file-now" class="dropify" value=""/>
					                    <input class="btn-block" type="button" onclick="btnOnclick()" value="上传图片"></input>
					                </div>
					            </div>
							</td>			
						</tr>
						<tr>
							<td><div>竞赛开始时间</div></td>
							<td>
							<div class="row">
							<div class="col-md-12">
								<input style="width:95%" type="date" name="cDate"/>
							</div>
							</div>
							</td>
						</tr>
						<tr>
							<td>							
							<div>报名费用</div>
							</td>
							<td>
							<div class="row">
							<div class="col-md-12">
								<input style="width:95%" type="text" name="cFee"/>
							</div>
							</div>
							<c:if test="${param.error == 2}">
			                    <span class="alert-danger" style="background: transparent">您必须输入一个数字</span>
			                </c:if>
							</td>
						</tr>
						<tr style="height:150px">
							<td>主办方信息</td>
							<td colspan="2"><textarea rows="5" cols="100" disabled="disabled"><%=session.getAttribute("userName") %></textarea></td>
						</tr>
						<tr style="height:150px">
							<td>备注</td>
							<td colspan="2"><textarea rows="5" cols="100" name="cRemark"></textarea></td>
						</tr>
					</tbody>
				</table>
				<c:if test="${param.error == 0}">
                    <span class="alert-danger" style="background: transparent">您还有没填完的项</span>
                </c:if>
                <c:if test="${param.error == 3}">
                    <span class="alert-danger" style="background: transparent">您还有没有上传图片</span>
                </c:if>
				<div><input id="btnSub" style="margin-left:50%;" type="submit" value="提交" disabled="disabled" /></div>
				<c:if test="${param.error == 5}">
                    <span class="alert-danger" style="background: transparent">提交成功</span>
                </c:if>
			</form>
		</div>
	</div>
</body>
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
</html>
