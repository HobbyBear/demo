<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>z-treeDemo</title>
	<script type="text/javascript" src="js/jquery.min.js"></script>
		<link rel="stylesheet" href="zTree_v3-master/css/zTreeStyle/zTreeStyle.css" />
		<script type="text/javascript" src="zTree_v3-master/js/jquery.ztree.core.js"></script>
		
  </head>
  
  <body>
    <div>
			<ul id="treeDemo" class="ztree"></ul>
		</div>

		<script type="text/javascript">
			var zTreeObj;

			var setting = {
				async: {
					enable: true,
					url: "http://localhost:8080/Z-treeDemo/getGoodsTypeList.do",
					autoParam: ["id"],
					type: "get"
				},
				data: {
					simpleData: {
						enable: true,
						idKey: "id",
						pIdKey: "pid",
						rootPId: 0
					}
				}
			}

			$(document).ready(function() {
				zTreeObj = $.fn.zTree.init($("#treeDemo"), setting);
			});
		</script>
  </body>
</html>
