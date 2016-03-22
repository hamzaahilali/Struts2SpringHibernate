<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="en">
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
<title>Insert title here</title>
</head>
<body>
	<div class="button">
		<a id="modal_trigger" href="#modal" class="buttonLogin">
			Login/Register</a>


		<button id="buttonLogout" class="buttonLogout">Log Out</button>
		<a id="modal_trigger" href="AdminLoginForm" class="buttonAdmin">
		<img
			src="<s:url value="/Image/Icon/admin.jpg"/>" width="50px"
			height="50px" />
		Admin</a>
	</div>
	<div class="welcome">
		<s:include value="/Header/Header.jsp" />
	</div>



	<s:url action="ViewShoppingCartAction.action" var="urlTag">
	</s:url>
	<br>
	<div class="shopping">
		<a href="ViewShoppingCartAction.action"> <img
			src="<s:url value="/Image/Icon/ShoppingCart.jpg"/>" width="50px"
			height="50px" /><strong> <span class="totalAmount"
				id="totalAmount"></span></strong></a>

	</div>

	<br>



	<div id="site-wrapper">


		<div class=" info-title">
			<div class="row-fluid ">
				<div class="info-phone-left">
					<h3>MOBILE</h3>
				</div>
			</div>
		</div>

		<ul class="products homepage">
			<s:iterator value="mobiles" var="mobile" status="rowStatus">
				<li class="preorder"><span class="tagimg "></span> <a
					href="ShowMobileAction.action?uniqueName=<s:property value= "uniqueName"/>">
						<img src="<s:url value="/Image/Mobile/%{pic}.jpg"/>" width="200px"
						height="200px" />
						<h3>
							<s:property value="name" />
						</h3>

						<p class="info">
							<span> Screen: <s:property value="screen.screenSize" />
								inch, <s:property value="screen.screenType" /></span> <span>OS:
								<s:property value="operatingSystem" />
							</span> <span>Storage : <s:property value="internalStorage" />
								GB
							</span> <span>Front Camera : <s:property
									value="camera.frontCamera" /> MB
							</span> <span>Sefie Camera: <s:property value="camera.rearCamera" />
								MB
							</span>
						</p>
				</a>
					<h4>
						<strong> Price: <s:property value="price" /> USD
						</strong>
						<button class="buttonOrder"
							onclick="addItem('<s:property value="itemID"/>','<s:property value="name"/>','<s:property value="price"/>','<s:property value="pic"/>')">Order</button>
					</h4></li>



			</s:iterator>
		</ul>
	</div>




	<div id="site-wrapper">
		<div class=" info-title">
			<div class="row-fluid ">
				<div class="info-phone-left">
					<h3>CASE</h3>
				</div>
			</div>
		</div>

		<ul class="products homepage">
			<s:iterator value="mobileCases" var="mobileCase" status="rowStatus">
				<li class="preorder"><span class="tagimg "></span> <a
					href="ShowMobileCaseAction.action?uniqueName=<s:property value= "uniqueName"/>">
						<img src="<s:url value="/Image/MobileCase/%{pic}.jpg"/>"
						width="200px" height="200px" />
						<h3>
							<s:property value="name" />
						</h3>

				</a>
					<h4>
						<strong> Price: <s:property value="price" /> USD
						</strong>
						<button class="buttonOrder"
							onclick="addItem('<s:property value="itemID"/>','<s:property value="name"/>','<s:property value="price"/>','<s:property value="pic"/>')">Order</button>
					</h4></li>



			</s:iterator>
		</ul>
	</div>

	<!-- ********************************************** -->


	<div id="site-wrapper">
		<div class=" info-title">
			<div class="row-fluid ">
				<div class="info-phone-left">
					<h3>POWER BANK</h3>
				</div>
			</div>
		</div>
		<ul class="products homepage">
			<s:iterator value="powerBanks" var="powerBank" status="rowStatus">
				<li class="preorder"><span class="tagimg "></span> <a
					href="ShowPowerBankAction.action?uniqueName=<s:property value= "uniqueName"/>">
						<img src="<s:url value="/Image/PowerBank/%{pic}.jpg"/>"
						width="200px" height="200px" />
						<h3>
							<s:property value="name" />
						</h3>

				</a>
					<h4>
						<strong> Price: <s:property value="price" /> USD
						</strong>
						<button class="buttonOrder"
							onclick="addItem( '<s:property value="itemID"/>','<s:property value="name"/>','<s:property value="price"/>','<s:property value="pic"/>')">Order</button>
					</h4></li>



			</s:iterator>
		</ul>
	</div>
	<div class="container">
		<div id="modal" class="popupContainer" style="display: none;">
			<header class="popupHeader">
				<span class="header_title">Login</span> <span class="modal_close"><i
					class="fa fa-times"></i></span>
			</header>

			<section class="popupBody">
				<!-- Social Login -->
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
						<input id="password" type="password" name="password" required />
						<br />


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


</body>
</html>