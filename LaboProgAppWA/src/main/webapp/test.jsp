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
            out.println("resultado: "+ op.BuscarEdicion(nombre).getNombre());
            out.println("resultados usuario: " +op.BuscarCursosWS("innova").get(0).getNombre());
        %>
    </body>
</html>
