package br.com.rfapi.rendafamiliarapi.service;

import br.com.rfapi.rendafamiliarapi.model.Receita;

import java.util.List;
import java.util.Objects;


public interface ReceitasService {

    List<Receita> buscarDescricao(String descricao);

    List<Receita> findByData(int ano, int mes);

    List<Receita> somarValorReceitas(int ano, int mes);

    Receita descontarDespesas(int ano, int mes);
}
