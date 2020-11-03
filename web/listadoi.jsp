<%-- 
    Document   : listadoi
    Created on : 02-11-2020, 11:04:18 PM
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
        <p><a href="Inicioc">Ver cursos disponibles</a></p>
        
        <table border="1">
            <tr>
                <th colspan="8">ESTUDIANTES INSCRITOS<br><p><a href="Inicio">Ver lista de estudiantes registrados</a></p><p><a href="Inicioi?action=add">Inscribir estudiante a Curso</a></p></th>
                
            </tr>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Correo</th>
                <th>Materia</th>
                <th>Nota final</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${inscripciones}">
                <tr>
                    <td>${item.id_estudiante}</td>
                    <td>${item.nombre}</td>
                    <td>${item.apellidos}</td>
                    <td>${item.correo}</td>
                    <td>${item.descripcion}</td>
                    <td>${item.nota_final}</td>
                    <td><a href="Inicioi?action=edit&id=${item.id_estudiante}">Editar Nota</a></td>
                    <td><a href="Inicioi?action=delete&id_estudiante=${item.id_estudiante}">Eliminar inscripcion</a></td>
                </tr>
            </c:forEach>
        </table>
       
    </body>
</html>
