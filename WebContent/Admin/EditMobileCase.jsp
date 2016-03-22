<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/jquery.leanModal.min.js"></script>
<script type="text/javascript" src="js/simply-toast.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" />
<link rel="stylesheet" href="css/product.css" />
<link type="text/css" rel="stylesheet" href="css/style.css" />
<link type="text/css" rel="stylesheet" href="css/simply-toast.css" />
<title>Insert title here</title>
</head>
<body>
	<div style="margin-left: 50px; width: 600px">
		<s:push value=" mobileCase">
			<s:form action="UpdateMobileCaseAction">
				<s:property value="%{name}" />
				<s:hidden name="itemID" value="%{itemID}" />
				<s:textfield name="name" label="Name" value="%{name}" />
				<s:textfield name="price" label="Price" value="%{price}" />
				<s:select label="Select color" headerKey="-1"
					headerValue="Select color" name="color"
					list="%{@com.web.prepare.Constant@colors}" value="%{color}" />
				<s:textfield name="pic" label="Picture Name" value="%{pic}" />
				<s:textarea name="description" rows="4" cols="50">

				</s:textarea>
				<s:submit />
			</s:form>
		</s:push>
	</div>
</body>
</html>