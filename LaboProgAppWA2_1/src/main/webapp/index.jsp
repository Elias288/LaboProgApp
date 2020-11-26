<%@page import="servidor.Curso"%>
<%@page import="com.mycompany.laboprogappwa2_1.Operaciones"%>
<%@page import="Clases.ControladorCurso"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="Clases.curso"%>
<%@page import="Clases.curso"%>
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
    
    <!--CODIGO DE BARRA SUPERIOR-->
    <header class="site-navbar py-4" role="banner" >
        <jsp:include page="barraSuperior.jsp" />
    </header>

    <div class="site-section">
      	<div class="container">
            <div class="row">
                
                <!--CODIGO DE BARRA LATERAL-->
                <jsp:include page="barraLateral.jsp" />

                
                <!--PANEL PRINCIPAL-->
                <div class="col-lg-9">
                    
                        <%
                            /*
                            ControladorCurso cc = new ControladorCurso();
                            List<curso> cursos = cc.buscarCurso("");
                            */
                            Operaciones OP = new Operaciones();
                            List<Curso> cursosWS = OP.BuscarCursosWS("");
                            
                            Iterator itCur = cursosWS.iterator();
                            Curso cur = null;
                            while(itCur.hasNext()){
                                cur = (Curso) itCur.next();
                                out.println("<div class='d-block d-md-flex podcast-entry bg-white mb-5' style='height: 200px' data-aos='fade-up'>");
                                out.println("<div class='image' style='background-image: url(images/img-02.jpg)'></div>");
                                out.println("<div class='text'>");
                                out.println("<h3 class='font-weight-light'><strong>"+ cur.getNombre() +"</strong> "+cur.getDescripcion() + "</h3>");
                                out.println("<a href='curso.jsp?curso="+cur.getNombre() +"' class='h10'>leer mas</a>");    
                                out.println("</div></div>");
                            }
                        %>
                    
                    <div class="d-block d-md-flex podcast-entry bg-white" data-aos="fade-up">
                            <div class="image" style="background-image: url(images/img-02.jpg);"></div>
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

