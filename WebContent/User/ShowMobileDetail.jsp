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
	<s:include value="/Header/Header.jsp" />
	<br>

	<s:push value="mobile">
		<ul>
			<img src="<s:url value="/Image/Mobile/%{pic}_Large.jpg"/>"
				width="400" height="400" />
			<li>Name: <s:property value="name" /></li>
			<li>Color: <s:property value="color" /></li>
			<li>Price: <s:property value="price" /> $
			</li>
			<li>Front Camera : <s:property value="Camera.frontCamera" /></li>
			<li>Rear Camera : <s:property value="Camera.rearCamera" /> MB
			</li>
			<li>Internal Storage : <s:property value="internalStorage" />
				GB
			</li>
			<li>External Card : <s:property value="isSupportExternalCard" /></li>
			<li>Operating System : <s:property value="operatingSystem" /></li>
			<li>Ram : <s:property value="ram" /></li>
			<li>Accessories Available</li>
			<table id="accessory" border="1">
				<tr>
					<th>Name</th>
					<th>Image</th>
				</tr>

				<s:iterator value="accessories">
					<s:if test="type=='MobileCase'">
						<tr>
							<td><s:property value="name" /></td>
							<td><a
								href="ShowMobileCaseAction.action?itemID=<s:property value= "itemID"/>">
									<img src="<s:url value="/Image/MobileCase/%{pic}.jpg"/>"
									width="200" height="200" />
							</a></td>
						</tr>
					</s:if>
					<s:if test="type=='PowerBank'">
						<tr>
							<td><s:property value="name" /></td>
							<td><a
								href="ShowPowerBankAction.action?itemID=<s:property value= "itemID"/>">
									<img src="<s:url value="/Image/PowerBank/%{pic}.jpg"/>"
									width="200" height="200" />
							</a></td>
						</tr>
					</s:if>
				</s:iterator>

			</table>
		</ul>
	</s:push>
</body>
</html>