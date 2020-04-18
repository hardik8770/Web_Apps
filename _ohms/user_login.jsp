<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <%@ include file="top.jsp" %>
        <link rel="stylesheet" type="text/css" href="css/common.css" />
        <link rel="stylesheet" type="text/css" href="css/footer.css" />
        <link rel="stylesheet" type="text/css" href="css/user_login.css" />
        <link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css" />
        <title>Document</title>
        
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <% String userMessage = (String)request.getAttribute("u_msg"); %>
        <% if(userMessage!=null){ %>
            <input type="hidden" id="userMsg" name="user_msg" value= "<%= userMessage %>" />
            <script>
                var userMessage = document.getElementById('userMsg');
                alert(userMessage.value);
            </script>    
        <% } %>
        <div class="jumbotron jumbotron-fluid height100p banner" id="home" data-aos="fade-up" data-aos-duration="1000" data-aos-delay="500">
        <!-- <img src="uploads/front.jpg" class="back_pic"/> -->
        <div class="section3" data-aos="fade-up" data-aos-duration="1000" data-aos-delay="0">
            <section class="contact" id="contact_us">
                <div class="container admin_signin">
                    <div class="row login_box">
                        <div class="col-sm-12">
                            <div class="headerText text-center welcm">
                                <h1 data-aos="fade-up" data-aos-duration="1000" data-aos-delay="300"><br />Welcome <span>Guest</span> !!!</h1>
                                <p class="para" data-aos="fade-up" data-aos-duration="1000" data-aos-delay="500">Provide us your credential to continue...</p>
                            </div>
                            <br />
                            <div class="row clearfix">
                                <div class="offset-sm-2 col-sm-8">
                                    <% String message = (String)request.getAttribute("message");
                                    if(message!=null){ %>
                                        <div class="alert alert-danger text-center err_box" role="alert">
                                            <%= message %>
                                        </div>
                                    <% } %>    
                                    <form action="user_login.do" method="POST">
                                        <div class="form-group frm" data-aos="fade-up" data-aos-duration="1000" data-aos-delay="1000">
                                            <label class="lbl">Email:</label>
                                            <input type="email" name="user_email" class="form-control form_size" />
                                        </div>
                                        <div class="form-group frm" data-aos="fade-up" data-aos-duration="1000" data-aos-delay="1100">
                                            <label class="lbl">Password:</label>
                                            <input type="password" name="user_password" class="form-control form_size" />
                                        </div>
                                        <br /><br />
                                        <div class="form-group text-center get_strtd" data-aos="fade-up" data-aos-duration="1000" data-aos-delay="1200">
                                            <input type="submit" value="Get Started" class="btn btn-light btnD1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <button type="button" class="btn btn-dark btnD1" id="signUpModel" data-toggle="modal" data-target="#exampleModalScrollableSignUpModel">
                                                <span id="sigup">SignUP</span>
                                            </button>
                                        </div>
                                    </form>
                                </div>
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
    <script src="https://unpkg.com/aos@next/dist/aos.js"></script>
    <script>
        AOS.init();
    </script>
    
    </body>
</html>