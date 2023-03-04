package com.example.portfolioapi.controllers;

import java.util.ArrayList;

import java.util.Optional;

import com.example.portfolioapi.DTO.Mensaje;
import com.example.portfolioapi.models.SkillsModel;
import com.example.portfolioapi.services.SkillsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "https://portfolio-frontend-mg.web.app")
@RestController
@RequestMapping("/api/skills")
public class SkillsController {

    @Autowired
    SkillsService skillservice;

   

    @GetMapping("/lista")
    public ArrayList<SkillsModel> obtenerSkills() {
        return skillservice.obtenerSkills();
    }

    @PostMapping("/crear")
    public SkillsModel guardarSkills(@RequestBody SkillsModel skills) {
        return this.skillservice.guardarSkills(skills);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<SkillsModel> editarSkills(@PathVariable(value = "id") Integer id,
            @Validated @RequestBody SkillsModel skills) {
        if (!skillservice.existsById(id))
            return new ResponseEntity(new Mensaje("Esa habilidad no existe"), HttpStatus.NOT_FOUND);

        SkillsModel skill = skillservice.obtenerSkillsPorId(id).get();
        skill.setArea(skills.getArea());
        skill.setPorcentaje(skills.getPorcentaje());
        skill.setHabilidadTipo(skills.getHabilidadTipo());
        skill.setPersona(skills.getPersona());
        skillservice.guardarSkills(skill);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);

    }

    @GetMapping(path = "/{id}")
    public Optional<SkillsModel> obtenerSkillsById(@PathVariable("id") Integer id) {
        return this.skillservice.obtenerSkillsPorId(id);
    }

    @DeleteMapping(path = "/borrar/{id}")
    public String borrarSkills(@PathVariable("id") Integer id) {
        boolean ok = this.skillservice.borrarSkills(id);
        if (ok) {
            return "Se eliminó skills de id" + id + " correctamente.";
        } else {
            return "El registro no existe o no pudo ser eliminado.";
        }
    }
}
