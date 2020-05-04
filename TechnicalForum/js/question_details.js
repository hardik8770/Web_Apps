window.onload = initAll;

function initAll(){
	getAllElements();
	setAllActions();
}

var post_answer_button,question_id,reply_field;

function getAllElements(){
	
	post_answer_button = document.getElementById('post_answer_button');
	question_id = document.getElementById('question_id');
	reply_field = document.getElementById('reply_field');
}

function setAllActions(){
	post_answer_button.onclick = saveResponse;
}

var responseSaveRequest;
function saveResponse(){
	responseSaveRequest = new XMLHttpRequest();
	responseSaveRequest.open('get','post_my_answer.do?question_id='+question_id.value+'&response='+escape(reply_field.value));
	responseSaveRequest.onreadystatechange = showResponse;
	responseSaveRequest.send(null)
}

function showResponse(){
	if(responseSaveRequest.readyState==4&&responseSaveRequest.status==200){
	
	}
}