package br.com.rfapi.rendafamiliarapi.services.impl;

import br.com.rfapi.rendafamiliarapi.infrastructure.repositories.receita.ReceitasRepository;
import br.com.rfapi.rendafamiliarapi.domain.receita.Receita;
import br.com.rfapi.rendafamiliarapi.services.receita.ReceitasService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaServiceImpl implements ReceitasService {


    private final ReceitasRepository repo;

    public ReceitaServiceImpl(ReceitasRepository repo) {
        this.repo = repo;
    }



    @Override
    public List<Receita> buscarDescricao(String descricao) {
        return repo.buscarDescricao(descricao);

    }


    @Override
    public List<Receita> findByData(int ano, int mes) {

        List<Receita> date = repo.findByData(ano, mes);
        return date;
    }

    @Override
    public Long somarValorReceitas(int ano, int mes) {
        Long valor = repo.somarValorReceitas(ano,mes);
        return valor;

    }

    @Override
    public Long descontarDespesas(int ano, int mes) {
        Long saldoFinal = repo.descontarDespesas(ano, mes);
        return saldoFinal;
    }

    @Override
    public List<Receita> findAll() {
        return repo.findAll();
    }



}
