(function() {

	var parts = document.location.search.slice(1).split("&"), length = parts.length, scripts = document
			.getElementsByTagName("script"), src = scripts[scripts.length - 1].src, i = 0, current, version = "1.11.1", file = "http://code.jquery.com/jquery-git.js";

	for (; i < length; i++) {
		current = parts[i].split("=");
		if (current[0] === "jquery") {
			version = current[1];
			break;
		}
	}

	if (version != "git") {
		file = src.replace(/jquery\.js$/, "jquery-" + version + ".js");
	}

	document.write("<script src='" + file + "'></script>");

})();

$(function() {
	$.ajax({
		type : 'POST',
		url : 'GetTotalAction',
		headers : {
			Accept : "application/json; charset = charset=utf-8",
			"Content-type" : "application/json,charset=utf-8"
		},

		success : function(data) {
			if (!data)
				$("#totalAmount").text(0);
			else
				$("#totalAmount").text(data.totalAmount);
		}
	});

	$("#buttonLogout").click(function() {

		$.ajax({
			type : 'POST',
			url : 'GetTotalAction',
			headers : {
				Accept : "application/json; charset = charset=utf-8",
				"Content-type" : "application/json,charset=utf-8"
			},

			success : function(data) {
				if (!data.userName) {
					$.simplyToast(" Plesse log in first :)", 'danger');
				} else {
					$.post("LogOutAction", function(data, status) {
						$.simplyToast("Log out successfully", 'success');
						setTimeout(function() {
							window.location.reload();

						}, 2000)

					});
				}
			}
		});

	});

	$("#formLogin").submit(function() {

		var name = $("#userName").val();
		var pass = $("#password").val();
		var errorMessage = "";

		$.ajax({
			type : 'POST',
			url : 'GetTotalAction',
			headers : {
				Accept : "application/json; charset = charset=utf-8",
				"Content-type" : "application/json,charset=utf-8"
			},

			success : function(data) {
				if (data.userName)
					$.simplyToast(" you are already logged in :)", 'danger');
				else

				{
					$.post("LoginAction", {
						userName : name,
						password : pass
					}, function(data, status) {

						if (data == "input") {
							$.simplyToast(

							" User does not exist, Please register", 'danger');
						} else {
							$.simplyToast(

							"Login Successfully", 'success');
							setTimeout(function() {
								window.location.reload();
							}, 1000);

						}

					});
				}
			}
		});

		return false;
	})

});
function showMobileAction(itemID) {
	alert(itemID);
	$.post("ShowMobileAction.action", {
		itemID : itemID
	}, function(data, status) {
		alert("dome");
	});
	return false;
}

function addItem(itemID, name, price, pic) {
	$.post("AddItemAction", {
		itemID : itemID,
		name : name,
		price : price,
		pic : pic
	}, function(data, status) {
		$.simplyToast(data, 'info');
		$.ajax({
			type : 'POST',
			url : 'GetTotalAction',
			headers : {
				Accept : "application/json; charset = charset=utf-8",
				"Content-type" : "application/json,charset=utf-8"
			},

			success : function(data) {

				$("#totalAmount").text(data.totalAmount);
			}
		});
	});

}
$(function() {
	$("#formRegister").submit(function() {

		var name = $("#userNameReg").val();
		var pass = $("#passwordReg").val();
		var email = $("#emailReg").val();
		var address = $("#addressReg").val();
		{
			$.post("RegisterAction", {
				userName : name,
				password : pass,
				email : email,
				address : address
			}, function(data, status) {
				if (data == "input") {
					$.simplyToast("email has already registered ", 'error');

				} else {
					// $("#myPopup").hide(500);
					$.simplyToast("Resgister Successfully ", 'info');
					setTimeout(function() {
						window.location.reload();
					}, 1000);

				}

			});
		}
		return false
	})
});

$(function() {
	$("#modal_trigger").leanModal({
		top : 200,
		overlay : 0.6,
		closeButton : ".modal_close"
	});
	// Calling Login Form
	$("#login_form").click(function() {
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
