package com.modelo;

import java.io.InputStream;


public class Medico {
    
    private int id;
    private String nombre, apellido, especialidad, dAtencion, horario;
    private InputStream imagen;

    public Medico(String nombre, String apellido, String especialidad, String dAtencion, String horario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.dAtencion = dAtencion;
        this.horario = horario;
    }

    public Medico(int id, String nombre, String apellido, String especialidad, String dAtencion, String horario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.dAtencion = dAtencion;
        this.horario = horario;
    }

    public Medico() {
        nombre = "";
        apellido = "";
        especialidad = "";
        dAtencion = "";
        horario = "";
        imagen = null;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getdAtencion() {
        return dAtencion;
    }

    public void setdAtencion(String dAtencion) {
        this.dAtencion = dAtencion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public InputStream getImagen() {
        return imagen;
    }

    public void setImagen(InputStream imagen) {
        this.imagen = imagen;
    }
    
    
    
}
