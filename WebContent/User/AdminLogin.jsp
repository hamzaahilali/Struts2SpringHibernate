<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
input[type=text] {
	width: 100%;
	box-sizing: border-box;
	border: 2px solid #ccc;
	border-radius: 10px;
	font-size: 16px;
	background-color: white;
	background-image: url('searchicon.png');
	background-position: 10px 10px;
	background-repeat: no-repeat;
	padding: 12px 20px 12px 40px;
}

input[type=password] {
	width: 100%;
	box-sizing: border-box;
	border: 2px solid #ccc;
	border-radius: 10px;
	font-size: 16px;
	background-color: white;
	background-image: url('searchicon.png');
	background-position: 10px 10px;
	background-repeat: no-repeat;
	padding: 12px 20px 12px 40px;
}

input[type=submit] {
	background-color: #4CAF50;
	border: none;
	border-radius: 16px;
	color: white;
	padding: 16px 32px;
	text-decoration: none;
	margin: 4px 2px;
	cursor: pointer;
	color: white;
	font-size: 18px;
}

div.login {
	border-color: green;
	border-style : solid;
	padding: 30px;
	width: 400px;
	margin: auto;
	border-style: solid
}

label {
	font-size: 18px;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<div class='login'>
		<s:form action="AdminLoginAction">
			<s:textfield name="adminName" label="Admin Name" />
			<s:password name="password" label="Password    " />
			<s:submit value="Login" />
		</s:form>
	</div>
</body>
</html>