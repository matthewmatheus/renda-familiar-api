package br.com.rfapi.rendafamiliarapi.service;

import br.com.rfapi.rendafamiliarapi.model.Receita;

import java.time.LocalDate;

public record DadosListagemReceita(String descricao, String valor, LocalDate data) {

    public DadosListagemReceita(Receita receita) {

        this(receita.getDescricao(), String.valueOf(receita.getValor()), receita.getData());
    }
}
