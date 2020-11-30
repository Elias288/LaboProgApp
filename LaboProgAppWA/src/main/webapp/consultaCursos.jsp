<%//@page import="Clases.edicionCurso"%>
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

                
                <div class="col-lg-4">
                    <!--<h1>Cursos: </h1>-->
                    <div class="d-block podcast-entry bg-white" data-aos="fade-up">
                        <% 
                            //ControladorCurso cc = new ControladorCurso();
                            
                            if(request.getParameter("instituto") != null){
                                String ins = request.getParameter("instituto");
                                
                                //List<curso> cursos = cc.buscarCurso(ins);
                                List<servidor.Curso> cursosWS = OP.BuscarCursosWS(ins);
                                if(cursosWS!=null){
                                    Iterator itCur = cursosWS.iterator();
                                    servidor.Curso cur = null;
                                    while(itCur.hasNext()){
                                        cur = (servidor.Curso) itCur.next();
                                        /*out.println("<form action='curso.jsp' method='GET'>");
                                        out.println("<button type='submit' name='curso' value='"+cur.getName()+"' >"+cur.getName()+"</button>");
                                        out.println("</form><br>");*/
                                        out.println("<div class='d-block d-md-flex podcast-entry bg-white mb-5' style='height: 200px' data-aos='fade-up'>");
                                        out.println("<div class='text'>");
                                        out.println("<a href='curso.jsp?curso="+cur.getNombre()+"'class='mb-4' style='color: black'>"+cur.getNombre()+"</a><br><br>");
                                        out.println("</div></div>");
                                    }
                                }
                            }
                            if(request.getParameter("categoria") != null){
                                String cato =request.getParameter("categoria");
                                //List<categoria> cat = cc.buscarCategorias(cato); //categoria a buscar
                                List<servidor.Categoria> catWS = OP.categoriaWS(cato);
                                if(catWS!=null){
                                    //categoria cat1 = cat.get(0); //guardo la categoria en un objeto categoria
                                    servidor.Categoria cat1WS = catWS.get(0); //guardo la categoria en un objeto categoria
                                    List<servidor.Curso> cursos = OP.BuscarCursosWS(""); //lista de cursos
                                    Iterator itCur = cursos.iterator();
                                    servidor.Curso cur = null; //curso
                                    while(itCur.hasNext()){
                                        cur = (servidor.Curso) itCur.next();

                                        List<servidor.Categoria> cates = cur.getCat();
                                        Iterator itCates = cates.iterator();
                                        servidor.Categoria catego = null;
                                        while(itCates.hasNext()){
                                            catego = (servidor.Categoria) itCates.next();
                                            if(cat1WS.getNombre().equals(catego.getNombre())){
                                                out.println("<div class='d-block d-md-flex podcast-entry bg-white mb-5' style='height: 200px' data-aos='fade-up'>");
                                                out.println("<div class='text'>");
                                                out.println("<a href='curso.jsp?curso="+cur.getNombre()+"' class='mb-4' style='color: black'>"+cur.getNombre()+"</a><br><br>");
                                                out.println("</div></div>");
                                            }
                                        }
                                    }
                                }
                            }
                         %>
                    </div>
                </div>
                <!--    
                <div class="col-lg-4">
                    <h1>Ediciones: </h1>
                    <div class="d-block podcast-entry bg-white" data-aos="fade-up">
                        <% 
                            /*
                            if(request.getParameter("instituto") != null){
                                String ins = request.getParameter("instituto");

                                List<edicionCurso> edCurso = cc.buscarEdicionXIns(ins);
                                Iterator itEd = edCurso.iterator();
                                edicionCurso ed = null;
                                while(itEd.hasNext()){
                                    ed = (edicionCurso) itEd.next();
                                    out.println("<div class='d-block d-md-flex podcast-entry bg-white mb-5' style='height: 200px' data-aos='fade-up'>");
                                    out.println("<div class='text'>");
                                    out.println("<a href='EdiciondeCurso.jsp?edicion="+ed.getNombre()+"' class='mb-4' style='color: black'>"+ed.getNombre()+"</a><br><br>");
                                    out.println("</div></div>");
                                }
                                
                            }*/
                         %>
                    </div>
                </div>
                -->
            </div>
        </div>
    </div>
</body>