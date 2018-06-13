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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=basePath%>css/pintuer.css">
<link rel="stylesheet" href="<%=basePath%>css/admin.css">
<script src="<%=basePath%>js/jquery.js"></script>
<script src="<%=basePath%>js/pintuer.js"></script>
<script>
	$(function() {
		var arrayForenoon = new Array();
		var str1 = "";
		var str2 = "";
		var str3 = "";
		var str4 = "";
		var str5 = "";
		<c:forEach items="${Forenoon}" var="forenoon" varStatus="status" >
		arrayForenoon.push("${forenoon}"); // 对象，加引号
		/* console.log(arrayForenoon); */
		if ('${forenoon.timeName}' == '星期一上午') {
			str1 += '<h2>${forenoon.subjectName}</h2> ' +'<br>'+ '${forenoon.tName} '
					+'<br>'+ '${forenoon.placeName}' + '<br>';
			$(".forenoon_first").html(str1);
		}
		if ('${forenoon.timeName}' == '星期二上午') {
			str2 += '<h2>${forenoon.subjectName}</h2> ' + '<br>'+'${forenoon.tName} '
					+'<br>'+ '${forenoon.placeName}' + '<br>';
			$(".forenoon_second").html(str2);
		}
		if ('${forenoon.timeName}' == '星期三上午') {
			str3 += '<h2>${forenoon.subjectName} </h2>' +'<br>'+ '${forenoon.tName} '
					+'<br>'+ '${forenoon.placeName}' + '<br>';
			$(".forenoon_third").html(str3);
		}
		if ('${forenoon.timeName}' == '星期四上午') {
			str4 += '<h2>${forenoon.subjectName}</h2>' +'<br>'+ '${forenoon.tName} '
					+'<br>'+ '${forenoon.placeName}' + '<br>';
			$(".forenoon_fourth").html(str4);
		}
		if ('${forenoon.timeName}' == '星期五上午') {
			str5 += '<h2>${forenoon.subjectName}</h2> ' + '<br>'+'${forenoon.tName} '
					+ '<br>'+'${forenoon.placeName}' + '<br>';
			$(".forenoon_fiveth").html(str5);
		}
		</c:forEach>

		var arrayAfternoon = new Array();
		var str6 = "";
		var str7 = "";
		var str8 = "";
		var str9 = "";
		var str0 = "";
		<c:forEach items="${Afternoon}" var="afternoon" varStatus="status" >
		arrayAfternoon.push("${afternoon}"); // 对象，加引号
		/* console.log(arrayAfternoon); */
		if ('${afternoon.timeName}' == '星期一下午') {
			str6 += '<h2>${afternoon.subjectName}</h2>' +'<br>'+ '${afternoon.tName} '
					+ '${afternoon.placeName}' + '<br>';
			$(".afternoon_first").html(str6);
		}
		if ('${afternoon.timeName}' == '星期二下午') {
			str7 += '<h2>${afternoon.subjectName}</h2> ' + '<br>'+'${afternoon.tName} '
					+ '<br>'+'${afternoon.placeName}' + '<br>';
			$(".afternoon_second").html(str7);
		}
		if ('${afternoon.timeName}' == '星期三下午') {
			str8 += '<h2>${afternoon.subjectName}</h2> ' + '<br>'+'${afternoon.tName} '
					+ '<br>'+'${afternoon.placeName}' + '<br>';
			$(".afternoon_third").html(str8);
		}
		if ('${afternoon.timeName}' == '星期四下午') {
			str9 += '<h2>${afternoon.subjectName}</h2>' + '<br>'+'${afternoon.tName} '
					+ '<br>'+'${afternoon.placeName}' + '<br>';
			$(".afternoon_fourth").html(str9);
		}
		if ('${afternoon.timeName}' == '星期五下午') {
			str0 += '<h2>${afternoon.subjectName} </h2> ' + '<br>'+'${afternoon.tName} '
					+'<br>'+ '${afternoon.placeName}' + '<br>';
			$(".afternoon_fiveth").html(str0);
		}
		</c:forEach>
	});
</script>
<style media=print>
.button {
	display: none;
}
</style>
<style type="text/css">
.first {
	height: 50px;
}

.first th {
	line-height: 50px;
}
</style>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong><span class="icon-pencil-square-o"></span>排课表</strong>
		</div>
		<div class="body-content" align="center">
			<table border="1px solid gray" width="90%" height="200px;">
				<caption></caption>
				<tr class="first">
					<th width="11%"><input name="Button" value="打印" type="button"
						onclick="window.print()" class="button border-blue" id="in"
						style="margin-top: 10px" /></th>
					<th width="11%">星期一</th>
					<th width="11%">星期二</th>
					<th width="11%">星期三</th>
					<th width="11%">星期四</th>
					<th width="11%">星期五</th>
					<th width="11%">星期六</th>
					<th width="11%">星期日</th>
				</tr>
				<tr height="50px" style="vertical-align:middle;text-align: center">
					<th style="line-height: 100px;">上午</th>
					<td class="forenoon forenoon_first"></td>
					<td class="forenoon forenoon_second"></td>
					<td class="forenoon forenoon_third"></td>
					<td class="forenoon forenoon_fourth"></td>
					<td class="forenoon forenoon_fiveth"></td>
					<td class="forenoon forenoon_sixth"></td>
					<td class="forenoon forenoon_seventh"></td>
				</tr>
				<tr height="50px" style="vertical-align:middle;text-align: center">
					<th style="line-height: 100px;">下午</th>
					<td class="afternoon afternoon_first"></td>
					<td class="afternoon afternoon_second"></td>
					<td class="afternoon afternoon_third"></td>
					<td class="afternoon afternoon_fourth"></td>
					<td class="afternoon afternoon_fiveth"></td>
					<td class="afternoon afternoon_sixth"></td>
					<td class="afternoon afternoon_seventh"></td>
				</tr>
			</table>
		</div>
	</div>

</body>
</html>