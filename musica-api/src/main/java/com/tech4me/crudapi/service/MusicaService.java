package com.tech4me.crudapi.service;

import java.util.List;
import java.util.Optional;

import com.tech4me.crudapi.compartilhado.MusicaDto;
import com.tech4me.crudapi.model.Musica;

public interface MusicaService {
    MusicaDto criarMusica(MusicaDto musica);
    List<MusicaDto> obterTodos();
    Optional<MusicaDto> obterPorId(String id);

    MusicaDto atualizarMusica(String id, MusicaDto musica);

    void deleteById(String id);

    long count();
}
