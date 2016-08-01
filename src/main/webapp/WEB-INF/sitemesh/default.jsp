<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<c:set property="application" var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Test-<decorator:title /></title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8"></meta>
<meta http-equiv="Cache-Control" content="max-age=5000000" />
<decorator:head />
</head>
<body>
	<div style="float: left;width: 23%">
		<img src="http://yadong0415.cn/dist/views/img/image.png" alt="" style="width: 100%;height: 100%;border-radius: 5px;"/>
	</div>
	<div style="margin-left: 24%;">
		<decorator:body />
	</div>
</body>
</html>