<%@page import="java.util.List"%>
<%@page import="servidor.Usuario"%>
<%//@page import="Clases.usuario"%>
<%//@page import="Clases.ControladorUsuario"%>
<%@page import="com.mycompany.laboprogappwa.Operaciones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    HttpSession sesion = request.getSession();
    Operaciones OP = new Operaciones();
%>      
<div class="container">
    <div class="topnav" id="myTopnav">
    <div class="row align-items-center" style="border-bottom: 2px solid">
        <div class="col-3">
            <h1 class="site-logo"><a href="index.jsp" class="h2">ed<span class="text-primary">EXT</span> </a></h1>
        </div>
        <div class="col-9">
            <nav class="site-navigation position-relative text-right text-md-right" role="navigation">
                
               
                <div class="d-block d-lg-none ml-md-0 mr-auto" >
                    <a href="#" class="site-menu-toggle js-menu-toggle text-black" >
                        <span class="icon-menu h3"></span>
                    </a>
                </div>

                <ul class="site-menu js-clone-nav d-none d-lg-block">
                    <!--HOME-->
                    <li class="active"><a href="index.jsp">Home</a></li>

                        <%
                            String user = (String)sesion.getAttribute("user");
                            if(user!=null){
                                if ( user != null ){
                                    out.println("<li class='active'><a href='User.jsp'>" + user + "</a></li>");
                                    out.println("<li class='active'></a></li>");
                                }else{
                                    out.println("usuario "+ user + " no encontrado<br>");
                                }
                            }else{
                                out.println("<li><a href='login.jsp'>Login</a></li>");
                                out.println("<li>/</li>");
                                out.println("<li><a href='register.jsp'>Register</a></li>");
                                //out.println("<script>location.replace('login.jsp');</script>");
                            }
                        %>

                </ul>
                  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
                    <i class="fa fa-bars"></i>
                  </a>
           

     <!--           
                <div class="d-block d-lg-none ml-md-0 mr-auto" >
                    <a href="#" class="site-menu-toggle js-menu-toggle text-black" >
                        <span class="icon-menu h3"></span>
                    </a>
                </div>

                <ul class="site-menu js-clone-nav d-none d-lg-block">
                    <!--HOME-->
                <!--    <li class="active"><a href="index.jsp">Home</a></li>

                        <%
                          /*  String user = (String)sesion.getAttribute("user");
                            if(user!=null){
                                if ( user != null ){
                                    out.println("<li class='active'><a href='User.jsp'>" + user + "</a></li>");
                                    out.println("<li class='active'></a></li>");
                                }else{
                                    out.println("usuario "+ user + " no encontrado<br>");
                                }
                            }else{
                                out.println("<li><a href='login.jsp'>Login</a></li>");
                                out.println("<li>/</li>");
                                out.println("<li><a href='register.jsp'>Register</a></li>");
                                //out.println("<script>location.replace('login.jsp');</script>");
                            } */
                        %>

                </ul> -->
            </nav>

            <script>
                function myFunction() {
                  var x = document.getElementById("myTopnav");
                  if (x.className === "topnav") {
                    x.className += " responsive";
                  } else {
                    x.className = "topnav";
                  }
                }
            </script>

            <div class="buscador" style="margin-bottom: 3rem!important; display: flex; flex-direction: row-reverse; max-width: 60%">
                <form action="curso.jsp" method="GET">
                    <input type="search" name="busqueda" placeholder="Cursos, Programas" style=" padding-left: 10px; flex: 1; border: 1px solid; font-size: medium;">
                    <input type="submit" value="Buscar" style="padding: 5px 15px; margin-left: 15px; font-size: medium;">
                </form>
            </div>
        </div>
    </div>
 </div>
</div>
