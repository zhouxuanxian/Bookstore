<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>邑大二手书城</title>
<link href="css/login.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="login_box">
      <div class="login_l_img"><img src="img/login-img.png" /></div>
      <div class="login">
          <div class="login_logo"><a href="# "><img src="img/login_logo.png" /></a></div>
          <div class="login_name">
               <p>邑大二手书城</p>
          </div>
          <form method="post" action="userLoginServlet">
              <input name="username" type="text"  value="用户名" onfocus="this.value=''" onblur="if(this.value==''){this.value='用户名'}">
              <span id="password_text" onclick="this.style.display='none';document.getElementById('password').style.display='block';document.getElementById('password').focus().select();" >密码</span>
              <input name="password" type="password" id="password" style="display:none;" onblur="if(this.value==''){document.getElementById('password_text').style.display='block';this.style.display='none'};"/>
              <input value="登录" style="width:100%;" type="submit">
              <div id="login-bot">
						<div id="login-bot-left">
							<a href="findPassword.jsp">忘记密码？</a>
						</div>
						<div id="login-bot-right">
							<a href="register.jsp">没有账号？</a>
						</div>	
			 </div>
          </form>
      </div>
      <div class="copyright">邑大二手书城 版权所有©2018-2020 技术支持电话：15015054637</div>
</div>
</body>
</html>
		