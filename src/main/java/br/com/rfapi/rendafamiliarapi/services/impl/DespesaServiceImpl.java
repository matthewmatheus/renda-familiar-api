package br.com.rfapi.rendafamiliarapi.services.impl;

import br.com.rfapi.rendafamiliarapi.infrastructure.repositories.despesa.DespesasRepository;
import br.com.rfapi.rendafamiliarapi.domain.despesa.Despesa;
import br.com.rfapi.rendafamiliarapi.services.despesa.DespesaService;
import org.springframework.stereotype.Service;

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
    public Long somarValorDespesas(int ano, int mes) {

        Long valor = repo.somarValorDespesas(ano, mes);
        return valor;
    }

    @Override
    public List<Long> somarDespesasPorCategoria(int ano, int mes) {
        List<Long> totalGasto = repo.somarDespesasPorCategoria(ano, mes);
        return totalGasto;
    }


}
