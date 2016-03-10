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
	<img
		src="<s:property value= "myService.imageLocation"/>/<s:property value = "shoe.pic"/>"
		width="400" height="300" />
	<ul>
		<li>Color: <s:property value="shoe.Color" /></li>
		<li>Price: <s:property value="shoe.price" /> $
		</li>
		<li>Size : <s:property value="shoe.shoeSize" /></li>
	</ul>
</body>
</html>