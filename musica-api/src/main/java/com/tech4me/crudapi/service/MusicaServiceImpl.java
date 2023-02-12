package com.tech4me.crudapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech4me.crudapi.compartilhado.MusicaDto;
import com.tech4me.crudapi.model.Musica;
import com.tech4me.crudapi.repository.MusicaRepositorio;

@Service
public class MusicaServiceImpl implements MusicaService{

    @Autowired
    private MusicaRepositorio repo;

    ModelMapper mapper = new ModelMapper();

    @Override
    public MusicaDto criarMusica(MusicaDto musicadto) {

        Musica m = mapper.map(musicadto, Musica.class);
        m = repo.save(m);
        MusicaDto dto = mapper.map(m, MusicaDto.class);
        return dto;
   
    }

    @Override
    public List<MusicaDto> obterTodos() {
        List<Musica> mus = repo.findAll();
        List<MusicaDto> musdto =
        mus.
        stream().
        map(m -> mapper.map(m, MusicaDto.class)).
        collect(Collectors.toList());

        return musdto;
    }

    @Override
    public Optional <MusicaDto> obterPorId(String id) {
        Optional<Musica> optmus = repo.findById(id);

        if(optmus.isPresent()){
            MusicaDto musdto = mapper.map(optmus.get(), MusicaDto.class);
            return Optional.of(musdto);
        }

        return Optional.empty();
    }

    @Override
    public MusicaDto atualizarMusica(String id, MusicaDto musicadto){
        Musica m = mapper.map(musicadto, Musica.class);
        m.setId(id);
        m = repo.save(m);
        MusicaDto dto = mapper.map(m, MusicaDto.class);
        return dto;
    }


    @Override
    public void deleteById(String id){
        repo.deleteById(id);
    }

    @Override
    public long count() {
        return repo.count();
    }

    
    
}
