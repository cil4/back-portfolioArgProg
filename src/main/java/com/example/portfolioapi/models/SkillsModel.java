package com.example.portfolioapi.models;



import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name= "skills")
public class SkillsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idskills;
  
    @Basic
    
    private int porcentaje;

    private String area;

    
    @Enumerated(EnumType.STRING)
private habilidadTipo habilidadtipo;

    public habilidadTipo getHabilidadTipo() {
        return this.habilidadtipo;
    }

    public void setHabilidadTipo(habilidadTipo habilidadTipo) {
        this.habilidadtipo = habilidadTipo;
    }
    
    private int persona;
 
    


    public int getIdskills() {
        return this.idskills;
    }

    public void setIdskills(int idskills) {
        this.idskills = idskills;
    }

    
   
   


  

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getPorcentaje() {
        return this.porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    

    public int getPersona() {
        return this.persona;
    }

    public void setPersona(int persona) {
        this.persona = persona;
    }
   
  

    

    

}

