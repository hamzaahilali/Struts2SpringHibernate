<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:include value="/Header/Header.jsp" />
	<br>

	<s:push value="mobileCase">
		<ul>
			<img src="<s:url value="/Image/MobileCase/%{pic}_Large.jpg"/>"
				width="400" height="400" />
			<li>Name: <s:property value="name" /></li>
			<li>Color: <s:property value="color" /></li>
			<li>Price: <s:property value="price" /> $
			</li>
			<li>Description: <s:property value="description" />
			</li>

		</ul>
	</s:push>
</body>
</html>