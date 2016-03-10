<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
#wrap {
	overflow: hidden;
}

.box {
	width: 30%;
	padding-bottom: 20%;
	color: #FFF;
	position: relative;
	float: left;
}

.innerContent {
	position: absolute;
	left: 1px;
	right: 1px;
	top: 1px;
	bottom: 1px;
	background: #00F;
	padding: 10px;
}
</style>
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
	<br> Shoes Table
	<table id="ItemOfShoe" border="1">
		<tr>
			<th>No</th>
			<th>Name</th>
			<th>Color</th>
			<th>Price</th>
			<th>Size</th>
			<th>Image</th>
			<th>Order</th>
		</tr>
		<s:iterator value="listOfShoe" var="shoe" status="rowStatus">
			<tr>
				<td><s:property value="#rowStatus.count" /></td>
				<td><s:property value="name" /></td>
				<td><s:property value="color" /></td>
				<td><s:property value="price" /> $</td>
				<td><s:property value="shoeSize" /></td>
				<td><a
					href="ProductAction.action?itemID=<s:property value= "itemID"/>">
						<img src="<s:url value="/Image/%{pic}"/>" width = "200" height ="150"/>
				</a></td>
				<td><a href="Order?itemId=<s:property value="Itemid"/>">Order</a></td>
			</tr>
		</s:iterator>
	</table>

	<!-- ********************************************** -->
	<div id="wrap">
		<s:iterator value="listOfShoe" var="shoe" status="rowStatus">
			<div class="box">

				<a href="ProductAction.action?itemID=<s:property value= "itemID"/>">
					<img src="<s:url value="/Image/%{pic}"/>" />
				</a> 
				<s:property value="price" />

			</div>
		</s:iterator>
	</div>





</body>
</html>