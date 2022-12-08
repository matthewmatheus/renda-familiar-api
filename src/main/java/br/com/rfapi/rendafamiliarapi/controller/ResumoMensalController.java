package br.com.rfapi.rendafamiliarapi.controller;

import br.com.rfapi.rendafamiliarapi.infra.repo.ResumoRepository;
//import br.com.rfapi.rendafamiliarapi.model.Resumo;
import br.com.rfapi.rendafamiliarapi.model.ResumoMensal;
//import br.com.rfapi.rendafamiliarapi.service.ResumoService;
import br.com.rfapi.rendafamiliarapi.service.ResumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("resumo")
public class ResumoMensalController {


    @Autowired
    private ResumoRepository repository;
    private ResumoService resumoService;

    public ResumoMensalController(ResumoService resumoService) {
        this.resumoService = resumoService;
    }

    @GetMapping("/{ano}/{mes}")
    public List<ResumoMensal> resumoDoMes(@PathVariable("ano") String ano, @PathVariable("mes") String mes) {

        List<ResumoMensal> resumo = resumoService.fazerResumo(ano, mes);
        return resumo;

    }


}
