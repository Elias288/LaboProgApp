<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Date"%>
<%@page import="com.mycompany.laboprogappwa.Operaciones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesion = request.getSession();
    Operaciones OP = new Operaciones();
%>
<html>
    <head>
        <title>User</title>
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
                        <!-- //////////////////////////////////////////////////////////////////////////// -->
                        <!-- [DETALLES PERFIL] -->
                        <div class="d-block d-md-flex podcast-entry bg-white" data-aos="fade-up" style="height: 200px">
                            <div class="image" style="background-image: url('images/img-prof.jpg'); width: 200px;"></div>
                            <div class="text">
                                <% if(sesion.getAttribute("user")!=null){
                                    servidor.DataUsuario Dusu = OP.findusuWS(sesion.getAttribute("user").toString());
                                    out.println("<h2 class='font-weight-light'><strong>"+ Dusu.getNombre()+ " "+ Dusu.getApellido() +"</strong></h2>");
                                    out.println("<h3 class='font-weight-light'>"+ Dusu.getNickname() + " / " + Dusu.getCorreo() + "</h3>");
                                    //out.println("<h3 class='font-weight-light'><strong>Último ingreso: " + Dusu.getFechaNac() + "<strong></h3>");
                                }else{
                                    out.println("<script>location.replace('index.jsp')</script>");
                                }
                                
                                %>
                            </div>
                        </div>
                        <!-- //////////////////////////////////////////////////////////////////////////// -->
          		<!-- [TAB] -->
              		<div class="tab">
                            <button class="tablinks" onclick="openCity(event, 'general')" id="defaultOpen">GENERAL</button>
                            <button class="tablinks" onclick="openCity(event, 'cursos')">CURSOS</button>
                            <button class="tablinks" onclick="openCity(event, 'programas')">PROGRAMAS</button>
                        </div>
                        <!-- Tab content -->

                        <!-- ///////////////////////////////////////////////////////////////////////////// -->
                        <!-- [GENERAL] -->
                        <div id="general" class="tabcontent">
                            <%servidor.DataUsuario Dusu = OP.findusuWS(sesion.getAttribute("user").toString());%>
                            <h4>Nickname: <%out.println(Dusu.getNickname());%></h4>
                            <h4><strong>Nombre: <%out.println(Dusu.getNombre());%></strong><i class="glyphicon glyphicon-edit" aria-hidden="true"></i></h4>
                            <h4><strong>Apellido: <%out.println(Dusu.getApellido());%> </strong><i class="glyphicon glyphicon-edit" aria-hidden="true"></i></h4>
                            <h4>Correo lectrónico: <%out.println(Dusu.getCorreo());%></h4>
                            
                            <%
                                //Formato de fecha
                                LocalDate fechaNac = LocalDate.of(Dusu.getFechaNac().getYear(), Dusu.getFechaNac().getDay(), Dusu.getFechaNac().getMonth());
                                DateTimeFormatter esDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                fechaNac.format(esDateFormat);
                            %>
                            
                            <h4><strong>Fecha de nacimiento: <%out.println(fechaNac.format(esDateFormat));%></strong></h4>
                        </div>

                        <div id="cursos" class="tabcontent">
                            <h4>Cursos</h4>
                        </div>

                        <div id="programas" class="tabcontent">
                            <h4>Programas</h4>
                        </div>
                        <script>
                            document.getElementById("defaultOpen").click();
                            function openCity(evt, cityName) {
                                var i, tabcontent, tablinks;
                                tabcontent = document.getElementsByClassName("tabcontent");
                                for (i = 0; i < tabcontent.length; i++) {
                                        tabcontent[i].style.display = "none";
                                }
                                tablinks = document.getElementsByClassName("tablinks");
                                for (i = 0; i < tablinks.length; i++) {
                                        tablinks[i].className = tablinks[i].className.replace(" active", "");
                                }
                                document.getElementById(cityName).style.display = "block";
                                evt.currentTarget.className += " active";
                            }
                        </script>
                    </div>
                </div>
            </div>
        </div>
        
    </body>
</html>
