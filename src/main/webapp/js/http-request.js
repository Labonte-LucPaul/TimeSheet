
function httpRequest(url, funct) {
	
	var xmlhttp = new XMLHttpRequest();
	var json = null;
	
	xmlhttp.onreadystatechange = function() {
		if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			var response = xmlhttp.responseText;
			if(response === "") {
				return null;
			}
			json = JSON.parse(response);
			funct(json);
		}
	}
	
	xmlhttp.open("POST", url, true);
	xmlhttp.send();
	
	return json;
}