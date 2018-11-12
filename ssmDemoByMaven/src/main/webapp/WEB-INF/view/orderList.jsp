<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>订单页</title>

  </head>
  
  <body>
    	<c:forEach items="${requestScope.orderList }" var="o">
    		<div>商品订单详情:${o.detailOrder}</div>
    		<div>商品:${o.detailGoods }</div>
    		<div>价格:${o.detailPrice }</div>
    		<div>数量:${o.detailNum }</div>
    		<hr>
    	</c:forEach>
  </body>
</html>
