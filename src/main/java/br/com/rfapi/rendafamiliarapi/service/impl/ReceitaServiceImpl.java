package br.com.rfapi.rendafamiliarapi.service.impl;

import br.com.rfapi.rendafamiliarapi.infra.repo.ReceitasRepository;
import br.com.rfapi.rendafamiliarapi.model.Receita;
import br.com.rfapi.rendafamiliarapi.service.ReceitasService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;

@Service
public class ReceitaServiceImpl implements ReceitasService {

    private final ReceitasRepository repo;

    public ReceitaServiceImpl(ReceitasRepository repo) {
        this.repo = repo;
    }



    @Override
    public List<Receita> buscarDescricao(String descricao) {
        List<Receita> descricaoBuscada = repo.buscarDescricao(descricao);
        return descricaoBuscada;
    }


    @Override
    public List<Receita> findByData(String ano, String mes) {

        List<Receita> date = repo.findByData(ano, mes);
        return date;
    }


}
