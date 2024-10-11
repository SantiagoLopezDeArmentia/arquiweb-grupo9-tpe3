package com.integrado3grupo9.demo.model.dto;

import java.util.LinkedList;
import java.util.List;

public class EstudianteDTO {
    private Long dniEstudiante;
    private String nombre;
    private String apellido;
    private int edad;
    private Long nroLibreta;
    private String genero;
    private String ciudad;

    public EstudianteDTO(Long dniEstudiante, String nombre, String apellido, int edad, Long nroLibreta, String genero, String ciudad) {
        this.dniEstudiante = dniEstudiante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nroLibreta = nroLibreta;
        this.genero = genero;
        this.ciudad = ciudad;
    }

    public Long getDniEstudiante() {
        return dniEstudiante;
    }

    public void setDniEstudiante(Long dniEstudiante) {
        this.dniEstudiante = dniEstudiante;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Long getNroLibreta() {
        return nroLibreta;
    }

    public void setNroLibreta(Long nroLibreta) {
        this.nroLibreta = nroLibreta;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "dniEstudiante=" + dniEstudiante +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", nroLibreta=" + nroLibreta +
                ", genero='" + genero + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
