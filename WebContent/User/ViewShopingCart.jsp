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


<script type="text/javascript">
	
</script>

<style>
</style>




<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="button">
		<a id="modal_trigger" href="#modal" class="buttonLogin">
			Login/Register</a>

		<button id="buttonLogout" class="buttonLogout">Log Out</button>

	</div>



	<div class="welcome">
		<s:include value="/Header/Header.jsp" />
	</div>
	<div class="shoppingContainer">
		<div class="homeIcon">
			<a id="HomeAction" href="HomeAction"> <span><img
					src="<s:url value="/Image/Icon/home.jpg"/>" width="50px"
					height="50px" /> HOME </span>
			</a>
		</div>
		<div class="shoppingCart">
			<br> Shoping Cart <br> Date create:
			<s:property value="shoppingCart.createdDate" />
		</div>
		<table class="item" id="orderedItems" border="1">
			<tr>
				<th>No</th>
				<th>Name</th>
				<th>Price</th>
				<th>Amount</th>
				<th>Delete</th>

			</tr>
			<s:iterator value="shoppingCart.orderedItems" var="orderedItem"
				status="rowStatus">
				<tr>
					<td><s:property value="#rowStatus.count" /></td>
					<td><s:property value="item.name" /></td>
					<td><s:property value="item.price" /></td>
					<td><s:property value="amount" /></td>
					<td><a href="#"
						onclick="deleteRow(this, '<s:property value="item.itemID" />')">Delete</a></td>
				</tr>
			</s:iterator>
			<div class="total">
				<h1>
					TOTAL: <span id="totalMoney"><s:property
							value="#session.totalPrice" /></span> USD
				</h1>
			</div>
		</table>


		<br>


		<script>
			function deleteRow(row, itemID) {

				$.post("DeteleItemAction", {
					itemID : itemID
				}, function(data, status) {
					if (status == "success") {
						$("#totalMoney").text(data);
						var i = row.parentNode.parentNode.rowIndex;
						document.getElementById('orderedItems').deleteRow(i);
					}
				});

			}

			function getJSON() {
				$.ajax({
					type : 'POST',
					url : 'GetTotalAction',
					headers : {
						Accept : "application/json; charset = charset=utf-8",
						"Content-type" : "application/json,charset=utf-8"
					},

					success : function(data) {
						return data;

					}
				})
			}
		</script>
		<script>
			$(document).ready(
							function() {
								$("#submit")
										.submit(
												function() {
													alert("dsdsa");
													$
															.ajax({
																type : 'POST',
																url : 'GetTotalAction',
																headers : {
																	Accept : "application/json; charset = charset=utf-8",
																	"Content-type" : "application/json,charset=utf-8"
																},

																success : function(
																		data) {

																	if (!data.userName) {
																		$
																				.simplyToast(
																						"PleaseLogin",
																						"danger")
																		return false;
																	}
																	if (data.totalAmount == 0) {
																		$
																				.simplyToast(
																						"Please order some items",
																						"danger")
																		return false;
																	}
																	$
																			.post(
																					"BuyItemAction",
																					{

																					});

																}
															});

												})
							});
		</script>


		<script>
			
		</script>








		<br>
		<button id="buttonBuy">BUY</button>
	</div>
	<!-- Login And Register -->
	<div class="container">
		<div id="modal" class="popupContainer" style="display: none;">
			<header class="popupHeader"> <span class="header_title">Login</span>
			<span class="modal_close"><i class="fa fa-times"></i></span> </header>

			<section class="popupBody"> <!-- Social Login -->
			<div class="social_login">
				<div class=""></div>



				<div class="action_btns">
					<div class="one_half">
						<a href="#" id="login_form" class="btn">Login</a>
					</div>
					<div class="one_half last">
						<a href="#" id="register_form" class="btn">Sign up</a>
					</div>
				</div>
			</div>

			<!-- Username & Password Login form -->
			<div class="user_login">
				<form id="formLogin" method="post" action="">
					<label>Email / Username</label> <input id="userName" type="text"
						name="userName" id="userName" required /> <br /> <label>Password</label>
					<input id="password" type="password" name="password" required /> <br />


					<div class="action_btns">
						<div class="one_half">
							<a href="#" class="btn back_btn"><i
								class="fa fa-angle-double-left"></i> Back</a>
						</div>
						<div class="one_half last">
							<input type="submit" id="buttonSubmit" class=" btn btn_red"
								value="     Login    " />

						</div>
					</div>
				</form>

				<a href="#" class="forgot_password">Forgot password?</a>
			</div>

			<!-- Register Form -->
			<div class="user_register">
				<form id="formRegister" method="post" action="">
					<label>Name</label> <input id="userNameReg" name="userName"
						type="text" required /> <br /> <label>Email Address</label> <input
						id="emailReg" name="email" type="email" required /> <br /> <label>Address</label>
					<br /> <input id="addressReg" name="address" type="text" required />
					<br /> <label>Password</label><input id="passwordReg"
						name="password" type="password" required />


					<div class="action_btns">
						<div class="one_half">
							<a href="#" class="btn back_btn"><i
								class="fa fa-angle-double-left"></i> Back</a>
						</div>
						<div class="one_half last">
							<input type="submit" id="buttonSubmit" class=" btn btn_red"
								value="      Register      " />
						</div>
					</div>
				</form>
			</div>
			</section>
		</div>
	</div>


	<!-- /Login And Register -->
</body>
</html>