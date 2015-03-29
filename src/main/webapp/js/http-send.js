
function httpSend(url, json) {
	
	var request = new XMLHttpRequest();
	var confirmation = null;
	
	request.onreadystatechange = function() {
		if(request.readyState === 4 && request.status === 200) {
	        confirmation = request.responseText;
	    } else {
	    	
	    }
	}
	
	request.open("POST", url, true);
	request.setRequestHeader("Content-Type", "application/json");
	var strJson = JSON.stringify(json);
	request.send(strJson);
	
	return confirmation;
}