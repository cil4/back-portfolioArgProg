package com.example.portfolioapi.repositories;

import com.example.portfolioapi.models.SkillsModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepository extends CrudRepository<SkillsModel, Integer>{
    
}
