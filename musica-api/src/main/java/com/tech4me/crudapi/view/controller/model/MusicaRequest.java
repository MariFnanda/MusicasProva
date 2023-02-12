package com.tech4me.crudapi.view.controller.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class MusicaRequest {
    // " "
    // ""


    private String id;
    @NotBlank(message = "O titulo nao pode ter caracteres em branco")
    @NotEmpty(message = "O titulo nao pode ser vazio")
    private String titulo;
    private String artista;
    private String álbum;
    private String genero;
    private int anoLancamento;
    private String compositor;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public String getÁlbum() {
        return álbum;
    }
    public void setÁlbum(String álbum) {
        this.álbum = álbum;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getAnoLancamento() {
        return anoLancamento;
    }
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    public String getCompositor() {
        return compositor;
    }
    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }
}
