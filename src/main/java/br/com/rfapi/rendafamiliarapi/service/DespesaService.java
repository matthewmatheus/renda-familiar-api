package br.com.rfapi.rendafamiliarapi.service;

import br.com.rfapi.rendafamiliarapi.model.Despesa;

import java.util.List;

public interface DespesaService {

    List<Despesa> buscarDescricao(String descricao);


    List<Despesa> findByData(String ano, String mes);

    Despesa somarValorDespesas(String ano,String mes);

    List<Despesa> somarDespesasPorCategoria(String ano, String mes);
}
