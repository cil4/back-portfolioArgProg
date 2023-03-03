package com.example.portfolioapi.models;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "proyectos")
public class ProyectosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idproyectos;
    
    @Basic
    private String nombreproyecto;
    private String descripcion;
    private String enlace;
    private Date fechainicio;
    private Date fechafin;
    private int persona;


    public int getIdproyectos() {
        return this.idproyectos;
    }

    public void setIdproyectos(int idproyectos) {
        this.idproyectos = idproyectos;
    }

    public String getNombreproyecto() {
        return this.nombreproyecto;
    }

    public void setNombreproyecto(String nombreproyecto) {
        this.nombreproyecto = nombreproyecto;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEnlace() {
        return this.enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public Date getFechainicio() {
        return this.fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return this.fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public int getPersona() {
        return this.persona;
    }

    public void setPersona(int persona) {
        this.persona = persona;
    }

   
}
