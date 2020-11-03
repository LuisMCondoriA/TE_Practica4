/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.dao;

import com.emergentes.modelo.Curso;
import com.emergentes.utilies.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wwwsd
 */
//public class EstudiantesDAOimpl extends ConexionBD implements EstudiantesDAO{
public class CursoDAOimpl extends ConexionBD implements CursoDAO {
    @Override
    public void insert(Curso curso) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO curso (descripcion) values(?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, curso.getDescripcion());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Curso curso) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE curso set descripcion=? where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, curso.getDescripcion());
            ps.setInt(2, curso.getId());
            
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
            String sql = "DELETE from curso where id=?";
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
    public Curso getById(int id) throws Exception {
        Curso est = new Curso();
        try {
            this.conectar();
            
            String sql = "select * from curso where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                est.setId(rs.getInt("id"));
                est.setDescripcion(rs.getString("descripcion"));
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return est;
    }

    @Override
    public List<Curso> getAll() throws Exception {
        List<Curso> lista = null;
        try {
            this.conectar();
            String sql = "select * from curso";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Curso>();
            while(rs.next()){
                Curso est = new Curso();
                est.setId(rs.getInt("id"));
                est.setDescripcion(rs.getString("descripcion"));
                
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
