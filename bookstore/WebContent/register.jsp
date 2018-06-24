<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
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

#all {
	margin: 0px auto;
	height: 700px;
	width: 100%;
	/*border: 1px solid red;*/
	/*background-color: red;*/
}

#head {
	height: 80px;
}
#head h2{
    color: red;
}
#head #but {
	/*border: 1px solid blue;*/
	margin-top: 25px;
	text-align: right;
	margin-right:50px;
}

#centre #left {
	border: 1px solid red;
	float: left;
	height: 600px;
	width: 30%;
	/*margin: 0px auto;*/
	position: relative;
	/*top: 50px;*/
	/*text-align: center;*/
	color: red;
}

#centre #left #left-min {
	/*border: 1px solid blue;*/
	width: 80%;
	margin: 0px auto;
	position: relative;
	top: 20%;
}

#centre #left #left-min h2 {
	text-align: center;
}

#centre #right {
	margin: 0px auto;
	height: 600px;
	width: 65%;
	float: right;
	text-align: center;
	position: relative;
	/*top: 50px;*/
}

#centre #right form {
	width: 80%;
	height: 100%;
	margin: 0px auto;
	/*border:1px solid red;*/
}

#centre #right input {
	height: 30px;
	width: 200px;
}

table tr {
	height: 30px;
}

#centre #submit {
	height: 50px;
	width: 20%;
	margin: 0px 5% 0px 5%;
}

#centre #reset {
	height: 50px;
	width: 20%;
	margin: 0px 10% 0px 5%;
}
#centre #submit:hover{
	background-color: cyan;
}
#centre #reset:hover{
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

	function validatePsw() {
		var psw = document.getElementById("password");
		var pswmsg = document.getElementById("passwordMsg");
		var Rpsw = document.getElementById("repassword");
		var Rmsg = document.getElementById("repasswordMsg");
		try {
			if (psw.value != "") {
				psw.className = "right";
				if (pswmsg != null) {
					pswmsg.innerHTML = "";
				}
				if (Rmsg != null) {
					Rmsg.innerHTML = "";
				}
				if (Rpsw.value != "") {
					if (psw.value != Rpsw.value) {
						if (Rmsg != null) {
							Rmsg.innerHTML = "<font color='red'> 两次密码不一致！";
						}
						psw.className = "wrong";
						Rpsw.className = "wrong";
					} else {
						psw.className = "right";
						Rpsw.className = "right";
						if (Rmsg != null) {
							Rmsg.innerHTML = "";

						}
						if (pswmsg != null) {
							pswmsg.innerHTML = "";
						}

					}
					return true;
				} else {
					Rpsw.className = "";
				}

			} else {
				psw.className = "wrong";
				Rpsw.className = "";
				if (pswmsg != null) {
					pswmsg.innerHTML = "<font color='red'> 输入内容不能为空！";
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
		var msg = document.getElementById("repasswordMsg");
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

	function validateTele() {
		var obj = document.getElementById("phone");
		var msg = document.getElementById("phoneMsg");
		try {
			if (obj.value != "") {
				obj.className = "right";
				if (msg != null) {
					msg.innerHTML = "";
				}
				validateRegex("phone", /^1[3|4|5|7|8][0-9]{9}$/);
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

	function validateQQ() {
		var obj = document.getElementById("QQ");
		var msg = document.getElementById("QQMsg");
		var NameMsg = document.getElementById("usernameMsg");
		var RpswMsg = document.getElementById("repasswordMsg");
		var TeleMsg = document.getElementById("phoneMsg");
		try {
			if (obj.value != "") {
				obj.className = "right";
				if (msg != null) {
					msg.innerHTML = "";
				}
				validateRegex("QQ", /^\d[0-9]{5,10}$/);
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
</script>
</head>

<body>
	<div id="all">
		<div id="centre">
			<div id="head">
				<h2>专属五邑大学的二手书城信息共享平台欢迎你的加入！！！</h2>
				<div id="but">
					<a href="index.jsp">首页</a> | <a href="login.jsp">登录</a>
				</div>
			</div>
			<br>
			<hr />
			<div id="left">
				<div id="left-min">
					<h2>注册注意事项</h2>
					<ol>
						<li>注册者需保证所有注册信息均真实有效</li>
						<li>网站所有人有权合理使用注册者的信息</li>
						<li>网站所有人对注册者信息具有保密义务</li>

					</ol>
					<br /> <input id="checkbox" type="checkbox" />我已阅读注意事项！
				</div>

			</div>
			<div id="right" align="center">
				<form action="registerServlet" method="post" >
					<table border="0px" width="400px" bordercolor="black">
						<tr>
							<td></td>
							<td align="left">注册信息</td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								
							</td>
						</tr>
		
						<tr>
							<td align="right">用&nbsp;户&nbsp;名：</td>
							<td><input type="text" name="username" id="username"
								value="" placeholder="请输入用户名" onblur="validateName()" /></td>
						</tr>
						<tr>
							<td></td>
							<td><span id="usernameMsg"></span></td>
						</tr>
						<tr>
							<td align="right">&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
							<td><input type="password" name="password" id="password"
								value="" placeholder="请输入密码" onblur="validatePsw()" /></td>
						</tr>
						<tr>
							<td></td>
							<td><span id="passwordMsg"></span></td>
						</tr>
						<tr>
							<td align="right">确认密码：</td>
							<td><input type="password" name="repassword" id="repassword"
								value="" placeholder="请重新输入密码" onblur="validateRPsw()" /></td>
						</tr>
						<tr>
							<td></td>
							<td><span id="repasswordMsg"></span></td>
						</tr>
						<tr>
							<td align="right">手机号码：</td>
							<td><input type="text" name="phone" id="phone" 
								placeholder="请输入手机号码" onblur="validateTele()" /></td>
						</tr>
						<tr>
							<td></td>
							<td><span id="phoneMsg"></span></td>
						</tr>
						<tr>
							<td align="right">Q&nbsp;&nbsp;&nbsp;&nbsp;Q：</td>
							<td><input type="text" name="QQ" id="QQ" value=""
								placeholder="请输入QQ" onblur="validateQQ()" /></td>
						</tr>
						<tr>
							<td></td>
							<td><span id="QQMsg"></span></td>
						</tr>
						<tr> 
						<td align="center">   
						     <input type="submit" id="submit" value="提交" /> 
						     </td>
						     <td align="center">
						     <input type="reset" id="reset" value="重置" />
						     </td>
						</tr>
					</table>
					
			    </form>
			</div>
			
		</div>
	</div>

</body>
</html>