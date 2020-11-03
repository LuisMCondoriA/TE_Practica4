
package com.emergentes.modelo;


public class Inscripciones {
    private String nombre;
    private String apellidos;
    private String correo;
    private String descripcion;
    private int id_curso;
    private int id_estudiante;
    private int nota_final;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public int getNota_final() {
        return nota_final;
    }

    public void setNota_final(int nota_final) {
        this.nota_final = nota_final;
    }

    @Override
    public String toString() {
        return "Inscripciones{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo + ", descripcion=" + descripcion + ", id_curso=" + id_curso + ", id_estudiante=" + id_estudiante + ", nota_final=" + nota_final + '}';
    }


    
}
