package br.com.rfapi.rendafamiliarapi.service.impl;

import br.com.rfapi.rendafamiliarapi.infra.repo.ResumoRepository;
import br.com.rfapi.rendafamiliarapi.service.ResumoService;

import java.util.List;

public class ResumoServiceImpl implements ResumoService {


    private ResumoRepository repo;

    @Override
    public List<Object> fazerResumo(String ano, String mes) {
        List<Object> resumo = repo.fazerResumo(ano, mes);
        return resumo;
    }
}
