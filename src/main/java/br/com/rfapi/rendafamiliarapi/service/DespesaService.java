package br.com.rfapi.rendafamiliarapi.service;

import br.com.rfapi.rendafamiliarapi.model.Despesa;
import br.com.rfapi.rendafamiliarapi.model.Receita;

import java.util.List;

public interface DespesaService {

    List<Despesa> buscarDescricao(String descricao);
}
