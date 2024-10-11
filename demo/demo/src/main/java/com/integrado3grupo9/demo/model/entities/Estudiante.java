package com.integrado3grupo9.demo.model.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Estudiante implements Serializable {
    @Id
    @Column(name = "dni_estudiante")
    private Long dniEstudiante;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private int edad;

    @Column(name = "nro_libreta")
    private Long nroLibreta;

    @Column
    private String genero;

    @Column
    private String ciudad;

    @OneToMany(mappedBy = "estudiante", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cursa> cursadas;

    public Estudiante() {
        super();
    }

    public Estudiante(Long dniEstudiante, String nombre,
                      String apellido, int edad, Long nroLibreta,
                      String genero, String ciudad) {
        super();
        this.dniEstudiante = dniEstudiante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nroLibreta = nroLibreta;
        this.genero = genero;
        this.ciudad = ciudad;
        this.cursadas = new ArrayList<Cursa>();
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

    public List<Cursa> getCursadas() {
        return cursadas;
    }

    public void addCursada(Cursa cursada) {
        this.cursadas.add(cursada);
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
        return "Estudiante{" +
                "dni_estudiante=" + dniEstudiante +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", nro_libreta=" + nroLibreta +
                ", genero='" + genero + '\'' +
                ", ciudad='" + ciudad + '\'' +
                /*", cursadas=" + cursadas +*/
                '}';
    }
}
