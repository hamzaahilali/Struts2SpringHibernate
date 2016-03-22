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
<title>Insert title here</title>
<script type="text/javascript">
	function confirm_click(item) {
		return confirm("Are you sure to delete " + item);
	}
</script>

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


	<div>
		<a class="buttonAdmin"
			href="<s:url action="ViewAllShoppingCartAction"/>"> <img
			src="<s:url value="/Image/Icon/order.jpg"/>" width="50px"
			height="50px" />View Orders
		</a>
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
					>
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
					<div class="edit">

						<div>
							<h5>
								<s:property value="price" />
								USD
							</h5>
						</div>
						<div>
							<s:form action="EditMobileActionForm" method="post">
								<s:hidden name="uniqueName" value="%{uniqueName}" />
								<s:submit value=" Edit " />
							</s:form>
						</div>

						<div>
							<s:form method="post">
								<s:hidden name="itemID" value="%{itemID}" />
								<s:submit value="Delete" />
							</s:form>
						</div>


					</div></li>



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
			<s:iterator value="mobileCases" var="mobileCase">
				<li class="preorder"><span class="tagimg "></span> <a>
						<img src="<s:url value="/Image/MobileCase/%{pic}.jpg"/>"
						width="200px" height="200px" />
						<h3>
							<s:property value="name" />
						</h3>

				</a>
					<div class="edit">

						<div>
							<h5>
								<s:property value="price" />
								USD
							</h5>
						</div>
						<div>
							<s:form action="EditMobileCaseActionForm" method="post">
								<s:hidden name="uniqueName" value="%{uniqueName}" />
								<s:submit value=" Edit " />
							</s:form>
						</div>

						<div>
							<s:form method="post">
								<s:hidden name="itemID" value="%{itemID}" />
								<s:submit value="Delete" />
							</s:form>
						</div>
					</div></li>
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
				<li class="preorder"><span class="tagimg "></span> <a>
						<img src="<s:url value="/Image/PowerBank/%{pic}.jpg"/>"
						width="200px" height="200px" />
						<h3>
							<s:property value="name" />
						</h3>

				</a>
					<div class="edit">

						<div>
							<h5>
								<s:property value="price" />
								USD
							</h5>
						</div>
						<div>
							<s:form action="EditPowerBankActionForm" method="post">
								<s:hidden name="uniqueName" value="%{uniqueName}" />
								<s:submit value=" Edit " />
							</s:form>
						</div>

						<div>
							<s:form method="post">
								<s:hidden name="itemID" value="%{itemID}" />
								<s:submit value="Delete" />
							</s:form>
						</div>


					</div></li>



			</s:iterator>
		</ul>
	</div>
</body>
</html>