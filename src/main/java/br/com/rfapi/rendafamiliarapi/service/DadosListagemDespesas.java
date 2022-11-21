package br.com.rfapi.rendafamiliarapi.service;

import br.com.rfapi.rendafamiliarapi.model.Despesa;

import java.time.LocalDate;

public record DadosListagemDespesas(String descricao, String valor, LocalDate data) {

    public DadosListagemDespesas(Despesa despesa) {

        this(despesa.getDescricao(), despesa.getValor() , despesa.getData());

    }




}
