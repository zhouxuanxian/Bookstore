/**
 * 
 */

function getListBuy(pageNoBuy) {
	$.ajax({
		type : "post",
		data : {
			"pageNoBuy" : pageNoBuy
		},
		url : "PageBuyIndex", // 后台url
		success : function(response) {
			var pageBuy = $.parseJSON(response); // 将json字符串解析成对象

			var page = pageBuy.pageList[0];
			var list = page.lists;
			var users = pageBuy.userList;
			var s = '';
			for (var i = 0; i < list.length; i++) {
				s += '<div class="obj">' + '<div class="img"><img src="upload/'
						+ list[i].picture + '"/></div>' + '<div  class="info">'
						+ '<div class="book-info"><br/>书名：' + list[i].bookname
						+ '<br/>作者 ：' + list[i].author + '</div>'
						+ '<div class="user-info"><br/>求购者：' + users[i].name
						+ '<br/>QQ：' + users[i].contact + '</div>'
						+ '</div></div>';
			}

			$(".t_buy").html(s);
			var s = '';

			s = '<a href="javascript:getListBuy(' + page.getTopPageNo
					+ ')" >第一页</a>' + '<a href="javascript:getListBuy('
					+ page.getPreviousPageNo + ')" >上一页</a>'
					+ '<a href="javascript:getListBuy(' + page.getNextPageNo
					+ ')" >下一页</a>' + '<a href="javascript:getListBuy('
					+ page.getBottomPageNo + ')" >最后一页</a>';

			$(".pagebuy").html(s).css({
				"margin-left" : "350px",
				"margin-top" : "120px"
			});
			$(".pagebuy a").css({
				"margin" : "20px"
			});
			$(".t_buy").css({

				"text-align" : "center",
				"margin-left" : "10%",
				"width" : "80%",
				"height" : "300px"
			});

			$(".t_buy .obj").css({
				"border-bottom" : "1px solid red",
				"height" : "80px",
				"width" : "90%",
				"margin" : " 15px 5%"
			});
			$(".t_buy .obj .img").css({
				"width" : "20%",
				"height" : "100%",
				"float" : "left"
			});
			$(".t_buy .obj .img img").css({
				"width" : "80%",
				"height" : "80%"
			});
			$(".t_buy .obj .info").css({
				"width" : "79%",
				"height" : "100%",
				"float" : "right"
			});
			$(".t_buy .obj .info .book-info").css({
				"width" : "50%",
				"height" : "100%",
				"float" : "left",
				"text-align" : "left"
			});
			$(".t_buy .obj .info .user-info").css({
				"width" : "49%",
				"height" : "100%",
				"float" : "right",
				"text-align" : "left"
			});

		}
	});

}

function getListSell(pageNoSell) {

	$.ajax({
				type : "post",
				data : {
					"pageNoSell" : pageNoSell
				},
				url : "PageSellIndex", // 后台url
				success : function(response) {

					var pageSell = $.parseJSON(response); // 将json字符串解析成对象
					var list = pageSell.lists;
					// alert(list)
					var s = '';

					for (var i = 0; i < list.length; i++) {
						// alert(list[i].bookname)
						 s += '<div class="obj"><div class="img"><img src="upload/' + list[i].picture + '"/></div><div  class="info">'
                		 +'<div class="name-type"><br/>书名：<a href="Details?bookid='+list[i].id+'">' + list[i].bookname + '</a>'   
                         +'<br/>类型 ：' + list[i].booktype + '</div>' 
                        +'<div class="info-price"><div class="book-info"><br/>作者：' + list[i].author + '' 
                         + '<br/>出版社：' + list[i].publish + '</div>'
                         + '<div class="book-price">价格：' + list[i].price + '</div></div>'+
                         '</div></div>';      
					}

					$(".t_sell").html(s);
					var s = '';

					s = '<a href="javascript:getListSell(' + pageSell.topPageNo
							+ ')" >第一页</a>'
							+ '<a href="javascript:getListSell('
							+ pageSell.previousPageNo + ')" >上一页</a>'
							+ '<a href="javascript:getListSell('
							+ pageSell.nextPageNo + ')" >下一页</a>'
							+ '<a href="javascript:getListSell('
							+ pageSell.bottomPageNo + ')" >最后一页</a>';

					$(".pagesell").html(s).css({
						"margin-left" : "350px",
						"margin-top" : "120px"
					});
					$(".pagesell a").css({
						"margin" : "20px"
					});
					$(".t_sell").css({

						"text-align" : "center",
						"margin-left" : "10%",
						"width" : "80%",
						"height" : "300px"
					});
					$(".t_sell .obj").css({
						"border-bottom" : "1px solid red",
						"height" : "80px",
						"width" : "90%",
						"margin" : " 15px 15px"
					});
					$(".t_sell .obj .img").css({
						"width" : "20%",
						"height" : "100%",
						"float" : "left"
					});
					$(".t_sell .obj .img img").css({
						"width" : "80%",
						"height" : "80%"
					});
					$(".t_sell .obj .info").css({
						"width" : "79%",
						"height" : "100%",
						"float" : "right"
					});
					$(".t_sell .obj .info .name-type").css({
						"width" : "30%",
						"height" : "100%",
						"float" : "left",
						"text-align" : "left"
					});
					$(".t_sell .obj .info .info-price").css({
						"width" : "65%",
						"height" : "100%",
						"float" : "right"
					});
					$(".t_sell .obj .info .info-price .book-info").css({
						"width" : "60%",
						"height" : "100%",
						"float" : "left",
						"text-align" : "left"
					});
					$(".t_sell .obj .info .info-price .book-price").css({
						"width" : "40%",
						"height" : "100%",
						"line-height" : "80px",
						"float" : "right"
					});
				}
			});

}

function getType(pageNo, type2) {

	$
			.ajax({
				type : "post",
				data : {
					"pageNoType" : pageNo,
					"type" : type2,
				},
				url : "PageTypeIndex", // 后台url
				success : function(response) {

					var pageType = $.parseJSON(response); // 将json字符串解析成对象
					var list = pageType.lists;
					var s = '';

					for (var i = 0; i < list.length; i++) {

						s += '<div class="obj"><div class="img"><img src="upload/'
								+ list[i].picture
								+ '"/></div><div  class="info">'
								+ '<div class="name-type"><br/>书名：<a href="Details?bookid='
								+ list[i].id
								+ '">'
								+ list[i].bookname
								+ '</a>'
								+ '<br/>类型 ：'
								+ list[i].booktype
								+ '</div>'
								+ '<div class="info-price"><div class="book-info"><br/>作者：'
								+ list[i].author
								+ ''
								+ '<br/>出版社：'
								+ list[i].publish
								+ '</div>'
								+ '<div class="book-price">价格：'
								+ list[i].price
								+ '</div></div>' + '</div></div>';
					}
					var t_ty = '';
					var page_ty = '';
					if (type2 == "计算机类") {
						t_ty = ".t_jisuan";
						page_ty = ".pageji";
					}
					if (type2 == "经管类") {
						t_ty = ".t_jingguan";
						page_ty = ".pagejing";
					}
					if (type2 == "文学类") {
						t_ty = ".t_wenxue";
						page_ty = ".pagewen";
					}
					if (type2 == "工科类") {
						t_ty = ".t_gongke";
						page_ty = ".pagegong";
					}
					if (type2 == "通用学科类") {
						t_ty = ".t_tongyong";
						page_ty = ".pagetong";
					}
					$(t_ty).html(s);
					var s = '';

					s = '<a href="javascript:getType(' + pageType.topPageNo
							+ ',\'' + type2 + '\')" >第一页</a>'
							+ '<a href="javascript:getType('
							+ pageType.previousPageNo + ',\'' + type2
							+ '\')" >上一页</a>' + '<a href="javascript:getType('
							+ pageType.nextPageNo + ',\'' + type2
							+ '\')" >下一页</a>' + '<a href="javascript:getType('
							+ pageType.bottomPageNo + ',\'' + type2
							+ '\')" >最后一页</a>';

					$(page_ty).html(s).css({
						"margin-left" : "350px",
					});
					$(page_ty + " a").css({
						"margin" : "20px"
					});
					$(t_ty).css({
						"text-align" : "center",
						"margin-left" : "15%",
						"width" : "80%",
						"height" : "85%",
					});
					$(t_ty + " .obj").css({
						"border-bottom" : "1px solid red",
						"height" : "80px",
						"width" : "90%",
						"margin" : " 15px 15px"
					});
					$(t_ty + " .obj .img").css({
						"width" : "20%",
						"height" : "100%",
						"float" : "left"
					});
					$(t_ty + " .obj .img img").css({
						"width" : "80%",
						"height" : "80%"
					});
					$(t_ty + " .obj .info").css({
						"width" : "79%",
						"height" : "100%",
						"float" : "right"
					});
					$(t_ty + " .obj .info .name-type").css({
						"width" : "30%",
						"height" : "100%",
						"float" : "left"
					});
					$(t_ty + " .obj .info .info-price").css({
						"width" : "65%",
						"height" : "100%",
						"float" : "right"
					});
					$(t_ty + " .obj .info .info-price .book-info").css({
						"width" : "60%",
						"height" : "100%",
						"float" : "left"
					});
					$(t_ty + " .obj .info .info-price .book-price").css({
						"width" : "40%",
						"height" : "100%",
						"line-height" : "80px",
						"float" : "right"
					});
				}
			});

}
