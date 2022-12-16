package br.com.rfapi.rendafamiliarapi.service.impl;

import br.com.rfapi.rendafamiliarapi.infra.repo.DespesasRepository;
import br.com.rfapi.rendafamiliarapi.model.Despesa;
import br.com.rfapi.rendafamiliarapi.service.DespesaService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class DespesaServiceImpl implements DespesaService {

    private final DespesasRepository repo;

    public DespesaServiceImpl(DespesasRepository repo) {
    this.repo = repo;
    }

    @Override
    public List<Despesa> buscarDescricao(String descricao) {
        List<Despesa> desc = repo.buscarDescricao(descricao);
        return desc;
    }



    @Override
    public List<Despesa> findByData(int ano, int mes) {
        List<Despesa> data = repo.findByData(ano, mes);
        return data;

    }

    @Override
    public Object somarValorDespesas(int ano, int mes) {

        Object valor = repo.somarValorDespesas(ano, mes);
        return valor;
    }

    @Override
    public List<Object> somarDespesasPorCategoria(int ano, int mes) {
        List<Object> totalGasto = Collections.singletonList(repo.somarDespesasPorCategoria(ano, mes));
        return Collections.singletonList(totalGasto);
    }


}
