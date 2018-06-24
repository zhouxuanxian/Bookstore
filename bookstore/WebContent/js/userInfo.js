function getListBuy(pageNoBuy) {	
	$.ajax({
		type : "post",
		data : {
			"pageNoBuy" : pageNoBuy
		},
		url : "PageBuyServlet", // 后台url
		success : function(response) {

			var pageBuy = $.parseJSON(response); // 将json字符串解析成对象
			// var page = pageBuy.pageList[0];
			var list = pageBuy.lists;
			var s = '';
			
			for (var i = 0; i < list.length; i++) {

				s += '<div class="obj">' 
					+ '<div class="img"><img src="upload/'+ list[i].picture + '"/></div>' 
					+ '<div  class="info">'
						+ '<div class="book-info"><br/>书名：' + list[i].bookname+ '</div>'
						+'<div class="user-info">'
						+'<div class="author"><br/>作者 ：'+ list[i].author + '</div>'
						+'<div class="but"><br/><a href="deleteBuyBookServlet?id='+list[i].id+'">删除</a></div>'
						+'</div></div></div>'; 
			}

			$(".t_buy").html(s);
			var s = '';

			s = '<a href="javascript:getListBuy(' + pageBuy.topPageNo
					+ ')" >第一页</a>' + '<a href="javascript:getListBuy('
					+ pageBuy.previousPageNo + ')" >上一页</a>'
					+ '<a href="javascript:getListBuy(' + pageBuy.nextPageNo
					+ ')" >下一页</a>' + '<a href="javascript:getListBuy('
					+ pageBuy.bottomPageNo + ')" >最后一页</a>';

			$(".pagebuy").html(s).css({
				"margin-left" : "150px",
				"margin-top" : "0px",
					
			});
			$(".pagebuy a").css({
				"color":"black",
				"margin" : "20px"
			});
			$(".t_buy").css({

				"text-align" : "center",
				"margin-left" : "5%",
				"width" : "93%",
				"height" : "300px",

			});

			$(".t_buy .obj").css({
				"border-bottom" : "1px solid red",
				"height" : "80px",
				"width" : "100%",
				"margin" : " 15px 10px",
				"font-size": "15px"
			});
			$(".t_buy .obj .img").css({
				"width" : "20%",
				"height" : "100%",
				"float" : "left"
			});
			$(".t_buy .obj .img img").css({
				"width" : "80%",
				"height" : "80%",
				"margin-top":"7px"
				
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
				"text-align" : "left",
				"margin-top" : "0px"
			});
			$(".t_buy .obj .info .user-info .author").css({
				"width" : "40%",
				"height" : "100%",
				"float" : "left",
				"text-align" : "left",
				"margin-top" : "0px"
			});
			$(".t_buy .obj .info .user-info .but").css({
				"width" : "49%",
				"height" : "100%",
				"float" : "right",
				"text-align" : "center",
				"margin-top" : "0px"
			});
			$(".t_buy .obj .info .user-info .but a").css({
				"width" : "60px",
				"height" : "40px",
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
				url : "PageSellSevlet", // 后台url
				success : function(response) {

					var pageSell = $.parseJSON(response); // 将json字符串解析成对象
					var list = pageSell.lists;
					var s = '';
					for (var i = 0; i < list.length; i++) {

						s += '<div class="obj"><div class="img"><img src="upload/'
								+ list[i].picture
								+ '"/></div><div  class="info">'
								+ '<div class="name-type">书名：<a href="Details.servlet?bookid='
								+ list[i].id
								+ '">'
								+ list[i].bookname
								+ '</a>'
								+ '<br/>类型 ：'
								+ list[i].booktype
								+ '</div>'
								+ '<div class="info-price"><div class="book-info">作者：'
								+ list[i].author
								+ ''
								+ '<br/>出版社：'
								+ list[i].publish
								+ '</div>'
								+ '<div class="book-price">'
								+'<div class="price">价格：'
								+ list[i].price+ '</div>'
								+'<div class="but"><br/><a href="deleteSellBookServlet?bookid='+list[i].id+'">删除</a></div>'
								+'</div></div>' + '</div></div>';

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
						"margin-left" : "300px",
						
					});
					$(".pagesell a").css({
						"color":"black",
						"margin" : "15px"
					});
					$(".t_sell").css({

						"text-align" : "center",
						"margin-left" : "5%",
						"width" : "93%",
						"height" : "300px",

					});
					$(".t_sell .obj").css({
						"border-bottom" : "1px solid red",
						
						"text-align":"left",
						"height" : "80px",
						"width" : "100%",
						"margin" : " 15px 10px",
						"font-size": "15px"
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
						"color":"black",
						"height" : "100%",
						"float" : "left"
					});
					$(".t_sell .obj .info .name-type a").css({						
						"color":"black"
					});
					$(".t_sell .obj .info .info-price").css({
						"width" : "69%",
						"height" : "100%",
						"float" : "right"
					});
					$(".t_sell .obj .info .info-price .book-info").css({
						"width" : "49%",
						"height" : "100%",
						"float" : "left"
					});
					$(".t_sell .obj .info .info-price .book-price").css({
						"width" : "50%",
						"height" : "100%",
						"float" : "right"
					});
					$(".t_sell .obj .info .info-price .book-price .price").css({
						"width" : "50%",
						"height" : "100%",
						"line-height" : "80px",
						"float" : "left"
					});
					$(".t_sell .obj .info .info-price .book-price .but").css({
						"width" : "49%",
						"height" : "100%",
						"float" : "right",
						"text-align" : "center",
					});
					$(".t_sell .obj .info .info-price .book-price .but a").css({
						"width" : "60px",
						"height" : "40px",
					});
				}
			});

}
