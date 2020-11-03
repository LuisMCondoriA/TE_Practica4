<%-- 
    Document   : listadoc
    Created on : 02-11-2020, 10:04:23 PM
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
        <h1>Gestion de calificacion de estudiantes</h1>
        <h2>Lista de cursos disponibles</h2>
        <p><a href="Inicioc?action=add">Ingresar nuevo curso</a></p>
        <p><a href="Inicio">Volver</a></p>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Descripcion</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${curso}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.descripcion}</td>
                    <td><a href="Inicioc?action=edit&id=${item.id}">Editar</a></td>
                    <td><a href="Inicioc?action=delete&id=${item.id}">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
