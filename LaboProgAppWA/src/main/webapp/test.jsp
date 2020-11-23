<%-- 
    Document   : test
    Created on : 23 nov. 2020, 19:24:34
    Author     : nacho
--%>

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
            out.println("resultado: "+op.BuscarEdicion(nombre).getNombre());
        %>
    </body>
</html>
