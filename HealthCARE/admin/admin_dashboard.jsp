<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <%@ include file="../top.jsp" %>
        <link rel="stylesheet" type="text/css" href="../css/common.css" />
        <link rel="stylesheet" type="text/css" href="../css/clock.css" />
        <link rel="stylesheet" type="text/css" href="../css/admin_dashboard.css" />
        <link rel="stylesheet" type="text/css" href="../css/admin_footer.css" />
        <link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css" />
        <title>Document</title>
    </head>
    <body>
        <%@ include file="admin_dashboard_header.jsp" %>

        <div class="jumbotron jumbotron-fluid height100p banner" id="home" data-aos="fade-up" data-aos-duration="1000" data-aos-delay="500">
            <!-- <img src="uploads/front.jpg" class="back_pic"/> --> 
            <%@ include file="clock.html" %>
        </div>
        <% String message = (String)request.getAttribute("message");
            if(message!=null){ %>
                <input type="hidden" id="msg" value="<%= message %>" />
                <script>
                    var msg = document.getElementById('msg');
                    alert(msg.value);
                </script>
            <% } %>
            
        <% String message1 = (String)request.getAttribute("message1");
            if(message1!=null){ %>
                <input type="hidden" id="msg" value="<%= message1 %>" />
                <script>
                    var msg1 = document.getElementById('msg');
                    alert(msg1.value);
                </script>
        <% } %>
        <% String confMsg =  (String)request.getAttribute("confMsg");
            if(confMsg!=null){ %>
                <input type="hidden" id="confMsg" value="<%= confMsg %>" />
                <script>
                    var confMsgs = document.getElementById('confMsg');
                    alert(confMsgs.value);
                </script>
        <% } %>
        <% String upcomingMsg =  (String)request.getAttribute("upcomingMsg");
            if(upcomingMsg!=null){ %>
                <input type="hidden" id="upcomingMsg" value="<%= upcomingMsg %>" />
                <script>
                    var upcomingMsgs = document.getElementById('upcomingMsg');
                    alert(upcomingMsgs.value);
                </script>
        <% } %>
        <% String deleteMessage =  (String)request.getAttribute("delete_message");
        if(deleteMessage!=null){ %>
            <input type="hidden" id="deleteMessage" value="<%= deleteMessage %>" />
            <script>
                var deleteMessage = document.getElementById('deleteMessage');
                alert(deleteMessage.value);
            </script>
       <% } %>
                 
        <div class="container tables">
            <div class="row">
                <div class="col-lg-12" data-aos="fade-up" data-aos-duration="1000" data-aos-delay="1000">
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-info adminbtn ad1" data-toggle="modal" data-target="#exampleModalScrollable">
                    Add Doctor
                    </button>
                
                    <!-- Modal For Add Doctor -->
                    <div class="modal fade" id="exampleModalScrollable" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
                        <div class="modal-dialog modal-lg modal-dialog-scrollable" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalScrollableTitle">ADD DOCTOR</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                                </div>
                                <form action="doctor_register.do">
                                    <div class="modal-body">
                                        <div class="add_doctor_form">
                                            <div class="form-row">
                                                <div class="form-group col-md-6">
                                                    <label>First Name </label>
                                                    <input type="text" class="form-control" placeholder="First Name" name="doctor_first_name">
                                                </div>
                                                <div class="form-group col-md-6">
                                                    <label >Last Name </label>
                                                    <input type="text" class="form-control" placeholder="Last Name" name="doctor_last_name">
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="form-group col-md-6">
                                                    <label for="inputEmail4">Email</label>
                                                    <input type="email" class="form-control" id="inputEmail4" placeholder="Email" name="doctor_email">
                                                </div>
                                                <div class="form-group col-md-6">
                                                    <label for="inputPassword4">Password</label>
                                                    <input type="password" class="form-control" id="inputPassword4" placeholder="Password" class="doctor_password" name="doctor_password">
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="form-group col-md-3">
                                                    <label>Date Of Birth</label>
                                                    <input type="date" class="form-control" placeholder="Age (in years)" name="doctor_dob">
                                                </div>
                                                <div class="form-check col-md-3">
                                                    <label>Gender:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                                    <input class="form-check-input" type="radio" name="doctor_gender" id="exampleRadios1" value="Male" checked>
                                                    <label class="form-check-label" for="exampleRadios1">
                                                        Male
                                                    </label>
                                                </div>
                                                <div class="form-check col-md-2">
                                                    <input class="form-check-input" type="radio" name="doctor_gender" id="exampleRadios2" value="Female">
                                                    <label class="form-check-label" for="exampleRadios2">
                                                        Female
                                                    </label>
                                                </div>
                                                <div class="form-group col-md-4">
                                                    <label>&nbsp;&nbsp;&nbsp;&nbsp;Department</label>
                                                    <select class="form-control" name="doctor_department">
                                                        <option selected>Choose...</option>
                                                        <option>Orthopaedics</option>
                                                        <option>Skin</option>
                                                        <option>Surgery</option>
                                                        <option>Cardiology</option>
                                                        <option>Radiology</option>
                                                        <option>Emergency</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="inputAddress">Address</label>
                                                <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St" name="doctor_address_1">
                                            </div>
                                            <div class="form-group">
                                                <label for="inputAddress2">Address 2</label>
                                                <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor" name="doctor_address_2">
                                            </div>
                                            <div class="form-row">
                                                <div class="form-group col-md-3">
                                                    <label for="inputCity">City</label>
                                                    <input type="text" class="form-control" id="inputCity" name="doctor_city" placeholder="City">
                                                </div>
                                                <div class="form-group col-md-3">
                                                    <label for="inputState">State</label>
                                                    <select id="inputState" class="form-control" name="doctor_state">
                                                        <option selected disabled>Choose...</option>
                                                        <option>Andhra Pradesh</option>
                                                        <option>Arunachal Pradesh</option>
                                                        <option>Assam</option>
                                                        <option>Bihar</option>
                                                        <option>Chhattisgarh</option>
                                                        <option>Goa</option>
                                                        <option>Gujarat</option>
                                                        <option>Haryana</option>
                                                        <option>Himachal Pradesh</option>
                                                        <option>Jammu and Kashmir</option>
                                                        <option>Jharkhand</option>
                                                        <option>Karnataka</option>
                                                        <option>Kerala</option>
                                                        <option>Madhya Pradesh</option>
                                                        <option>Maharashtra</option>
                                                        <option>Manipur</option>
                                                        <option>Meghalaya</option>
                                                        <option>Mizoram</option>
                                                        <option>Nagaland</option>
                                                        <option>Odisha</option>
                                                        <option>Punjab</option>
                                                        <option>Rajasthan</option>
                                                        <option>Sikkim</option>
                                                        <option>Tamil Nadu</option>
                                                        <option>Telangana</option>
                                                        <option>Tripura</option>
                                                        <option>Uttar Pradesh</option>
                                                        <option>Uttarakhand</option>
                                                        <option>West Bengal</option>
                                                    </select>
                                                </div>
                                                <div class="form-group col-md-3">
                                                    <label for="inputZip">Zip</label>
                                                    <input type="text" class="form-control" id="inputZip" name="doctor_zip" placeholder="Zip Code">
                                                </div>
                                                <div class="form-group col-md-3">
                                                    <label>Nationality</label>
                                                    <input type="text" class="form-control" id="inputZip" name="doctor_nationality" placeholder="Nationality">
                                                </div>
                                            </div>
                                            <div class="form-row">
                                                <div class="form-group col-md-4">
                                                    <label>Experience</label>
                                                    <input type="number" class="form-control" placeholder="Experience (in years)" name="doctor_experience">
                                                </div>
                                                <div class="form-group col-md-4">
                                                    <label>Qualification</label>
                                                    <input type="text" class="form-control" placeholder="Qualification" name="doctor_qualification">
                                                </div>
                                                <div class="form-group col-md-4">
                                                    <label>Specialist</label>
                                                    <input type="text" class="form-control" placeholder="Specialist" name="doctor_specialist">
                                                </div>
                                            </div>    
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <input type="submit" class="btn btn-success" value="Add To Database">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <br />
                <!-- Modal For Conference And Workshops-->
                <div class="modal fade" id="exampleModalScrollable2" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
                    <div class="modal-dialog modal-lg modal-dialog-scrollable" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalScrollableTitle">ADD CONFERENCES & WORKSHOPS</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            </div>
                            <form action="conferences_and_workshops_register.do">
                                <div class="modal-body">
                                    <div class="add_conferences_&_workshops_event_form">
                                        <div class="form-row">
                                            <div class="form-group col-md-12">
                                                <label>Title</label>
                                                <input type="text" class="form-control" placeholder="Enter Title Here..." name="conferences_and_workshops_title">
                                            </div>
                                        </div>
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label>Date Of Uploading</label>
                                                <input type="date" class="form-control" placeholder="Enter Date" name="conferences_and_workshops_date_of_uploading">
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label>Date Of Closing</label>
                                                <input type="date" class="form-control" placeholder="Enter Date" name="conferences_and_workshops_date_of_conference_ws_closed">
                                            </div>
                                        </div> 
                                    </div>   
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <input type="submit" class="btn btn-success" value="Add To Database">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                 <!-- Modal For Upcoming Events -->
                 <div class="modal fade" id="exampleModalScrollable3" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
                    <div class="modal-dialog modal-lg modal-dialog-scrollable" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalScrollableTitle">ADD UPCOMING EVENTS</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            </div>
                            <form action="upcoming_events_register.do">
                                <div class="modal-body">
                                    <div class="add_upcoming_events_form">
                                        <div class="form-row">
                                            <div class="form-group col-md-12">
                                                <label>Title</label>
                                                <input type="text" class="form-control" placeholder="Enter Title Here..." name="upcoming_events_title">
                                            </div>
                                        </div>
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label>Start Date</label>
                                                <input type="date" class="form-control" placeholder="Enter Date" name="upcoming_events_start_date">
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label>End Date</label>
                                                <input type="date" class="form-control" placeholder="Enter Date" name="upcoming_events_close_date">
                                            </div>
                                        </div> 
                                    </div>   
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <input type="submit" class="btn btn-success" value="Add To Database">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- REMOVAL Modal For Conference And Workshops-->
                <div class="modal fade" id="removable1" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
                    <div class="modal-dialog modal-lg modal-dialog-scrollable" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                            <h5 class="modal-title" id="removable1">REMOVE CONFERENCES & WORKSHOPS</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            </div>
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th scope="col">S.No</th>
                                        <th scope="col">Conference Event Title</th>
                                        <th scope="col">Start Date</th>
                                        <th scope="col">End Date</th>
                                        <th scope="col">Removal</th>
                                    </tr>
                                </thead>
                                <tbody id="conference_append">
                                    
                                </tbody>
                            </table>	                        
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" id="close_btn" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
                 <!--REMOVAL Modal For Upcoming Events -->
                 <div class="modal fade" id="removable2" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
                    <div class="modal-dialog modal-lg modal-dialog-scrollable" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="removable2">REMOVE UPCOMING EVENTS</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>                            
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th scope="col">S.No</th>
                                            <th scope="col">Upcoming Event Title</th>
                                            <th scope="col">Start Date</th>
                                            <th scope="col">End Date</th>
                                            <th scope="col">Removal</th>
                                        </tr>
                                    </thead>
                                    <tbody id="upcoming_append">
                                        
                                    </tbody>
                                </table>	 
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary"  id="close_btn2" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-12" data-aos="fade-up" data-aos-duration="1000" data-aos-delay="1200">
                    <button class="btn btn-warning adminbtn ad2 nav-link dropdown-toggle" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Add Events
                    </button>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        
                        <button type="button" class="btn btn-link" data-toggle="modal" data-target="#exampleModalScrollable2">
                            Conferences & Workshops
                        </button>
                       
                        <div class="dropdown-divider"></div>

                        <button type="button" class="btn btn-link" data-toggle="modal" data-target="#exampleModalScrollable3">
                            Upcoming Events 
                        </button>

                    </div>
                </div>
                <br />
                <div class="col-lg-12" data-aos="fade-up" data-aos-duration="1000" data-aos-delay="1400">
                    <button type="button" class="btn btn-info adminbtn ad3" data-toggle="modal" data-target="#exampleModalScrollable1">
                        Add Receptionist
                        </button>
                    
                        <!-- Modal For Add Receptionist -->
                        <div class="modal fade" id="exampleModalScrollable1" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
                            <div class="modal-dialog modal-lg modal-dialog-scrollable" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalScrollableTitle">ADD RECEPTIONIST</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                    </div>
                                    <form action="receptionist_register.do">
                                        <div class="modal-body">
                                            <div class="add_receptioist_form">
                                                <div class="form-row">
                                                    <div class="form-group col-md-6">
                                                        <label>First Name </label>
                                                        <input type="text" class="form-control" placeholder="First Name" name="receptionist_first_name">
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label >Last Name </label>
                                                        <input type="text" class="form-control" placeholder="Last Name" name="receptionist_last_name">
                                                    </div>
                                                </div>
                                                <div class="form-row">
                                                    <div class="form-group col-md-6">
                                                        <label for="inputEmail4">Email</label>
                                                        <input type="email" class="form-control" id="inputEmail4" placeholder="Email" name="receptionist_email">
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label for="inputPassword4">Password</label>
                                                        <input type="password" class="form-control" id="inputPassword4" placeholder="Password" class="receptionist_password" name="receptionist_password">
                                                    </div>
                                                </div>
                                                <div class="form-row">
                                                    <div class="form-group col-md-4">
                                                        <label>Date Of Birth</label>
                                                        <input type="date" class="form-control" placeholder="Age (in years)" name="receptionist_dob">
                                                    </div>
                                                    <div class="form-check col-md-4">
                                                        <label>Gender:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                                        <input class="form-check-input" type="radio" name="receptionist_gender" id="exampleRadios1" value="Male" checked>
                                                        <label class="form-check-label" for="exampleRadios1">
                                                            Male
                                                        </label>
                                                    </div>
                                                    <div class="form-check col-md-4">
                                                        <input class="form-check-input" type="radio" name="receptionist_gender" id="exampleRadios2" value="Female">
                                                        <label class="form-check-label" for="exampleRadios2">
                                                            Female
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="inputAddress">Address</label>
                                                    <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St" name="receptionist_address_1">
                                                </div>
                                                <div class="form-group">
                                                    <label for="inputAddress2">Address 2</label>
                                                    <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor" name="receptionist_address_2">
                                                </div>
                                                <div class="form-row">
                                                    <div class="form-group col-md-3">
                                                        <label for="inputCity">City</label>
                                                        <input type="text" class="form-control" id="inputCity" name="receptionist_city" placeholder="City">
                                                    </div>
                                                    <div class="form-group col-md-3">
                                                        <label for="inputState">State</label>
                                                        <select id="inputState" class="form-control" name="receptionist_state">
                                                            <option selected disabled>Choose...</option>
                                                            <option>Andhra Pradesh</option>
                                                            <option>Arunachal Pradesh</option>
                                                            <option>Assam</option>
                                                            <option>Bihar</option>
                                                            <option>Chhattisgarh</option>
                                                            <option>Goa</option>
                                                            <option>Gujarat</option>
                                                            <option>Haryana</option>
                                                            <option>Himachal Pradesh</option>
                                                            <option>Jammu and Kashmir</option>
                                                            <option>Jharkhand</option>
                                                            <option>Karnataka</option>
                                                            <option>Kerala</option>
                                                            <option>Madhya Pradesh</option>
                                                            <option>Maharashtra</option>
                                                            <option>Manipur</option>
                                                            <option>Meghalaya</option>
                                                            <option>Mizoram</option>
                                                            <option>Nagaland</option>
                                                            <option>Odisha</option>
                                                            <option>Punjab</option>
                                                            <option>Rajasthan</option>
                                                            <option>Sikkim</option>
                                                            <option>Tamil Nadu</option>
                                                            <option>Telangana</option>
                                                            <option>Tripura</option>
                                                            <option>Uttar Pradesh</option>
                                                            <option>Uttarakhand</option>
                                                            <option>West Bengal</option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group col-md-3">
                                                        <label for="inputZip">Zip</label>
                                                        <input type="text" class="form-control" id="inputZip" name="receptionist_zip" placeholder="Zip Code">
                                                    </div>
                                                    <div class="form-group col-md-3">
                                                        <label>Nationality</label>
                                                        <input type="text" class="form-control" id="inputZip" name="receptionist_nationality" placeholder="Nationality">
                                                    </div>
                                                </div>
                                                <div class="form-row">
                                                    <div class="form-group col-md-6">
                                                        <label>Experience</label>
                                                        <input type="number" class="form-control" placeholder="Experience (in years)" name="receptionist_experience">
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label>Qualification</label>
                                                        <input type="text" class="form-control" placeholder="Qualification" name="receptionist_qualification">
                                                    </div>
                                                </div>    
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                            <input type="submit" class="btn btn-success" value="Add To Database">
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="container tablesright">
            <div class="row">
                <div class="col-lg-12" data-aos="fade-up" data-aos-duration="1000" data-aos-delay="1600">
                <!-- <a href="#" class="btn btn-info adminbtn ad1">Remove Doctor</a> -->
                <button type="button" class="btn btn-info adminbtn ad1" id="remove_doctor_btn" data-toggle="modal" data-target="#exampleModalScrollableRemoveDoctor">
                    Remove Doctor
                </button>
                <!-- Remove Doctor Model -->
                <div class="modal fade" id="exampleModalScrollableRemoveDoctor" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
                    <div class="modal-dialog mw-100 w-75 modal-lg modal-dialog-scrollable" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalScrollableTitle">Remove Doctor</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            </div>
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th scope="col">S.No</th>
                                        <th scope="col">Doctor</th>
                                        <th scope="col">Email</th>
                                        <th scope="col">DOB</th>
                                        <th scope="col">Specialist</th>
                                        <th scope="col">Experience</th>
                                        <th scope="col">Gender</th>
                                        <th scope="col">Department</th>
                                        <th scope="col">Removal</th>
                                    </tr>
                                </thead>
                                <tbody id="doctor_records">
                                    
                                </tbody>
                            </table>	                                
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" id="close_btn1" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
                </div>
                <br />
                <div class="col-lg-12" data-aos="fade-up" data-aos-duration="1000" data-aos-delay="1800">
                <button class="btn btn-warning adminbtn ad2 nav-link dropdown-toggle" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Remove Events
                </button>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <!-- <a class="dropdown-item" href="#">Conferences & Workshops</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Upcoming Events</a> -->

                    <button type="button" class="btn btn-link" id="remove_conference" data-toggle="modal" data-target="#removable1">
                        Conferences & Workshops
                    </button>
                   
                    <div class="dropdown-divider"></div>

                    <button type="button" class="btn btn-link" id="remove_upcoming_events" data-toggle="modal" data-target="#removable2">
                        Upcoming Events 
                    </button>
                </div>
                </div>
                <br />
                <div class="col-lg-12" data-aos="fade-up" data-aos-duration="1000" data-aos-delay="2000">
                    <!-- <a href="#" class="btn btn-info adminbtn ad3">Remove Receptionist</a> -->
                    <button type="button" class="btn btn-info adminbtn ad3" id="remove_receptionist_btn" data-toggle="modal" data-target="#exampleModalScrollableRemoveReceptionist">
                        Remove Receptionist
                    </button>
                    <!-- Remove Receptionist Model -->
                    <div class="modal fade" id="exampleModalScrollableRemoveReceptionist" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
                        <div class="modal-dialog mw-100 w-75 modal-lg modal-dialog-scrollable" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalScrollableTitle">Remove Receptionist</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                                </div>
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th scope="col">S.No</th>
                                            <th scope="col">Receptionist</th>
                                            <th scope="col">Email</th>
                                            <th scope="col">DOB</th>
                                            <th scope="col">Experience</th>
                                            <th scope="col">Gender</th>
                                            <th scope="col">Removal</th>
                                        </tr>
                                    </thead>
                                    <tbody id="receptionist_records">
                                        
                                    </tbody>
                                </table>	                                
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" id="close_btn3" data-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%@ include file="../bottom.jsp" %>
        <%@ include file="admin_footer.jsp" %>

        <script src="https://unpkg.com/aos@next/dist/aos.js"></script>
        <script>
            AOS.init();
        </script>
        <script src="../js/admin_dashboard.js"></script>
        <script src="../js/clock.js"></script>
    </body>
</html>