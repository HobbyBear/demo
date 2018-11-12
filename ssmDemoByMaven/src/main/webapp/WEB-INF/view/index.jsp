<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>商品列表</title>
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
</head>

<body>
	<a href="${pageContext.request.contextPath }/toCart">跳转到购物车</a>
	<script type="text/javascript">
		$(function(){
		})
		function addItemToCart(g){
			$.ajax({
				type: "get",
				url: "addCart",
				data: "goodsId="+g,
				success: function(msg) {
					alert(msg);
				}
			});
		}
	</script>
	<c:forEach items="${requestScope.goodsList}" var="g">
		<form>
		
		</form>
		<dl>
			<dt>${g.goodsImg }</dt>
			<dd>${g.goodsName }</dd>
			<dd>${g.goodsPrice }</dd>
			<input type="checkbox" class="addCart" onclick="addItemToCart(${g.goodsId})"/>
		</dl>
	</c:forEach>
</body>
</html>
