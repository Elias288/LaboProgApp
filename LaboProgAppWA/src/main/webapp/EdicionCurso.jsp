<%@page import="java.util.Iterator"%>
<%@page import="Clases.inscripcion"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="Clases.edicionCurso"%>
<%@page import="Clases.ControladorCurso"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="Clases.curso"%>
<%@page import="com.mycompany.laboprogappwa.Operaciones"%>
<%@page import="Clases.usuario"%>
<%@page import="Clases.ControladorUsuario"%>
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
        <%
            HttpSession sesion = request.getSession();
            Operaciones OP = new Operaciones();
            ControladorCurso CC = new ControladorCurso();
            
            //out.println(OP.CursoDeEdCur("chispa"));
            //out.println(OP.insitutoCur(OP.CursoDeEdCur("chispa")));
            
            if(sesion.getAttribute("user")!=null && sesion.getAttribute("nivel")!=null){
                String tipo = sesion.getAttribute("nivel").toString();
                if(!tipo.equals("1")) //si el tipo no es profesor
                    out.println("<script>location.replace('index.jsp')</script>");
            }else
                out.println("<script>location.replace('login.jsp')</script>");
        %>
	
        <header class="site-navbar py-4" role="banner" >
            <jsp:include page="barraSuperior.jsp" />  
        </header>

        <div class="site-section">
            <div class="container">
        	<div class="row">
                    
                    <!--CODIGO DE BARRA LATERAL-->
                    <jsp:include page="barraLateral.jsp" />
              
                    <div class="col-lg-9">

                        <!--TITULO EDICION DE CURSO-->
                        <div class="d-block d-md-flex podcast-entry bg-white" data-aos="fade-up">
                            <div class="image" style="background-image: url('images/img-04.jpg');"></div>
                            <div class='text'>
                                <h3 class='font-weight-light'>
                                    <%
                                        /*DECODIFICO EL NOMBRE DE LA EDICION DE CUROSO PARA PODER USARLO*/
                                        String url = request.getParameter("EdCur");
                                        String NomEdCur = URLDecoder.decode(url,"UTF-8");
                                        edicionCurso EC = CC.buscarEdicion(NomEdCur);
                                        
                                        curso cur = OP.CursoDeEdCur(NomEdCur);
                                        out.println("<font size='4' face='verdana' color='black'>" + EC.getNombre() + "</font><br>");
                                        out.println("<font  size ='2' face='verdana' color='black'>"+ OP.insitutoCur(cur.getName()) +"</font><br><br>");
                                        out.println("<a href='#' class='h10'>Ver informacion del Curso</a><br>");
                                    %>
                                </h3>
                            </div>
                        </div>
                                
                        <!--INFORMACION GENERAL-->
                        <div class="d-block d-md-flex podcast-entry bg-white mb-5" data-aos="fade-up">
                            <div class="text">
                                <h3 class="font-weight-light">
                                    <font size="4" face="verdana" color="black">
                                        <%
                                            out.println("<strong>Fecha inicio:</strong> "+EC.getPinicio()+"<br>");
                                            out.println("<strong>Fecha Fin:</strong> "+EC.getPfin()+"<br>");
                                            out.println("<strong>Cupo:</strong> "+EC.getCupo()+"<br>");
                                            out.println("<strong>Fecha publicacion: </strong> "+EC.getFechaPublicacion()+"<br>");
                                        %>
                                        <!--
                                        <strong>Fecha inicio:</strong> 10/09/19<br>
                                        <strong>Fecha Fin:</strong> 08/11/019 <br>
                                        <strong>Cupo:</strong> 20 <br>
                                        <strong>Fecha publicacion:15/08/19</strong>  <br>
                                        <br>
                                        <strong>Inscripciones:</strong>
                                        -->
                                    </font> 
                                </h3>
                            </div>
                        </div>

                        
                            <!--TABLA DE ALUMNOS-->
                            <table class="table table-striped">
                                <thead>                
                                    <tr>                 
                                        <th>Nombre</th>                 
                                        <th>Fecha inscripción</th>                 
                                        <th>Inscripción</th>
                                        <th>Estado</th>                  
                                    </tr>               
                                </thead>
                                <tbody>
                                        <%
                                            List<inscripcion> inscrip = OP.listarInscripciones();
                                            Iterator iter = inscrip.iterator();

                                            while(iter.hasNext()){
                                                inscripcion ins = (inscripcion)iter.next();
                                                if(ins.getedicion().getNombre().equals(NomEdCur)){

                                                    out.println("<tr><th scope='row'>"+ins.getAlumno().getName()+"</th> ");
                                                    out.println("<td>"+ins.getFecha()+"</td>");
                                                    if(ins.getEstado().equals("Rechazada")){
                                                        out.println("<td><label><input type='checkbox' value='first_checkbox' disabled></td>");
                                                        out.println("<td disabled>"+ins.getEstado()+"</td>");
                                                    }else if(ins.getEstado().equals("Aceptada")){
                                                        out.println("<td><label><input type='checkbox' value='first_checkbox' checked></td>");
                                                        out.println("<td>"+ins.getEstado()+"</td>");
                                                    }else{
                                                        out.println("<td><label><input type='checkbox' value='first_checkbox'></td>");
                                                        out.println("<td>"+ins.getEstado()+"</td>");
                                                    }
                                                }
                                            }
                                        %>

                                </tbody>      
                            </table>
                            <div >
                                <button name="btnLogin" style="width: 30%" class="login100-form-btn">Guardar Selección</button>
                            </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
