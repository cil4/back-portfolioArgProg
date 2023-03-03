package com.example.portfolioapi.repositories;

import com.example.portfolioapi.models.ExperienciaModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExperienciaRepository  extends CrudRepository<ExperienciaModel, Integer>{
    
}
