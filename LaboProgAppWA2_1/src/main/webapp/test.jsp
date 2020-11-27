<%@page import="com.mycompany.laboprogappwa2_1.Operaciones"%>
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
            String name = "Eleli";
            Operaciones op = new Operaciones();
             //op.BuscarEdicion(nombre);
            out.println("resultado edicion: "+op.BuscarEdicion(nombre).getNombre());
            out.println("resultado: " + op.findusuWS(name).getCorreo());
        %>
    </body>
</html>
