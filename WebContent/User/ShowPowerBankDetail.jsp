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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">



</head>

<body>
	<div class="shopping">
		<a href="ViewShoppingCartAction.action"> <img
			src="<s:url value="/Image/Icon/ShoppingCart.jpg"/>" width="50px"
			height="50px" /><strong> <span class="totalAmount"
				id="totalAmount"></span></strong></a>

	</div>

	<div class="button">
		<a id="modal_trigger" href="#modal" class="buttonLogin">
			Login/Register</a>


		<button id="buttonLogout" class="buttonLogout">Log Out</button>

	</div>
	<div class="welcome">
		<s:include value="/Header/Header.jsp" />
	</div>


	<div class="container">
		<div id="modal" class="popupContainer" style="display: none;">
			<header class="popupHeader"> <span class="header_title">Login</span>
			<span class="modal_close"><i class="fa fa-times"></i></span> </header>

			<section class="popupBody"> <!-- Social Login -->
			<div class="social_login">
				<div class=""></div>

				<div class="centeredText">
					<span>Or use your Email address</span>
				</div>

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









	<div class="itemContainer">
		<s:push value="powerBank">

			<div class="itemImage">
				<img src="<s:url value="/Image/PowerBank/Large/%{pic}_Large.jpg"/>"
					width="400" height="400" />
				<button class="buttonOrder"
					onclick="addItem('<s:property value="itemID"/>','<s:property value="name"/>','<s:property value="price"/>','<s:property value="pic"/>')">Order</button>
			</div>
			<div class="itemDetail">
				<ul>
					<li>Name: <s:property value="name" /></li>
					<li>Color: <s:property value="color" /></li>
					<li>Price: <s:property value="price" /> $
					</li>
					<li>Description: <s:property value="description" />
					<li>Capacity: <s:property value="capacity" />
					mAh
					</li>

				</ul>

			</div>
		</s:push>
	</div>
</body>
</html>