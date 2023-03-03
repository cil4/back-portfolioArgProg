package com.example.portfolioapi.models;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name= "persona")
public class PersonaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpersona;

   
@Basic
    private String nombres;
    private String apellido;
    private String email;
    private String ocupacion;
    private String ubicacion;
    private String acerca;
    private String fotoperfil;
    private String fotofondo;
    private String username;
    private String password;

    @Transient
    private String token;

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getIdpersona() {
        return this.idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }
    
    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOcupacion() {
        return this.ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getAcerca() {
        return this.acerca;
    }

    public void setAcerca(String acerca) {
        this.acerca = acerca;
    }

    public String getFotoperfil() {
        return this.fotoperfil;
    }

    public void setFotoperfil(String fotoperfil) {
        this.fotoperfil = fotoperfil;
    }

    public String getFotofondo() {
        return this.fotofondo;
    }

    public void setFotofondo(String fotofondo) {
        this.fotofondo = fotofondo;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    

}
