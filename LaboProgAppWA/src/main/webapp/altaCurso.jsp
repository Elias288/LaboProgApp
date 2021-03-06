<%@page import="Clases.categoria"%>
<%@page import="Clases.instituto"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Clases.curso"%>
<%@page import="Clases.ControladorCurso"%>
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
    <%
        HttpSession sesion = request.getSession();
        if(sesion.getAttribute("user")!=null && sesion.getAttribute("nivel")!=null){
            String tipo = sesion.getAttribute("nivel").toString();
            if(!tipo.equals("1")) //si el tipo no es profesor
                out.println("<script>location.replace('index.jsp')</script>");
            }else
                out.println("<script>location.replace('login.jsp')</script>");
    %>
    
    <header class="site-navbar py-4" role="banner" >
        <div class="container">
            <jsp:include page="barraSuperior.jsp" />  
    </header>

    <div class="site-section">
      	<div class="container">
            <div class="row">
                
                <jsp:include page="barraLateral.jsp" />

                <div class="col-lg-9">
                    <div class="d-block d-md-flex podcast-entry bg-white" data-aos="fade-up">
                        <form action="altaCurso" method="GET">
                            <table>
                                <tr>
                                    <th style="width:200px"></th>
                                    <th style="width:200px"></th>
                                </tr>
                                <tr>

                                    <td><p>Instituto:</p></td>
                                    <td><!--<input type="text" name="instituto">-->
                                        <select name='instituto' id="selectOpt">
                                            
                                            <%
                                                if(request.getParameter("instituto")!= null){
                                                    out.print("<option value='"+request.getParameter("instituto")+"' name='insituto'>"+request.getParameter("instituto")+"</option>"); 
                                                }
                                                if(request.getParameter("existe")!= null){
                                                    out.println("<script language='javascript'>alert('El curso ya existe');</script");
                                                }
                                                else{
                                                    out.print("<option value='' name='insituto'></option>"); 
                                                }
                                                ControladorCurso cc = new ControladorCurso();
                                                List<instituto> inst = cc.buscarInstituto("");
                                                Iterator itIns = inst.iterator();
                                                instituto ins = null;
                                                while(itIns.hasNext()){
                                                    ins = (instituto) itIns.next();
                                                    out.print("<option value='"+ins.getFacultad()+"' onclick='jsFunction()' name='instituto'>"+ins.getFacultad()+"</option>");
                                                }
                                            %>
                                            
                                            <!--<option value="ITSP" onclick="jsFunction()">ITSP</option>-->
                                        </select>

                                        <!--<script>
                                            function jsFunction(){
                                                var myselect = document.getElementById("selectOpt");
                                                //alert(myselect.options[myselect.selectedIndex].value);
                                                location.replace("altaCurso.jsp?instituto="+myselect.value);
                                            }
                                        </script>-->
                                    </td>
                                    
                                </tr>
                                <tr>
                                    <td><p>Nombre del curso:</p></td>
                                    <td><input type="text" name="nombre">
                                        <!--<select id="selectCurso" name='nombre'>
                                        <option value=""></option>
                                        <%
                                            /*if(request.getParameter("instituto")!= null){
                                                String insti = request.getParameter("instituto");
                                                List<curso> cursos = cc.buscarCurso(insti);
                                                Iterator itCur = cursos.iterator();
                                                curso cur = null;
                                                while(itCur.hasNext()){
                                                    cur = (curso) itCur.next();
                                                    out.print("<option value='"+cur.getName()+"' onclick='jsFunction()' name='nombre'>"+cur.getName()+"</option>");
                                                }
                                            }*/
                                        %>
                                        </select>-->
                                    </td>
                                </tr>
                                <tr>
                                    <td><p>Descripción:</p></td>
                                    <td><input type="text" name="descripcion"></td>
                                </tr>
                                <tr>
                                    <td><p>Duración:</p></td>
                                    <td><input type="number" min="1" name="duracion"></td>
                                </tr>
                                <tr>
                                    <td><p>Horas:</p></td>
                                    <td><input type="number" min="1" name="horas"></td>
                                </tr>
                                <tr>
                                    <td><p>Créditos:</p></td>
                                    <td><input type="number" min="1" max="20" name="creditos"></td>
                                </tr>
                                <tr>
                                    <td><p>URL:</p></td>
                                    <td><input type="text" name="url"></td>
                                </tr>
                                </table>
                                    <hr width="75%" size="16px">
                                <table>
                                <tr>
                                    <th style="width:200px"></th>
                                    <th style="width:200px"></th>
                                </tr>
                                <tr>
                                    
                                    <td><p>Previas:</p></td>
                                    <!--<td><input type="text" name="previas"></td>-->
                                    <td>
                                    <%
                                        List<curso> prev = cc.buscarCurso("");
                                        Iterator itPrev = prev.iterator();
                                        curso previa = null;
                                        while(itPrev.hasNext()){
                                            previa = (curso)itPrev.next();
                                            out.print("<p><input type='checkbox' name='previas' value='"+previa.getName()+"'/> "+previa.getName()+"</p>");
                                        }
                                    %>
                                    </td>
                                </tr>
                                </table>
                                    <hr width="75%" size="16px">
                                <table>
                                <tr>
                                    <th style="width:200px"></th>
                                    <th style="width:200px"></th>
                                </tr>
                                <tr>
                                    
                                    <td><p>Categorías:</p></td>
                                    <td><!--<input type="text" name="categorias">-->
                                        <%
                                        List<categoria> cate = cc.buscarCategorias("");
                                        Iterator itCate = cate.iterator();
                                        categoria cat = null;
                                        while(itCate.hasNext()){
                                            cat = (categoria)itCate.next();
                                            out.print("<p><input type='checkbox' name='categorias' value='"+cat.Getnombre()+"'/> "+cat.Getnombre()+"</p>");
                                        }
                                    %>
                                    </td>
                                    
                                </tr>
                            </table>
                                    <hr width="75%" size="16px">
                                <%
                                        ControladorUsuario CU = new ControladorUsuario();
                                        usuario usu = CU.findusu(sesion.getAttribute("user").toString());
                                        out.println("<p><button type='submit' name='btnSubmit' style='padding: 5px 15px; margin-left: 15px; font-size: medium;' value='" + usu.getNN() +"'>Registrar</button></p>");
                                %>  
                        </form> 
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>