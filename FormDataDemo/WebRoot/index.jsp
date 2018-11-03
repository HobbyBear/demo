<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>

<body>

	<form action="<%=basePath%>/testServlet"  method="post" enctype="multipart/form-data">
		用户名：<input type="text" name="name"><br> 密码：<input
			type="text" name="pass"><br> 
			<input type="file" name="file"><br>
			<input type="submit"
			 value="提交"><br>
	</form>
	<hr>
	<form action="#" id="testForm">
		用户名：<input type="text" name="name"><br> 密码：<input
			type="text" name="pass"><br>
			 <input type="button"
			id="submit" value="提交"><br>
	</form>
	<script type="text/javascript">
		$(function() {
			$("#submit").click(function() {
				var dom = $("#testForm")[0];
				var formData = new FormData(dom);
				formData.append("name", $("input[name='name']").text());
				formData.append("pass", $("input[name='pass']").text());
				$.ajax({
					url : "<%=basePath%>/testServlet",
					type : "POST",
					data : formData,
					cache : false, // 不缓存数据
					processData : false, // 不处理数据
					contentType : false, // 不设置内容类型
					success : function(data) { //成功回调
						alert(data);
					}
				});
			})
		})
	</script>
</body>
</html>
