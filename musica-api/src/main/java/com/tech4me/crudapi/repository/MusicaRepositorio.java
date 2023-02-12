package com.tech4me.crudapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tech4me.crudapi.model.Musica;

public interface MusicaRepositorio extends MongoRepository<Musica,String>{
    
}
