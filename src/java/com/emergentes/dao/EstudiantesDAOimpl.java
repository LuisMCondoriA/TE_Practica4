
package com.emergentes.dao;

import com.emergentes.modelo.Estudiantes;
import com.emergentes.utilies.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EstudiantesDAOimpl extends ConexionBD implements EstudiantesDAO{

    @Override
    public void insert(Estudiantes estudiantes) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO estudiantes (nombre,apellidos,correo) values(?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, estudiantes.getNombre());
            ps.setString(2, estudiantes.getApellidos());
            ps.setString(3, estudiantes.getCorreo());
            
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Estudiantes estudiantes) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE estudiantes set nombre=?, apellidos=?, correo=? where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, estudiantes.getNombre());
            ps.setString(2, estudiantes.getApellidos());
            ps.setString(3, estudiantes.getCorreo());
            ps.setInt(4, estudiantes.getId());
            
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE from estudiantes where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }
    

    @Override
    public Estudiantes getById(int id) throws Exception {
        Estudiantes est = new Estudiantes();
        try {
            this.conectar();
            
            String sql = "select * from estudiantes where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                est.setId(rs.getInt("id"));
                est.setNombre(rs.getString("nombre"));
                est.setApellidos(rs.getString("apellidos"));
                est.setCorreo(rs.getString("correo"));
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return est;
    }

    @Override
    public List<Estudiantes> getAll() throws Exception {
        List<Estudiantes> lista = null;
        try {
            this.conectar();
            String sql = "select * from estudiantes";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Estudiantes>();
            while(rs.next()){
                Estudiantes est = new Estudiantes();
                est.setId(rs.getInt("id"));
                est.setNombre(rs.getString("nombre"));
                est.setApellidos(rs.getString("apellidos"));
                est.setCorreo(rs.getString("correo"));
                
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
