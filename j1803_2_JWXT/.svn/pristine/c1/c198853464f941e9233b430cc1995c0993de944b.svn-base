<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="<%=basePath%>css/pintuer.css">
<link rel="stylesheet" href="<%=basePath%>css/admin.css">
<script src="<%=basePath%>js/jquery.js"></script>
<script src="<%=basePath%>js/pintuer.js"></script>
<script src="<%=basePath%>resources/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head" id="update">
			<strong><span class="icon-pencil-square-o"></span>修改内容</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="<%=basePath%>placeController/update.do">
			<input type="hidden" name="placeId" value="${place.placeId }">
				<div class="form-group">
					<div class="label">
						<label>上课地点名：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${place.placeName }" name="placeName" />
						<div class="tips"></div>
					</div>
				</div>
				
				
			
				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="submit">
							提交</button>
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
</html>