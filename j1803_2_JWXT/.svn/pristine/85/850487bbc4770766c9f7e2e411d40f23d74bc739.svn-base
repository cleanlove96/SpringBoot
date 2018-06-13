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
<link rel="stylesheet" href="<%=basePath%>css/admin.css">
<script src="<%=basePath%>js/jquery.js"></script>
<script src="<%=basePath%>js/pintuer.js"></script>
<title>Insert title here</title>

</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>菜单修改</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=basePath%>menuController/menuUpdate.do">  
      <input type="hidden" class="input w50" value="${menu.menuId }" name="menuId"  />
      <input type="hidden" class="input w50" value="${menu.createTime }" name="createTime"  />
      <div class="form-group">
        <div class="label">
          <label>父菜单：</label>
        </div>
        <div class="field">
           <select id="pId" name="pId" style="padding: 5px 15px; border: 1px solid #ddd;">
				<c:forEach items="${menuList}" var="m">
					<option value="${m.menuId}">${m.menuName}</option>
				</c:forEach>
			</select>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>菜单名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${menu.menuName }" name="menuName" data-validate="required:请输入菜单名" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>菜单描述：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${menu.menuDesc }" name="menuDesc" data-validate="required:请输入菜单描述" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>菜单路径：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${menu.menuUrl }" name="menuUrl" data-validate="required:请输入菜单路径" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
<script type="text/javascript">
$(function(){
	 var pId="${menu.pId}";
	 $("#pId").val(pId); 
})
</script>
</body>
</html>