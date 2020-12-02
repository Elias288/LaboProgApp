<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
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
            //ControladorCurso CC = new ControladorCurso();
            
            //out.println(OP.CursoDeEdCur("chispa"));
            //out.println(OP.insitutoCur(OP.CursoDeEdCur("chispa")));
            
            if(sesion.getAttribute("user")!=null && sesion.getAttribute("nivel")!=null){
                String tipo = (String)sesion.getAttribute("nivel");
                String nombreUsu = (String)sesion.getAttribute("user");
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
                                        servidor.EdicionCurso EC = OP.BuscarEdicionWS(NomEdCur);
                                        if(EC!= null){
                                            servidor.Curso cur = OP.CursoDeEdCur(NomEdCur);
                                            if(cur!=null){
                                                out.println("<font size='4' face='verdana' color='black'>" + EC.getNombre() + "</font><br>");
                                                out.println("<font  size ='2' face='verdana' color='black'>"+ OP.insitutoCur(cur.getNombre()) +"</font><br><br>");
                                                out.println("<a href='#' class='h10'>Ver informacion del Curso</a><br>");
                                            }else
                                                out.println("<p>No existe Curso</p>");
                                       
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
                                            DateTimeFormatter esDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                            LocalDate fechaIns = EC.getPinicio().toGregorianCalendar().toZonedDateTime().toLocalDate();
                                            LocalDate fechafin = EC.getPfin().toGregorianCalendar().toZonedDateTime().toLocalDate();
                                            LocalDate fechapub= EC.getFechaPublicacion().toGregorianCalendar().toZonedDateTime().toLocalDate();
                                            
                                            out.println("<strong>Fecha inicio:</strong> "+fechaIns.format(esDateFormat)+"<br>"); //simpledateformat
                                            out.println("<strong>Fecha Fin:</strong> "+fechafin.format(esDateFormat)+"<br>");
                                            out.println("<strong>Cupo:</strong> "+EC.getCupo()+"<br>");
                                            out.println("<strong>Fecha publicacion: </strong> "+fechapub.format(esDateFormat)+"<br>");
                                            if(!EC.isVigente())
                                                out.println("<strong>Edición Cerrada.</strong><br>");
                                        }else
                                            out.println("<p>No existe Edicion</p>");
                                        %>
                                        
                                    </font> 
                                </h3>
                            </div>
                        </div>
                        <form action="EditInscripcion" method="GET">
                            <%out.println("<input type='hidden' name='edicion' value='"+NomEdCur+"'>");%>                    
                            <!--TABLA DE ALUMNOS-->
                            <table class="table table-striped">
                                <thead>                
                                    <tr>                 
                                        <th>Nombre</th>                 
                                        <th>Fecha inscripción</th>                 
                                        <th>Inscripción</th>
                                        <th>Estado</th>          
                                        <th>Nota</th>  
                                    </tr>               
                                </thead>
                                <tbody>
                                        <%
                                            //List<inscripcion> inscrip = OP.listarInscripciones("Elias","Programacion de aplicaciones 2020");
                                            List<servidor.Inscripcion> inscrip = OP.listarInscripcionesWS("",NomEdCur);
                                            if(inscrip!=null){
                                                Iterator iter = inscrip.iterator();

                                                DateTimeFormatter esDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                                                while(iter.hasNext()){
                                                    servidor.Inscripcion ins = (servidor.Inscripcion)iter.next();

                                                    LocalDate fechaIns = ins.getFecha().toGregorianCalendar().toZonedDateTime().toLocalDate();

                                                    out.println("<tr><th scope='row'><p>"+ins.getAlu().getNombre()+"</p></th> ");
                                                    out.println("<td><p>"+fechaIns.format(esDateFormat)+"</p></td>");


                                                    if(ins.getEstado().equals("Rechazada")){
                                                        out.println("<td><label><input type='checkbox' disabled></td>");
                                                        out.println("<td disabled><p>"+ins.getEstado()+"</p></td>");
                                                        out.println("<td><input type='number' min='1' max='12' name='nota' disabled></td>");
                                                        out.println("<td><input type='hidden' min='1' max='12' name='nota' value='0'></td>");

                                                    }else if(ins.getEstado().equals("Aceptada")){
                                                        out.println("<td><label><input type='checkbox' name='checkbox' id='"+ins.getAlu().getNombre()+"' onclick='CambiarEstado(this.id,\"text_"+ins.getAlu().getNombre()+"\")' checked></td>");
                                                        out.println("<td><p id='text_"+ins.getAlu().getNombre()+"' >"+ins.getEstado()+"</p></td>");
                                                        out.println("<input type='hidden' id='estado_"+ins.getAlu().getNombre()+"' name='estado' value='"+ins.getEstado()+"'>"); //
                                                        out.println("<td><input type='number' id='nota_"+ins.getAlu().getNombre()+"' min='1' max='12' name='nota' value='"+ins.getNota()+"'></td>");   


                                                    }else{
                                                        out.println("<td><label><input type='checkbox' name='checkboxAceptado' id='"+ins.getAlu().getNombre()+"' onclick='CambiarEstado(this.id,\"text_"+ins.getAlu().getNombre()+"\")'></td>");
                                                        out.println("<td ><p id='text_"+ins.getAlu().getNombre()+"' name='estado'>"+ins.getEstado()+"</p></td>");
                                                        out.println("<input type='hidden' id='estado_"+ins.getAlu().getNombre()+"' name='estado' value='null'>"); //
                                                        out.println("<td><input type='hidden' id='nota_"+ins.getAlu().getNombre()+"' min='1' max='12' name='nota' value='0'></td>");

                                                    }
                                                    out.println("</tr>");
                                                    out.println("<input type='hidden' name='nombreEst' value='"+ins.getAlu().getNickname()+"'>");
                                                }
                                            }else
                                                out.println("<p>No hay inscripciones</p>");
                                        %>
                                </tbody>
                            </table>
                            <div>
                                <%
                                    if(EC.isVigente()){
                                        out.println("<button style='width: 30%' class='login100-form-btn' name='botonG' value='guardar'>Guardar Selección</button>");
                                        out.println("<button style='width: 30%' class='login100-form-btn' name='botonC' value='cerrar'>Cerrar edición</button>");
                                    }
                                %>
                                
                            </div> 
                        </form>
                        <script>
                            function CambiarEstado(idCheckbox, idp){
                                var checkBox = document.getElementById(idCheckbox);
                                var hidden1 = "estado_"+ idCheckbox;
                                var nota = "nota_"+ idCheckbox;
                                changeType(nota);
                                var mensaje1 = "Aceptada";
                                var mensaje2 = "Rechazada";
                                var text = document.getElementById(idp);
                                
                                if (checkBox.checked === true){
                                    text.innerHTML  = mensaje1;
                                    document.getElementById(hidden1).value = mensaje1;
                                }else{
                                    text.innerHTML  = mensaje2;
                                    document.getElementById(hidden1).value = mensaje2;
                                }
                            }
                            function changeType(id){
                                var nota = id;
                                if (document.getElementById(nota).type === 'hidden'){
                                    document.getElementById(nota).type = 'number';
                                }else{
                                    document.getElementById(nota).type = 'hidden';
                                }
                            }

                        </script>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
