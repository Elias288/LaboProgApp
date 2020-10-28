<%@page import="Clases.edicionCurso"%>
<%@page import="Clases.ControladorUsuario"%>
<%@page import="Clases.usuario"%>
<%@page import="Clases.categoria"%>
<%@page import="com.mycompany.laboprogappwa.Operaciones"%>
<%@page import="java.util.Iterator"%>
<%@page import="Clases.instituto"%>
<%@page import="java.util.List"%>
<%@page import="Clases.curso"%>
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

                
                <div class="col-lg-6">
                    <div class="d-block podcast-entry bg-white" data-aos="fade-up">
                        <% 
                            ControladorUsuario uu = new ControladorUsuario();
                            Operaciones OP = new Operaciones();
                            
                            if(request.getParameter("usuario") != null){
                                String nickname = request.getParameter("usuario");
                                 List<usuario>usu = uu.buscarusuario(nickname);
                                
                                Iterator itCur = usu.iterator();
                                usuario usuariox = null;
                                while(itCur.hasNext()){
                                    usuariox = (usuario) itCur.next();
                                    /*out.println("<form action='curso.jsp' method='GET'>");
                                    out.println("<button type='submit' name='curso' value='"+cur.getName()+"' >"+cur.getName()+"</button>");
                                    out.println("</form><br>");*/
                                    out.println("<div>");
                    
                                    out.println("<h4> Nickname="+usuariox.getNN()+" Nombre="+usuariox.getName()+" Apellido="+usuariox.getLastName()+"</h4>" );
                                    out.println("</div>");
                            
                            
                                }
                                  if(uu.tipoUsuario(nickname)==1){
                                   out.println("<h4> es docente </h4>"); 
                                  ControladorCurso  cc= new ControladorCurso();
                                 
                                                
                                  
                                 curso cu= OP.findCurso2(nickname);
                                  List<edicionCurso>datos = cc.buscarEdiciones(cu.getName());
                                  Iterator opaaaa = datos.iterator();
                                  edicionCurso opa = null;
                                    while(opaaaa.hasNext()){
                                    opa = (edicionCurso) opaaaa.next();
                                    /*out.println("<form action='curso.jsp' method='GET'>");
                                    out.println("<button type='submit' name='curso' value='"+cur.getName()+"' >"+cur.getName()+"</button>");
                                    out.println("</form><br>");*/
                                    
                                    out.println("<div>");
                    
                                    out.println("<h4> Nombre="+opa.getNombre()+" Fecha Final="+opa.getPfin()+" Fecha Inicio="+opa.getPinicio()+" Cupos="+opa.getCupo()+" Fecha publicacion"+ opa.getFechaPublicacion()+"</h4>" );
                                    out.println("</div>");
                            
                            
                                }
                            }
                                
                            }
                            
                            else{
                             
                                 List<usuario>usu = uu.buscarusuario("");
                                
                                Iterator itCur = usu.iterator();
                                usuario usuariox = null;
                                while(itCur.hasNext()){
                                
                                    usuariox = (usuario) itCur.next();
                                    /*out.println("<form action='curso.jsp' method='GET'>");
                                    out.println("<button type='submit' name='curso' value='"+cur.getName()+"' >"+cur.getName()+"</button>");
                                    out.println("</form><br>");*/
                                    out.println("<div>");
                    
                                    out.println("<a href='consultarusuarios.jsp?usuario="+usuariox.getNN()+"'class='mb-4' style='color: black'>"+usuariox.getNN()+"</a><br><br>");
                                    out.println("</div>");
                            
                                }
                            }
                         %>
                    </div>
                </div>
                
            </div>
        </div>
    </div>
</body>