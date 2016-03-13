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
	<s:push value=" powerBank">
		<s:form action="UpdatePowerBankAction">
			<s:property value="%{name}" />
			<s:hidden name="itemID" value="%{itemID}" />
			<s:textfield name="name" label="Name" value="%{name}" />
			<s:textfield name="price" label="Price" value="%{price}" />
			<s:select label="Select color" headerKey="-1"
				headerValue="Select color" name="color"
				list="%{@com.web.prepare.Constant@colors}" value="%{color}" />
			<s:textfield name="Capacity" label="Price" value="%{capacity}" />
			<s:textfield name="pic" label="Picture Name" value="%{pic}" />
			<s:textarea name="description" rows="4" cols="50">

			</s:textarea>
			<s:submit />
		</s:form>
	</s:push>
</body>
</html>