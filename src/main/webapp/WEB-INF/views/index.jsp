<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
	<div
		style="width: 98%; height: 500px; background-color: white; border: 2px solid gray; border-radius: 5px; padding-top: 20px; padding-left: 10px;">
		<div class="ipRecord">IP访问记录</div>
		<table width="60%" border="1">
			<tr>
				<th>ip</th>
				<th>count</th>
			</tr>
			<c:forEach items="${applicationScope.ipMap}" var="entry">
				<tr>
					<td>${entry.key }</td>
					<td>${entry.value[0] }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>

