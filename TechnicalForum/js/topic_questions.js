var buttn = document.getElementById("button");
var tp_id = document.getElementById("tp_id");
var tp_nm = document.getElementById("tp_nm");

buttn.onclick = function(){
					window.location = 'show_post_question.do?topic_id='+tp_id.value+'&topic='+tp_nm.value;
			   };