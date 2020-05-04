<link rel="stylesheet" type="text/css" href="css/header.css" />
<% Boolean receptionist =  (Boolean)request.getAttribute("receptionist_dashboard"); %>
<% Boolean doctorDash =  (Boolean)request.getAttribute("doctor_dashboard"); %>
<header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top" data-aos="fade-up" data-aos-duration="1000" data-aos-delay="1000">
            <div class="container">
                <a class="navbar-brand" href="#">
                        <img src="uploads/logo.png" alt="Brand" class="img-responsive">
                </a>
                <div id="logo_txt" class="nav_text"><a class="navbar-brand" href="#"><h2>Health <span id="care">CARE</span></h2></a></div>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
            
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <% if(receptionist!=null){ %>
                        <% String message1 = (String)request.getAttribute("message1");
                        if(message1!=null){ %>
                            <input type="hidden" id="msg" value="<%= message1 %>" />
                            <script>
                                var msg = document.getElementById('msg');
                                alert(msg.value);
                            </script>
                        <% } %>
                    
                        <!-- Remove Appointment Model -->
                    <div class="modal fade" id="exampleModalScrollableManageAppointment" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
                            <div class="modal-dialog mw-100 w-75 modal-lg modal-dialog-scrollable" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalScrollableTitle">Manage Appointments</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                    </div>
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th scope="col">S.No</th>
                                                <th scope="col">Patient Name</th>
                                                <th scope="col">DOB</th>    
                                                <th scope="col">Gender</th>
                                                <th scope="col">Doctor's Name</th>
                                                <th scope="col">Removal</th>
                                            </tr>
                                        </thead>
                                        <tbody id="patient_records_append">
                                            
                                        </tbody>
                                    </table>	                                
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" id="close_btn1" data-dismiss="modal">Close</button>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Modal for +Appointment -->
                        <div class="modal fade" id="exampleModalScrollableappointment" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
                                <div class="modal-dialog modal-lg modal-dialog-scrollable" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalScrollableTitle">NEW APPOINTMENT</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                        </div>
                                        <form action="appointment_register.do">
                                            <div class="modal-body">
                                                <div class="add_doctor_form">
                                                    <div class="form-row">
                                                        <div class="form-group col-md-6">
                                                            <label>First Name </label>
                                                            <input type="text" class="form-control" placeholder="First Name" name="patient_first_name">
                                                        </div>
                                                        <div class="form-group col-md-6">
                                                            <label >Last Name </label>
                                                            <input type="text" class="form-control" placeholder="Last Name" name="patient_last_name">
                                                        </div>
                                                    </div>
                                                    <div class="form-row">
                                                        <div class="form-group col-md-6">
                                                            <label for="inputEmail4">Email</label>
                                                            <input type="email" class="form-control" id="inputEmail4" placeholder="Email" name="patient_email">
                                                        </div>
                                                        <div class="form-group col-md-6">
                                                            <label >Contact No.</label>
                                                            <input type="number" class="form-control" id="contact" placeholder="Contact Here" class="patient_password" name="patient_contact">
                                                        </div>
                                                    </div>
                                                    <div class="form-row">
                                                        <div class="form-group col-md-3">
                                                            <label>Date Of Birth</label>
                                                            <input type="date" class="form-control" placeholder="Age (in years)" name="patient_dob">
                                                        </div>
                                                        <div class="form-check col-md-3">
                                                            <label>Gender:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                                            <input class="form-check-input" type="radio" name="patient_gender" id="exampleRadios1" value="Male" checked>
                                                            <label class="form-check-label" for="exampleRadios1">
                                                                Male
                                                            </label>
                                                        </div>
                                                        <div class="form-check col-md-2">
                                                            <input class="form-check-input" type="radio" name="patient_gender" id="exampleRadios2" value="Female">
                                                            <label class="form-check-label" for="exampleRadios2">
                                                                Female
                                                            </label>
                                                        </div>
                                                        <div class="form-group col-md-4">
                                                            <label>&nbsp;&nbsp;&nbsp;&nbsp;Select Doctor</label>
                                                            <select class="form-control" name="patient_doctor" id="choose_doctor_append">
                                                                <option selected>Choose...</option>
                                                                
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="inputAddress">Address</label>
                                                        <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St" name="patient_address_1">
                                                    </div>
                                                    
                                                    <div class="form-row">
                                                        <div class="form-group col-md-4">
                                                            <label for="inputCity">City</label>
                                                            <input type="text" class="form-control" id="inputCity" name="patient_city" placeholder="City">
                                                        </div>
                                                        <div class="form-group col-md-4">
                                                            <label for="inputState">State</label>
                                                            <select id="inputState" class="form-control" name="patient_state">
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
                                                        <div class="form-group col-md-4">
                                                            <label for="inputZip">Zip</label>
                                                            <input type="text" class="form-control" id="inputZip" name="patient_zip" placeholder="Zip Code">
                                                        </div>
                                                    </div>
                                                    <div class="form-row">
                                                        <div class="form-group col-md-4">
                                                            <label>Date Of Appointment</label>
                                                            <input type="date" class="form-control" placeholder="Date Of Appointment" name="patient_doa">
                                                        </div>
                                                        <div class="form-group col-md-4">
                                                            <label>Time</label>
                                                            <input type="time" class="form-control" placeholder="Time" name="patient_doa_time" value="00:00:01" step="1">
                                                        </div>
                                                    </div>    
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" id="close_btn" data-dismiss="modal">Close</button>
                                                <input type="submit" class="btn btn-success" value="Add To Database">
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                           
                            <div id="rec_logout">
                                <ul class="navbar-nav ml-lg-auto">
                                    <div class="nav-item dropdown event_btn">
                                        <button type="button" class="btn btn-success dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Events
                                        </button>
                                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                            <a class="dropdown-item" href="#">Conferences & Workshops</a>
                                            <div class="dropdown-divider"></div>
                                            <a class="dropdown-item" href="#">Upcoming Events</a>
                                        </div>
                                    </div>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <li class="nav-item">
                                        <button type="button" class="btn btn-success"  id="appointment_take" data-toggle="modal" data-target="#exampleModalScrollableappointment">
                                            <b> <i>Appointment +</i></b>
                                        </button>
                                    </li>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <li class="nav-item">
                                        <a class="btn btn-danger" href="receptionist_logout.do">LogOut </a>
                                    </li>    
                                </ul>
                            </div>   
                            <script src="js/header.js"></script> 
                    <% }else if(doctorDash!=null){ %>
                        <!-- Remove Patient By Doctor Model -->
                        <div class="modal fade" id="exampleModalScrollableManageAppointment" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
                                <div class="modal-dialog mw-100 w-75 modal-lg modal-dialog-scrollable" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalScrollableTitle">Manage Appointments</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                        </div>
                                        <table class="table table-striped">
                                            <thead>
                                                <tr>
                                                    <th scope="col">S.No</th>
                                                    <th scope="col">Patient Name</th>
                                                    <th scope="col">DOB</th>    
                                                    <th scope="col">Gender</th>
                                                    <th scope="col">Doctor's Name</th>
                                                    <th scope="col">Removal</th>
                                                </tr>
                                            </thead>
                                            <tbody id="patient_records_append1">
                                                
                                            </tbody>
                                        </table>	                                
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" id="close_btn1" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <ul class="navbar-nav ml-lg-auto">
                                <div class="nav-item dropdown event_btn">
                                    <button type="button" class="btn btn-warning dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Events
                                    </button>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                        <a class="dropdown-item" href="#">Conferences & Workshops</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="#">Upcoming Events</a>
                                    </div>
                                </div>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <li class="nav-item">
                                    <a class="nav-link btn btn-danger" href="doctor_logout.do">LogOut</a>
                                </li>
                            </ul>
                        <% }else{ %>
                             <!-- SignUpModel -->
                                <div class="modal fade" id="exampleModalScrollableSignUpModel" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
                                    <div class="modal-dialog modal-lg modal-dialog-scrollable" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalScrollableTitle"><span id="signUpTxt">SignUp Here</span></h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                            <form action="user_register.do" name="user_form">
                                                <div class="modal-body">
                                                    <div class="add_doctor_form">
                                                        <div class="form-row">
                                                            <div class="form-group col-md-6">
                                                                <label>First Name </label>
                                                                <input type="text" class="form-control" placeholder="First Name" name="user_first_name">
                                                            </div>
                                                            <div class="form-group col-md-6">
                                                                <label >Last Name </label>
                                                                <input type="text" class="form-control" placeholder="Last Name" name="user_last_name">
                                                            </div>
                                                        </div>
                                                        <div class="form-row">
                                                            <div class="form-group col-md-6">
                                                                <label for="inputEmail4">Email</label>
                                                                <input type="email" class="form-control" id="inputEmail4" placeholder="Email" name="user_email">
                                                            </div>
                                                            <div class="form-group col-md-6">
                                                                <label for="inputPassword4">Password</label>
                                                                <input type="password" class="form-control" id="inputPassword4" placeholder="Password" class="user_password" name="user_password">
                                                            </div>
                                                        </div>
                                                        <div class="form-row">
                                                            <div class="form-group col-md-6">
                                                                <label for="inputPassword4">Confirm Password</label>
                                                                <input type="password" class="form-control" id="inputPassword4" placeholder="Password" class="user_confirm_password" name="user_confirm_password">
                                                            </div>
                                                            
                                                            <div class="form-check col-md-3">
                                                                <label>Gender:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                                                <input class="form-check-input" type="radio" name="user_gender" id="exampleRadios1" value="Male" checked>
                                                                <label class="form-check-label" for="exampleRadios1">
                                                                    Male
                                                                </label>
                                                            </div>
                                                            <div class="form-check col-md-2">
                                                                <input class="form-check-input" type="radio" name="user_gender" id="exampleRadios2" value="Female">
                                                                <label class="form-check-label" for="exampleRadios2">
                                                                    Female
                                                                </label>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                    <input type="submit" class="btn btn-success" value="SignUp">
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                        <ul class="navbar-nav ml-lg-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                            </li>
                        
                            <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Departments
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                        <a class="dropdown-item" href="ortho.jsp">Orthopaedics</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="skin.jsp">Skin</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="surgery.jsp">Plastic Surgery</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="cardio.jsp">Cardiology</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="radio.jsp">Radiology</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="emergency.jsp">Emergency</a>
                                    </div>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="doctor_login.jsp">Doctor</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="receptionist_login.jsp">Receptionist</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="user_login.jsp">User</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="index.jsp#contact_us">Contact Us</a>
                                </li>
                            <!-- <li class="nav-item">
                            <a class="nav-link disabled" href="#">Disabled</a>
                            </li> -->
                        </ul>
                    <% } %>
                </div>
           </div>
        </nav>
</header>