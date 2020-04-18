window.onload = initAll();

function initAll() {
    getAllElements();
    setAllActions();
}

//------------------------------Doctor Removal Variable Declaration------------------------------------------------

var removeEventRequest, removeDoctorButton, request, removeDoctorRequest, doctorRecords, userId = 1, closeBtn, rmvBtnId = 1, doctorEmail, closeBtn1, closeBtn2, close_btn3;

//-----------------------------------------------------------------------------------------------------------------

//------------------------------Receptionist Removal Variable Declaration------------------------------------------------

var removeReceptionistButton, receptionistRequest, removeReceptionistRequest, receptionistRecordsAppend, recep=1;

//-----------------------------------------------------------------------------------------------------------------


//------------------------------Conference Removal Variable Declaration------------------------------------------------

var conferenceRemoveButton, conferenceRequest, conferenceAppend, conf = 1;

//-----------------------------------------------------------------------------------------------------------------

//------------------------------Upcoming Removal Variable Declaration------------------------------------------------

var upcomingRemoveButton, upcomingRequest, upcomingAppend, upcomingCount = 1;

//-----------------------------------------------------------------------------------------------------------------

function getAllElements() {

    //----------------------------Doctor Removal Panel Button Initialization--------------------

    removeDoctorButton = document.getElementById("remove_doctor_btn");
    doctorRecords = document.getElementById("doctor_records");
    closeBtn = document.getElementById('close_btn');
    closeBtn1 = document.getElementById('close_btn1');
    closeBtn2 = document.getElementById('close_btn2');
    closeBtn3 = document.getElementById('close_btn3');
    clear = document.getElementById('exampleModalScrollableRemoveDoctor');

    //------------------------------------------------------------------------------------------

    //----------------------------Receptionist Button Initialization------------------------------

    removeReceptionistButton = document.getElementById('remove_receptionist_btn');
    receptionistRecordsAppend = document.getElementById('receptionist_records');

    //------------------------------------------------------------------------------------------

    //----------------------------Conference Button Initialization------------------------------

    conferenceRemoveButton = document.getElementById('remove_conference');
    conferenceAppend = document.getElementById('conference_append');

    //------------------------------------------------------------------------------------------

    //----------------------------Upcoming Button Initialization------------------------------

    upcomingRemoveButton = document.getElementById('remove_upcoming_events');
    upcomingAppend = document.getElementById('upcoming_append');
    
    //------------------------------------------------------------------------------------------
}

function setAllActions() {

    //-------------------------Doctor Removal Action Setters------------------------------------

    removeDoctorButton.onclick = collectDoctorRecords;
    closeBtn.onclick = clearAll;
    closeBtn1.onclick = clearAll;
    closeBtn2.onclick = clearAll;
    closeBtn3.onclick = clearAll;

    //-------------------------------------------------------------------------------------------

    //-------------------------Conference Removal Action Setters---------------------------------

    conferenceRemoveButton.onclick = collectConferenceRecord;

    //-------------------------------------------------------------------------------------------

    //-------------------------Upcoming Removal Action Setters---------------------------------

    upcomingRemoveButton.onclick = collectUpcomingRecord;

    //-------------------------------------------------------------------------------------------

    //-------------------------Receptionist Removal Action Setters---------------------------------

    removeReceptionistButton.onclick = collectReceptionist;

    //-------------------------------------------------------------------------------------------
}

function collectReceptionist(){
    receptionistRequest = new XMLHttpRequest();
    receptionistRequest.open('get','collect_receptionist.do?user_type_id=3');
    receptionistRequest.onreadystatechange = showReceptionistRecords;
    receptionistRequest.send(null);
}

function showReceptionistRecords(){
    if(receptionistRequest.readyState == 4 && receptionistRequest.status == 200){
        var result = eval(receptionistRequest.responseText);

        for(i=0;i<result.length;i++){
            for (i = 0; i < result.length; i++) {
                var tr = document.createElement("tr");
                tr.className = "text-center";
                var th1 = document.createElement("th");
                th1.scope = "row";
                var td2 = document.createElement("td");
                var td3 = document.createElement("td");
                td3.id = "doctor_email";
                var td4 = document.createElement("td");
                var td6 = document.createElement("td");
                var td7 = document.createElement("td");
                var td9 = document.createElement("button");
    
    
                th1.innerHTML = recep;
                td2.innerHTML = result[i].name;
                td3.innerHTML = result[i].email;
                td4.innerHTML = result[i].dob;
                td6.innerHTML = result[i].experience;
                td7.innerHTML = result[i].gender;
    
                td9.id = "removeBtn" + rmvBtnId++;
                td9.className = "btn btn-danger";
                td9.style.width = "90px";
                td9.style.height = "35px";
                td9.style.radius = "80px";
                td9.style.marginTop = "10px";
                td9.style.marginBottom = "2px";
                td9.innerHTML = "Remove";
                td9.name = td3.innerHTML;
    
                receptionistRecordsAppend.appendChild(tr);
                receptionistRecordsAppend.appendChild(th1);
                receptionistRecordsAppend.appendChild(td2);
                receptionistRecordsAppend.appendChild(td3);
                receptionistRecordsAppend.appendChild(td4);
                receptionistRecordsAppend.appendChild(td6);
                receptionistRecordsAppend.appendChild(td7);
                receptionistRecordsAppend.appendChild(td9);
    
                recep++;
                td9.onclick = deleteReceptionistRequest;
            }
        }
    }    
}

function deleteReceptionistRequest(){
    removeReceptionistRequest = new XMLHttpRequest();
    removeReceptionistRequest.open('get','delete_receptionist.do?user_type_id=3&email='+this.name,true); 
    removeReceptionistRequest.onreadystatechange = deleteReceptionist;
    removeReceptionistRequest.send(null);
}

function deleteReceptionist(){
    if(removeReceptionistRequest.readyState == 4 && removeReceptionistRequest.status == 200){
        recep = 1;
        var result = eval(removeReceptionistRequest.responseText);
        clearAll();
        collectReceptionist();
        //alert(result);
    }
}

function collectUpcomingRecord(){
    upcomingRequest = new XMLHttpRequest();
    upcomingRequest.open('get', 'collect_upcoming.do?event_type_id=2', true);
    upcomingRequest.onreadystatechange = showUpcomingRecords;
    upcomingRequest.send(null);
}

function showUpcomingRecords(){
    if (upcomingRequest.readyState == 4 && upcomingRequest.status == 200) {
        var result = eval(upcomingRequest.responseText);

        for (i = 0; i < result.length; i++) {
            var tr = document.createElement("tr");
            var th1 = document.createElement("th");
            th1.scope = "row";
            var td2 = document.createElement("td");
            var td3 = document.createElement("td");
            var td4 = document.createElement("td");
            var td5 = document.createElement("button");


            th1.innerHTML = upcomingCount;
            td2.innerHTML = result[i].eventTitle;
            td3.innerHTML = result[i].eventEndDate;
            td4.innerHTML = result[i].eventStartDate;

            td5.id = "removeBtn" + rmvBtnId++;
            td5.className = "btn btn-danger";
            td5.style.width = "90px";
            td5.style.height = "35px";
            td5.style.radius = "80px";
            td5.style.marginTop = "10px";
            td5.style.marginBottom = "2px";
            td5.innerHTML = "Remove";
            td5.name = "2"+result[i].eventTitle;

            upcomingAppend.appendChild(tr);
            upcomingAppend.appendChild(th1);
            upcomingAppend.appendChild(td2);
            upcomingAppend.appendChild(td3);
            upcomingAppend.appendChild(td4);
            upcomingAppend.appendChild(td5);

            upcomingCount++;
            td5.onclick = deleteEventRequest2;
        }
    }
}

function collectConferenceRecord() {
    conferenceRequest = new XMLHttpRequest();
    conferenceRequest.open('get', 'collect_conference.do?event_type_id=1', true);
    conferenceRequest.onreadystatechange = showConferenceRecords;
    conferenceRequest.send(null);
}

function showConferenceRecords() {
    if (conferenceRequest.readyState == 4 && conferenceRequest.status == 200) {
        var result = eval(conferenceRequest.responseText);

        for (i = 0; i < result.length; i++) {
            var tr = document.createElement("tr");
            var th1 = document.createElement("th");
            th1.scope = "row";
            var td2 = document.createElement("td");
            var td3 = document.createElement("td");
            td3.id = "doctor_email";
            var td4 = document.createElement("td");
            var td5 = document.createElement("button");


            th1.innerHTML = conf;
            td2.innerHTML = result[i].eventTitle;
            td3.innerHTML = result[i].eventEndDate;
            td4.innerHTML = result[i].eventStartDate;

            td5.id = "removeBtn" + rmvBtnId++;
            td5.className = "btn btn-danger";
            td5.style.width = "90px";
            td5.style.height = "35px";
            td5.style.radius = "80px";
            td5.style.marginTop = "10px";
            td5.style.marginBottom = "2px";
            td5.innerHTML = "Remove";
            td5.name = "1"+result[i].eventTitle;

            conferenceAppend.appendChild(tr);
            conferenceAppend.appendChild(th1);
            conferenceAppend.appendChild(td2);
            conferenceAppend.appendChild(td3);
            conferenceAppend.appendChild(td4);
            conferenceAppend.appendChild(td5);

            conf++;
            td5.onclick = deleteEventRequest1;
        }
    }
}

function deleteEventRequest1() {
    removeEventRequest = new XMLHttpRequest();
    removeEventRequest.open('get', 'delete_event.do?event_type_id=' + this.name, true);
    removeEventRequest.onreadystatechange = deleteEvent1;
    removeEventRequest.send(null);
}

function deleteEvent1() {
    if (removeEventRequest.readyState==4&&removeEventRequest.status==200){
        conf = 1;
        var result = eval(removeEventRequest.responseText);
        clearAll();
        collectConferenceRecord();
        //alert(result);
    }
}

function deleteEventRequest2() {
    removeEventRequest = new XMLHttpRequest();
    removeEventRequest.open('get', 'delete_event.do?event_type_id=' + this.name, true);
    removeEventRequest.onreadystatechange = deleteEvent2;
    removeEventRequest.send(null);
}

function deleteEvent2() {
    if (removeEventRequest.readyState==4&&removeEventRequest.status==200){
        upcomingCount = 1;
        var result = eval(removeEventRequest.responseText);
        //alert(result);
        clearAll();
        collectUpcomingRecord();
    }
}

function collectDoctorRecords() {
    request = new XMLHttpRequest();
    request.open('get', 'collect_doctors_records.do?user_type_id=2', true); 
    request.onreadystatechange = showDoctorsRecords;
    request.send(null);
}

function showDoctorsRecords() {

    if (request.readyState == 4 && request.status == 200) {

        var result = eval(request.responseText);

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
            var td6 = document.createElement("td");
            var td7 = document.createElement("td");
            var td8 = document.createElement("td");
            var td9 = document.createElement("button");


            th1.innerHTML = userId;
            td2.innerHTML = result[i].name;
            td3.innerHTML = result[i].email;
            td4.innerHTML = result[i].dob;
            td5.innerHTML = result[i].specialist;
            td6.innerHTML = result[i].experience;
            td7.innerHTML = result[i].gender;
            td8.innerHTML = result[i].department;

            td9.id = "removeBtn" + rmvBtnId++;
            td9.className = "btn btn-danger";
            td9.style.width = "90px";
            td9.style.height = "35px";
            td9.style.radius = "80px";
            td9.style.marginTop = "10px";
            td9.style.marginBottom = "2px";
            td9.innerHTML = "Remove";
            td9.name = td3.innerHTML;

            doctorRecords.appendChild(tr);
            doctorRecords.appendChild(th1);
            doctorRecords.appendChild(td2);
            doctorRecords.appendChild(td3);
            doctorRecords.appendChild(td4);
            doctorRecords.appendChild(td5);
            doctorRecords.appendChild(td6);
            doctorRecords.appendChild(td7);
            doctorRecords.appendChild(td8);
            doctorRecords.appendChild(td9);

            userId++;
            td9.onclick = deleteDoctorRequest;
        }
    }
}
//-------------------------------------------delete doctor record AJAX----------------------------
function deleteDoctorRequest() {
    removeDoctorRequest = new XMLHttpRequest();
    removeDoctorRequest.open('get', 'delete_doctors_records.do?user_type_id=2&email=' + this.name + '&record_id=' + this.id, true);
    removeDoctorRequest.onreadystatechange = deleteDoctorRecord;
    removeDoctorRequest.send(null);
}

function deleteDoctorRecord() {
    //alert(removeDoctorRequest.readyState+"~~~~~~~~~~~~~"+removeDoctorRequest.status);
    if (removeDoctorRequest.readyState == 4 && removeDoctorRequest.status == 200) {
        userId = 1;
        var result = eval(removeDoctorRequest.responseText);
        clearAll();
        collectDoctorRecords();
        //alert(result);
    }
}
//------------------------------------------------------------------------------------------------
function clearAll() {
    doctorRecords.innerHTML = null;
    userId = 1;
    rmvBtnId = 1;

    conferenceAppend.innerHTML = null;
    conf = 1;

    upcomingAppend.innerHTML = null;
    upcomingCount = 1;

    receptionistRecordsAppend.innerHTML = null;
    recep=1;
}