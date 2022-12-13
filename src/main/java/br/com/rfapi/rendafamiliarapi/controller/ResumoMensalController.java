package br.com.rfapi.rendafamiliarapi.controller;

//import br.com.rfapi.rendafamiliarapi.model.Resumo;
//import br.com.rfapi.rendafamiliarapi.service.ResumoService;
import br.com.rfapi.rendafamiliarapi.model.Despesa;
import br.com.rfapi.rendafamiliarapi.model.Receita;
import br.com.rfapi.rendafamiliarapi.service.DespesaService;
import br.com.rfapi.rendafamiliarapi.service.ReceitasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("resumo")
public class ResumoMensalController {


    private ReceitasService receitasService;
    private DespesaService despesaService;

    public ResumoMensalController(ReceitasService receitasService, DespesaService despesaService) {
        this.receitasService = receitasService;
        this.despesaService = despesaService;
    }

    public Receita valorTotalReceitas(String ano, String mes) {
        Receita valor = receitasService.somarValorReceitas(ano, mes);
        return valor;
    }

    public Despesa valorTotalDespesas(String ano, String mes) {
        Despesa valor = despesaService.somarValorDespesas(ano, mes);
        return valor;
    }

    public Receita saldoFinalDoMes(String ano, String mes) {

        Receita saldoFInal = receitasService.descontarDespesas(ano,mes);
        return saldoFInal;
    }

    public List<Despesa> valorTotalGastoPorCategoria(String ano, String mes) {

        List<Despesa> totalGasto = despesaService.somarDespesasPorCategoria(ano, mes);
        return totalGasto;
    }

    @GetMapping("/{ano}/{mes}")
    public void resumo(@PathVariable("ano") String ano, @PathVariable("mes") String mes){

//        valorTotalDespesas(ano, mes);
            valorTotalReceitas(ano, mes);
//        saldoFinalDoMes(ano, mes);
//        valorTotalGastoPorCategoria(ano, mes);

    }


}
