/**
 * 
 */

function addRow(tableName) {
	
	var table = document.getElementById(tableName);
	
	
	var insertAt = table.rows.length - 1;
	
	var txtProject = document.getElementById('projectName');
	var txtDescription = document.getElementById('projectDescription');
	var txtWeekleyTime = document.getElementById('weekleyTime');
	
	if(isEmpty(txtProject)) {
		alert("Can't add an empty project!");
		txtProject.focus();
		return;
	}
	
	if(projectExist(txtProject.value, table)) {
		alert('Project \'' + txtProject.value + '\' already exist.');
		txtProject.select();
		return;
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
	
	txtProject.value = '';
	txtDescription.value = '';
	txtWeekleyTime.value = '';
	txtProject.focus();
}

function isEmpty(textBox) {
	return textBox.value.length === 0;
}

function projectExist(projName, table) {
	var exist = document.getElementById(projName);
	return exist !== null;
}

function removeRow(tableName, rowID) {
	var table = document.getElementById(tableName);
	var row = document.getElementById(rowID);
	index = row.rowIndex;
	table.deleteRow(index);
}

function json() {
	
}