package br.com.rfapi.rendafamiliarapi.service.impl;

import br.com.rfapi.rendafamiliarapi.infra.repo.ResumoRepository;
import br.com.rfapi.rendafamiliarapi.model.ResumoMensal;
import br.com.rfapi.rendafamiliarapi.service.ResumoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumoServiceImpl implements ResumoService {


    private final ResumoRepository repo;

    public ResumoServiceImpl(ResumoRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<ResumoMensal> fazerResumo(String ano, String mes) {
        List<ResumoMensal> resumo = repo.fazerResumo(ano, mes);
        return resumo;
    }
}
