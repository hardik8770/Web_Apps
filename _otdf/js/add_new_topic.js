window.onload = initAll;

function initAll(){
	getAllElements();

	setAllActions();
}


var x, y, topic_list, obj, obj1;
function getAllElements(){
	x = document.getElementById("btn1");
	y = document.getElementById("topicname");
	topic_list = document.getElementById("topic_table");

	obj = null;
	obj1 = null;
}

function setAllActions(){
	x.onclick = saveTopic;
	collectTopics();
}



function collectTopics(){
	obj1 = new XMLHttpRequest();
	//alert(y.value);
	obj1.open("get","collecttopic.do?tpname="+y.value,true);
	obj1.onreadystatechange = showTopics;
	obj1.send(null);
}

function showTopics(){
	//alert(obj1.readyState+' ~ '+obj1.status)
	if(obj1.readyState==4&&obj1.status==200){
		//alert(obj1.responseText)
		
		var result = eval(obj1.responseText);
		
		for(i=0;i<result.length;i++){
			var tr = document.createElement("tr");
			var td1 = document.createElement("td");
			var td2 = document.createElement("td");

			td1.innerHTML = result[i].topicId;
			td2.innerHTML = result[i].topic;
			td2.className = "new_row";

			topic_list.className = "new_table";
			topic_list.appendChild(tr);
			topic_list.appendChild(td1);
			topic_list.appendChild(td2);

		}
	}
}

function saveTopic(){
	obj = new XMLHttpRequest();
	
	obj.open("get",'addtopic.do?tpname='+y.value,true);
	obj.onreadystatechange = afterSaveTopics;
	obj.send(null);
}

function afterSaveTopics(){
	if(obj.readyState==4&&obj.status==200){
		collectTopics();
	}
}