<%@page import="java.util.Iterator"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.laboprogappwa.Operaciones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            String nombre = request.getParameter("edcur");
            Operaciones op = new Operaciones();
            //op.BuscarEdicion(nombre);
            out.println(op.buscarusuarioWS("Eleli").get(0).getNombre());
            /*out.println("resultado edicion: "+ op.BuscarEdicionWS(nombre).getNombre() + "<br>");
            out.println("resultados cursos " + op.BuscarCursosWS("").get(0).getNombre() + "<br>");
            out.println("resultados categoria: " + op.categoriaWS("").get(0).getNombre() + "<br>");
            out.println("resultados ediciones: " + op.buscarEdicionesWS("chispa").get(0).getNombre()+ "<br>");
            out.println("resultados ediciones por curso: " + op.buscarEdicionesXCursoWS("programacion").get(0).getNombre()+ "<br>");
            out.println("tipo Usuario: " + op.tipousuarioWS("ElProfe") + "<br>");
            out.println("resultado curso por docente " + op.findCursoXDocenteWS("ElProfe").get(0).getNombre() + "<br>");
            
            List<servidor.EdicionCurso>datos = op.buscarEdicionesWS("Programacion de aplicaciones 2020");
            servidor.EdicionCurso ed = datos.get(0);
            out.println(ed.getNombre());
            
            LocalDate fechaNac = LocalDate.of(ed.getPinicio().getYear(),ed.getPinicio().getMonth(), ed.getPinicio().getDay());
            DateTimeFormatter esDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            out.println("resultado fecha edicion: "+fechaNac.format(esDateFormat));
            
            
            List<servidor.Inscripcion> inscrip = op.listarInscripcionesWS("","");
            servidor.Inscripcion insWS = null;
            out.println(inscrip.size()+"<br>");
            Iterator iter2 = inscrip.iterator();
            
            out.println(op.listarInscripcionesWS("Eleli", "").size());
            servidor.Inscripcion insWS;
            Iterator iter2 = op.listarInscripcionesWS("Eleli", "").iterator();
            
            while(iter2.hasNext()){
                //insWS = (servidor.Inscripcion)iter2.next();
                insWS = (servidor.Inscripcion)iter2.next();
                out.println(insWS.getEdicionCurso().getNombre()+"<br>");
            }*/
            op.eliminarInscripcionWS("Eleli", "chispa");
            //op.editIsncripcionWS(op.listarInscripcionesWS("", "").get(0), "aceptada", "7");

        %>
    </body>
</html>
