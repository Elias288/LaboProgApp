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
                        <form class="login100-form validate-form" method="POST" action="login.jsp">
                            <span class="login100-form-title">User Login</span>
                            <div class="wrap-input100 validate-input" data-validate = "Valid Nickame is required: ex@abc.xyz">
                                <input class="input100" type="text" name="nickname" placeholder="Nickname">
                                <span class="focus-input100"></span>
                                <span class="symbol-input100">
                                        <!--<i class="fa fa-envelope" aria-hidden="true"></i>-->
                                        <i class="glyphicon glyphicon-user" aria-hidden="true"></i>
                                </span>
                            </div>

                            <div class="wrap-input100 validate-input" data-validate = "Password is required">
                                <input class="input100" type="password" name="pass" placeholder="Password">
                                <span class="focus-input100"></span>
                                <span class="symbol-input100">
                                        <i class="fa fa-lock" aria-hidden="true"></i>
                                </span>
                            </div>

                            <div class="container-login100-form-btn">
                                <button name="btnLogin" class="login100-form-btn">Login</button>
                            </div>

                            <div class="text-center p-t-136"><a class="txt2" href="#"></a></div>
                        </form>
                    
                        <%
                            Operaciones OP = new Operaciones();

                            if(request.getParameter("btnLogin") != null){

                                String user = request.getParameter("nickname");
                                String passwd = request.getParameter("pass");

                                HttpSession sesion = request.getSession();

                                switch(OP.loguear(user, passwd)){
                                    case 1:
                                        sesion.setAttribute("user", user);
                                        sesion.setAttribute("nivel", "1");
                                        response.sendRedirect("indexDocente.jsp");
                                        break;
                                    case 2:
                                        sesion.setAttribute("user", user);
                                        sesion.setAttribute("nivel", "2");
                                        response.sendRedirect("indexAlumno.jsp");
                                        break;
                                    default:
                                        out.println("Usuario invalido o contraseña invalida");
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
