
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
<title></title>
<link rel="stylesheet" href="<%=basePath%>css/pintuer.css">
<link rel="stylesheet" href="<%=basePath%>css/admin.css">
<script src="<%=basePath%>js/jquery.js"></script>
<script src="<%=basePath%>js/pintuer.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/kkpager/jpager.js"></script>
<script type="text/javascript"
	src="<%=basePath%>view/Score/listPage3.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/kkpager/jpager.css">
<script type="text/javascript"
	src="<%=basePath%>js/kkpager/listPage1.js"></script>
<script type="text/javascript">
        function load() {
        	arrayPage(${pageResult.pages},${pageResult.total});
        }
</script>
<script>
	$(function() {
		var array = new Array();
		<c:forEach items="${sub}" var="item" >
		array.push("${item}"); //对象，加引号       
		</c:forEach>
		for (var i = 0; i < array.length; i++) {
			$("#" + array[i]).attr("checked", "checked");
		}
	})
</script>
<script type="text/javascript">
$(document).ready(function(){ 
	  $("#button1").click(function(){  
        $("#form1").attr("action","<%=basePath%>userController/userpldelete.do");   
        $("#form1").submit();  
    });  
  $("#button2").click(function(){  
      $("#form1").attr("action","<%=basePath%>scoreController/selectStudentByName.do");   
      $("#form1").submit();  
  });  
});

</script>
</head>
<body onload="load()">
	<form method="post" id="form1"
		action="<%=basePath%>scoreController/selectStudentByName.do">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder">学生成绩维护</strong>
			</div>
			<div class="padding border-bottom">
				<ul class="search">
					<div class="form-group">
						<div class="label">
							<label><strong>按姓学生名查询：</strong></label>
						</div>
						<div class="field">
							<input type="text" class="input w50" name="str" />
							<div class="tips"></div>
							<button class="button bg-main icon-check-square-o" type="submit"
								id="button2">查询</button>
						</div>
					</div>
				</ul>

			</div>
			<table class="table table-hover text-center">
				<tr>
					<!-- <th width="300">ID</th> -->
					<th>学生姓名</th>
					<th>学生院系</th>
					<th>学生班级</th>
					<th>科目</th>
					<th>授课教师</th>

					<th>分数</th>
					<th colspan="2">用户操作</th>
				</tr>
				<tr>
					<c:forEach items="${pageResult.dataList}" var="score1">
						<%-- <td>${score1.scoreId}</td> --%>
						<td>${score1.sName}</td>
						<td>${score1.majorName}</td>
						<td>${score1.className}</td>
						<td>${score1.subjectName }</td>
						<td>${score1.tName}</td>
						<td>${score1.score}</td>
						<td></td>
						<td><div class="button-group">
								<a class="button border-red"
									href="<%=basePath%>scoreController/updateScore.do?scoreId=${score1.scoreId}"
									onclick="return del(1)"><span class="icon-pencil"></span>
									修改</a>
							</div></td>
				</tr>
				</c:forEach>
			</table>

		</div>
		<div id="jpager" align="center"></div>
	</form>
	<script type="text/javascript">
		function del(id) {
			if (confirm("您确定要修改吗?")) {
				return true;				    
			   }else{
				   window.event.returnValue = false;
			   }
			
		}
		function update(id) {
			if (confirm("您确定要删除吗?")) {
				return true;	
			}else{
				 window.event.returnValue = false;
			}
		}
		function onok(id) {
			if (confirm("您确定要给此用户分配权限吗?")) {
				return true;
			}else{
				 window.event.returnValue = false;
			}
		}
		function onrole(id) {
			if (confirm("您确定要给此用户分配角色吗?")) {
				return true;	
			}else{
				window.event.returnValue = false;
			}
		}
		$("#checkall").click(function() {
			$("input[name='userIds']").each(function() {
				if (this.checked) {
					this.checked = false;
				} else {
					this.checked = true;
				}
			});
		})

		function DelSelect() {
			var Checkbox = false;
			$("input[name='id[]']").each(function() {
				if (this.checked == true) {
					Checkbox = true;
				}
			});
			if (Checkbox) {
				var t = confirm("您确认要删除选中的内容吗？");
				if (t == false)
					return false;
			} else {
				alert("请选择您要删除的内容!");
				return false;
			}
		}
	</script>
</body>
</html>