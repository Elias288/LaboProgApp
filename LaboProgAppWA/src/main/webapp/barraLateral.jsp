<%//@page import="Clases.docente"%>
<%//@page import="Clases.categoria"%>
<%//@page import="Clases.usuario"%>
<%//@page import="Clases.ControladorUsuario"%>
<%//@page import="Clases.instituto"%>
<%@page import="servidor.Docente"%>
<%@page import="servidor.Categoria"%>
<%@page import="servidor.Instituto"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.mycompany.laboprogappwa.Operaciones"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
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
                        List<servidor.Instituto> listaInsWS = OP.insitututosWS("");
                        
                        if(listaInsWS!=null){
                            Iterator itIns = listaInsWS.iterator();

                            Instituto ins = null;
                            while(itIns.hasNext()){
                                ins = (Instituto) itIns.next();
                                out.println("<li><a href='consultaCursos.jsp?instituto="+ ins.getFacultad() +"' class='d-flex align-items-center'>");
                                out.println("<div class='podcaster'><span class='d-block'>" + ins.getFacultad() + "</span></div></a></li>");

                            }
                        }else{
                            out.println("<p>Sin institutos</p>");
                        }
                    %>
                    <li><a href='test.jsp?edcur=PYE' class='d-flex align-items-center'><div class='podcaster'><span class='d-block'>Probar</span></div></a></li>
                            
                </ul>
            </div>

            <!--CATEGORIAS-->    
            <div class="featured-user  mb-5 mb-lg-0" style="border-bottom: 2px solid">
                <h3 class="mb-4">CATEGORÍAS</h3>
                <ul class="list-unstyled">

                    <%
                        //List<categoria> listaCate = OP.categoria();
                        List<servidor.Categoria>listaCateWS = OP.categoriaWS("");
                        
                        if(listaCateWS!=null){
                            Iterator itCate = listaCateWS.iterator();
                        
                            servidor.Categoria cat = null;
                            while(itCate.hasNext()){
                                cat = (servidor.Categoria) itCate.next();
                                out.println("<li><a href='consultaCursos.jsp?categoria="+cat.getNombre()+"' class='d-flex align-items-center'>");
                                out.println("<div class='podcaster'><span class='d-block'>" + cat.getNombre() + "</span></div>");
                                out.println("</a></li>");
                            }
                        }else{
                            out.println("<p>Sin categorias</p>");
                        }
                    %>
                </ul>
            </div>
                
                
            <div class="featured-user  mb-5 mb-lg-0">
                <div>
                    <ul class="list-unstyled">
                        <%
                        //out.println("<li><a href='consultarusuarios.jsp'> Listar Usuarios");
                        out.println("<li><a href='consultarusuarios.jsp' class='d-flex align-items-center'>");
                        out.println("<div class='podcaster'><span class='d-block'>Listar Usuarios</span></div>");
                        out.println("</a></li>");
                        %>
                    </ul>
                </div>
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
                        <li><a href='User.jsp'>Gestionar</a></li>
                        <% 
                            if(sesion.getAttribute("user")!=null && sesion.getAttribute("nivel")!=null){ //si la sesion esta iniciada
                                String tipo = (String)sesion.getAttribute("nivel");
                                if(tipo.equals("1")){ //si el tipo es profesor
                                    out.println("<li><a href='#'>Menu one</a></li>");
                                    out.println("<li><a href='#'>Menu two</a></li>");
                                    out.println("<li><a href='#'>Menu three</a></li>");
                                    //out.println("<li><a href='consultarusuarios.jsp'> Listar Usuarios");
                                }else{
                                    //out.println("<li><a href='consultarusuarios.jsp'> Listar Usuarios");
                                    out.println("<li><a href='#'>Menu one</a></li>");
                                    out.println("<li><a href='#'>Menu two</a></li>");
                                    out.println("<li><a href='#'>Menu three</a></li>");
                                }
                                out.println("<li><a href='login.jsp?cerrar=true'class='mb-4'>Salir <i class='glyphicon glyphicon-log-out' aria-hidden='true'></i></a></li>");
                            }
                        %>
                    </ul>
                </div>
            </div>
                
            <!--INSCRIPCIONES (ALUMNO)-->
            <%
                if(sesion.getAttribute("user")!=null && sesion.getAttribute("nivel")!=null){ //si la sesion esta iniciada
                    String tipo = (String)sesion.getAttribute("nivel");
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
                String tipo = (String)sesion.getAttribute("nivel");
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
                    <a href="altaEdicion.jsp" class="d-flex align-items-center">
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
                    String user = (String)sesion.getAttribute("user");
                    String nivel=(String)sesion.getAttribute("nivel");
                    if(user!=null && nivel!=null){ //si la sesion esta iniciada
                        
                        if(nivel.equals("1")){
                            //ControladorUsuario CU = new ControladorUsuario();
                            //usuario usu = CU.findusu(sesion.getAttribute("user").toString());
                            //docente doc = CU.findDocente(sesion.getAttribute("user").toString());
                             
                             
                            servidor.Docente docWS = OP.findDocenteWS(user);
                        
                            //List<instituto>listaInsProf = OP.institutos();
                            List<servidor.Instituto>listaInsProfWS = OP.insitututosWS("");
                            
                            if(listaInsProfWS!=null){
                                Iterator itInsProf = listaInsProfWS.iterator();
                                servidor.Instituto insProf = null;
                                while(itInsProf.hasNext()){
                                    insProf = (servidor.Instituto) itInsProf.next();
                                    if(insProf.getId()== docWS.getInstituto().getId()){
                                        out.println("<li><a href='consultaCursos.jsp?instituto="+ insProf.getFacultad() +
                                        "' class='d-flex align-items-center'><div class='podcaster'><span class='d-block'>"
                                        +insProf.getFacultad()+"</span></div></a></li>");                            
                                    }  
                                }
                            }else{
                                out.println("Lista institutos vacia");
                            }
                        }else if(nivel.equals("2")){
                            List<servidor.Instituto>listaInsAlum = OP.insitututosWS("");
                            if(listaInsAlum!= null){
                                Iterator itInsAlum = listaInsAlum.iterator();
                                servidor.Instituto insAlumn = null;
                                while(itInsAlum.hasNext()){
                                    insAlumn = (servidor.Instituto) itInsAlum.next();
                                    out.println("<li><a href='consultaCursos.jsp?instituto="+ insAlumn.getFacultad() +"' class='d-flex align-items-center'>");
                                    out.println("<div class='podcaster'><span class='d-block'>" + insAlumn.getFacultad() + "</span></div></a></li>");
                                }
                            }else{
                                out.println("Lista institutos vacia");
                            }
                        }
                        
                    }
                %>
                
            </ul>
        </div>

        <!--CATEGORIAS-->    
            <div class="featured-user  mb-5 mb-lg-0" style="border-bottom: 2px solid">
                <h3 class="mb-4">CATEGORÍAS</h3>
                <ul class="list-unstyled">

                    <%
                        if(listaCateWS!=null){
                         servidor.Categoria cat = null;
                        Iterator itCate = listaCateWS.iterator();
                        listaCateWS = OP.categoriaWS("");
                        itCate = listaCateWS.iterator();
                        cat = null;
                        while(itCate.hasNext()){
                            cat = (servidor.Categoria) itCate.next();
                            out.println("<li><a href='consultaCursos.jsp?categoria="+cat.getNombre() +"' class='d-flex align-items-center'>");
                            out.println("<div class='podcaster'><span class='d-block'>" + cat.getNombre() + "</span></div>");
                            out.println("</a></li>");
                        }
                        }
                    %>
                </ul>
            </div>
            <div class="featured-user  mb-5 mb-lg-0">
                <div>
                    <ul class="list-unstyled">
                        <%
                        //out.println("<li><a href='consultarusuarios.jsp'> Listar Usuarios");
                        out.println("<li><a href='consultarusuarios.jsp' class='d-flex align-items-center'>");
                        out.println("<div class='podcaster'><span class='d-block'>Listar Usuarios</span></div>");
                        out.println("</a></li>");
                        %>
                    </ul>
                </div>
            </div>

        <div class="featured-user  mb-5 mb-lg-0">
            <% out.println("<a href='login.jsp?cerrar=true'class='mb-4'>Salir <i class='glyphicon glyphicon-log-out' aria-hidden='true'></i></a>"); %>

        </div>
        </div>
    </div>