
package com.emergentes.dao;

import com.emergentes.modelo.Estudiantes;
import java.util.List;


public interface EstudiantesDAO {
    public void insert(Estudiantes estudiantes) throws Exception;
    public void update(Estudiantes estidiantes) throws Exception;
    public void delete(int id) throws Exception;
    public Estudiantes getById(int id) throws Exception;
    public List<Estudiantes> getAll() throws Exception;
}
