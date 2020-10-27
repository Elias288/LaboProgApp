<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Clases.ControladorUsuario"%>
<%@page import="com.mycompany.laboprogappwa.Operaciones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">	
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>
	<div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <div class="login100-pic js-tilt" data-tilt><img src="images/img-01.png" alt="IMG"></div>
                    <div>
                        <form class="login100-form validate-form" method="POST" action="register.jsp">
                            <span class="login100-form-title">User Register</span>
                            <!--nickname-->
                            <div class="wrap-input100 validate-input" data-validate = "Valid Nickame is required: ex@abc.xyz">
                                <input class="input100" type="text" name="nickname" placeholder="Nickname">
                                <span class="focus-input100"></span>
                                <span class="symbol-input100">
                                        <!--<i class="fa fa-envelope" aria-hidden="true"></i>-->
                                        <i class="glyphicon glyphicon-user" aria-hidden="true"></i>
                                </span>
                            </div>
                            <!--contraseña -->
                            <div class="wrap-input100 validate-input" data-validate = "Password is required">
                                <input class="input100" type="password" name="pass" placeholder="Password">
                                <span class="focus-input100"></span>
                                <span class="symbol-input100">
                                        <i class="fa fa-lock" aria-hidden="true"></i>
                                </span>
                            </div>
                            <!--confirmar contraseña-->
                             <div class="wrap-input100 validate-input" data-validate = "Password is required">
                                <input class="input100" type="password" name="cpass" placeholder="Confirm Password">
                                <span class="focus-input100"></span>
                                <span class="symbol-input100">
                                        <i class="fa fa-lock" aria-hidden="true"></i>
                                </span>
                            </div>
                            <!--nombre -->
                             <div class="wrap-input100 validate-input" data-validate = "Invalid">
                                <input class="input100" type="text" name="name" placeholder="Nombre">
                                <span class="focus-input100"></span>
                                <span class="symbol-input100">
                                        <i class="glyphicon glyphicon-user" aria-hidden="true"></i>
                                </span>
                            </div>
                              <!--apellido -->
                             <div class="wrap-input100 validate-input" data-validate = "Invalid">
                                <input class="input100" type="text" name="lastname" placeholder="Apellido">
                                <span class="focus-input100"></span>
                                <span class="symbol-input100">
                                        <i class="glyphicon glyphicon-user" aria-hidden="true"></i>
                                </span>
                            </div>
                              <!--Correo electronico -->
                             <div class="wrap-input100 validate-input" data-validate = "Invalid">
                                <input class="input100" type="text" name="email" placeholder="Email">
                                <span class="focus-input100"></span>
                                <span class="symbol-input100">
                                        <i class="glyphicon glyphicon-envelope" aria-hidden="true"></i>
                                </span>
                            </div>
                                  <!--Fecha nacimiento -->
                             <div class="wrap-input100 validate-input" data-validate = "Invalid">
                                <input class="input100" type="date" name="date" >
                                <span class="focus-input100"></span>
                                <span class="symbol-input100">
                                        <i class="glyphicon glyphicon-calendar" aria-hidden="true"></i>
                                </span>
                            </div>
                            <div class="container-login100-form-btn">
                                <button name="btnLogin" class="login100-form-btn">Registrar</button>
                            </div>

                            <div class="text-center p-t-136"><a class="txt2" href="#"></a></div>
                        </form>
                        <script type="text/javascript" >
                            document.getElementById("btnLogin").onclick= manolo;
                            function manolo(){
                                var pass1 = document.getElementById("pass").value;
                                var pass2 = document.getElementById("cpass").value;
                                // var pass2 = document.querySelector('.cpass').value;

                                if (pass1 != pass2) {
                                    alert("Passwords Do not match");
                                }else {
                                    alert("Passwords Match!!!");
                                    //   document.getElementById("regForm").submit();
                                }
                            }
                        </script>
                            
                        <%
                            Operaciones OP = new Operaciones();

                            if(request.getParameter("btnLogin") != null){

                                String NN = request.getParameter("nickname");
                                String passwd = request.getParameter("pass");
                                 String cpass = request.getParameter("cpass");
                                String name=request.getParameter("name");
                                String lastname=request.getParameter("lastname");
                                String email=request.getParameter("email");
                                String datefake=request.getParameter("date");
                                Date date=new SimpleDateFormat("yyyy-MM-dd").parse(datefake);  
                                HttpSession sesion = request.getSession();
                                ControladorUsuario CU = new ControladorUsuario();
                                
                                if(!(cpass.equals(passwd))){
                                    out.println("<script language='javascript'>alert('Verificacion de contraseña invalida, reingresela');</script");
                                    //out.println("Verificacion de contraseña invalida, reingresela.");
                                 }else{
                                    if(CU.findusu(NN)!=null){ //usuario ya existe
                                        out.println("<script language='javascript'>alert('Usuario ya existe');</script");
                                        //out.println("Usuario ya existe.");
                                    }else{
                                        if(!CU.verFecha(date)){//fecha invalida
                                            out.println("<script language='javascript'>alert('Fecha invalida, reingresela.');</script");
                                            //out.println("Fecha invalida, reingresela.");
                                        }else{
                                            CU.altaUsuario(name, passwd, lastname, NN, email, date, false, "");//se agrego correctamente
                                        }
                                    }
                                }
                            }
                            //mantiene la sesion cerrada
                            if(request.getParameter("cerrar")!=null){
                                session.invalidate();
                            }


                            %>
                    </div>
                    
                </div>
            </div>
	</div>
		
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="vendor/select2/select2.min.js"></script>
	<script src="vendor/tilt/tilt.jquery.min.js"></script>
	<script >
		$('.js-tilt').tilt({
			scale: 1.1
		})
	</script>
	<script src="js/main.js"></script>

    </body>
</html>
