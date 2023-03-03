package com.example.portfolioapi.repositories;

import java.util.ArrayList;

import com.example.portfolioapi.models.PersonaModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonaRepository extends CrudRepository<PersonaModel, Integer>{
    public abstract ArrayList<PersonaModel> findByApellido(String apellido);
    public abstract PersonaModel findByUsername(String username);
}
