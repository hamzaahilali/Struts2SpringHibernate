<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajax Example in Struts 1e</title>
<script src="jquery-2.js"></script>
<script type="text/javascript">
	function doAjaxPost() {
		// get the form values
		var name = $('#name').val();

		$.ajax({
			type : "POST",
			url : "http://localhost:8080/WebForStudying/ajaxSubmit.action",
			data : "name=" + name,
			success : function(response) {
				// we have the response
				$('#info').html(response);
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
</script>
</head>
<body>
	Enter your name please :
	<input type="text" id="name">
	<br />
	<input type="button" value="Say Hello" onclick="doAjaxPost()">
	<br />
	<div id="info" style="color: green;"></div>
</body>
</html>