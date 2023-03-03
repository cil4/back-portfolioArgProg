package com.example.portfolioapi.controllers;

import java.util.ArrayList;

import java.util.Optional;

import com.example.portfolioapi.DTO.Mensaje;
import com.example.portfolioapi.models.ProyectosModel;
import com.example.portfolioapi.services.ProyectosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

@CrossOrigin(origins = "https://portfolio-mcg.web.app")
@RestController
@RequestMapping("/api/proyectos")
public class ProyectosController {
    @Autowired
    ProyectosService proyectoservice;

    

    @GetMapping("/lista")
    public ArrayList<ProyectosModel> obtenerProyecto() {
        return proyectoservice.obtenerProyecto();
    }

    @PostMapping("/crear")
    public ProyectosModel guardarProyecto(@RequestBody ProyectosModel proyecto) {
        return this.proyectoservice.guardarProyecto(proyecto);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<ProyectosModel> editarProyecto(@PathVariable(value = "id") Integer id,
            @Validated @RequestBody ProyectosModel proyectos) {
        if (!proyectoservice.existsById(id))
            return new ResponseEntity(new Mensaje("Ese proyecto no existe"), HttpStatus.NOT_FOUND);

        ProyectosModel proyecto = proyectoservice.obtenerProyectoPorId(id).get();
        proyecto.setNombreproyecto(proyectos.getNombreproyecto());
        proyecto.setDescripcion(proyectos.getDescripcion());
        proyecto.setEnlace(proyectos.getEnlace());
        proyecto.setFechainicio(proyectos.getFechainicio());
        proyecto.setFechafin(proyectos.getFechafin());
        proyecto.setPersona(proyectos.getPersona());
        proyectoservice.guardarProyecto(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);

    }

    @GetMapping(path = "/{id}")
    public Optional<ProyectosModel> obtenerProyectoById(@PathVariable("id") Integer id) {
        return this.proyectoservice.obtenerProyectoPorId(id);
    }

    @DeleteMapping(path = "/borrar/{id}")
    public String borrarProyecto(@PathVariable("id") Integer id) {
        boolean ok = this.proyectoservice.borrarProyecto(id);
        if (ok) {
            return "Se eliminó el proyecto de id " + id + "correctamente.";
        } else {
            return "El registro no existe o no pudo ser eliminado.";
        }
    }

}
