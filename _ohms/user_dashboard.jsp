<!DOCTYPE html>
<html lang="en">
<head>
    <% request.setAttribute("user_dashboard",true); %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <%@ include file="top.jsp" %>
    <link rel="stylesheet" type="text/css" href="css/common.css" />
    <link rel="stylesheet" type="text/css" href="css/footer.css" />
    <link rel="stylesheet" type="text/css" href="css/user_dashboard.css" />
    <link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css" />
    <title>Document</title>
    
</head>
<body>
    
    <%@ include file="header.jsp" %>
     
    <div class="jumbotron jumbotron-fluid height100p banner" id="home" data-aos="fade-up" data-aos-duration="1000" data-aos-delay="500">
        <!-- <img src="uploads/front.jpg" class="back_pic"/> -->
        <div class="section3" >
            <section class="contact" id="contact_us">
                <div class="container admin_signin">
                    <div class="row record_box">
                        <div class="container">
                            <div class="headerText text-center welcm">
                                <h1 ><br />Welcome <span>User</span> !!!</h1>
                            </div>
                            <br />
                            <div class="col-lg-12" data-aos="fade-up" data-aos-duration="300" data-aos-delay="300">
                                <!-- <a href="#" class="btn btn-info adminbtn ad3">Remove Receptionist</a> -->
                                <button type="button" class="btn btn-warning adminbtn ad3" id="manage_btn" data-toggle="modal" data-target="#exampleModalScrollableManageAppointment">
                                    See and manage your appointment
                                </button>
                                
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </div>
    <br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />   
    <%@ include file="footer.jsp" %>
    <%@ include file="bottom.jsp" %>
    <script type="text/javascript" src="js/user_login.js"></script>
</script>
    <script src="https://unpkg.com/aos@next/dist/aos.js"></script>
    <script>
        AOS.init();
    </script>
    
</body>
</html>