<%@page import="servidor.Usuario"%>
<%@page import="com.mycompany.laboprogappwa2_1.Operaciones"%>
<%@page import="Clases.usuario"%>
<%@page import="Clases.ControladorUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%HttpSession sesion = request.getSession();%>
<div class="container">
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
                            if(sesion.getAttribute("user")!=null && sesion.getAttribute("nivel")!=null){
                                /*ControladorUsuario CU = new ControladorUsuario();
                                usuario usu = CU.findusu(sesion.getAttribute("user").toString());*/
                                
                                Operaciones OP = new Operaciones();
                                servidor.DataUsuario usuWS = OP.findusuWS(sesion.getAttribute("user").toString());
                                
                                //String tipo = sesion.getAttribute("nivel").toString();
                                out.println("<li class='active'><a href='User.html'>" + usuWS.getNickname() + "</a></li>");
                                out.println("<li class='active'></a></li>");
                            }else{
                                out.println("<li><a href='login.jsp'>Login</a></li>");
                                out.println("<li>/</li>");
                                out.println("<li><a href='register.jsp'>Register</a></li>");
                                //out.println("<script>location.replace('login.jsp');</script>");
                            }
                        %>

                </ul>
            </nav>

            <div class="buscador" style="margin-bottom: 3rem!important; display: flex; flex-direction: row-reverse; max-width: 60%">
                <form action="curso.jsp" method="GET">
                    <input type="search" name="busqueda" placeholder="Cursos, Programas" style=" padding-left: 10px; flex: 1; border: 1px solid; font-size: medium;">
                    <input type="submit" value="Buscar" style="padding: 5px 15px; margin-left: 15px; font-size: medium;">
                </form>
            </div>
        </div>
    </div>
</div>
