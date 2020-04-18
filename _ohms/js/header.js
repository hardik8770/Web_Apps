window.onload = initAll();

function initAll() {
    getAllElements();
    setAllActions();
}

var appointmentBtn, docRecordRequest, doctorAppend,closeBtn;

function getAllElements() {
    appointmentBtn = document.getElementById('appointment_take');
    doctorAppend = document.getElementById('choose_doctor_append');
    closeBtn = document.getElementById('close_btn');
}
    
function setAllActions() {
    appointmentBtn.onclick = collectDoctors;
    closeBtn.onclick = clearAll;
}

function collectDoctors() {
    docRecordRequest = new XMLHttpRequest();
    docRecordRequest.open('get', 'collect_doctors_records.do?user_type_id=2', true);
    docRecordRequest.onreadystatechange = showDoctorsRecords;
    docRecordRequest.send(null);
}

function showDoctorsRecords() {
    if (docRecordRequest.readyState == 4 && docRecordRequest.status == 200) {
        var result = eval(docRecordRequest.responseText);

        for(i=0;i<result.length;i++){
            var option = document.createElement('option');
            option.innerHTML = result[i].name;
            doctorAppend.appendChild(option);
        }
    }
}

function clearAll(){
    doctorAppend.innerHTML = null;
}