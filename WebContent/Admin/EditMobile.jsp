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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="font-size: 18px; line-height: 25px">
		<s:push value=" mobile">
			<s:form action="UpdateMobileAction">

				<s:hidden name="itemID" value="%{itemID}" />
				<s:textfield name="name" label="Name" value="%{name}"
					required="true" />
				<s:select label="Select color" headerKey="-1" name="color"
					list="%{@com.web.prepare.Constant@colors}" value="%{color}" />
				<s:select label="Select operating system" headerKey="-1"
					name="operatingSystem"
					list="%{@com.web.prepare.Constant@operatingSystems}"
					value="%{operatingSystem}" required="true" />
				<s:textfield name="camera.frontCamera" label="Front Camera"
					value="%{camera.frontCamera}" />
				<s:textfield name="camera.rearCamera" label="Rear Camera"
					value="%{camera.rearCamera}" />
				<s:select label="Select screen type" headerKey="-1"
					name="screen.screenType"
					list="%{@com.web.prepare.Constant@screenTypes}"
					value="%{screen.screenType}" required="true" />
				<s:textfield name="screen.screenSize" label="Screen Size"
					value="%{screen.screenSize}" required="true" />
				<s:radio label="Support External Card" name="isSupportExternalCard"
					list="%{@com.web.prepare.Constant@yesOrNo}"
					value="%{isSupportExternalCard}" required="true" />
				<s:textfield name="internalStorage" label="Internal Storage"
					value="%{internalStorage}" required="true" />
				<s:textfield name="price" label="Price" value="%{price}"
					required="true" />
				<s:textfield name="ram" label="Ram" value="%{ram}" required="true" />
				<s:textfield name="pic" label="Picture Name" value="%{pic}"
					readonly="true" />
				<s:textarea name="description" rows="4" cols="50"
					label="Description" value="%{description}">
				</s:textarea>

				<s:checkboxlist label="Add accessories" list="allAccessoriesName"
					name="mobileAccessoriesName" value="mobileAccessoriesName"
					 />
				<s:submit align="center" value="UPDATE"/>

			</s:form>
		</s:push>
	</div>
</body>
</html>