<%@page import="cn.abc.bookstore.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

.wrong {
	background: #F5F5F5;
	font-size: bold;
	border: 1px #ff0000 solid;
	color: #000000;
}

.right {
	background: #F5F5F5;
	font-weight: bold;
	border: 1px #00ff00 solid;
	color: #000000;
}

#passed {
	background-color: deepskyblue;
}

.active {
	background-color: whitesmoke;
}

#all {
	height: auto;
	width: 100%;
	margin-top: 25px;
}

.nav {
	/*background-color: burlywood;*/
	height: 80px;
	/*border: 1px solid red;*/
}

.nav ul {
	height: 100%;
	/*background-color: burlywood;*/
	list-style: none;
	padding-top: 14px;
	text-align: center;
	/*border: 1px solid blue;*/
}

.nav ul li {
	background-color: white;
	margin-left: 8%;
	float: left;
	height: 50px;
	width: 15%;
	
}

.nav ul li div {
	height: 100%;
}

#main {
	/*border: 1px solid red;*/
	height: 250px;
	margin-top: 30px;
	text-align: center;
	overflow: hidden;
}

#first {
	height: 100%;
	width: 100%;
	/*border: 1px solid red;*/
}

#first p {
	margin-left: -140px;
}

input {
	margin: 10px 0px;
	height: 25px;
}

#second {
	height: 100%;
	width: 100%;
	/*border: 1px solid red;*/
}

#third {
	height: 100%;
	width: 100%;
	/*border: 1px solid red;*/
}

#third p {
	margin-left: -100px;
}

#last {
	height: 100%;
	width: 100%;
	/*border: 1px solid red;*/
}

#last button {
	margin-top: 50px;
	height: 50px;
	width: 150px;
}

button {
	margin-top: 5px;
	height: 25px;
	width: 60px;
}

button:hover {
	background-color: cyan;
}
</style>
<script type="text/javascript">
	function validateRegex(eleName, regex) {
		var obj = document.getElementById(eleName);
		var msg = document.getElementById(eleName + "Msg");
		if (regex.test(obj.value)) {

			obj.className = "right";
			if (msg != null) {
				msg.innerHTML = "";
			}
			return true;
		} else {
			obj.className = "wrong";
			if (msg != null) {
				msg.innerHTML = "<font color='red'> 输入内容有误！";
			}
			return false;
		}
	}
	function validateName() {
		var obj = document.getElementById("username");
		var msg = document.getElementById("usernameMsg");
		try {
			if (obj.value != "") {
				obj.className = "right";
				if (msg != null) {
					msg.innerHTML = "";
				}
				return true;
			} else {
				obj.className = "wrong";
				if (msg != null) {
					msg.innerHTML = "<font color='red'> 输入内容不能为空！";
				}
				return false;
			}
		} catch (Exception) {
			return false;
		}
	}
	function validatephone() {
		var obj = document.getElementById("all-phone");
		var msg = document.getElementById("all-phoneMsg");
		try {
			if (obj.value != "") {
				obj.className = "right";
				if (msg != null) {
					msg.innerHTML = "";
				}
				validateRegex("all-phone", /^1[3|4|5|7|8][0-9]{9}$/);
				return true;
			} else {
				obj.className = "wrong";
				if (msg != null) {
					msg.innerHTML = "<font color='red'> 输入内容不能为空！";
				}
				return false;
			}
		} catch (Exception) {
			return false;
		}
	}
	function validatePsw() {
		var psw = document.getElementById("password");
		var msg = document.getElementById("passwordMsg");
		var Rpsw = document.getElementById("repassword");
		try {
			if (psw.value != "") {
				psw.className = "right";
				if (msg != null) {
					msg.innerHTML = "";
				}
				if (Rpsw.value != "") {
					if (psw.value != Rpsw.value) {
						if (msg != null) {
							msg.innerHTML = "<font color='red'> 两次密码不一致！";
						}
						psw.className = "wrong";
						Rpsw.className = "wrong";
					} else {
						psw.className = "right";
						Rpsw.className = "right";
						if (msg != null) {
							msg.innerHTML = "";

						}
					}
					return true;
				} else {
					Rpsw.className = "";
				}

			} else {
				psw.className = "wrong";
				Rpsw.className = "";
				if (msg != null) {
					msg.innerHTML = "<font color='red'> 输入内容不能为空！";
				}
				return false;
			}
		} catch (Exception) {
			return false;
		}
	}

	function validateRPsw() {
		var psw = document.getElementById("password");
		var rpsw = document.getElementById("repassword");
		var msg = document.getElementById("passwordMsg");

		try {
			if (rpsw.value != "") {
				if (psw.value != rpsw.value) {
					if (msg != null) {
						msg.innerHTML = "<font color='red'> 两次密码不一致！";
					}
					psw.className = "wrong";
					rpsw.className = "wrong";
				} else {
					psw.className = "right";
					rpsw.className = "right";
					if (msg != null) {
						msg.innerHTML = "";
					}

				}
				return true;
			} else {
				rpsw.className = "wrong";
				if (msg != null) {
					msg.innerHTML = "<font color='red'> 输入内容不能为空！";
				}
				return false;
			}
		} catch (Exception) {
			return false;
		}

	}
	function first() {
		var div = document.getElementById("first");

		div.value = "second";
		alert(div.value);

	}
</script>
</head>

<body>
	<div id="all">
		<div class="nav">
			<ul>
				<li>
					<div class="active" id="passed">
						<p>1</p>
						<p>填写帐号</p>
					</div>
				</li>
				<li>
					<div class="active" id="<%=session.getAttribute("passed2") %>">
						<p>2</p>
						<p>身份验证</p>
					</div>
				</li>
				<li>
					<div class="active" id="<%=session.getAttribute("passed3") %>">
						<p>3</p>
						<p>设置新密码</p>
					</div>
				</li>
				<li>
					<div class="active" id="<%=session.getAttribute("passed4") %>">
						<p>4</p>
						<p>完成</p>
					</div>
				</li>
			</ul>
		</div>
		<hr />
		<div id="main">
			<div id="first">
				<form action="findPasswordServlet" method="post">
				<br />
				<p>账号：</p>
				<input type="text" name="username" placeholder="请输入用户账号"
					onblur="validateName()" /> <br />
				<span id="usernameMsg"></span> <br />
			    <input  type="submit" value="确认"/>
				</form>


			</div>
			<div id="second">
				<form action="findPasswordFromPhoneServlet" method="post">
					<br />
					<p>请输入你的注册手机号码：</p>
					<%
                          String phone = (String)session.getAttribute("phone");
					      if(phone==null||phone.length()<=0){
					    	  phone="xxxxxxxxxxx";
					      }
					%>
					<span id="Hid-phone"><%=phone.substring(0, 3) %>****<%=phone.substring(7, 11)%></span> <br /> 
					<input type="text" id="all-phone" placeholder="请输入完整的手机号码" class="init"
						onblur="validatephone()" name="phone" /><br /> 
						<span id="all-phoneMsg"></span><br />
					  <input  type="submit" value="确认"/>
				</form>

			</div>
			<div id="third">
				<form action="findPasswordSetpdServlet" method="post">
					<br />
					<p>新密码：</p>
					<input type="password" id="password" placeholder="请输入新密码"
						class="init" onblur="validatePsw()" name="password"/><br />
					<p>确认密码：</p>
					<input type="password" id="repassword" name="repassword" placeholder="请再次输入密码"
						class="init" onblur="validateRPsw()" /><br /> <span
						id="passwordMsg"></span> <br />
		            <input  type="submit" value="确认"/>
				</form>

			</div>
			<div id="last">
				<button>
					<a href="login.jsp">登录</a>
				</button>
			</div>
		</div>
	</div>
</body>

</html>