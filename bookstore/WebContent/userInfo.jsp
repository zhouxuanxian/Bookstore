<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="js/userInfo.js"></script>
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/userInfo.css" />
<style type="text/css">
.release {
	height: 100%;
	width: 80%;
	border-top: 1px solid black;
}

.release .form-rel {
	/*border: 1px solid blue;*/
	height: 80%;
	width: 80%;
	margin: 0px auto;
	margin-top: 50px;
}

.release .form-rel table {
	height: 100%;
	width: 100%;
}

.release .form-rel table tr {
	height: 45px;
}

.release .form-rel table tr .td-name {
	text-align: right;
}

.release .form-rel table tr input {
	height: 30px;
}

.release .form-rel table tr .td-1 {
	width: 65%;
	height: 30px;
}

.release .form-rel table tr .td-3 {
	text-align: center;
}

.release .form-rel table tr td {
	text-align: left;
}

.release .form-rel table tr .sub {
	height: 30px;
	width: 60px;
	text-align: center;
	margin-left: -180px;
}

.buybook {
	height: 100%;
	width: 80%;
	border-top: 1px solid black;
}

.buybook .form-buy {
	height: 50%;
	width: 80%;
	margin: 0px auto;
	margin-top: 50px;
}

.buybook .form-buy table {
	height: 100%;
	width: 100%;
}

.buybook .form-buy table tr {
	height: 45px;
}

.buybook .form-buy table tr input {
	height: 30px;
}

.buybook .form-buy table tr .td-name {
	text-align: right;
}

.buybook .form-buy table tr td {
	text-align: left;
}

.buybook .form-buy table tr .td-1 {
	text-align: center;
}

.buybook .form-buy table tr .td-1 .sub {
	height: 30px;
	width: 50px;
	text-align: center;
	margin-left: -180px;
}

button:hover {
	background-color: cyan;
}
</style>
</head>

<body>
	<div class="all">
		<div class="head-big">
			<div class="head">
				<div class="user">
					<h1>用户信息</h1>
				</div>
				<div class="user-direct">
					<div class="div-ul">
						<ul>
							<li><a href="#buy">欲购书籍</a></li>
							<li><a href="#sell">出售书籍</a></li>
							<li><a href="#gai">修改资料</a></li>
							<div class="dropdown">
								<a href="#" class="dropbtn">发布</a>
								<div class="dropdown-content">
									<a href="#release">二手书出售</a> <a href="#buybook">二手书求购</a>
								</div>
							</div>

						</ul>
					</div>

					<div class="user-but">
						<ul>
							<li><a href="userInfoLogoutServlet">注销</a></li>
							<li><a href="index.jsp">首页</a></li>
						</ul>
					</div>
				</div>

			</div>
		</div>

		<div class="centre">
			<div class="left">
				<div class="user-t">
					<img src="upload/${sessionScope.user.getPicture() }" alt="头像上传" />
				</div>
				<div class="user-info" align="center">
					<table>
						<tr>
							<td>用户名：</td>

							<td><span>${sessionScope.user.getName()}</span></td>
						</tr>

						<tr>
							<td>手&nbsp;&nbsp;&nbsp;机：</td>
							<td><span>${sessionScope.user.getPhone()}</span></td>
						</tr>
						<tr>
							<td>Q&nbsp;&nbsp;&nbsp;&nbsp;Q：</td>
							<td><span>${sessionScope.user.getContact()}</span></td>
						</tr>

					</table>
				</div>
			</div>
			<div class="right">
				<div class="right-context">
					<div class="buybook">
						<a name="buy"></a>
						<h2>欲购书籍</h2>
						<div class="t_buy"></div>
						<div class="pagebuy"></div>
						<script type="text/javascript">
							var pageNoBuy = 1; //定义是第几页  
							getListBuy(pageNoBuy);
						</script>
					</div>
					<div class="sellbook">
						<a name="sell"></a>
						<h2>出售书籍</h2>
						<div class="t_sell"></div>
						<div class="pagesell"></div>
						<script type="text/javascript">
							var pageNoSell = 1;
							getListSell(pageNoSell);
						</script>
					</div>
					<div class="xiugai">
						<a name="gai"></a>
						<h2>请输入新的资料</h2>
						<form id="in-put" action="UpdateInfo"
							enctype="multipart/form-data" method="post">
							<table class="table_in">
								<tr>
									<td>用户名：</td>
									<td><input type="text" name="name"
										value="${sessionScope.user.getName() }" /></td>
								</tr>
								<tr>
									<td>密&nbsp;&nbsp;码&nbsp;：</td>
									<td><input type="password" name="password"
										value="${sessionScope.user.getPassword() }" /></td>
								</tr>
								<tr>
									<td>手&nbsp;&nbsp;机&nbsp;：</td>
									<td><input type="text" name="phone"
										value="${sessionScope.user.getPhone() }" /></td>
								</tr>
								<tr>
									<td>Q&nbsp;&nbsp;Q&nbsp;&nbsp;:</td>
									<td><input type="text" name="contact"
										value="${sessionScope.user.getContact() }" /></td>
								</tr>
								<tr>
									<td>头像上传:</td>
									<td><input type="file" name="touxiang" /></td>
								</tr>
								<tr>
									<td colspan="2" align="center"><input type="submit"
										class="sub" value="提交修改" /></td>
								</tr>
							</table>
						</form>
					</div>

					<div class="release" id="release">

						<form class="form-rel" align="center" method="post"
							action="releaseServlet" enctype="multipart/form-data">
							<table>
								<tr>
									<td class="td-name">书&nbsp;&nbsp;&nbsp;&nbsp;名&nbsp;&nbsp;:</td>
									<td><input type="text" placeholder="请输入书名："
										name="bookname"></td>
								</tr>
								<tr>
									<td class="td-name">作&nbsp;&nbsp;&nbsp;&nbsp;者&nbsp;&nbsp;:</td>
									<td><input type="text" placeholder="请输入作者：" name="author"></td>
								</tr>
								<tr>
									<td class="td-name">价&nbsp;&nbsp;&nbsp;&nbsp;格&nbsp;&nbsp;:</td>
									<td><input type="text" placeholder="请输入价格：" name="price"></td>
								</tr>
								<tr>
									<td class="td-name">数&nbsp;&nbsp;&nbsp;&nbsp;量&nbsp;&nbsp;:</td>
									<td><input type="text" placeholder="请输入数量：" name="number"></td>
								</tr>
								<tr>
									<td class="td-name">出&nbsp;&nbsp;版&nbsp;&nbsp;社:</td>
									<td><input type="text" placeholder="请输入出版社："
										name="publish"></td>
								</tr>
								<tr>
									<td class="td-name">图书类别:</td>
									<td>
										<!-- <label for="type" >选择列表</label> --> <select class="tr-1"
										name="type">
											<option value="计算机类">计算机类</option>
											<option value="经管类">经管类</option>
											<option value="文学类">文学类</option>
											<option value="工科类">工科类</option>
											<option value="通用学科类">通用学科类</option>
									</select>

									</td>
								</tr>
								<tr>
									<td class="td-name">图书封面:</td>
									<td><input type="file" placeholder="请选择图片：" class="td-2"
										name="picture"></td>
								</tr>
								<tr>
									<td colspan="2" class="td-3"><button class="sub"
											type="submit">发布</button></td>
								</tr>
							</table>
						</form>
					</div>

					<div class="buybook" id="buybook">
						<form class="form-buy" align="center" method="post"
							action="buyBookServlet" enctype="multipart/form-data">
							<table>
								<tr>
									<td class="td-name">书&nbsp;&nbsp;名&nbsp;&nbsp;：</td>
									<td><input type="text" placeholder="请输入书名："
										name="bookname"></td>
								</tr>
								<tr>
									<td class="td-name">作&nbsp;&nbsp;者&nbsp;&nbsp;：</td>
									<td><input type="text" placeholder="请输入作者：" name="author"></td>
								</tr>

								<tr>
									<td class="td-name">图书封面：</td>
									<td><input type="file" placeholder="请选择上传图片："
										name="picture"></td>
								</tr>
								<tr>
									<td colspan="2" class="td-1"><button type="submit"
											class="sub">发布</button></td>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="footer">
			<br /> <br />
			<h2>邑大二手书城</h2>
		</div>
	</div>
</body>

</html>