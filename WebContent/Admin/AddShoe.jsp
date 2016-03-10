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
	<s:form action="AddShoeAction">
		<s:textfield name="name" label="Name" />
		<s:select label="Select shoe's color" headerKey="-1"
			headerValue="Select Color" list="shoeColors" name="Color" />
		<s:select label="Select shoe's size" headerKey="-1"
			headerValue="Select Size" list="shoeSizes" name="shoeSize" />
		<s:textfield name="price" label="Price" />
		<s:textfield name="pic" label="Picture Name" />
		<s:submit />
	</s:form>
</body>
</html>