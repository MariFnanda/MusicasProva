package com.tech4me.crudapi.view.controller.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.CountQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech4me.crudapi.model.Musica;
import com.tech4me.crudapi.service.MusicaService;
import com.tech4me.crudapi.shared.MusicaDto;
import com.tech4me.crudapi.view.controller.model.MusicaRequest;
import com.tech4me.crudapi.view.controller.model.MusicaResponse;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/musicas")
public class MusicaController {
    //localhost:8080/api/musicas

    @Autowired
    private MusicaService servico;

    ModelMapper mapper = new ModelMapper();

    @GetMapping
    public ResponseEntity <List<MusicaResponse>> obterMusica (){
        List<MusicaDto> musdto = servico.obterTodos();
        List<MusicaResponse> musresponse =
        musdto.
        stream().
        map(m -> mapper.map(m, MusicaResponse.class)).
        collect(Collectors.toList());
        return new ResponseEntity<>(musresponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MusicaResponse> criarMusica (@RequestBody @Valid MusicaRequest musrequest){

        MusicaDto dtorequest = mapper.map(musrequest, MusicaDto.class);
        MusicaDto dtoresponse = servico.criarMusica(dtorequest);
        MusicaResponse musresponse = mapper.map(dtoresponse, MusicaResponse.class);

        return new ResponseEntity<>(musresponse, HttpStatus.CREATED);
    }
    

    @GetMapping(value="/{id}")
    public ResponseEntity<MusicaResponse> obterPorId(@PathVariable String id){
        Optional<MusicaDto> musdto = servico.obterPorId(id);

        if(musdto.isPresent()){
            MusicaResponse musresponse = mapper.map(musdto.get(), MusicaResponse.class);
            return new ResponseEntity<>(musresponse, HttpStatus.FOUND);
        }
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value="/{id}")
    public MusicaDto atualizarMusica(@PathVariable String id, @RequestBody MusicaDto musica){
        return servico.atualizarMusica(id, musica);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity <String> deleteById(@PathVariable String id) {
        servico.deleteById(id);
        return new ResponseEntity<>("Musica deletada com sucesso", HttpStatus.OK);
    }

    @GetMapping(value="/counting")
    public long count(String counting){
        return servico.count();
    }
    

}
