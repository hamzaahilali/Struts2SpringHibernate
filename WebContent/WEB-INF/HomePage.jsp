<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>



<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/jquery.leanModal.min.js"></script>
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" />
<link type="text/css" rel="stylesheet" href="css/style.css" />

<script>
	$(document)
			.ready(
					function() {
						//$("#welcomeUser").text("Hello "+ '<s:property value="#session.user.userName"/>');
						$("a").each(function() {
							if ($(this).attr("data-rel") != "popup") {
								$(this).attr("rel", "external");
							}
						});

						$("#login")
								.click(
										function() {
											$
													.post(
															"LoginAction",
															{
																userName : $(
																		"#userName")
																		.val(),
																password : $(
																		"#password")
																		.val()
															},
															function(data,
																	status) {
																if (data == "input") {
																	alert(data
																			+ " Wrong username or password");
																} else {
																	//$("#myPopup").hide(500);
																	location
																			.reload();
																}
																;
															});
										});

						$("#register-form")
								.validate(
										{

											// Specify the validation rules
											rules : {

												email : {
													required : true,
													email : true
												},
												password : {
													required : true,
													minlength : 5
												},

											},

											// Specify the validation error messages
											messages : {

												password : {
													required : "Please provide a password",
													minlength : "Your password must be at least 5 characters long"
												},
												email : "Please enter a valid email address",
												agree : "Please accept our policy"
											},

											submitHandler : function(form) {
												form.submit();
											}
										});

					});

	function ajaxPost(ID, itemName) {
		$.post("AddItemAction", {
			itemID : ID,
			name : itemName
		}, function(data, status) {
			alert(data);
		});
	}

	$(function() {
		// Calling Login Form
		$("#login_form").click(function() {
			alert("hehe");
			$(".social_login").hide();
			$(".user_login").show();
			return false;
		});

		// Calling Register Form
		$("#register_form").click(function() {
			$(".social_login").hide();
			$(".user_register").show();
			$(".header_title").text('Register');
			return false;
		});

		// Going back to Social Forms
		$(".back_btn").click(function() {
			$(".user_login").hide();
			$(".user_register").hide();
			$(".social_login").show();
			$(".header_title").text('Login');
			return false;
		});

	})
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



	<div class="container">
		<a id="modal_trigger" href="#modal" class="btn">Click here to
			Login or register</a>

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
				<form action="LoginAction" method="post">
					<label>Email / Username</label> <input type="text" name="userName" />
					<br /> <label>Password</label> <input type="password"
						name="password" /> <br />


					<div class="action_btns">
						<div class="one_half">
							<a href="#" class="btn back_btn"><i
								class="fa fa-angle-double-left"></i> Back</a>
						</div>
						<div class="one_half last">
							<a href="#" class="btn btn_red">Login</a>
						</div>
					</div>
				</form>

				<a href="#" class="forgot_password">Forgot password?</a>
			</div>

			<!-- Register Form -->
			<div class="user_register">
				<form>
					<label>Full Name</label> <input type="text" name="userName" /> <br />
					<label>Email Address</label> <input type="email" /> <br /> <label>Password</label>
					<input type="password" /> <br />

					<div class="checkbox">
						<input id="send_updates" type="checkbox" /> <label
							for="send_updates">Send me occasional email updates</label>
					</div>

					<div class="action_btns">
						<div class="one_half">
							<a href="#" class="btn back_btn"><i
								class="fa fa-angle-double-left"></i> Back</a>
						</div>
						<div class="one_half last">
							<a href="#" class="btn btn_red">Register</a>
						</div>
					</div>
				</form>
			</div>
			</section>
		</div>
	</div>



	<p id="welcomeUser"></p>

	<p id="time"></p>

	<script>
		document.getElementById("time").innerHTML = Date();
	</script>
	<s:include value="/Header/Header.jsp" />

	<s:url action="ViewShoppingCartAction.action" var="urlTag">
	</s:url>
	<a href="ViewShoppingCartAction.action"> Shopping Card </a>
	<a href="www.google.com.vn"> google </a>
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
						<img src="<s:url value="/Image/Mobile/%{pic}.jpg"/>" width="200"
						height="200" />
				</a></td>
				<td><button
						onclick="ajaxPost( '<s:property value="itemID"/>','<s:property value="name"/>')">Order</button></td>
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
						<img src="<s:url value="/Image/MobileCase/%{pic}.jpg"/>"
						width="200" height="200" />
				</a></td>
				<td><button
						onclick="ajaxPost( '<s:property value="itemID"/>','<s:property value="name"/>')">Order</button></td>
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
						<img src="<s:url value="/Image/PowerBank/%{pic}.jpg"/>"
						width="200" height="200" />
				</a></td>
				<td>
				<td><button
						onclick="ajaxPost( '<s:property value="itemID"/>','<s:property value="name"/>')">Order</button></td>
			</tr>
		</s:iterator>
	</table>


	<script type="text/javascript">
		$("#modal_trigger").leanModal({
			top : 200,
			overlay : 0.6,
			closeButton : ".modal_close"
		});

		$(function() {
			// Calling Login Form
			$("#login_form").click(function() {
				alert("hehe");
				$(".social_login").hide();
				$(".user_login").show();
				return false;
			});

			// Calling Register Form
			$("#register_form").click(function() {
				$(".social_login").hide();
				$(".user_register").show();
				$(".header_title").text('Register');
				return false;
			});

			// Going back to Social Forms
			$(".back_btn").click(function() {
				$(".user_login").hide();
				$(".user_register").hide();
				$(".social_login").show();
				$(".header_title").text('Login');
				return false;
			});

		})
	</script>





</body>
</html>