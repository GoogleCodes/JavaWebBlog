<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Blog</title>
<meta charset="UTF-8">
<meta name=viewport
	content="initial-scale=1,maximum-scale=1,user-scalable=no,minimal-ui">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">

</head>

<body>
	<form action="FileUploadServlet" method="post" enctype="multipart/form-data">
    	<span>选择一个文件:</span>
	    <input type="file" name="file" />
	    <input type="file" name="file1" />
	    <input type="submit" value="上传" />
    </form>
</body>
</html>
