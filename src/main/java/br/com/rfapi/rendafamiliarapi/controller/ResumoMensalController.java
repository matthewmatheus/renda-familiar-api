package br.com.rfapi.rendafamiliarapi.controller;

import br.com.rfapi.rendafamiliarapi.infra.repo.DespesasRepository;
import br.com.rfapi.rendafamiliarapi.infra.repo.ReceitasCustomRepository;
import br.com.rfapi.rendafamiliarapi.infra.repo.ReceitasRepository;
import br.com.rfapi.rendafamiliarapi.model.Despesa;
import br.com.rfapi.rendafamiliarapi.service.DespesaService;
import br.com.rfapi.rendafamiliarapi.service.ReceitasService;
import br.com.rfapi.rendafamiliarapi.service.ResumoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("resumo")
public class ResumoMensalController {

    @Autowired
    private DespesasRepository despesasRepository;
    private DespesaService despesaService;

    @Autowired
    private ReceitasRepository receitasRepository;

    private ReceitasService receitasService;
    private ReceitasCustomRepository receitasCustomRepository;
    private ResumoService resumoService;


    @GetMapping("/{ano}/{mes}")
    public List<Object> resumoDoMes(@PathVariable("ano") String ano, @PathVariable("mes") String mes) {

        List<Object> resumo = resumoService.fazerResumo(ano, mes);
        return resumo;

    }




}
