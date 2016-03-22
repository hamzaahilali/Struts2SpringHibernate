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

<link type="text/css" rel="stylesheet" href="css/style.css" />
<link type="text/css" rel="stylesheet" href="css/simply-toast.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table class="item" border="1">
		<tr>
			<th>No</th>
			<th>ID</th>
			<th>Name</th>
			<th>Price</th>
			<th>Amount</th>
		</tr>
		<s:iterator value="shoppingCart.orderedItems" var="orderedItem"
			status="rowStatus">
			<tr>
				<td><s:property value="#rowStatus.count" /></td>
				<td><s:property value="item.itemID" /></td>
				<td><s:property value="item.Name" /></td>
				<td><s:property value="item.price" /> $</td>
				<td><s:property value="amount" /></td>
			</tr>
		</s:iterator>
		<tr>

			<td colspan='5'><span style="color: red; font-size: 22px">
					TOTAL MONEY <s:property value="totalMoney" /> $
			</span></td>

		</tr>
	</table>
	<h1></h1>
	
</body>
</html>