package br.com.rfapi.rendafamiliarapi.service;

import br.com.rfapi.rendafamiliarapi.model.Receita;

import java.time.LocalDate;

public record ListagemReceitasDTO(String descricao, String valor, LocalDate data) {

    public ListagemReceitasDTO(Receita receita) {

        this(receita.getDescricao(), String.valueOf(receita.getValor()), receita.getData());
    }
}
