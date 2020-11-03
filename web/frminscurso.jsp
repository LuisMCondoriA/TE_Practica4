<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : frminscurso
    Created on : 03-11-2020, 12:57:04 AM
    Author     : wwwsd
      <input type ="hidden" name="id_estudiante" value="0"/>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Inicioi" method="POST">

            
        <input type ="hidden" name="id_p" value="0"/>    
        <p>Seleccionar estudiante</p>
        <select name="id_estudiante">
            <c:forEach var="item" items="${estudiantes}">
                <option value="${item.id}">${item.nombre}</option>
            </c:forEach>
        </select>
        <br>
        <p>Seleccionar curso</p>
        <select name="id_curso">
            <c:forEach var="item" items="${curso}">
                <option value="${item.id}">${item.descripcion}</option>
            </c:forEach>
        </select>
        <br>
        <p>Ingresar Nota</p>
        <input type ="number" name="nota_final" />
        <br>
        <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
