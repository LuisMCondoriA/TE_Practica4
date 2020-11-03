
package com.emergentes.controlador;

import com.emergentes.dao.CursoDAO;
import com.emergentes.dao.CursoDAOimpl;
import com.emergentes.modelo.Curso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inicioc", urlPatterns = {"/Inicioc"})
public class Inicioc extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
            CursoDAO dao = new CursoDAOimpl();
            //para recibir el id
            int id;
            //para gestionar los registros
            Curso est = new Curso();
            String action = (request.getParameter("action") != null) ? request.getParameter("action"):"view";
            switch(action){
                case "add":
                    request.setAttribute("curso", est);
                    request.getRequestDispatcher("frmcurso.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    est = dao.getById(id);
                    request.setAttribute("curso", est);
                    request.getRequestDispatcher("frmcurso.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("Inicioc");
                    break;
                default:
                    List<Curso> lista = dao.getAll();
                    request.setAttribute("curso", lista);
                    request.getRequestDispatcher("listadoc.jsp").forward(request, response);
                    break;
            }
        } catch (Exception e) {
            System.out.println("error"+e.getMessage());
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         CursoDAO dao = new CursoDAOimpl();
        int id = Integer.parseInt(request.getParameter("id"));
        String descripcion = request.getParameter("descripcion");
   
        Curso est = new Curso();
        est.setId(id);
        est.setDescripcion(descripcion);
     
        if(id == 0){
            try {
                dao.insert(est);
                response.sendRedirect("Inicioc");
            } catch (Exception e) {
                System.out.println("Error "+e.getMessage());
            }
  
        } else {
            try {
                dao.update(est);
                response.sendRedirect("Inicioc");
            } catch (Exception e) {
                System.out.println("Error "+e.getMessage());
            }
  
        }
    }


}
