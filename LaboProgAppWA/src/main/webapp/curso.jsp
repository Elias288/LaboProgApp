<%//@page import="Clases.edicionCurso"%>
<%//@page import="Clases.instituto"%>
<%//@page import="Clases.curso"%>
<%//@page import="Clases.ControladorCurso"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URL"%>
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
        String user = (String)sesion.getAttribute("user");
        String tipo = (String)sesion.getAttribute("nivel");
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
                
                <!--PANEL PRINCIPAL-->
                <div class="col-lg-6">
                    <div class="d-block d-md-flex podcast-entry bg-white" data-aos="fade-up" style="height: 200px">
                        <div class='image' style="background-image: url('images/img-02.jpg');"></div>
                        <% 
                            if(request.getParameter("curso")!=null){
                                
                                servidor.Curso curWS = OP.findCursoWS(request.getParameter("curso"));
                                if(curWS!=null){
                                
                                    out.println("<div class='text'>");
                                    out.println("<h3 style='color: black'>" + curWS.getNombre()+ "</h3><br>");
                                    out.println("<font  size ='2' face='verdana' color='black'>"+ OP.insitutoCur(curWS.getNombre()) +"</font><br><br>");
                                    out.println("</div></div>");
                                    out.println("<div class='d-lg-block m-b-25 podcast-entry bg-white'>");
                                    out.println("<a style='color:cornflowerblue' href='curos.html' class='h10'>"+curWS.getURL()+"<br><br></a>");
                                    out.println("<h3 class='font-weight-light'>");
                                    out.println(curWS.getDescripcion());
                                    out.println("</h3>");
                                    out.println("</div>");
                                }else
                                    out.println("<p>Curso no encontrado</p>");
                                
                            }
                        %>
                    </div>
                    
                    <!--EDICIONES DE CURSO-->
                    <div class="col-lg-3">
                        <h3 style="color: black">Ediciones del cursos</h3>

                        <%
                            if(request.getParameter("curso")!= null){
                                servidor.Curso curWS = OP.findCursoWS(request.getParameter("curso"));
                                
                                //servidor.Curso cur = curWS.get(0);
                                
                                List<servidor.EdicionCurso> ListecWS = OP.buscarEdicionesWS("");
                                if(ListecWS!=null){
                                    servidor.EdicionCurso ec = null;
                                    Iterator itEC = ListecWS.iterator();

                                    while(itEC.hasNext()){

                                        ec = (servidor.EdicionCurso)itEC.next();
                                        if(curWS.getId() == ec.getCurso().getId()){ 

                                            //CODIFICO EL NOMBRE DE LA EDICION DE CURSO PARA ENVIARLO POR URL
                                            String url = ec.getNombre();
                                            String encodedurl = URLEncoder.encode(url,"UTF-8"); 

                                            if(user != null && tipo != null){

                                                if(tipo.equals("1")) //si el tipo es profesor
                                                    out.println("<a style='color:black' href=EdicionCurso.jsp?EdCur="+encodedurl+">");
                                                else
                                                    out.println("<a style='color:black' href=EdiciondeCurso.jsp?edicion="+encodedurl+">");
                                            }else
                                                out.println("<a style='color:black' href=EdiciondeCurso.jsp?edicion="+encodedurl+">");

                                            out.println("<div class='d-block m-b-25 d-md-flex podcast-entry2 bg-white' data-aos='fade-up'>");
                                            out.println("<div class='image' style='background-image: url('images/img-02.jpg');'></div>");
                                            out.println("<div class='text'>");
                                            out.println("<h3 class='font-weight-light'>"+ec.getNombre()+"<br></h3>");
                                            out.println("</div></div></a>");
                                        }
                                    }
                                }else
                                    out.println("<p>Sin Ediciones del curso</p>");
                            }
                        %>
                  
                        <h3 style="color: black">Programas de formación</h3>
                        <div class="d-block m-b-25 d-md-flex podcast-entry2 bg-white" data-aos="fade-up">
                            <div class="image" style="background-image: url('images/img-04.png');"></div>
                            <div class="text">
                              <h3 class="font-weight-light">
                                EFI Robotica.<br>
                              </h3>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
