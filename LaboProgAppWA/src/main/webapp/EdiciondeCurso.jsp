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
        <header class="site-navbar py-4" role="banner" >
            <div class="container">
        	<div class="row align-items-center" style="border-bottom: 2px solid">
                    <div class="col-3">
            		<h1 class="site-logo"><a href="index.html" class="h2">ed<span class="text-primary">EXT</span> </a></h1>
                    </div>
                    <div class="col-9">
                        <nav class="site-navigation position-relative text-right text-md-right" role="navigation">
                            <div class="d-block d-lg-none ml-md-0 mr-auto" >
                                <a href="#" class="site-menu-toggle js-menu-toggle text-black" >
                                    <span class="icon-menu h3"></span>
                                </a>
                            </div>
                            <ul class="site-menu js-clone-nav d-none d-lg-block">
                                <li><a href="index.html">Home</a></li>
                                <li class="active"><h4>User</h4></li>
                                <li><img src="images/userlogo.png" style="width: 60px"></li>
                            </ul>
                        </nav>
                        <div class="buscador" style="margin-bottom: 3rem!important; display: flex; flex-direction: row-reverse; max-width: 60%">
                            <input type="submit" value="Buscar" style="padding: 5px 15px; margin-left: 15px; font-size: medium;">
                            <input type="search" name="busqueda" placeholder="Cursos, Programas" style=" padding-left: 10px; flex: 1; border: 1px solid; font-size: medium;">
                        </div>
                    </div>
	        </div>
            </div>  
        </header>

        <div class="site-section">
            <div class="container">
        	<div class="row">
                    <div class="col-lg-3" style="border: 2px solid">
                        <div class="featured-user  mb-5 mb-lg-0" style="border-bottom: 2px solid">
                            <div class="has-children">
                                <h3 class="mb-4">Mi perfil ></h3>
                                <ul class="miperfil arrow-top" style="border: 2px solid">
                                    <li><a href="#">Menu One</a></li>
                                    <li><a href="#">Menu Two</a></li>
                                    <li><a href="#">Menu Three</a></li>
                                </ul>
                            </div>
                        </div>

                        <div class="featured-user  mb-5 mb-lg-0" style="border-bottom: 2px solid">
                            <h3 class="mb-4">Inscripciones</h3>
                            <ul class="list-unstyled">
                                <li>
                                    <a href="#" class="d-flex align-items-center">
                                        <div class="podcaster"><span class="d-block">Inscribirme</span></div>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="d-flex align-items-center">
                                        <div class="podcaster"><span class="d-block">Ver resultados</span></div>
                                    </a>
                                </li>
                            </ul>
                        </div>

                        <div class="featured-user  mb-5 mb-lg-0" style="border-bottom: 2px solid">
                            <h3 class="mb-4">Institutos</h3>
                            <ul class="list-unstyled">
                                <li>
                                    <a href="#" class="d-flex align-items-center">
                                        <div class="podcaster"><span class="d-block">INCO</span></div>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="d-flex align-items-center">
                                        <div class="podcaster"><span class="d-block">IMERL</span></div>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="d-flex align-items-center">
                                        <div class="podcaster"><span class="d-block">Fisica</span></div>
                                    </a>
                                </li>
                            </ul>
                        </div>

                        <div class="featured-user  mb-5 mb-lg-0" style="border-bottom: 2px solid">
                            <h3 class="mb-4">CATEGORIAS</h3>
                            <ul class="list-unstyled">
                                <li>
                                    <a href="#" class="d-flex align-items-center">
                                        <div class="podcaster"><span class="d-block">Social</span></div>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="d-flex align-items-center">
                                        <div class="podcaster"><span class="d-block">Industrial</span></div>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="d-flex align-items-center">
                                        <div class="podcaster"><span class="d-block">Educativos</span></div>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="d-flex align-items-center">
                                        <div class="podcaster"><span class="d-block">Interdiciplinario</span></div>
                                    </a>
                                </li>
                            </ul>
                        </div>

                        <div class="featured-user  mb-5 mb-lg-0">
                            <h3 class="mb-4">Salir <i class="glyphicon glyphicon-log-out" aria-hidden="true"></i></h3>
                        </div>
                    </div>
              
                    <div class="col-lg-9">

                        <div class="d-block d-md-flex podcast-entry bg-white" data-aos="fade-up">
                            <div class="image" style="background-image: url('images/img-04.jpg');"></div>
                            <div class="text">
                                <h3 class="font-weight-light">
                                    <font size="4" face="verdana" color="black">Taller de robótica educativa 2019-2<br>
                                        <font  size ="2" face="verdana" color="black"> 
                                          Instituto de Computacion
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
                                        <strong>Fecha inicio:</strong> 10/09/19<br>
                                        <strong>Fecha Fin:</strong> 08/11/019 <br>
                                        <strong>Cupo:</strong> 20 <br>
                                        <strong>Fecha publicacion:15/08/19</strong>
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