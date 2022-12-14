package br.com.rfapi.rendafamiliarapi.service;

import br.com.rfapi.rendafamiliarapi.model.Despesa;

import java.util.List;

public interface DespesaService {

    List<Despesa> buscarDescricao(String descricao);


    List<Despesa> findByData(int ano, int mes);

    Despesa somarValorDespesas(int ano,int mes);

    List<Despesa> somarDespesasPorCategoria(int ano, int mes);
}
