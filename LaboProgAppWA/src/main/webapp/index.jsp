<%@page import="Clases.usuario"%>
<%@page import="Clases.ControladorUsuario"%>
<%@page session="true"%>
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
    
    <header class="site-navbar py-4" role="banner" >
        <div class="container">
            <div class="row align-items-center" style="border-bottom: 2px solid">
                <div class="col-3">
                    <h1 class="site-logo"><a href="index.jsp" class="h2">ed<span class="text-primary">EXT</span> </a></h1>
                </div>
                <div class="col-9">
                    <nav class="site-navigation position-relative text-right text-md-right" role="navigation">
                        <div class="d-block d-lg-none ml-md-0 mr-auto" >
                            <a href="#" class="site-menu-toggle js-menu-toggle text-black" >
                                <span class="icon-menu h3"></span>
                            </a>
                        </div>

                        <ul class="site-menu js-clone-nav d-none d-lg-block">
                            <!--HOME-->
                            <li class="active">
                                <a href="index.jsp">Home</a>
                            </li>
                            
                                <%
                                    if(sesion.getAttribute("user")!=null && sesion.getAttribute("nivel")!=null){
                                        ControladorUsuario CU = new ControladorUsuario();
                                        usuario usu = CU.findusu(sesion.getAttribute("user").toString());
                                        out.println("<li class='active'><a href='User.html'>" + usu.getNN() +"</a></li>");
                                        out.println("<li class='active'></a></li>");
                                    }else{
                                        out.println("<li><a href='login.jsp'>Login / Register</a></li>");
                                        //out.println("<script>location.replace('login.jsp');</script>");
                                    }
                                %>
                                
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
                
                <!-- PERFIL NO INICIADO -->
                <%
                    if(sesion.getAttribute("user")==null && sesion.getAttribute("nivel")==null){
                        out.println("<div class='col-lg-3' style='border: 2px solid'>");
                    }else
                        out.println("<div class='col-lg-3' style='border: 2px solid; display: none'>");
                %>
                <!--<div class="col-lg-3" style="border: 2px solid; display: none" >-->
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
                            <li>
                                <a href="#" class="d-flex align-items-center">
                                    <div class="podcaster"><span class="d-block">IMPII</span></div>
                                </a>
                            </li>
                            <li>
                                <a href="#" class="d-flex align-items-center">
                                    <div class="podcaster"><span class="d-block">Electrica</span></div>
                                </a>
                            </li>
                            <li>
                                <a href="#" class="d-flex align-items-center">
                                    <div class="podcaster"><span class="d-block">DISI</span></div>
                                </a>
                            </li>
                        </ul>
                    </div>

                    <div class="featured-user  mb-5 mb-lg-0">
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
                </div>
                
                <!-- PERFIL INICIADO-->
                <%
                    if(sesion.getAttribute("user")!=null && sesion.getAttribute("nivel")!=null){
                        out.println("<div class='col-lg-3' style='border: 2px solid'>");
                    }else
                        out.println("<div class='col-lg-3' style='border: 2px solid; display: none'>");
                %>
                <!--<div class="col-lg-3" style="border: 2px solid">-->
                    <div class="featured-user  mb-5 mb-lg-0" style="border-bottom: 2px solid">
                        <div class="has-children">
                            <h3 class="mb-4">Mi perfil ></h3>
                            <ul class="miperfil arrow-top" style="border: 2px solid">
                                <li><a href="altaCurso.jsp">Agregar curso</a></li>
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
                        <% out.println("<a href='login.jsp?cerrar=true'class='mb-4'>Salir <i class='glyphicon glyphicon-log-out' aria-hidden='true'></i></a>"); %>
                        
                    </div>
                </div>

                <div class="col-lg-9">
                    <div class="d-block d-md-flex podcast-entry bg-white" data-aos="fade-up">
                            <div class="image" style="background-image: url('images/img-02.jpg');"></div>
                            <div class="text">
                                <h3 class="font-weight-light">
                                    La segunda etapa consiste en que trabajen en grupo sobre el diseño e 
                                    implementación de una experiencia didáctica de inclusion de robot Butiá 
                                    en el aula, utilizando los conocimientos aprendidos en clase.
                                    <a href="#" class="h10">leer mas</a>
                                </h3>
                            </div>
                    </div>

                    <div class="d-block d-md-flex podcast-entry bg-white mb-5" data-aos="fade-up">
                        <div class="image" style="background-image: url('images/img-03.jpg');"></div>
                            <div class="text">
                                <h3 class="font-weight-light">
                                    <strong>Dalavuelta</strong> es un proyecto de extensión que nace en el Instituto 
                                    de Ingeniría Macánica y Producción Industrial (IMPI) de Fing, que, si bien inicia 
                                    su trabajo en el desarrollo de bicicletas accesibles para
                                    <a href="#" class="h10">leer mas</a>
                                </h3>
                            </div>
                    </div>

                    <div class="d-block d-md-flex podcast-entry bg-white mb-5" data-aos="fade-up">
                        <div class="image" style="background-image: url('images/img-04.png');"></div>
                        <div class="text">
                            <h3 class="font-weight-light">
                                <strong>Flor de Ceibo</strong> es un proyecto central de la Universidad de la República, 
                                que tiene misión por movilizar la participación de estudiantes universitarios en 
                                <a href="#" class="h10">leer mas</a>
                            </h3>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

