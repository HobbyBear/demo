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
    
    <title>购物车页面</title>
  </head>
  
  <body>
  	
  	<form action="${pageContext.request.contextPath}/createOrder">
  	<input type="submit">
    <c:forEach items="${sessionScope.cart}" var="g">
		<dl>
			<dt>${g.goodsImg }</dt>
			<dd>${g.goodsName }</dd>
			<dd>${g.goodsPrice }</dd>
		</dl>
		<input type="text" value="${g.goodsId}" name="goodsId">
	</c:forEach>
	</form>
  </body>
</html>
