<%-- 
    Document   : frminscripciones
    Created on : 02-11-2020, 11:00:12 PM
    Author     : wwwsd
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <c:if test="${estudiante.id==0} ">Nuevo</c:if>
            <c:if test="${estudiante.id!=0} ">Editar</c:if>
            registro
        </h1>
            <form action="Inicioi" method="POST">
                <input type ="hidden" name="id_estudiante" value="${inscripciones.id_estudiante}"/>
                <input type ="hidden" name="id_p" value="1"/>
                <input type ="hidden" name="id_curso" value="${inscripciones.id_curso}"/>
                <label>Nombre:</label>
                <input type="number" name="nota_final" value="${inscripciones.nota_final}"/>
                <br>
                <input type="submit" value="Enviar"/>
            </form>
    </body>
</html>
