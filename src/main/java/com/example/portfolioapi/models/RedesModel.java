package com.example.portfolioapi.models;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "redes")
public class RedesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idredes;

    

    @Basic
    private String github;
    private String linkedin;
    private String instagram;
    private int persona;

  
    public int getIdredes() {
        return this.idredes;
    }

    public void setIdredes(int idredes) {
        this.idredes = idredes;
    }
   

    public String getGithub() {
        return this.github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getLinkedin() {
        return this.linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getInstagram() {
        return this.instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }
   
  

  

    public int getPersona() {
        return this.persona;
    }

    public void setPersona(int persona) {
        this.persona = persona;
    }



   

}
