package br.com.rfapi.rendafamiliarapi.controller;

//import br.com.rfapi.rendafamiliarapi.model.Resumo;
//import br.com.rfapi.rendafamiliarapi.service.ResumoService;
import br.com.rfapi.rendafamiliarapi.model.Despesa;
import br.com.rfapi.rendafamiliarapi.model.Receita;
import br.com.rfapi.rendafamiliarapi.service.DespesaService;
import br.com.rfapi.rendafamiliarapi.service.ReceitasService;
import br.com.rfapi.rendafamiliarapi.service.ResumoMensalDTO;
import com.electronwill.nightconfig.core.conversion.Path;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
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


    private ResumoMensalDTO resumoMensal;

    private ReceitasService receitasService;
    private DespesaService despesaService;


    public ResumoMensalController(ReceitasService receitasService, DespesaService despesaService) {
        this.receitasService = receitasService;
        this.despesaService = despesaService;
    }



    public List<Object> valorTotalReceitas(@PathVariable("ano") int ano, @PathVariable("mes") int mes) {

        List<Object> valor =  receitasService.somarValorReceitas(ano, mes);
        return valor;
    }

    public Object valorTotalDespesas(int ano, int mes) {
        Object valor = despesaService.somarValorDespesas(ano, mes);
        return valor;
    }

    public Object saldoFinalDoMes(int ano, int mes) {

        Object saldoFInal = receitasService.descontarDespesas(ano,mes);
        return saldoFInal;
    }


    public List<Object> valorTotalGastoPorCategoria(int ano, int mes) {

        List<Object> totalGasto = despesaService.somarDespesasPorCategoria(ano, mes);
        return totalGasto;
    }


    @GetMapping("/{ano}/{mes}")
    public ResponseEntity<Object> resumo(@PathVariable("ano") int ano, @PathVariable("mes") int mes){


       return ResponseEntity.ok(new ResumoMensalDTO(valorTotalReceitas(ano, mes), valorTotalDespesas(ano, mes), saldoFinalDoMes(ano, mes),valorTotalGastoPorCategoria(ano, mes)));



    }


}
