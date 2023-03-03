package com.example.portfolioapi.models;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "experiencia")
public class ExperienciaModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idexperiencia;
@Basic

    private String puesto;
    private String descripciontareas;
    private String empresanombre;
    private String logo;
    private Date fechainicio;
    private Date fechafin;
    private int persona;

   
    public int getIdexperiencia() {
        return this.idexperiencia;
    }

    public void setIdexperiencia(int idexperiencia) {
        this.idexperiencia = idexperiencia;
    }
    public String getPuesto() {
        return this.puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDescripciontareas() {
        return this.descripciontareas;
    }

    public void setDescripciontareas(String descripciontareas) {
        this.descripciontareas = descripciontareas;
    }

    public String getEmpresanombre() {
        return this.empresanombre;
    }

    public void setEmpresanombre(String empresanombre) {
        this.empresanombre = empresanombre;
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
