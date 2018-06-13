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
<link rel="stylesheet" href="<%=basePath%>css/pintuer.css">
<link rel="stylesheet" href="<%=basePath%>css/student.css">
<script src="<%=basePath%>js/jquery.js"></script>
<script src="<%=basePath%>js/pintuer.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="panel student-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>密码修改</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=basePath%>personController/stuUpdate.do">  
      <input type="hidden" name="sId" value="${student.sId}">
      <input type="hidden" name="majorId" value="${student.majorId}">
      <input type="hidden" name="classId" value="${student.classId}">
      <input type="hidden" name="createTime" value="${student.createTime}">
      <input type="hidden" name="roleId" value="${student.roleId}">
      
      <div class="form-group">
        <div class="label">
          <label>姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${student.sName}" name="sName" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>性别：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${student.sex}" name="sex"  />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>籍贯：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${student.nativePlace}" name="nativePlace"  />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>年龄：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${student.age}" name="age"  />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit">确定</button>
        </div>
      </div>
    </form>
  </div>
</div>
<script type="text/javascript">
</script>
</body>
</html>