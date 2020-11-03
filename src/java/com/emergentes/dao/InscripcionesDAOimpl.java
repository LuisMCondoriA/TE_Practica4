
package com.emergentes.dao;


import com.emergentes.modelo.Estudiantes;
import com.emergentes.modelo.Inscripciones;
import com.emergentes.utilies.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InscripcionesDAOimpl extends ConexionBD implements InscripcionesDAO {
     @Override
    public void insert(Inscripciones inscripciones) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO inscripciones (id_curso,id_estudiante,nota_final) values(?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, inscripciones.getId_curso());
            ps.setInt(2, inscripciones.getId_estudiante());
            ps.setInt(3, inscripciones.getNota_final());
            
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Inscripciones inscripciones) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE inscripciones set nota_final=? where id_estudiante=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, inscripciones.getNota_final());
            ps.setInt(2, inscripciones.getId_estudiante());
           
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }

    @Override
    public void delete(int id_estudiante) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE from inscripciones where id_estudiante=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id_estudiante);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }
    

    @Override
    public Inscripciones getById(int id_estudiante) throws Exception {
        Inscripciones est = new Inscripciones();
        try {
            this.conectar();
            
            String sql = "select * from inscripciones where id_estudiante=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id_estudiante);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                est.setId_estudiante(rs.getInt("id_estudiante"));
                est.setId_curso(rs.getInt("id_curso"));
                est.setNota_final(rs.getInt("nota_final"));
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return est;
    }

    @Override
    public List<Inscripciones> getAll() throws Exception {
        List<Inscripciones> lista = null;
        try {
            this.conectar();
            String sql = "select * from inscripciones i, estudiantes e,curso c where i.id_estudiante=e.id and i.id_curso=c.id";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Inscripciones>();
            while(rs.next()){
                Inscripciones est = new Inscripciones();
                est.setId_estudiante(rs.getInt("id_estudiante"));
                est.setNombre(rs.getString("nombre"));
                est.setApellidos(rs.getString("apellidos"));
                est.setCorreo(rs.getString("correo"));
                est.setDescripcion(rs.getString("descripcion"));
                est.setNota_final(rs.getInt("nota_final"));
                
                lista.add(est);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
   
}
