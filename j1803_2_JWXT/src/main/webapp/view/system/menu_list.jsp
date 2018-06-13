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
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="<%=path%>/css/pintuer.css">
<link rel="stylesheet" href="<%=path%>/css/admin.css">
<script src="<%=path%>/js/jquery.js"></script>
<script src="<%=path%>/js/pintuer.js"></script>
<!--分页  -->
<script type="text/javascript" src="<%=basePath%>js/kkpager/jpager.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/kkpager/jpager.css">
<script type="text/javascript" src="<%=basePath%>js/listPage.js"></script>
<script type="text/javascript">
 function load() {
	 arrayPage(${pagedResult.pages},${pagedResult.total});
 }
 $(function(){
	 var searchStyle="${searchStyle}";
	 var keywords="${keywords}";
	 
	 if(searchStyle=="menuName"){
		 $("#keywords").val(keywords); 
		 $("#searchStyle").val("menuName"); 
	 }else if(searchStyle=="menuDesc"){
		 $("#keywords").val(keywords); 
		 $("#searchStyle").val("menuDesc"); 
	 }else if(searchStyle=="pName"){
		 $("#keywords").val(keywords); 
		 $("#searchStyle").val("pName"); 
	 }
	 
 })
</script>
 
<title>菜单列表</title>
</head>
<body onload="load()">
<form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder">菜单列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="<%=basePath%>menuController/menuAddUI.do"> 增加</a> </li>
        <li>搜索：</li>
          <li>
            <select id="searchStyle" name="searchStyle" class="input" style="width:200px; line-height:17px;" >
              <option value="">请选择查询方式</option>
              <option value="pName">父菜单名称</option>
              <option value="menuName">菜单名称</option>
              <option value="menuDesc">菜单描述</option>
            </select>
          </li>
        <li>
          <input id="keywords" value="" type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <a href="javascript:void(0)" class="button border-main icon-search" id="search" > 搜索</a></li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="100" style="text-align:left; padding-left:20px;"></th>
        <th>父菜单</th>
        <th>菜单名</th>
        <th>菜单描述</th>
        <th>菜单路径</th>
        <th>创建时间</th>
        <th width="310">操作</th>
      </tr>
      <c:forEach items="${pagedResult.dataList }" var="menu">
        <tr>
          <td style="text-align:left; padding-left:20px;"><input type="checkbox" name="ids" value="${menu.menuId}" />
           </td>
          <td>${menu.pName }</td>
          <td>${menu.menuName }</td>
          <td>${menu.menuDesc }</td>
          <td>${menu.menuUrl }</td>
          <td>
          		<fmt:formatDate value="${menu.createTime }" pattern="yyyy-MM-dd"/>
          </td>
          <td>
	          <div class="button-group"> 
	          <a class="button border-main" href="<%=basePath%>menuController/menuUpdateUI.do?menuId=${menu.menuId}"><span class="icon-edit"></span> 修改</a>
	          <a class="button border-red" href="<%=basePath%>menuController/menuDel.do?menuId=${menu.menuId}" onclick="return confirm('你确定删除吗？')">
	          <span class="icon-trash-o"></span> 删除</a> 
	          </div>
           </td>
        </tr>
      </c:forEach>
      <tr>
		<td style="text-align: left;  padding-left: 20px;">
			<a href="javascript:void(0)" style="padding: 5px 15px;" class="button border-blue" id="checkall">
			 全选</a>
			</td>
			
		<td colspan="12" style="text-align: left; ">
			<a href="javascript:void(0)"
			class="button border-red icon-trash-o" style="padding: 5px 15px;"
			onclick="DelSelect()"> 批量删除</a>
		</td>
	  </tr>
      <tr>
	       <td colspan="13">
				<div align="center" id="jpager"></div>
  		   </td>
      </tr>
      
    </table>
  </div>
</form>
<script type="text/javascript">
//全选
$("#checkall").click(function(){ 
 	$("input[name='ids']").each(function(){
 		if(this.checked){
 			this.checked=false;
 		}else{
 			this.checked=true;
 		}
 	});
})
//查询
$("#search").click(function(){
	$("#listform").attr("action","<%=basePath%>menuController/listPage.do");
	$("#listform").submit();
})

function DelSelect(){
	var isSelect=false;
	$("input[name='ids']").each(function(){
 		if(this.checked){
 			isSelect=true;
 		}
 	});
	if(isSelect){
		var is=confirm("你确定那个删除吗？");
		if(is){
			$("#listform").attr("action","<%=basePath%>menuController/menusDel.do");
			$("#listform").submit();
		}
	}
	
}
</script>
</body>
</html>