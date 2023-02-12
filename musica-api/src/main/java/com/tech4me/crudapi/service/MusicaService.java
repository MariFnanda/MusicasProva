package com.tech4me.crudapi.service;

import java.util.List;
import java.util.Optional;

import com.tech4me.crudapi.model.Musica;
import com.tech4me.crudapi.shared.MusicaDto;

public interface MusicaService {
    MusicaDto criarMusica(MusicaDto musica);
    List<MusicaDto> obterTodos();
    Optional<MusicaDto> obterPorId(String id);

    MusicaDto atualizarMusica(String id, MusicaDto musica);

    void deleteById(String id);

    long count();
}
