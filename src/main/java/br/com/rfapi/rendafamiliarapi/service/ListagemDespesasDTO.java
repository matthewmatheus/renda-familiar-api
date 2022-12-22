package br.com.rfapi.rendafamiliarapi.service;

import br.com.rfapi.rendafamiliarapi.model.Despesa;

import java.time.LocalDate;

public record ListagemDespesasDTO(String descricao, String valor, LocalDate data) {



    public ListagemDespesasDTO(Despesa despesa) {

        this(despesa.getDescricao(), String.valueOf(despesa.getValor()), despesa.getData());

    }


}
