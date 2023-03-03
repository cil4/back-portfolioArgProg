package com.example.portfolioapi.models;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="educacion")
public class EducacionModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int ideducacion;

    @Basic
    private String titulo;
    private String institucion;
    private String carrera;
    private String logo;
    private Date fechainicio;
    private Date fechafin;
    private int persona;

    public int getIdeducacion() {
        return this.ideducacion;
    }

    public void setIdeducacion(int ideducacion) {
        this.ideducacion = ideducacion;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInstitucion() {
        return this.institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getCarrera() {
        return this.carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getLogo() {
        return this.logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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
