<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<script type="text/javascript">
		var path = '<%=path%>';
		var basePath = '<%=basePath%>';
	</script>
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/bootstrap.js"></script>
	<script src="<%=basePath%>js/base64_ie.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>qigscan/css/success.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.css">
	<title>提交成功</title>
	<style type="text/css">
	</style>
</head>
<body style="width:100%;height:100%;background-attachment: fixed; overflow-x: hidden; overflow-y: hidden;    margin: 0;" border="1px" margin="0px" padding="0px">
	<div class="pics_div">
		<div class="pics"></div>
	</div>
</body>
</html>
