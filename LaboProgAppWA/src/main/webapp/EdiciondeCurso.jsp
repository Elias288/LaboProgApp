
<%@page import="Clases.edicionCurso"%>
<%@page import="Clases.ControladorCurso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
	<title>edExt</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!--<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,700,900"> 
	<link rel="stylesheet" href="fonts/icomoon/style.css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css"> 
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<!-- <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css"> -->
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<!-- <link rel="stylesheet" href="css/magnific-popup.css"> -->
	<!-- <link rel="stylesheet" href="css/jquery-ui.css"> -->
	<!-- <link rel="stylesheet" href="css/owl.carousel.min.css"> -->
	<!-- <link rel="stylesheet" href="css/owl.theme.default.min.css"> -->

	<!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mediaelement@4.2.7/build/mediaelementplayer.min.css"> -->
	<!-- <link rel="stylesheet" href="css/aos.css"> -->
	<link rel="stylesheet" href="css/style.css">
    </head>
    <body>
            
    <!--Valida sesion -->
    <%HttpSession sesion = request.getSession();%>
    
    <!--CODIGO DE BARRA SUPERIOR-->
    <header class="site-navbar py-4" role="banner" >
        <jsp:include page="barraSuperior.jsp" />
    </header>

    <div class="site-section">
      	<div class="container">
            <div class="row">
                
                <!--CODIGO DE BARRA LATERAL-->
                <jsp:include page="barraLateral.jsp" />

                    <div class="col-lg-9">

                        <div class="d-block d-md-flex podcast-entry bg-white" data-aos="fade-up">
                            <div class="image" style="background-image: url('images/img-04.jpg');"></div>
                            <div class="text">
                                <h3 class="font-weight-light">
                                    <% 
                                        ControladorCurso cc = new ControladorCurso();
                                        edicionCurso ed = cc.buscarEdicion(request.getParameter("edicion"));
                                    %>
                                    <font size="4" face="verdana" color="black"><% out.print(ed.getNombre()+" "+ed.getFechaPublicacion()); %><br>
                                        <font  size ="2" face="verdana" color="black"> 
                                        Intituto
                                        </font><br><br>
                                        <a href="#" class="h10">Inscribirme</a> <br>
                                        <a href="#" class="h10">Ver informacion del Curso</a><br>
                                    </font> 
                                </h3>
                            </div>
                        </div>
                        
                        <div class="d-block d-md-flex podcast-entry bg-white mb-5" data-aos="fade-up">
         
                            <div class="text">
                                <h3 class="font-weight-light">
                                    <font size="4" face="verdana" color="black"> 
                                    <strong>Fecha inicio:</strong> <% out.print(ed.getPinicio()); %><br>
                                        <strong>Fecha Fin:</strong> <% out.print(ed.getPfin()); %> <br>
                                        <strong>Cupo:</strong> <% out.print(ed.getCupo()); %> <br>
                                        <strong>Fecha publicacion:<% out.print(ed.getFechaPublicacion()); %></strong>
                                        <br><br>
                                        <strong>Docentes:</strong>
                                        <br>
                                        > Alvaro Correa - <a href="#" class="h10">benkenobi</a> <br>
                                        > Andres Pia - <a href="#" class="h10">watson</a> <br>
                                    </font> 
                                </h3>
                            </div>
                        </div>
                    </div>
          	</div>
            </div>
        </div>
    </body>
</html>