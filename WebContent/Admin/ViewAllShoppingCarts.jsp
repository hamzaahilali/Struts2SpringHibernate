<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/product.css" />
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/jquery.leanModal.min.js"></script>
<script type="text/javascript" src="js/simply-toast.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" />

<link type="text/css" rel="stylesheet" href="css/style.css" />
<link type="text/css" rel="stylesheet" href="css/simply-toast.css" />
</head>
<body>

	<table class="item" border="1">
		<tr>
			<th>No</th>
			<th>ID</th>
			<th>Date</th>
			<th>Status</th>
			<th>User's Email</th>
			<th>User's name</th>
			<th>User's Address</th>
			<th>View</th>
		</tr>
		<s:iterator value="shoppingCarts" status="rowStatus">
			<tr>
				<td><s:property value="#rowStatus.count" /></td>
				<td><s:property value="shoppingCartID" /></td>
				<td><s:property value="createdDate" /></td>
				<td><select id='<s:property value = 'shoppingCartID'/>'
					name="status">
						<option selected>
							<s:property value="status" />
						</option>
						<option>On going</option>
						<option>Delivering</option>
						<option>Done</option>
				</select>

					<button onclick="update('<s:property value = 'shoppingCartID'/>')">
						Update</button></td>
				<td><s:property value="user.email" /></td>
				<td><s:property value="user.userName" /></td>
				<td><s:property value="user.Address" /></td>
				<td><s:form action="ViewShoppingCartAction">
						<s:hidden name="shoppingCartID" value="%{shoppingCartID}" />

						<s:submit value="View" />
					</s:form></td>


			</tr>
		</s:iterator>
	</table>
	<script>
	
	
			
		function update(id)
		{
			var e = document.getElementById(id);
		    var status = e.options[e.selectedIndex].text;
		    alert("id: "+ id+status);
		    $.post("UpdateShoppingCartAction", {
				shoppingCartID : id,
				status:status
				
			}, function(data, status) {});
			$.simplyToast('Success','success');	
		}
	</script>

</body>
</html>