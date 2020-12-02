<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%//@page import="Clases.inscripcion"%>
<%//@page import="Clases.edicionCurso"%>
<%//@page import="Clases.ControladorUsuario"%>
<%//@page import="Clases.usuario"%> 
<%//@page import="Clases.categoria"%>
<%//@page import="Clases.curso"%>
<%//@page import="Clases.ControladorCurso"%>
<%//@page import="Clases.instituto"%>
<%@page import="com.mycompany.laboprogappwa.Operaciones"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
        String nickname = request.getParameter("usuario");
    %>
    
    
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
                    <div class="d-block podcast-entry bg-white" data-aos="fade-up">
                        <% 
                           
                            if(nickname != null){ //si el nickname no esta bacio
                                List<servidor.Usuario>usu = OP.buscarusuarioWS(nickname);
                                
                                if(usu!= null){ //si el usuario existe
                                    Iterator itCur = usu.iterator();
                                    servidor.Usuario usuariox = null;
                                    while(itCur.hasNext()){
                                        usuariox = (servidor.Usuario) itCur.next();
                                        /*out.println("<form action='curso.jsp' method='GET'>");
                                        out.println("<button type='submit' name='curso' value='"+cur.getName()+"' >"+cur.getName()+"</button>");
                                        out.println("</form><br>");*/
                                        out.println("<div>");

                                        out.println("<p> <strong style='font-weight: bold'>Nickname: </strong>"+usuariox.getNickname()+"</p>"); 
                                        out.println("<p><strong style='font-weight: bold'>Nombre: </strong>"+usuariox.getNombre()+"</p>");
                                        out.println("<p><strong style='font-weight: bold'>Apellido:</strong> "+usuariox.getApellido()+"</p>" );

                                        out.println("</div>");


                                    }
                                    if(OP.tipousuarioWS(nickname)==1){ //si el tipo de usuario es docente
                                        out.println("<h3><strong> Cursos: </strong></h3>");
                                        
                                        List<servidor.Curso> cu= OP.findCursoXDocente(nickname);
                                        if(cu != null){ //si tiene curso
                                            Iterator cursos = cu.iterator();
                                            while(cursos.hasNext()){
                                                servidor.Curso cur = (servidor.Curso)cursos.next();
                                                out.println("<h3>"+cur.getNombre()+":</h3>");
                                                
                                                List<servidor.EdicionCurso>datos = OP.buscarEdicionesXCursoWS(cur.getNombre());
                                                if(datos!= null){
                                                    Iterator opaaaa = datos.iterator();
                                                    servidor.EdicionCurso opa = null;
                                                    while(opaaaa.hasNext()){
                                                        opa = (servidor.EdicionCurso) opaaaa.next();
                                                        
                                                        //Formato de fecha
                                                        DateTimeFormatter esDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                                        LocalDate fechafin = opa.getPfin().toGregorianCalendar().toZonedDateTime().toLocalDate();
                                                        LocalDate fechainicio = opa.getPinicio().toGregorianCalendar().toZonedDateTime().toLocalDate();
                                                        LocalDate fechapublicacion= opa.getFechaPublicacion().toGregorianCalendar().toZonedDateTime().toLocalDate();
                                                        
                                                        out.println("<div>");
                                                        out.println("<h3>"+opa.getNombre()+"</h3>");
                                                        out.println("<h4>Fecha Inicio: "+fechainicio.format(esDateFormat)+"</h4>");
                                                        out.println("<h4>Fecha Final: "+fechafin.format(esDateFormat)+"</h4>");
                                                        out.println("<h4>Cupos: "+opa.getCupo()+"</h4>");
                                                        out.println("<h4>Fecha publicacion: "+ fechapublicacion.format(esDateFormat)+"</h4>" );
                                                        out.println("</div>");
                                                    }
                                                }else
                                                    out.println("<p>Sin Edicion del curso</p>");
                                            }
                                            
                                        }else
                                            out.println("<p>Sin Curso</p>");
                                        
                                    }else if(OP.tipousuarioWS(nickname)==2){

                                        int semaforo=0;
                                        //List<inscripcion> inscrip2 = OP.listarInscripciones("","");
                                        List<servidor.Inscripcion> inscrip2 = OP.listarInscripcionesWS("","");
                                        Iterator iter2 = inscrip2.iterator();
                                        while(iter2.hasNext()){
                                            servidor.Inscripcion insWS = (servidor.Inscripcion)iter2.next();
                                            if(insWS.getAlu().getNickname().equals(nickname) && !insWS.getEstado().equals("Rechazada")){
                                                semaforo=1;
                                            }   

                                        }
                                        out.println("<p> Es Alumno</p>");
                                        if(semaforo==1){
                                            //out.println("<p>Estas son las ediciones a las que solicito inscribirse</p>"); 

                                            //List<inscripcion> inscrip = OP.listarInscripciones("","");
                                            List<servidor.Inscripcion> inscrip = OP.listarInscripcionesWS("","");
                                            Iterator iter = inscrip.iterator();

                                            out.println("<h3>Ediciones de Curso</h3>");
                                            while(iter.hasNext()){
                                                servidor.Inscripcion insWS = (servidor.Inscripcion)iter.next();
                                                if(insWS.getAlu().getNickname().equals(nickname) && !insWS.getEstado().equals("Rechazada")){
                                                    out.println("<div>");
                                                    out.println("<h4> "+insWS.getEdicionCurso().getNombre()+"</h4>"+"<p> Estado: "+insWS.getEstado()+"</p>");
                                                    out.println("</div>");
                                                }   

                                            }
                                        }
                                        if(sesion.getAttribute("user")!=null){
                                            servidor.Usuario usua = OP.findusupostaWS(sesion.getAttribute("user").toString());

                                            if(usua.getNickname().equals(nickname)){
                                                List<servidor.Inscripcion> inscrip = OP.listarInscripcionesWS("","");
                                                Iterator iter = inscrip.iterator();
                                                while(iter.hasNext()){
                                                    servidor.Inscripcion insWS = (servidor.Inscripcion)iter.next();
                                                    if(insWS.getAlu().getNickname().equals(nickname) && insWS.getEstado().equals("Rechazada")){
                                                        out.println("<div>");
                                                        out.println("<h4> "+insWS.getEdicionCurso().getNombre()+"</h4>"+"<p> Estado: "+insWS.getEstado()+"</p>");
                                                        out.println("</div>");
                                                    }   

                                                }
                                            }
                                        }
                                    }
                                }else
                                    out.println("<p>Usuario no encontrado</p>");
                            }else{
                             
                                List<servidor.Usuario>usu = OP.buscarusuarioWS("");
                                if(usu!= null){
                                    Iterator itCur = usu.iterator();
                                    servidor.Usuario usuariox = null;
                                    while(itCur.hasNext()){

                                        usuariox = (servidor.Usuario) itCur.next();
                                        out.println("<div>");

                                        out.println("<a href='consultarusuarios.jsp?usuario="+usuariox.getNickname()+"'class='mb-4' style='color: black'>"+usuariox.getNickname()+"</a><br><br>");
                                        out.println("</div>");

                                    }
                                }else
                                    out.println("<p>Sin usuarios</p>");
                            }
                         %>
                    </div>
                </div>
                
            </div>
        </div>
    </div>
</body>