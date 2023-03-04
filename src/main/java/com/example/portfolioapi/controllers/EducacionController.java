package com.example.portfolioapi.controllers;

import java.util.ArrayList;

import java.util.Optional;

import com.example.portfolioapi.DTO.Mensaje;
import com.example.portfolioapi.models.EducacionModel;
import com.example.portfolioapi.services.EducacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "https://portfolio-frontend-mg.web.app")
@RestController
@RequestMapping("/api/educacion")
public class EducacionController {
    @Autowired
    EducacionService educaservice;

    

    @GetMapping("/lista")
    public ArrayList<EducacionModel> obtenerEducacion() {
        return educaservice.obtenerEducacion();
    }

    @PostMapping("/crear")
    public EducacionModel guardarEducacion(@RequestBody EducacionModel educacion) {
        return this.educaservice.guardarEducacion(educacion);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<EducacionModel> editarEducacion(@PathVariable(value = "id") Integer id,
            @Validated @RequestBody EducacionModel educacion) {
        if (!educaservice.existsById(id))
            return new ResponseEntity(new Mensaje("Ese registro de educación no existe"), HttpStatus.NOT_FOUND);

        EducacionModel edu = educaservice.obtenerEducacionPorId(id).get();
        edu.setTitulo(educacion.getTitulo());
        edu.setInstitucion(educacion.getInstitucion());
        edu.setCarrera(educacion.getCarrera());
        edu.setLogo(educacion.getLogo());
        edu.setFechainicio(educacion.getFechainicio());
        edu.setFechafin(educacion.getFechafin());
        edu.setPersona(educacion.getPersona());
        educaservice.guardarEducacion(edu);
        return new ResponseEntity(new Mensaje("Registro de educación actualizado"), HttpStatus.OK);

    }

    @GetMapping(path = "/{id}")
    public Optional<EducacionModel> obtenerEducacionById(@PathVariable("id") Integer id) {
        return this.educaservice.obtenerEducacionPorId(id);
    }

    @DeleteMapping(path = "/borrar/{id}")
    public String borrarEducacion(@PathVariable("id") Integer id) {
        boolean ok = this.educaservice.borrarEducacion(id);
        if (ok) {
            return "Se eliminó educación de id" + id + " correctamente.";
        } else {
            return "El registro no existe o no pudo ser eliminado.";
        }

    }
}
