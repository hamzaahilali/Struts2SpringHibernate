<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<a href="secure/AddShoeActionForm">Add more shoe </a>
<br>
<body>



	<table id="ItemOfShoe" border="1">
		<tr>
			<th>No</th>
			<th>Name</th>
			<th>Color</th>
			<th>Price</th>
			<th>Size</th>
			<th>Image</th>
			<th>Edit</th>
			<th>Delete</th>

		</tr>
		<s:iterator value="listOfShoe" var="shoe" status="rowStatus">
			<tr>
				<td><s:property value="#rowStatus.count" /></td>
				<td><s:property value="name" /></td>
				<td><s:property value="Color" /></td>
				<td><s:property value="price" /> $</td>
				<td><s:property value="shoeSize" /></td>
				<td><a
					href="ProductAction.action?itemID=<s:property value= "itemID"/>">
						<img src="<s:url value="/Image/%{pic}"/>" width="200" height="150" />
				</a></td>
				<td><a
					href="EditShoeActionForm?itemID=<s:property value="itemID"/>">Edit</a></td>

				<s:url action="DeleteAction" var="urlTag">
					<s:param name="itemID">%{itemID}</s:param>
				</s:url>

				<td><a href="<s:property value="#urlTag" />">Delete</a></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>