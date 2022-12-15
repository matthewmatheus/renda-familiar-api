package br.com.rfapi.rendafamiliarapi.controller;

//import br.com.rfapi.rendafamiliarapi.model.Resumo;
//import br.com.rfapi.rendafamiliarapi.service.ResumoService;
import br.com.rfapi.rendafamiliarapi.model.Despesa;
import br.com.rfapi.rendafamiliarapi.model.Receita;
import br.com.rfapi.rendafamiliarapi.service.DespesaService;
import br.com.rfapi.rendafamiliarapi.service.ReceitasService;
import com.electronwill.nightconfig.core.conversion.Path;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("resumo")
public class ResumoMensalController {


    private ReceitasService receitasService;
    private DespesaService despesaService;


    public ResumoMensalController(ReceitasService receitasService, DespesaService despesaService) {
        this.receitasService = receitasService;
        this.despesaService = despesaService;
    }


    @GetMapping("/{ano}/{mes}")
    public List<Receita> valorTotalReceitas(@PathVariable("ano") int ano, @PathVariable("mes") int mes) {

        List<Receita> valor =  receitasService.somarValorReceitas(ano, mes);
        return valor;
    }

    public Despesa valorTotalDespesas(int ano, int mes) {
        Despesa valor = despesaService.somarValorDespesas(ano, mes);
        return valor;
    }

    public Receita saldoFinalDoMes(int ano, int mes) {

        Receita saldoFInal = receitasService.descontarDespesas(ano,mes);
        return saldoFInal;
    }

    public List<Despesa> valorTotalGastoPorCategoria(int ano, int mes) {

        List<Despesa> totalGasto = despesaService.somarDespesasPorCategoria(ano, mes);
        return totalGasto;
    }


    public ResponseEntity<Object> resumo(@PathVariable("ano") int ano, @PathVariable("mes") int mes){


//        valorTotalDespesas(ano, mes);
         return ResponseEntity.ok(valorTotalReceitas(ano, mes));
//        saldoFinalDoMes(ano, mes);
//        valorTotalGastoPorCategoria(ano, mes);

    }


}
