package br.com.rfapi.rendafamiliarapi.service;

import br.com.rfapi.rendafamiliarapi.model.Receita;

import java.util.List;


public interface ReceitasService {

    List<Receita> buscarDescricao(String descricao);

    List<Receita> findByData(int ano, int mes);

    List<Object> somarValorReceitas(int ano, int mes);

    Object descontarDespesas(int ano, int mes);
}
