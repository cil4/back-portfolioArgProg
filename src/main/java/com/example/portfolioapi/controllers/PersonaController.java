package com.example.portfolioapi.controllers;

import java.util.ArrayList;

import java.util.Optional;

import com.example.portfolioapi.DTO.Mensaje;
import com.example.portfolioapi.models.PersonaModel;
import com.example.portfolioapi.services.PersonaService;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://portfolio-mcg.web.app")
@RestController
@RequestMapping("/api/personas")
public class PersonaController {
    @Autowired
    PersonaService personaservice;

   
    @GetMapping("/lista")
    public ArrayList<PersonaModel> obtenerPersonas() {
        return personaservice.obtenerPersonas();
    }

    @PostMapping("/crear")
    public PersonaModel guardarPersona(@RequestBody PersonaModel persona) {
        return this.personaservice.guardarPersona(persona);
    }

    /*
     * @PutMapping("/editar/{id}")
     * public PersonaModel editarPersona(@PathVariable("id")Integer id, @RequestBody
     * PersonaModel persona){
     * return this.personaservice.editarPersona(persona);}
     */

    @PutMapping("/editar/{id}")
    public ResponseEntity<PersonaModel> editarPersona(@PathVariable(value = "id") Integer id,
            @Validated @RequestBody PersonaModel persona) {
        if (!personaservice.existsById(id))
            return new ResponseEntity(new Mensaje("Esa persona no existe"), HttpStatus.NOT_FOUND);

        PersonaModel pers = personaservice.obtenerPersonaById(id).get();
        pers.setNombres(persona.getNombres());
        pers.setApellido(persona.getApellido());
        pers.setOcupacion(persona.getOcupacion());
        pers.setEmail(persona.getEmail());
        pers.setUbicacion(persona.getUbicacion());
        pers.setFotofondo(persona.getFotofondo());
        pers.setFotoperfil(persona.getFotoperfil());
        pers.setAcerca(persona.getAcerca());
        pers.setUsername(persona.getUsername());
        pers.setPassword(persona.getPassword());

        personaservice.guardarPersona(pers);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public Optional<PersonaModel> obtenerPersonaById(@PathVariable("id") Integer id) {
        return this.personaservice.obtenerPersonaById(id);
    }

    @GetMapping("/query")
    public ArrayList<PersonaModel> obtenerPersonaByApellido(@RequestParam("apellido") String apellido) {
        return this.personaservice.obtenerPersonaByApellido(apellido);
    }

    /*
     * @DeleteMapping(path= "/borrar/{id}")
     * public ResponseEntity<?> delete(@PathVariable("id")Integer id){
     * if(!personaservice.existsById(id))
     * return new ResponseEntity(new Mensaje("El usuario referido no existe"),
     * HttpStatus.NOT_FOUND);
     * personaservice.borrarPersona(id);
     * return new ResponseEntity(new Mensaje("Usuario eliminado"), HttpStatus.OK);
     * }
     */

    @DeleteMapping( path = "/borrar/{id}")
    public String deleteById(@PathVariable("id") Integer id){
    boolean ok = this.personaservice.delete(id);
    if (ok){
    return "Se eliminó la persona con id " + id;
    }else{
    return "No pudo eliminar a la persona con id" + id;
    }
    }
}
