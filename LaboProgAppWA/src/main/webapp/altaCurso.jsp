<%-- 
    Document   : altaCurso
    Created on : 22 oct. 2020, 15:43:43
    Author     : nacho
--%>
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
                            <!--HOME-->
                            <li class="active">
                                <a href="index.html">Home</a>
                            </li>
                            
                            <!--Nombre de usuario-->
                            <li class="active">
                                <%
                                    if(sesion.getAttribute("user")!=null && sesion.getAttribute("nivel")!=null){
                                        ControladorUsuario CU = new ControladorUsuario();
                                        usuario usu = CU.findusu(sesion.getAttribute("user").toString());
                                        out.println("<a href='User.html'>" + usu.getNN() +"</a>");
                                    }else
                                        out.println("<script>location.replace('login.jsp');</script>");
                                %>
                            </li>
                            
                            <!--Imagen de Usuario-->
                            <li>
                                <!--Falta implementarlo-->
                            </li>
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
                
                <jsp:include page="barraLateral.jsp" />

                <div class="col-lg-9">
                    <div class="d-block d-md-flex podcast-entry bg-white" data-aos="fade-up">
                        <form action="altaCurso" method="POST">
                            <table>
                                <tr>
                                    <td><p>Instituto:</p></td>
                                    <td><input type="text" name="instituto"></td>
                                </tr>
                                <tr>
                                    <td><p>Nombre del curso:</p></td>
                                    <td><input type="text" name="nombre"></td>
                                </tr>
                                <tr>
                                    <td><p>Descripción:</p></td>
                                    <td><input type="text" name="descripcion"></td>
                                </tr>
                                <tr>
                                    <td><p>Duración:</p></td>
                                    <td><input type="text" name="duracion"></td>
                                </tr>
                                <tr>
                                    <td><p>Horas:</p></td>
                                    <td><input type="text" name="horas"></td>
                                </tr>
                                <tr>
                                    <td><p>Créditos:</p></td>
                                    <td><input type="text" name="creditos"></td>
                                </tr>
                                <tr>
                                    <td><p>URL:</p></td>
                                    <td><input type="text" name="url"></td>
                                </tr>
                                <tr>
                                    <td><p>Previas:</p></td>
                                    <td><input type="text" name="previas"></td>
                                </tr>
                                <tr>
                                    <td><p>Categorías:</p></td>
                                    <td><input type="text" name="categorias"></td>
                                </tr>
                            </table>
                                <%
                                        ControladorUsuario CU = new ControladorUsuario();
                                        usuario usu = CU.findusu(sesion.getAttribute("user").toString());
                                        out.println("<p><button type=\"submit\" name=\"btnSubmit\" value=\"" + usu.getNN() +"\">Registrar</button></p>");
                                %>  
                        </form> 
                    </div>
                    
                    <!--<div class="d-block d-md-flex podcast-entry bg-white" data-aos="fade-up">
                        <label for="cars">Choose a car:</label>
                        <select name="cars" id="cars">
                          <optgroup label="Swedish Cars">
                            <option value="volvo">Volvo</option>
                            <option value="saab">Saab</option>
                          </optgroup>
                          <optgroup label="German Cars">
                            <option value="mercedes">Mercedes</option>
                            <option value="audi">Audi</option>
                          </optgroup>
                        </select>
                    </div> ///COMBOBOX///  -->

                </div>
            </div>
        </div>
    </div>
</body>