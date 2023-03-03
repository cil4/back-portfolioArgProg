package com.example.portfolioapi.repositories;

import com.example.portfolioapi.models.ProyectosModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProyectosRepository extends CrudRepository<ProyectosModel, Integer>{
    
}
