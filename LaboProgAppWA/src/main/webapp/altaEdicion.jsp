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
    <%HttpSession sesion = request.getSession();%>
    
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
                        <form action="altaEdicion" method="GET">
                            <table>
                                <tr>
                                    <th style="width:200px"></th>
                                    <th style="width:200px"></th>
                                </tr>
                                <td><!--<input type="text" name="instituto">-->
                                    <p>Insituto:</p></td>
                                <td>
                                    <select name='instituto' onchange="jsFunction()" id="selectOpt">

                                        <%
                                            if(request.getParameter("instituto")!= null){
                                                out.print("<option onclick='jsFunction()' value='"+request.getParameter("instituto")+"' name='insituto'>"+request.getParameter("instituto")+"</option>"); 
                                            }
                                            else{
                                                out.print("<option onclick='jsFunction()' value='' name='insituto'></option>"); 
                                            }
                                            ControladorCurso cc = new ControladorCurso();
                                            List<instituto> inst = cc.buscarInstituto("");
                                            Iterator itIns = inst.iterator();
                                            instituto ins = null;
                                            while(itIns.hasNext()){
                                                ins = (instituto) itIns.next();
                                                out.print("<option onclick='jsFunction()' value='"+ins.getFacultad()+"' name='instituto'>"+ins.getFacultad()+"</option>");
                                            }
                                        %>

                                        <!--<option value="ITSP" onclick="jsFunction()">ITSP</option>-->
                                    </select>

                                    <script>
                                        function jsFunction(){
                                            var myselect = document.getElementById("selectOpt");
                                            //alert(myselect.options[myselect.selectedIndex].value);
                                            location.replace("altaEdicion.jsp?instituto="+myselect.value);
                                        }
                                    </script>
                                </td>
                                <tr>
                                    <td><p>Curso:</p></td>
                                    <td><!--<input type="text" name="curso">-->
                                        <select id="selectCurso" name='curso'>
                                        <option value=""></option>
                                        <%
                                            if(request.getParameter("instituto")!= null){
                                                String insti = request.getParameter("instituto");
                                                List<curso> cursos = cc.buscarCurso(insti);
                                                Iterator itCur = cursos.iterator();
                                                curso cur = null;
                                                while(itCur.hasNext()){
                                                    cur = (curso) itCur.next();
                                                    out.print("<option value='"+cur.getName()+"' onclick='jsFunction()' name='curso'>"+cur.getName()+"</option>");
                                                }
                                            }
                                        %>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td><p>Nombre edición:</p></td>
                                    <td><input type="text" name="nombre"></td>
                                </tr>
                                <tr>
                                    <td><p>Fecha Inicio:</p></td>
                                    <td><input type="date" name="finicio"></td>
                                </tr>
                                <tr>
                                    <td><p>Fecha Fin:</p></td>
                                    <td><input type="date" name="ffin"></td>
                                </tr>
                                <tr>
                                    <td><p>Cupos:</p></td>
                                    <td><input type="number" min="1" max="50" name="cupos"></td>
                                </tr>
                                
                                <tr>
                                    <%
                                        /*List<curso> cursos  = new ArrayList<curso>();
                                        cursos = cc.buscarCurso("");
                                        Iterator iterCur = cursos.iterator();
                                        curso cur;
                                        while(iterCur.hasNext()){
                                            cur = (curso)iterCur.next();
                                            out.println("<label><input type='checkbox' id='cbox1' value='first_checkbox'>"+cur.getName()+"</label><br>");
                                            out.println("<label><input type='checkbox' id='cbox1' value='first_checkbox'> Este es mi primer checkbox</label><br>");
                                        }*/
                                    %>
                                </tr>
                            </table>
                                <%
                                        ControladorUsuario CU = new ControladorUsuario();
                                        usuario usu = CU.findusu(sesion.getAttribute("user").toString());
                                        out.println("<p><button type='submit' name='btnSubmit' style='padding: 5px 15px; margin-left: 15px; font-size: medium;' value='" + usu.getNN() +"'>Registrar</button></p>");
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