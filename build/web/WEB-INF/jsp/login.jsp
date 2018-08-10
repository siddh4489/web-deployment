<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Salesforce Metadata Retrieve & Deploy</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>       
    </head>
    <body>
        <form:form action="view" method="post" commandName="loginForm">
            <div class="container">
                <div id="loginbox" style="margin-top:50px;" >
                    <div class="col-md-6">
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <div class="panel-title">Source Organization</div>
                                <div style="float:right; font-size: 80%; position: relative; top:-10px">
                                    <!--<a href="#">Forgot password?</a>-->
                                </div>
                            </div>

                            <div style="padding-top:30px" class="panel-body">

                                <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>


                                <div style="margin-bottom: 25px" class="input-group">
                                    <span class="input-group-addon">
                                        <i class="glyphicon glyphicon-user"></i>
                                    </span>
                                    <!--<input id="srclogin-username" type="text" class="form-control" name="srcusername" value="" placeholder="Username">-->
                                    <form:input id="srclogin-username" path="srcusername"  class="form-control" placeholder="Username" />
                                </div>

                                <div style="margin-bottom: 25px" class="input-group">
                                    <span class="input-group-addon">
                                        <i class="glyphicon glyphicon-lock"></i>
                                    </span>
                                    <form:input id="srclogin-password" type="password" class="form-control" path="srcpassword" placeholder="Password"/>
                                </div>

                                <div style="margin-bottom: 25px" class="input-group">
                                    <span class="input-group-addon">
                                        <i class="glyphicon glyphicon-link"></i>
                                    </span>
                                    <form:input id="srclogin-url" type="text" class="form-control" path="srcurl" placeholder="Salesforce Login URL"/>
                                </div>



                                <div class="input-group">
                                    <div class="checkbox">
                                        <label>
                                            <input id="login-remember" type="checkbox" name="remember" value="1"> Remember me
                                        </label>
                                    </div>
                                </div>
                                <div style="margin-top:10px" class="form-group">
                                    <!-- Button -->

                                    <div class="col-sm-12 controls">
                                        <a id="srcbtn-login" href="view" class="btn btn-success">Login </a>
                                        <!--<a id="btn-fblogin" href="#" class="btn btn-primary">Login with Facebook</a>-->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <div class="panel-title">Destination Organization</div>
                                <div style="float:right; font-size: 80%; position: relative; top:-10px">
                                    <!--<a href="#">Forgot password?</a>-->
                                </div>
                            </div>

                            <div style="padding-top:30px" class="panel-body">

                                <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>


                                <div style="margin-bottom: 25px" class="input-group">
                                    <span class="input-group-addon">
                                        <i class="glyphicon glyphicon-user"></i>
                                    </span>
                                    <form:input id="deslogin-username" type="text" class="form-control" path="desusername" value="" placeholder="Username"/>
                                </div>

                                <div style="margin-bottom: 25px" class="input-group">
                                    <span class="input-group-addon">
                                        <i class="glyphicon glyphicon-lock"></i>
                                    </span>
                                    <form:input id="deslogin-password" type="password" class="form-control" path="despassword" placeholder="Password"/>
                                </div>

                                <div style="margin-bottom: 25px" class="input-group">
                                    <span class="input-group-addon">
                                        <i class="glyphicon glyphicon-link"></i>
                                    </span>
                                    <form:input id="deslogin-url" type="text" class="form-control" path="desurl" placeholder="Salesforce Login URL"/>
                                </div>

                                <div class="input-group">
                                    <div class="checkbox">
                                        <label>
                                            <input id="login-remember" type="checkbox" name="remember" value="1"> Remember me
                                        </label>
                                    </div>
                                </div>
                                <div style="margin-top:10px" class="form-group">
                                    <!-- Button -->

                                    <div class="col-sm-12 controls">
                                        <a id="desbtn-login" href="view" class="btn btn-success">Login </a>
                                        <!--<a id="btn-fblogin" href="#" class="btn btn-primary">Login with Facebook</a>-->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>            
            </div>
            <input type="submit" value="Register" />
             </form:form>
    </body>
</html>

