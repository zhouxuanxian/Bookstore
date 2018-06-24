<%@page import="cn.abc.bookstore.domain.User"%>
<%@page import="java.util.List"%>
<%@page import="cn.abc.bookstore.tools.Page"%>
<%@page import="cn.abc.bookstore.domain.Book"%>
<%@page import="cn.abc.bookstore.servlet.selectBookAllServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<title>后台管理系统</title>
<link rel="stylesheet" href="css/layui.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">

</head>
<body class="layui-layout-body">
<%
String admin_name = (String)session.getAttribute("admin_name");
if(null==admin_name){
	response.sendRedirect("/bookstore/admin/login.jsp");
	return;
}
%>
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">邑大二手书城</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"
					style="font-style: italic; font-size: 20px;">欢迎使用后台管理系统！</li>
			</ul>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <img
						src="http://t.cn/RCzsdCq" class="layui-nav-img"> <%=session.getAttribute("admin_name") %>
				</a></li>
				<li class="layui-nav-item"><a href="adminLogoutServlet">注销</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<li class="layui-nav-item layui-nav-itemed"><a class=""
						href="javascript:;">图书管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="#one">查询图书</a>
							</dd>
						</dl></li>

					<li class="layui-nav-item"><a href="javascript:;">用户管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="#two">添加用户</a>
							</dd>
							<dd>
								<a href="#three">查询用户</a>
							</dd>
						</dl></li>
				</ul>
			</div>
		</div>

		<div class="layui-body">
			<!-- 内容主体区域 -->
			<div style="padding: 15px; height: 570px; overflow: hidden; margin-top: 30px;">
				<div style="height: 600px;">
					<a name="one"></a>
					<p>&nbsp;</p>
					<div align="center">
						<!-- <p>查找图书</p>   -->
						<table class="table table-striped" style="width: 900px;">
							<caption style="text-align: center; font-size: 18px;">图书信息</caption>
							<thead>
								<tr>
									<th>ID</th>
									<th>书名</th>
									<th>作者</th>
									<th>价格</th>
									<th>库存</th>
									<th>类别</th>
									<th>出版社</th>
									<th>图片地址</th>
								</tr>
							</thead>
							<tbody>
								<%
									Page<Book> bookPage = (Page<Book>) session.getAttribute("bookPage");
									if (null==bookPage) {
										response.sendRedirect("/bookstore/admin/selectBookAllServlet");
										return;
									}
									int currentPage = bookPage.getCurrentPage();
									int totalPage = bookPage.getTotalPage();
									List<Book> bList = bookPage.getLists();
									for (Book book : bList) {
								%>

								<tr>
									<td><%=book.getId()%></td>
									<td><%=book.getBookname()%></td>
									<td><%=book.getAuthor()%></td>
									<td><%=book.getPrice()%></td>
									<td><%=book.getNumber()%></td>
									<td><%=book.getBooktype()%></td>
									<td><%=book.getPublish()%></td>
									<td><%=book.getPicture()%></td>
									<td><a href="deleteBookServlet?id=<%=book.getId()%>">删除</a></td>
								</tr>
								<%
									}
								%>
							</tbody>
						</table>
						<div style="width: 800px; font-size: 18px; margin-top: 20px;">
							<a href="selectBookAllServlet?currentPage=1"
								style="margin-right: 20px;">首页</a> <a
								href="selectBookAllServlet?currentPage=<%=currentPage - 1 < 1 ? 1 : currentPage - 1%>"
								style="margin-right: 20px;">上一页</a> <a
								href="selectBookAllServlet?currentPage=<%=currentPage + 1 > totalPage ? totalPage : currentPage + 1%>"
								style="margin-right: 20px;">下一页</a> <a
								href="selectBookAllServlet?currentPage=<%=totalPage%>"
								style="margin-right: 20px;">尾页</a>
						</div>
					</div>
				</div>
				<div style="height: 600px;">
					<a name="two"></a>
					<p>&nbsp;</p>
					<div align="center">
						<div class="add" align="center">
							<form action="addUserServlet" method="get">
								<div style="margin-top: 40px;">
									用户名&nbsp;&nbsp;<input type="text" name="username" />
								</div>
								<div style="margin-top: 40px;">
									密码&nbsp;&nbsp;<input type="text" name="password" />
								</div>
								<div style="margin-top: 40px;">
									电话&nbsp;&nbsp;<input type="text" name="phone" />
								</div>
								<div style="margin-top: 40px;">
									联系方式&nbsp;&nbsp;<input type="text" name="contact" />
								</div>
								<div align="center" style="margin-top: 40px;">
									<input type="submit" value="添加" />
								</div>
							</form>
						</div>

					</div>
				</div>
				<div style="height: 600px;">
					<a name="three"></a>
					<p>&nbsp;</p>
					<div align="center">
						<!-- <p>查找图书</p>   -->

						<table class="table table-striped" style="width: 800px;">
							<caption style="text-align: center; font-size: 18px;">用户信息</caption>
							<thead>
								<tr>
									<th>ID</th>
									<th>用户名</th>
									<th>密码</th>
									<th>电话</th>
									<th>联系方式</th>
								</tr>
							</thead>

							<tbody>
								<%
									Page<User> userPage = (Page<User>) session.getAttribute("userPage");
									if (null==userPage) {
										response.sendRedirect("/bookstore/admin/selectUserServlet");
										return;
									}
									int currentPage1 = userPage.getCurrentPage();
									int totalPage1 = userPage.getTotalPage();
									List<User> uList = userPage.getLists();
									for (User user : uList) {
								%>

								<tr>
									<td><%=user.getId()%></td>
									<td><%=user.getName()%></td>
									<td><%=user.getPassword()%></td>
									<td><%=user.getPhone()%></td>
									<td><%=user.getContact()%></td>
								</tr>
								<%
									}
								%>

							</tbody>

						</table>
						<div style="width: 800px; font-size: 18px; margin-top: 20px;">
							<a href="selectUserServlet?currentPage1=1"
								style="margin-right: 20px;">首页</a> <a
								href="selectUserServlet?currentPage1=<%=currentPage1 - 1 < 1 ? 1 : currentPage1 - 1%>"
								style="margin-right: 20px;">上一页</a> <a
								href="selectUserServlet?currentPage1=<%=currentPage1 + 1 > totalPage1 ? totalPage1 : currentPage1 + 1%>"
								style="margin-right: 20px;">下一页</a> <a
								href="selectUserServlet?currentPage1=<%=totalPage1%>"
								style="margin-right: 20px;">尾页</a>
						</div>
					</div>



				</div>
			</div>

		</div>

		<div class="layui-footer" align="center">
			<!-- 底部固定区域 -->
			专属五邑大学二手书城
		</div>
	</div>
	<script src="layui.js"></script>
	<script>
		//JavaScript代码区域
		layui.use('element', function() {
			var element = layui.element;

		});
	</script>
	<script src="../js/bootstrap.min.js"></script>
    <script src="../js/jquery.min.js"></script>
</body>
</html>