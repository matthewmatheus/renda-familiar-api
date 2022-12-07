package br.com.rfapi.rendafamiliarapi.service.impl;

import br.com.rfapi.rendafamiliarapi.infra.repo.ResumoRepository;
import br.com.rfapi.rendafamiliarapi.model.Resumo;
import br.com.rfapi.rendafamiliarapi.service.ResumoService;

import java.util.List;

public class ResumoServiceImpl implements ResumoService {


    private ResumoRepository repo;

    @Override
    public List<Resumo> fazerResumo(String ano, String mes) {
        List<Resumo> resumo = repo.fazerResumo(ano, mes);
        return resumo;
    }
}
