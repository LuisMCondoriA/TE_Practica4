
package com.emergentes.controlador;

import com.emergentes.dao.CursoDAO;
import com.emergentes.dao.CursoDAOimpl;
import com.emergentes.dao.EstudiantesDAO;
import com.emergentes.dao.EstudiantesDAOimpl;
import com.emergentes.dao.InscripcionesDAO;
import com.emergentes.dao.InscripcionesDAOimpl;
import com.emergentes.modelo.Curso;
import com.emergentes.modelo.Estudiantes;
import com.emergentes.modelo.Inscripciones;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inicioi", urlPatterns = {"/Inicioi"})
public class Inicioi extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                 try {
            InscripcionesDAO dao = new InscripcionesDAOimpl();
            EstudiantesDAO daoe = new EstudiantesDAOimpl(); //esto es nuevo para ver si borrar
            CursoDAO daoc = new CursoDAOimpl(); //esto es nuevo para ver si borrar
            //para recibir el id
            int id;
            int id2;
            //para gestionar los registros
            Inscripciones est = new Inscripciones();
            String action = (request.getParameter("action") != null) ? request.getParameter("action"):"view";
            switch(action){
                case "add":
                    List<Estudiantes> listae = daoe.getAll();
                    List<Curso> listac = daoc.getAll();
                    request.setAttribute("estudiantes", listae);
                    request.setAttribute("curso", listac);
                    request.getRequestDispatcher("frminscurso.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    est = dao.getById(id);
                    request.setAttribute("inscripciones", est);
                    request.getRequestDispatcher("frminscripciones.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id_estudiante"));
                    dao.delete(id);
                    response.sendRedirect("Inicioi");
                    break;
                default:
                    List<Inscripciones> lista = dao.getAll();
                    request.setAttribute("inscripciones", lista);
                    request.getRequestDispatcher("listadoi.jsp").forward(request, response);
                    break;
            }
        } catch (Exception e) {
            System.out.println("error"+e.getMessage());
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        InscripcionesDAO dao = new InscripcionesDAOimpl();
        int id_p = Integer.parseInt(request.getParameter("id_p"));
        int id_curso = Integer.parseInt(request.getParameter("id_curso"));
        int id_estudiante = Integer.parseInt(request.getParameter("id_estudiante"));
        int nota_final = Integer.parseInt(request.getParameter("nota_final"));
   
        Inscripciones est = new Inscripciones();
        est.setId_curso(id_curso);
        est.setId_estudiante(id_estudiante);
        est.setNota_final(nota_final);

         
        if(id_estudiante == 0 || id_p == 0){
            try {
                dao.insert(est);
                response.sendRedirect("Inicioi");
            } catch (Exception e) {
                System.out.println("Error "+e.getMessage());
            }
  
        } else {
            try {
                dao.update(est);
                response.sendRedirect("Inicioi");
            } catch (Exception e) {
                System.out.println("Error"+e.getMessage());
            }
  
        }
    }



}
