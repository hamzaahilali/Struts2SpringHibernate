<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:push value=" mobile">
		<s:form action="UpdateMobileAction">
			<s:property value="%{name}" />
			<s:hidden name="itemID" value="%{itemID}" />
			<s:textfield name="name" label="Name" value="%{name}" />
			<s:select label="Select color" headerKey="-1"
				headerValue="Select color" name="color"
				list="%{@com.web.prepare.Constant@colors}" value="%{color}" />
			<s:select label="Select operating system" headerKey="-1"
				headerValue="Select Operating System" name="operatingSystem"
				list="%{@com.web.prepare.Constant@operatingSystems}"
				value="%{operatingSystem}" />
			<s:textfield name="camera.frontCamera" label="Front Camera"
				value="%{camera.frontCamera}" />
			<s:textfield name="camera.rearCamera" label="Rear Camera"
				value="%{camera.rearCamera}" />
			<s:select label="Select screen type" headerKey="-1"
				headerValue="Select screen type" name="screen.screenType"
				list="%{@com.web.prepare.Constant@screenTypes}"
				value="%{screen.screenType}" />
			<s:textfield name="screen.screenSize" label="Screen Size"
				value="%{screen.screenSize}" />
			<s:radio label="Support External Card" name="isSupportExternalCard"
				list="%{@com.web.prepare.Constant@yesOrNo}"
				value="%{isSupportExternalCard}" />
			<s:textfield name="internalStorage" label="Internal Storage"
				value="%{internalStorage}" />
			<s:textfield name="price" label="Price" value="%{price}" />
			<s:textfield name="ram" label="Ram" value="%{ram}" />
			<s:textfield name="pic" label="Picture Name" value="%{pic}" />
			<s:textarea name="description" rows="4" cols="50" label="Description"
				value="%{description}">
			</s:textarea>
			<s:checkboxlist label="Add accessories" list="allAccessoriesName"
				name="mobileAccessoriesName" value="mobileAccessoriesName" />
			<s:submit />
		</s:form>
	</s:push>
</body>
</html>