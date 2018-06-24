<%@page import="java.util.List"%>
<%@page import="cn.abc.bookstore.domain.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> </title>
<link rel="stylesheet" type="text/css" href="css/details.css">
</head>
<body>
<div  class="head">
		 <div class="head-nav">
   	     <ul>
   		   <li><a href="index.jsp">首页</a></li> 		 
      	 </ul>
        </div>
        
   </div>
  <div class="guodu">
  	
  </div>
   <div  class="concent"  >
   
      <div class="left" >
       <div class="left-img"  >
        <img alt=""   src="upload/${sessionScope.sellBook.getPicture() }" >
       </div>
       <div class="left-details" >
        
          
          <h2> 书名: ${sessionScope.sellBook.getBookname() } </h2>
          
           <h3>作者: ${sessionScope.sellBook.getAuthor() } </h3>
         &nbsp;&nbsp;&nbsp;&nbsp;        
           <h3>     类型: ${sessionScope.sellBook.getBooktype() } </h3> 
         <br>
                <h3> 出版社: ${sessionScope.sellBook.getPublish() } </h3>
         &nbsp;&nbsp;&nbsp;&nbsp; 
             <h3>  价格: ${sessionScope.sellBook.getPrice() } ￥ </h3> 
             <br />
          <h3>库存: ${sessionScope.sellBook.getPrice()}</h3>
       </div>
       <div class="left-seller"  >
         <div class="seller-t">
         	<img src="upload/${sessionScope.seller.getPicture() }" />
         </div>
         <div class="seller-info">
         	<h4>卖家：${sessionScope.seller.getName() }</h4>
         	<h4>联系方式: ${sessionScope.seller.getPhone() }</h4>
         	<h4>qq:${sessionScope.seller.getContact() }</h4>
         </div>
               
                 
        </div>
      </div>
      
      <div class="right" >
        
        <div class="right-like">
        	<div class="like-head">
        		<h4>猜你喜欢</h4>
        	</div>
        	<%
        	  List<Book> sellLike = (List<Book>)session.getAttribute("sellLike");
        	  for(Book like: sellLike)
        	  {
        	 %>
        	   <div class="like-v">
        		<div class="v-img">
        			<img src="upload/<%=like.getPicture() %>"/>
        		</div>
        		<div class="v-c">
        		    书名:<%=like.getBookname() %>
        		    价格:<%=like.getPrice() %>
        		</div>
        		
        	</div>
        	 <%
        	  }
        	%>
        	
        	
        </div>
      </div>
      
   </div>
</body>
</html>