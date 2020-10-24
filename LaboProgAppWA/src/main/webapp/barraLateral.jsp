<%@page import="Clases.usuario"%>
<%@page import="Clases.ControladorUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%HttpSession sesion = request.getSession();%>
<!-- PERFIL NO INICIADO -->
    <%
        if(sesion.getAttribute("user")==null && sesion.getAttribute("nivel")==null){
            out.println("<div class='col-lg-3' style='border: 2px solid'>");
        }else
            out.println("<div class='col-lg-3' style='border: 2px solid; display: none'>");
    %>
    <!--<div class="col-lg-3" style="border: 2px solid; display: none" >-->
        <div class="featured-user  mb-5 mb-lg-0" style="border-bottom: 2px solid">
            <h3 class="mb-4">Institutos</h3>
            <ul class="list-unstyled">
                <li>
                    <a href="#" class="d-flex align-items-center">
                        <div class="podcaster"><span class="d-block">INCO</span></div>
                    </a>
                </li>
                <li>
                    <a href="#" class="d-flex align-items-center">
                        <div class="podcaster"><span class="d-block">IMERL</span></div>
                    </a>
                </li>
                <li>
                    <a href="#" class="d-flex align-items-center">
                        <div class="podcaster"><span class="d-block">Fisica</span></div>
                    </a>
                </li>
                <li>
                    <a href="#" class="d-flex align-items-center">
                        <div class="podcaster"><span class="d-block">IMPII</span></div>
                    </a>
                </li>
                <li>
                    <a href="#" class="d-flex align-items-center">
                        <div class="podcaster"><span class="d-block">Electrica</span></div>
                    </a>
                </li>
                <li>
                    <a href="#" class="d-flex align-items-center">
                        <div class="podcaster"><span class="d-block">DISI</span></div>
                    </a>
                </li>
            </ul>
        </div>

        <div class="featured-user  mb-5 mb-lg-0">
            <h3 class="mb-4">CATEGORIAS</h3>
            <ul class="list-unstyled">
                <li>
                    <a href="#" class="d-flex align-items-center">
                        <div class="podcaster"><span class="d-block">Social</span></div>
                    </a>
                </li>
                <li>
                    <a href="#" class="d-flex align-items-center">
                        <div class="podcaster"><span class="d-block">Industrial</span></div>
                    </a>
                </li>
                <li>
                    <a href="#" class="d-flex align-items-center">
                        <div class="podcaster"><span class="d-block">Educativos</span></div>
                    </a>
                </li>
                <li>
                    <a href="#" class="d-flex align-items-center">
                        <div class="podcaster"><span class="d-block">Interdiciplinario</span></div>
                    </a>
                </li>
            </ul>
        </div>
    </div>
                
    <!-- PERFIL INICIADO-->
    <%
        if(sesion.getAttribute("user")!=null && sesion.getAttribute("nivel")!=null){
            out.println("<div class='col-lg-3' style='border: 2px solid'>");
        }else
            out.println("<div class='col-lg-3' style='border: 2px solid; display: none'>");
    %>
    
        <!--MI PERFIL-->
        <div class="featured-user  mb-5 mb-lg-0" style="border-bottom: 2px solid">
            <div class="has-children">
                <h3 class="mb-4">Mi perfil ></h3>
                <ul class="miperfil arrow-top" style="border: 2px solid">
                    <li><a href='User.html'>Gestionar</a></li>
                    <% 
                        if(sesion.getAttribute("user")!=null && sesion.getAttribute("nivel")!=null){ //si la sesion esta iniciada
                            String tipo = sesion.getAttribute("nivel").toString();
                            if(tipo.equals("1")){ //si el tipo es profesor
                                out.println("<li><a href='#'>Menu one</a></li>");
                                out.println("<li><a href='#'>Menu two</a></li>");
                                out.println("<li><a href='#'>Menu three</a></li>");
                                out.println("<li><a href='SelEstEdCur.jsp'>seleccionar alumno</a></li>"); //temporal
                            }else{
                                out.println("<li><a href='#'>Menu one</a></li>");
                                out.println("<li><a href='#'>Menu two</a></li>");
                                out.println("<li><a href='#'>Menu three</a></li>");
                            }
                        }
                    %>
                </ul>
            </div>
        </div>
                
        <!--INSCRIPCIONES (ALUMNO)-->
        <%
            String tipo = sesion.getAttribute("nivel").toString();
            if(tipo.equals("2")){ //si el tipo es alumno
                out.println("<div class='featured-user  mb-5 mb-lg-0' style='border-bottom: 2px solid'>");
            }else
                out.println("<div class='featured-user  mb-5 mb-lg-0' style='border-bottom: 2px solid; display: none'>");
        %>
        
            <h3 class="mb-4">Inscripciones</h3>
            <ul class="list-unstyled">
                <li>
                    <a href="#" class="d-flex align-items-center">
                        <div class="podcaster"><span class="d-block">Inscribirme</span></div>
                    </a>
                </li>
                <li>
                    <a href="#" class="d-flex align-items-center">
                        <div class="podcaster"><span class="d-block">Ver resultados</span></div>
                    </a>
                </li>
                
            </ul>
        </div>
        
        <!--CURSOS (PROFESOR)-->
        <%
            if(tipo.equals("1")){ //si el tipo es profesor
                out.println("<div class='featured-user  mb-5 mb-lg-0' style='border-bottom: 2px solid'>");
            }else
                out.println("<div class='featured-user  mb-5 mb-lg-0' style='border-bottom: 2px solid; display: none'>");
        %>
            <h3 class="mb-4">Cursos</h3>
            <ul class="list-unstyled">
                <li>
                    <a href="altaCurso.jsp" class="d-flex align-items-center">
                        <div class="podcaster"><span class="d-block">Alta Curso</span></div>
                    </a>
                </li>
                <li>
                    <a href="#" class="d-flex align-items-center">
                        <div class="podcaster"><span class="d-block">Alta Edición</span></div>
                    </a>
                </li>
                <li>
                    <a href="#" class="d-flex align-items-center">
                        <div class="podcaster"><span class="d-block">Alta Programa</span></div>
                    </a>
                </li>
            </ul>
        </div>

        <div class="featured-user  mb-5 mb-lg-0" style="border-bottom: 2px solid">
            <h3 class="mb-4">Institutos</h3>
            <ul class="list-unstyled">
                <li>
                    <a href="#" class="d-flex align-items-center">
                        <div class="podcaster"><span class="d-block">INCO</span></div>
                    </a>
                </li>
                <li>
                    <a href="#" class="d-flex align-items-center">
                        <div class="podcaster"><span class="d-block">IMERL</span></div>
                    </a>
                </li>
                <li>
                    <a href="#" class="d-flex align-items-center">
                        <div class="podcaster"><span class="d-block">Fisica</span></div>
                    </a>
                </li>
            </ul>
        </div>

        <div class="featured-user  mb-5 mb-lg-0" style="border-bottom: 2px solid">
            <h3 class="mb-4">CATEGORIAS</h3>
            <ul class="list-unstyled">
                <li>
                    <a href="#" class="d-flex align-items-center">
                        <div class="podcaster"><span class="d-block">Social</span></div>
                    </a>
                </li>
                <li>
                    <a href="#" class="d-flex align-items-center">
                        <div class="podcaster"><span class="d-block">Industrial</span></div>
                    </a>
                </li>
                <li>
                    <a href="#" class="d-flex align-items-center">
                        <div class="podcaster"><span class="d-block">Educativos</span></div>
                    </a>
                </li>
                <li>
                    <a href="#" class="d-flex align-items-center">
                        <div class="podcaster"><span class="d-block">Interdiciplinario</span></div>
                    </a>
                </li>
            </ul>
        </div>

        <div class="featured-user  mb-5 mb-lg-0">
            <% out.println("<a href='login.jsp?cerrar=true'class='mb-4'>Salir <i class='glyphicon glyphicon-log-out' aria-hidden='true'></i></a>"); %>

        </div>
    </div>