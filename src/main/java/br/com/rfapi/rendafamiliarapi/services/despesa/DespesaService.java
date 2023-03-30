package br.com.rfapi.rendafamiliarapi.services.despesa;

import br.com.rfapi.rendafamiliarapi.domain.despesa.Despesa;

import java.util.List;

public interface DespesaService {

    List<Despesa> buscarDescricao(String descricao);


    List<Despesa> findByData(int ano, int mes);

    Long somarValorDespesas(int ano, int mes);

    List<Long> somarDespesasPorCategoria(int ano, int mes);
}
