package br.com.rfapi.rendafamiliarapi.service.impl;

import br.com.rfapi.rendafamiliarapi.infra.repo.ReceitasRepository;
import br.com.rfapi.rendafamiliarapi.model.Receita;
import br.com.rfapi.rendafamiliarapi.service.ReceitasService;
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
        List<Receita> descricaoBuscada = repo.buscarDescricao(descricao);
        return descricaoBuscada;
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
