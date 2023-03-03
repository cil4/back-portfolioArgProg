package com.example.portfolioapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.portfolioapi.models.ExperienciaModel;
import com.example.portfolioapi.repositories.ExperienciaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService {
    @Autowired
    ExperienciaRepository expeRepo;

   

    public ArrayList<ExperienciaModel> obtenerExperiencia(){
        return (ArrayList<ExperienciaModel>) expeRepo.findAll();
        }
        public ExperienciaModel guardarExperiencia(ExperienciaModel experiencia){
            return expeRepo.save(experiencia);
        }
        public ExperienciaModel editarExperiencia(ExperienciaModel experiencia){
            return expeRepo.save(experiencia);
        }
        public Optional<ExperienciaModel> obtenerExperienciaById(Integer id){
            return expeRepo.findById(id);
        }
        public boolean existsById(Integer id){
            return expeRepo.existsById(id);
        }
    
        public boolean borrarExperiencia(Integer id){
            try{
                expeRepo.deleteById(id);
                return true;
            }catch(Exception err){
                return false;
            }
        }
}
