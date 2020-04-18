$(document).scroll(function () {
    $('.navbar').toggleClass('scrolled', $(this).scrollTop() > $('.navbar').height());
});

window.onload = initAll();

function initAll() {
    getAllElements();
    setAllActions();
}

var manageBtn, patientRequest, patientAppend,closeBtn,patientId=1,deletePatientReq,urlString,url;

urlString = window.location.href;
url = new URL(urlString);
var email = url.searchParams.get("doctor_email");

function getAllElements() {
    manageBtn = document.getElementById('see_btn');
    patientAppend = document.getElementById('patient_records_append1');
    closeBtn = document.getElementById('close_btn1');
}

function setAllActions() {
    manageBtn.onclick = collectPatient;
    closeBtn.onclick = clearAll;
    //alert(urlString);
    
}

function collectPatient(){
    patientRequest = new XMLHttpRequest();
    patientRequest.open('get','collect_doctor_patient.do?doctor_email='+email,true);
    patientRequest.onreadystatechange = showPatient;
    patientRequest.send(null);
}

function showPatient(){
    if(patientRequest.readyState == 4 && patientRequest.status == 200){
        var result = eval(patientRequest.responseText);

        for (i = 0; i < result.length; i++) {
            var tr = document.createElement("tr");
            tr.className = "text-center";
            var th1 = document.createElement("th");
            th1.scope = "row";
            var td2 = document.createElement("td");
            var td3 = document.createElement("td");
            td3.id = "doctor_email";
            var td4 = document.createElement("td");
            var td5 = document.createElement("td");
           
            var td9 = document.createElement("button");


            th1.innerHTML = patientId;
            td2.innerHTML = result[i].name;
            td3.innerHTML = result[i].dob;
            td4.innerHTML = result[i].gender;
            td5.innerHTML = result[i].patientDoctor;
           

            //td9.id = "removeBtn" + rmvBtnId++;
            td9.className = "btn btn-danger";
            td9.style.width = "90px";
            td9.style.height = "35px";
            td9.style.radius = "80px";
            td9.style.marginTop = "10px";
            td9.style.marginBottom = "2px";
            td9.innerHTML = "Remove";
            td9.name = result[i].email;

            patientAppend.appendChild(tr);
            patientAppend.appendChild(th1);
            patientAppend.appendChild(td2);
            patientAppend.appendChild(td3);
            patientAppend.appendChild(td4);
            patientAppend.appendChild(td5);
            
            patientAppend.appendChild(td9);

            patientId++;
            td9.onclick = deletePatientRequest;
        }
    }
}

function deletePatientRequest(){
    deletePatientReq = new XMLHttpRequest();
    deletePatientReq.open('get','delete_patient.do?email='+this.name,true);
    deletePatientReq.onreadystatechange = deletePatient;
    deletePatientReq.send(null);
}

function deletePatient(){
    //alert(deletePatientReq.readyState +"````````````"+deletePatientReq.status);
    if(deletePatientReq.readyState==4 && deletePatientReq.status==200){
        patientId = 1;
        clearAll();
        collectPatient();
    }
}

function clearAll(){
    patientAppend.innerHTML = null;
    patientId = 1;
}
