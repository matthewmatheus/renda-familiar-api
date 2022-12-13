package br.com.rfapi.rendafamiliarapi.service;

import br.com.rfapi.rendafamiliarapi.model.Receita;

import java.util.List;


public interface ReceitasService {

    List<Receita> buscarDescricao(String descricao);

    List<Receita> findByData(String ano, String mes);

    Receita somarValorReceitas(String ano, String mes);

    Receita descontarDespesas(String ano, String mes);
}
