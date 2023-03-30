package br.com.rfapi.rendafamiliarapi.domain.despesa.dto;

import br.com.rfapi.rendafamiliarapi.domain.despesa.Despesa;

import java.time.LocalDate;

public record ListagemDespesasDTO(String descricao, String valor, LocalDate data) {



    public ListagemDespesasDTO(Despesa despesa) {

        this(despesa.getDescricao(), String.valueOf(despesa.getValor()), despesa.getData());

    }


}
