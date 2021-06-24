/**
 * 
 */
function way(xml, g) {
	var r = document.getElementsByClassName("more");
	r.innerHtml = "";
	switch (g) {
	case '0':
		console.log("r ", xml)
		if (xml.response[0] == 'I')
			alert(xml.response);
		else if (xml.response == "sucsess") {
			window.location = "user.jsp";
			alert("签到成功");
		}

		break;
	case '1':

		break;
	case '2':

		break;
	case '3':

		break;
	case '4':

		break;
	case '5':

		break;
	}
}

function getXHR() {
	var xmlHttp;
	try {
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("你的浏览器不支持ajax");
				return false;
			}
		}
	}
	return xmlHttp;
}
function talk(g) {
	var xhttp = getXHR();
	if (xhttp == false) {
		alert("AJAX初始化失败");
		return false;
	}
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			way(this, g);
		}
	};
	xhttp.open("GET", "/userAction?type=" + g, true);
	xhttp.send();
}