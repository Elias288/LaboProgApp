<%@page import="Clases.docente"%>
<%@page import="Clases.categoria"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.mycompany.laboprogappwa.Operaciones"%>
<%@page import="Clases.instituto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="Clases.usuario"%>
<%@page import="Clases.ControladorUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesion = request.getSession();
    Operaciones OP = new Operaciones();
%>

<!-- PERFIL NO INICIADO -->
    <%
        if(sesion.getAttribute("user")==null && sesion.getAttribute("nivel")==null){
            out.println("<div class='col-lg-3'>");
        }else
            out.println("<div class='col-lg-3' style='border: 2px solid; display: none'>");
    %>
        <div style="border: 2px solid; padding: 5px 10px">
            <div class="featured-user  mb-5 mb-lg-0" style="border-bottom: 2px solid">
                <h3 class="mb-4">Institutos</h3>
                <ul class="list-unstyled">

                    <!--LISAR INSTITUTOS-->
                    <%
                        List<instituto>listaIns = OP.institutos();
                        Iterator itIns = listaIns.iterator();
                        instituto ins = null;
                        while(itIns.hasNext()){
                            ins = (instituto) itIns.next();
                            out.println("<li><a href='consultaCursos.jsp?instituto="+ ins.getFacultad() +"' class='d-flex align-items-center'>");
                            out.println("<div class='podcaster'><span class='d-block'>" + ins.getFacultad() + "</span></div></a></li>");

                        }
                    %>
                </ul>
            </div>

            <!--CATEGORIAS-->    
            <div class="featured-user  mb-5 mb-lg-0">
                <h3 class="mb-4">CATEGORÍAS</h3>
                <ul class="list-unstyled">

                    <%
                        List<categoria>listaCate = OP.categoria();
                        Iterator itCate = listaCate.iterator();
                        categoria cat = null;
                        while(itCate.hasNext()){
                            cat = (categoria) itCate.next();
                            out.println("<li><a href='#' class='d-flex align-items-center'>");
                            out.println("<div class='podcaster'><span class='d-block'>" + cat.Getnombre() + "</span></div>");
                            out.println("</a></li>");
                        }
                    %>
                </ul>
            </div>
        </div>
    </div>
                
    <!-- PERFIL INICIADO-->
    <%
        if(sesion.getAttribute("user")!=null && sesion.getAttribute("nivel")!=null){
            out.println("<div class='col-lg-3'>");
        }else
            out.println("<div class='col-lg-3' style='border: 2px solid; display: none'>");
    %>
        <div style="border: 2px solid; padding: 5px 10px">
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
                                    out.println("<li><a href='EdicionCurso.jsp'>seleccionar alumno</a></li>"); //temporal
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
                if(sesion.getAttribute("user")!=null && sesion.getAttribute("nivel")!=null){ //si la sesion esta iniciada
                    String tipo = sesion.getAttribute("nivel").toString();
                    if(tipo.equals("2")){ //si el tipo es alumno
                        out.println("<div class='featured-user  mb-5 mb-lg-0' style='border-bottom: 2px solid'>");
                    }else
                        out.println("<div class='featured-user  mb-5 mb-lg-0' style='border-bottom: 2px solid; display: none'>");
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
            if(sesion.getAttribute("user")!=null && sesion.getAttribute("nivel")!=null){ //si la sesion esta iniciada
                String tipo = sesion.getAttribute("nivel").toString();
                if(tipo.equals("1")){ //si el tipo es profesor
                    out.println("<div class='featured-user  mb-5 mb-lg-0' style='border-bottom: 2px solid'>");
                }else
                    out.println("<div class='featured-user  mb-5 mb-lg-0' style='border-bottom: 2px solid; display: none'>");
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
                
                <!--LISAR INSTITUTOS-->
                <%
                    if(sesion.getAttribute("user")!=null && sesion.getAttribute("nivel")!=null){ //si la sesion esta iniciada
                        
                        if(sesion.getAttribute("nivel").toString().equals("1")){
                            ControladorUsuario CU = new ControladorUsuario();
                            //usuario usu = CU.findusu(sesion.getAttribute("user").toString());
                            docente doc = CU.findDocente(sesion.getAttribute("user").toString());
                        
                            List<instituto>listaInsProf = OP.institutos();
                            Iterator itInsProf = listaInsProf.iterator();
                            instituto insProf = null;
                            while(itInsProf.hasNext()){
                                insProf = (instituto) itInsProf.next();
                                if(insProf.getId()== doc.getInstituto().getId()){
                                    out.println("<li><a href='consultaCursos.jsp?instituto="+ insProf.getFacultad() +
                                        "' class='d-flex align-items-center'><div class='podcaster'><span class='d-block'>"
                                        +insProf.getFacultad()+"</span></div></a></li>");                            
                                }  
                            }
                        }else if(sesion.getAttribute("nivel").toString().equals("2")){
                            List<instituto>listaInsAlum = OP.institutos();
                            Iterator itInsAlum = listaInsAlum.iterator();
                            instituto insAlumn = null;
                            while(itInsAlum.hasNext()){
                                insAlumn = (instituto) itInsAlum.next();
                                out.println("<li><a href='consultaCursos.jsp?instituto="+ insAlumn.getFacultad() +"' class='d-flex align-items-center'>");
                                out.println("<div class='podcaster'><span class='d-block'>" + insAlumn.getFacultad() + "</span></div></a></li>");
                            }
                        }
                        
                    }
                %>
                
            </ul>
        </div>

        <div class="featured-user  mb-5 mb-lg-0" style="border-bottom: 2px solid">
            <h3 class="mb-4">CATEGORÍAS</h3>
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
    </div>