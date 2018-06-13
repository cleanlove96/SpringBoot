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
<title>登录</title>
<link rel="stylesheet" href="<%=basePath%>css/pintuer.css">
<link rel="stylesheet" href="<%=basePath%>css/admin.css">
<script src="<%=basePath%>js/jquery.js"></script>
<script src="<%=basePath%>js/pintuer.js"></script>
<style type="text/css">  
        #code{  
        	width:80px;
        	height:46px;
            font-family:Arial;  
            font-style:italic;  
            font-weight:bold; 
            font-size:16px; 
            border:0;  
            letter-spacing:2px;  
            color:blue;  
            background-color: #F8E278;
        }  
</style>  
</head>
<body>
	<div class="bg"></div>
	<div class="container">
		<div class="line bouncein">
			<div class="xs6 xm4 xs3-move xm4-move">
				<div style="height: 150px;"></div>
				<div class="media media-y margin-big-bottom"></div>
				<form action="<%=basePath%>userController/login.do" method="post">
					<div class="panel loginbox">
						<div class="text-center margin-big padding-big-top">
							<h1>教务系统</h1>
							<font color="red">${loginError}</font>
						</div>
						<div class="panel-body"
							style="padding: 30px; padding-bottom: 10px; padding-top: 10px;">
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="text" class="input input-big" name="loginName"
										placeholder="用户名" data-validate="required:请填写账号" /> <span
										class="icon icon-user margin-small"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="password" class="input input-big" name="password"
										placeholder="登录密码" data-validate="required:请填写密码" /> <span
										class="icon icon-key margin-small"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="field">
									<input type="text" class="input input-big" name="input_code" id="input_code"
										placeholder="验证码" data-validate="required:请填写验证码"/>
									<input type="button" id="code" onclick="createCode()" style="position: absolute;right:0;bottom:0;border:1px solid green;"/>  
								</div>
							</div>
						
						</div>
						<div style="padding: 30px;">
							<input type="submit"
								class="button button-block bg-main text-big input-big"
								value="登录" onclick="return validate()">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	 <script type="text/javascript">
          var code ; //在全局定义验证码   
        //产生验证码         
        $(function (){
        	code = "";   
            var codeLength = 4;//验证码的长度  
            var checkCode = document.getElementById("code");   
            var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R',  
            'S','T','U','V','W','X','Y','Z');//随机数  
            for(var i = 0; i < codeLength; i++) {//循环操作  
               var index = Math.floor(Math.random()*36);//取得随机数的索引（0~35）  
               code += random[index];//根据索引取得随机数加到code上  
           }  
           checkCode.value = code;//把code值赋给验证码
        });  
          
          
        function createCode(){  
            code = "";   
            var codeLength = 4;//验证码的长度  
            var checkCode = document.getElementById("code");   
            var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R',  
            'S','T','U','V','W','X','Y','Z');//随机数  
            for(var i = 0; i < codeLength; i++) {//循环操作  
               var index = Math.floor(Math.random()*36);//取得随机数的索引（0~35）  
               code += random[index];//根据索引取得随机数加到code上  
           }  
           checkCode.value = code;//把code值赋给验证码
       }    
          
        //校验验证码  
        function validate(){  
        	var is = "";
            var inputCode = document.getElementById("input_code").value.toUpperCase(); //取得输入的验证码并转化为大写        
            if(inputCode.length <= 0) { //若输入的验证码长度为0  
                alert("请输入验证码！"); //则弹出请输入验证码 
                is =  false;
            }         
            else if(inputCode != code ) { //若输入的验证码与产生的验证码不一致时  
                alert("验证码输入错误！"); //则弹出验证码输入错误  
                createCode();//刷新验证码  
                document.getElementById("input_code").value = "";//清空文本框  
                is = false;
            }         
            else { //输入正确时  
                is = true;
            }     
            return is;
        }  
    </script>
</body>
</html>