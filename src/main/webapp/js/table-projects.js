
function addRow(tableName) {
	
	var table = document.getElementById(tableName);

	var insertAt = table.rows.length - 1;
	
	var txtProject = document.getElementById('projectName');
	var txtDescription = document.getElementById('projectDescription');
	var txtWeekleyTime = document.getElementById('weekleyTime');
	
	if(isEmpty(txtProject)) {
		alert("Can't add an empty project!");
		txtProject.focus();
		return null;
	}
	
	if(projectExist(txtProject.value)) {
		alert('Project \'' + txtProject.value + '\' already exist.');
		txtProject.select();
		return null;
	}
	
	if(isNaN(txtWeekleyTime.value)) {
		alert("The value '" + txtWeekleyTime.value + "' is not a number.");
		txtWeekleyTime.select();
		return null;
	}
	
	var row = table.insertRow(insertAt);
	row.id = txtProject.value;
	var cellProject = row.insertCell(0);
	var cellDescription = row.insertCell(1);
	var cellWeekleyTime = row.insertCell(2);
	var cellRemoveImg = row.insertCell(3);
	
	cellProject.innerHTML = txtProject.value;
	cellDescription.innerHTML = txtDescription.value;
	cellWeekleyTime.innerHTML = txtWeekleyTime.value;
	cellRemoveImg.innerHTML = '<a href="javascript:removeRow(\'projects\', \'' + txtProject.value + '\')"><img alt="add" src="../img/default/24x24/remove_24x24.png"></a>';
	
	var time = txtWeekleyTime.value == '' ? 0 : txtWeekleyTime.value;
	var json = createJson(txtProject.value, txtDescription.value, time);
	
	txtProject.value = '';
	txtDescription.value = '';
	txtWeekleyTime.value = '';
	txtProject.focus();
	
	return json;
}

function isEmpty(textBox) {
	return textBox.value.length === 0;
}

function projectExist(projName) {
	var exist = document.getElementById(projName);
	return exist !== null;
}

function createJson(projName, description, time) {
	
	var jo = {};
	jo.projectname = projName;
	jo.description = description;
	jo.time = time;
	
	return jo;
}

function removeRow(tableName, rowID) {
	var table = document.getElementById(tableName);
	var row = document.getElementById(rowID);
	index = row.rowIndex;
	table.deleteRow(index);
}

function insert(json, tableName) {
	
	var table = document.getElementById(tableName);
	var insertAt = table.rows.length - 1;
	
	var row = table.insertRow(insertAt);
	row.id = json.projectname;
	var cellProject = row.insertCell(0);
	var cellDescription = row.insertCell(1);
	var cellWeekleyTime = row.insertCell(2);
	var cellRemoveImg = row.insertCell(3);
	
	cellProject.innerHTML = json.projectname;
	cellDescription.innerHTML = json.description;
	cellWeekleyTime.innerHTML = json.weekleytime;
	cellRemoveImg.innerHTML = '<a href="javascript:remove(\'projects\', \'' + json.projectname + '\')"><img alt="add" src="../img/default/24x24/remove_24x24.png"></a>';
}
