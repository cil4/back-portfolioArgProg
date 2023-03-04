package com.example.portfolioapi.controllers;

import java.util.ArrayList;

import java.util.Optional;

import com.example.portfolioapi.DTO.Mensaje;
import com.example.portfolioapi.models.RedesModel;
import com.example.portfolioapi.services.RedesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://portfolio-frontend-mg.web.app")
@RestController
@RequestMapping("/api/redes")
public class RedesController {
    @Autowired
    RedesService redservice;

    @GetMapping("/lista")
    public ArrayList<RedesModel> obtenerRedes() {
        return redservice.obtenerRedes();
    }

    @PostMapping("/crear")
    public RedesModel guardarRedes(@RequestBody RedesModel redes) {
        return this.redservice.guardarRedes(redes);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<RedesModel> editarRedes(@PathVariable(value = "id") Integer id,
            @Validated @RequestBody RedesModel redes) {
        if (!redservice.existsById(id))
            return new ResponseEntity(new Mensaje("Esa red no existe"), HttpStatus.NOT_FOUND);

        RedesModel red = redservice.obtenerRedesPorId(id).get();
        red.setGithub(redes.getGithub());
        red.setInstagram(redes.getInstagram());
        red.setLinkedin(redes.getLinkedin());
        red.setPersona(redes.getPersona());
        redservice.guardarRedes(red);
        return new ResponseEntity(new Mensaje("Red actualizada"), HttpStatus.OK);

    }

    @GetMapping(path = "/{id}")
    public Optional<RedesModel> obtenerRedesById(@PathVariable("id") Integer id) {
        return this.redservice.obtenerRedesPorId(id);
    }

    @DeleteMapping(path = "/borrar/{id}")
    public String borrarRedes(@PathVariable("id") Integer id) {
        boolean ok = this.redservice.borrarRedes(id);
        if (ok) {
            return "Se eliminó redes de id" + id + " correctamente.";
        } else {
            return "El registro no existe o no pudo ser eliminado.";
        }
    }
}
