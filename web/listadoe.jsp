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
        <p><a href="Inicio?action=add">Ingresar nuevo estudiante</a></p>

        <table border="1">
            <tr>
                <th colspan="7">ESTUDIANTES REGISTRADOS<br><p><a href="Inicioi">Ver lista de estudiantes inscritos en materias</a></p></th>
                
            </tr>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Correo</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${estudiantes}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.nombre}</td>
                    <td>${item.apellidos}</td>
                    <td>${item.correo}</td>
                    <td><a href="Inicio?action=edit&id=${item.id}">Editar</a></td>
                    <td><a href="Inicio?action=delete&id=${item.id}">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>
            
    </body>
</html>
