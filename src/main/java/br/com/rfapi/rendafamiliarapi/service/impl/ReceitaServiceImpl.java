package br.com.rfapi.rendafamiliarapi.service.impl;

import br.com.rfapi.rendafamiliarapi.infra.ReceitasRepository;
import br.com.rfapi.rendafamiliarapi.model.Receita;
import br.com.rfapi.rendafamiliarapi.service.ReceitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaServiceImpl implements ReceitasService {


    public ReceitaServiceImpl(ReceitasRepository repo) {
        this.repo = repo;
    }


    private ReceitasRepository repo;

    @Override
    public List<Receita> buscarDescricao(String descricao) {
        List<Receita> desc = repo.buscarDescricao(descricao);
        return desc;
    }
}
