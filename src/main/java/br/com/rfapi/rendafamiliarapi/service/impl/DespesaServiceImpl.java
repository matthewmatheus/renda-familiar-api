package br.com.rfapi.rendafamiliarapi.service.impl;

import br.com.rfapi.rendafamiliarapi.infra.repo.DespesasRepository;
import br.com.rfapi.rendafamiliarapi.model.Despesa;
import br.com.rfapi.rendafamiliarapi.service.DespesaService;
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
    public List<Despesa> buscarData(String data) {
        List<Despesa> dataBuscada = repo.buscarData(data);
        return dataBuscada;
    }

}
