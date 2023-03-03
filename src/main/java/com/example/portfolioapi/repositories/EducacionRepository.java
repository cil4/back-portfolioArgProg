package com.example.portfolioapi.repositories;

import com.example.portfolioapi.models.EducacionModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EducacionRepository  extends CrudRepository<EducacionModel, Integer>{
    
}
