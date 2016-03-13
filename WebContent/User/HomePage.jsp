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
	<p id="time"></p>

	<script>
		document.getElementById("time").innerHTML = Date();
	</script>
	<s:include value="/Header/Header.jsp" />
	<br>
	<a href="<s:url action="LoginFormAction"/>"> Login</a>
	<a href="<s:url action="RegisterFormAction"/>"> Register</a>
	<a href="<s:url action="SuccessLoginAction"/>"> RegisterSuccess</a>
	<br>
	<br> Mobiles Table
	<table id="mobile" border="1">
		<tr>
			<th>No</th>
			<th>Name</th>
			<th>Color</th>
			<th>Price</th>
			<th>Image</th>
			<th>Order</th>
		</tr>
		<s:iterator value="mobiles" var="mobile" status="rowStatus">
			<tr>
				<td><s:property value="#rowStatus.count" /></td>
				<td><s:property value="name" /></td>
				<td><s:property value="color" /></td>
				<td><s:property value="price" /> $</td>
				<td><a
					href="ShowMobileAction.action?itemID=<s:property value= "itemID"/>">
						<img src="<s:url value="/Image/Mobile/%{pic}.jpg"/>" width="200" height="200" />
				</a></td>
				<td><a href="Order?itemId=<s:property value="Itemid"/>">Order</a></td>
			</tr>
		</s:iterator>
	</table>

	<!-- ********************************************** -->
	<br> Mobile Case Table
	<table id="mobileCase" border="1">
		<tr>
			<th>No</th>
			<th>Name</th>
			<th>Color</th>
			<th>Price</th>
			<th>Image</th>
			<th>Order</th>
		</tr>
		<s:iterator value="mobileCases" var="mobile" status="rowStatus">
			<tr>
				<td><s:property value="#rowStatus.count" /></td>
				<td><s:property value="name" /></td>
				<td><s:property value="color" /></td>
				<td><s:property value="price" /> $</td>
				<td><a
					href="ShowMobileCaseAction.action?itemID=<s:property value= "itemID"/>">
						<img src="<s:url value="/Image/MobileCase/%{pic}.jpg"/>" width="200" height="200"/>
				</a></td>
				<td><a href="Order?itemId=<s:property value="Itemid"/>">Order</a></td>
			</tr>
		</s:iterator>
	</table>

	<!-- *********************************************************** -->
	<br> Power Bank Table
	<table id="powerBank" border="1">
		<tr>
			<th>No</th>
			<th>Name</th>
			<th>Color</th>
			<th>Price</th>
			<th>Image</th>
			<th>Order</th>
		</tr>
		<s:iterator value="powerBanks" var="mobile" status="rowStatus">
			<tr>
				<td><s:property value="#rowStatus.count" /></td>
				<td><s:property value="name" /></td>
				<td><s:property value="color" /></td>
				<td><s:property value="price" /> $</td>
				<td><a
					href="ShowPowerBankAction.action?itemID=<s:property value= "itemID"/>">
						<img src="<s:url value="/Image/PowerBank/%{pic}.jpg"/>" width="200" height="200"/>
				</a></td>
				<td><a href="Order?itemId=<s:property value="Itemid"/>">Order</a></td>
			</tr>
		</s:iterator>
	</table>


</body>
</html>