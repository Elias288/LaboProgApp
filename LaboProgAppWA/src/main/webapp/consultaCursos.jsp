<%@page import="Clases.edicionCurso"%>
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

                
                <div class="col-lg-4">
                    <h1>Cursos: </h1>
                    <div class="d-block podcast-entry bg-white" data-aos="fade-up">
                        <% 
                            ControladorCurso cc = new ControladorCurso();
                            Operaciones OP = new Operaciones();
                            
                            if(request.getParameter("instituto") != null){
                                String ins = request.getParameter("instituto");
                                
                                List<curso> cursos = cc.buscarCurso(ins);
                                Iterator itCur = cursos.iterator();
                                curso cur = null;
                                while(itCur.hasNext()){
                                    cur = (curso) itCur.next();
                                    /*out.println("<form action='curso.jsp' method='GET'>");
                                    out.println("<button type='submit' name='curso' value='"+cur.getName()+"' >"+cur.getName()+"</button>");
                                    out.println("</form><br>");*/
                                    out.println("<div class='d-block d-md-flex podcast-entry bg-white mb-5' style='height: 200px' data-aos='fade-up'>");
                                    out.println("<div class='text'>");
                                    out.println("<a href='curso.jsp?curso="+cur.getName()+"'class='mb-4' style='color: black'>"+cur.getName()+"</a><br><br>");
                                    out.println("</div></div>");
                                }
                                
                                
                                
                            }
                            
                            /*if(request.getParameter("categoria") != null){
                                String cato =request.getParameter("categoria");
                                List<categoria> cat = cc.buscarCategorias(cato); //categoria a buscar
                                categoria cat1 = cat.get(0); //guardo la categoria en un objeto categoria
                                List<curso> cursos = OP.BuscarCursos(""); //lista de cursos
                                Iterator itCur = cursos.iterator();
                                curso cur = null; //curso
                                while(itCur.hasNext()){
                                    cur = (curso) itCur.next();
                                    
                                    List<categoria> cates = cur.getCategorias();
                                    Iterator itCates = cates.iterator();
                                    categoria catego = null;
                                    while(itCates.hasNext()){
                                        catego = (categoria) itCates.next();
                                        if(cat1.Getnombre().equals(catego.Getnombre())){
                                            out.println("<div class='d-block d-md-flex podcast-entry bg-white mb-5' style='height: 200px' data-aos='fade-up'>");
                                            out.println("<div class='text'>");
                                            out.println("<a href='curso.jsp?curso="+cur.getName()+"' class='mb-4' style='color: black'>"+cur.getName()+"</a><br><br>");
                                            out.println("</div></div>");
                                        }
                                    }
                                    //out.println("<form action='curso.jsp' method='GET'>");
                                    //out.println("<button type='submit' name='curso' value='"+cur.getName()+"' >"+cur.getName()+"</button>");
                                    //out.println("</form><br>");
                                    
                                }
                                
                            }*/
                         %>
                    </div>
                </div>
                <div class="col-lg-4">
                    <h1>Ediciones: </h1>
                    <div class="d-block podcast-entry bg-white" data-aos="fade-up">
                        <% 
                            
                            if(request.getParameter("instituto") != null){
                                String ins = request.getParameter("instituto");

                                List<edicionCurso> edCurso = cc.buscarEdicionXIns(ins);
                                Iterator itEd = edCurso.iterator();
                                edicionCurso ed = null;
                                while(itEd.hasNext()){
                                    ed = (edicionCurso) itEd.next();
                                    /*out.println("<form action='curso.jsp' method='GET'>");
                                    out.println("<button type='submit' name='curso' value='"+cur.getName()+"' >"+cur.getName()+"</button>");
                                    out.println("</form><br>");*/
                                    out.println("<div class='d-block d-md-flex podcast-entry bg-white mb-5' style='height: 200px' data-aos='fade-up'>");
                                    out.println("<div class='text'>");
                                    out.println("<a href='EdiciondeCurso.jsp?edicion="+ed.getNombre()+"' class='mb-4' style='color: black'>"+ed.getNombre()+"</a><br><br>");
                                    out.println("</div></div>");
                                }
                                
                            }
                            
                            /*if(request.getParameter("categoria") != null){
                                String cato = request.getParameter("categoria");
                                List<edicionCurso> ed = cc.buscarEdicionXCat(cato);
                                Iterator itEd = ed.iterator();
                                edicionCurso edicion = null;
                                while(itEd.hasNext()){
                                    edicion = (edicionCurso) itEd.next();

                                    out.println("<div class='d-block d-md-flex podcast-entry bg-white mb-5' style='height: 200px' data-aos='fade-up'>");
                                    out.println("<div class='text'>");
                                    out.println("<a href='EdiciondeCurso.jsp?edicion='"+edicion.getNombre()+"'class='mb-4' style='color: black'>"+edicion.getNombre()+"</a><br><br>");
                                    out.println("</div></div>");

                                }
                            }*/
                            
                         %>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>