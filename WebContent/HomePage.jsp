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
	<a href="<s:url action="LoginFormAction"/>"> Login</a>
	<a href="<s:url action="RegisterFormAction"/>"> Register</a>
	<a href="<s:url action="SuccessLoginAction"/>"> RegisterSuccess</a>
	<br>
	<br> Shoe Table
	<table id="ItemOfShoe" border="1">
		<tr>
			<th>No</th>
			<th>Color</th>
			<th>Price</th>
			<th>Shoe Size</th>
			<th>Order</th>

		</tr>
		<s:iterator value="listOfShoe" var="shoe" status = "rowStatus">
			<tr>
			<td><s:property value="#rowStatus.count" /></td>
				<td><s:property value="Color" /></td>
				<td><s:property value="price" /></td>
				<td><s:property value="shoeSize" /></td>
				<td><a href="Order?itemId=<s:property value="Itemid"/>">Order</a></td>
			</tr>
		</s:iterator>
	</table>
	<br> Clothes Table
	<table id="ItemOfClothes" border="1">
		<tr>
			<th>No</th>
			<th>Color</th>
			<th>Price</th>
			<th>Clothing Size</th>
			<th>Order</th>

		</tr>
		<s:iterator value="listOfClothes" var="cloth" status="rowStatus">
			<tr>
				<td><s:property value="#rowStatus.count" /></td>
				<td><s:property value="Color" /></td>
				<td><s:property value="price" /></td>
				<td><s:property value="clothingSize" /></td>
				<td><a href="Order?itemId=<s:property value="Itemid"/>">Order</a></td>
			</tr>
		</s:iterator>
	</table>


</body>
</html>