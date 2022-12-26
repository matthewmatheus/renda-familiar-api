package br.com.rfapi.rendafamiliarapi.model.receita.dto;

import br.com.rfapi.rendafamiliarapi.model.receita.Receita;

import java.time.LocalDate;


public record ListagemReceitasDTO(String descricao, int valor, LocalDate data) {

    public ListagemReceitasDTO(Receita receita) {

        this(receita.getDescricao(), receita.getValor(), receita.getData());
    }


}
