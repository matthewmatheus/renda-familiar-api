package br.com.rfapi.rendafamiliarapi.service.impl;

import br.com.rfapi.rendafamiliarapi.infra.repo.ReceitasRepository;
import br.com.rfapi.rendafamiliarapi.model.Receita;
import br.com.rfapi.rendafamiliarapi.service.ReceitasService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
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
    public List<Receita> buscarData(LocalDate data) {
        List<Receita> dataBuscada = repo.buscarData(data);
        return dataBuscada;
    }

    @Override
    public List<Receita> findByData(String ano, String mes) {

        Receita receita = new Receita();
        String year = String.valueOf(receita.getData().getYear());
        String month = String.valueOf(receita.getData().getMonth());

        List<Receita> date = repo.findByData(year,month);
        return date;
    }


}
