package com.example.portfolioapi.repositories;

import com.example.portfolioapi.models.RedesModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RedesRepository  extends CrudRepository<RedesModel, Integer>{
    
}
