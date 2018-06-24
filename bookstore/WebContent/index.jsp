<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="cn.abc.bookstore.domain.Book"%>
<%@page import="cn.abc.bookstore.tools.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>邑大二手书城</title>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 包含了所有编译插件 -->
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript">
	function loginAndRegister() {
		var yonghuming = document.getElementById("yonghuming").innerHTML;
		if (yonghuming.length != 0) {
			document.getElementById("loginAndRegister").style.display = "none";
		} else {
			document.getElementById("imformation").style.display = "none";
		}
	}
</script>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<style type="text/css">
#centre #centre-left #booktype li {
	text-align: center;
	padding: 10px 12px;
	list-style-type: none;
	/*border: 1px solid red;*/
	background-image: url(img/icon.gif);
	background-repeat: no-repeat;
	background-size: 100% 280%;
	background-position: 0px -28px;
}

#centre #centre-left #booktype #all-type {
	text-align: center;
	padding: 10px 12px;
	list-style-type: none;
	/*border: 1px solid red;*/
	background-image: url(img/icon.gif);
	background-repeat: no-repeat;
	background-size: 100% 130%;
	background-position: 0px 5px;
}

#centre #centre-left #booktype #all-type-last {
	text-align: center;
	padding: 10px 12px 15px 12px;
	list-style-type: none;
	/*border: 1px solid red;*/
	background-image: url(img/icon.gif);
	background-repeat: no-repeat;
	background-size: 100% 130%;
	background-position: 0px -15px;
}

#centre #centre-right #search-book {
	height: 100%;
	width: 100%;
	margin: opx auto;
}

#centre #centre-right #search-book .search {
	
	height: 80px;
	width: 90%;
	
}

#centre #centre-right #search-book .but {
	height: 80px;
	width: 90%;
}

#centre #centre-right #search-book .obj {
	height: 80px;
	width: 90%;
	/*border: 1px solid black;*/
	border-bottom: 1px solid red;
}

#centre #centre-right #search-book .obj .IMG {
	float: left;
	height: 100%;
	width: 29%;
	text-align: center;
	
}

#centre #centre-right #search-book .obj .IMG img {
	width: 80px;
	height: 70px;
	margin: 3px 5px;
}

#centre #centre-right #search-book .obj .bookinfo {
	width: 70%;
	height: 100%;
	float: right;
	
}

#centre #centre-right #search-book .obj .bookinfo .book {
	height: 100%;
	width: 40%;
	float: left;
	
}

#centre #centre-right #search-book .obj .bookinfo .book-price {
	height: 100%;
	width: 60%;
	float: right;
}

#centre #centre-right #search-book .obj .bookinfo .book-price .book-info {
	height: 100%;
	width: 50%;
	float: left;
}

#centre #centre-right #search-book .obj .bookinfo .book-price .price {
	height: 100%;
	width: 49%;
	line-height: 80px;
	float: right;
	text-align: center;
	
}
</style>
</head>
<body onload="loginAndRegister()">
	<div id="logoAll">
		<div id="logo">
			<div id="logo-left">
				<img src="img/logo.png" />
			</div>
			<div id="logo-right">
				<p id="p1">邑大二手书城</p>
				<p>www.wyubook.com</p>
			</div>
		</div>
		<div id="imformation">
			<img src="upload/${sessionScope.user.getPicture() }" /> <a
				href="userInfo.jsp" id="yonghuming">${sessionScope.user.getName()}</a>
			<a href="logoutServlet">注销</a>
		</div>
	</div>
	<nav class="navbar navbar-default" role="navigation" id="daohang">
	<div class="container-fluid" id="header">
		<div class="navbar-header" id="navbar-header">
			<a class="navbar-brand" href="#">邑大二手书城</a>
		</div>
		<ul class="nav navbar-nav">
			<li id="buybook"><a href="#sell-book">二手书市场</a></li>
			<li id="sellbook"><a href="#buy-book">求购清单</a></li>
			<form class="navbar-form navbar-left" role="search" id="searchbook"
				action="searchBookByBookNameServlet">
				<div class="form-group">
					<input type="text" class="form-control" name="bookname"
						placeholder="请输入要查找的书名">
				</div>
				<button type="submit" class="btn btn-default">查找</button>
			</form>
		</ul>
		<div id="loginAndRegister">
			<ul class="nav navbar-nav navbar-right">
				<li id="register"><a href="register.jsp"><span
						class="glyphicon glyphicon-user"></span> 注册</a></li>
				<li id="login"><a href="login.jsp"><span
						class="glyphicon glyphicon-log-in"></span> 登录</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<div id="centre">
		<div id="centre-left">
			<div id="booktype">
				<ul>
					<li id="all-type">全部分类</li>
					<li><a href="#type-jisuan">计算机类</a></li>
					<li><a href="#type-jingguan">经管类</a></li>
					<li><a href="#type-wenxue">文学类</a></li>
					<li><a href="#type-gongke">工科类</a></li>
					<li><a href="#type-tongyong">通用学科类</a></li>
					<li id="all-type-last"></li>
				</ul>
			</div>
		</div>
		<div id="centre-right">
			<div id="sell-book">
				<div class="t_sell"></div>
				<div class="pagesell"></div>
				<script type="text/javascript">
					var pageNoSell = 1;
					getListSell(pageNoSell);
				</script>
			</div>

			<div id="buy-book">
				<div class="t_buy"></div>
				<div class="pagebuy"></div>
				<script type="text/javascript">
					var pageNoBuy = 1; //定义是第几页  
					getListBuy(pageNoBuy);
				</script>
			</div>



			<!-- type -->
			<div id="type-jisuan">
				<div class="t_jisuan"></div>
				<div class="pageji"></div>
				<script type="text/javascript">
					var pageNoJi = 1;
					var typeJi = "计算机类";
					getType(pageNoJi, typeJi);
				</script>
			</div>
			<div id="type-jingguan">
				<div class="t_jingguan"></div>
				<div class="pagejing"></div>
				<script type="text/javascript">
					var pageNoJing = 1;
					var typeJing = "经管类";
					getType(pageNoJing, typeJing);
				</script>
			</div>
			<div id="type-wenxue">
				<div class="t_wenxue"></div>
				<div class="pagewen"></div>
				<script type="text/javascript">
					var pageNoWen = 1;
					var typeWen = "文学类";
					getType(pageNoWen, typeWen);
				</script>
			</div>
			<div id="type-gongke">
				<div class="t_gongke"></div>

				<div class="pagegong"></div>
				<script type="text/javascript">
					var pageNoGong = 1;
					var typeGong = "工科类";
					getType(pageNoGong, typeGong);
				</script>
			</div>
			<div id="type-tongyong">
				<div class="t_tongyong"></div>
				<div class="pagetong"></div>
				<script type="text/javascript">
					var pageNoTong = 1;
					var typeTong = "通用学科类";
					getType(pageNoTong, typeTong);
				</script>
			</div>

			<div id="search-book">
				<%
					Page<Book> pageBookByName = (Page<Book>) session.getAttribute("pageBookByName");
					if (null == pageBookByName) {
						return;
					} else {
						int currentPage = pageBookByName.getCurrentPage();
						int totalPage = pageBookByName.getTotalPage();
						List<Book> bookLists = pageBookByName.getLists();
						if (bookLists != null) {
							for (Book book : bookLists) {
				%>
				<div class="search">
					<div class="obj">
						<div class="IMG">
							<img src="upload/<%=book.getPicture()%>" />
						</div>
						<div class="bookinfo">
							<div class="book">
								<br />书名：<a id="BookName" href="Details?bookid=<%=book.getId() %>"><%=book.getBookname()%></a> <br />类别：<span><%=book.getBooktype()%></span>
							</div>
							<div class="book-price">
								<div class="book-info">
									<br/>作者：<span><%=book.getAuthor()%></span> <br /> 出版社：<span><%=book.getPublish()%></span>
								</div>
								<div class="price">
									价格：<span><%=book.getPrice()%>元</span>
								</div>
							</div>
						</div>
					</div>
				</div>
				<%
					}
						}
				%>
				<div class="but" align="center"
					style="font-size: 18px; margin-top: 20px;">
					<a href="searchBookByBookNameServlet?currentPage=1"
						style="margin-right: 20px;">首页</a> <a
						href="searchBookByBookNameServlet?currentPage=<%=currentPage - 1 < 1 ? 1 : currentPage - 1%>"
						style="margin-right: 20px;">上一页</a> <a
						href="searchBookByBookNameServlet?currentPage=<%=currentPage + 1 > totalPage ? totalPage : currentPage + 1%>"
						style="margin-right: 20px;">下一页</a> <a
						href="searchBookByBookNameServlet?currentPage=<%=totalPage%>"
						style="margin-right: 20px;">尾页</a> <span>共有<%=pageBookByName.getCount()%>条记录
					</span>
				</div>

			</div>
			<%
				}
			%>
		</div>


	</div>
</body>
</html>