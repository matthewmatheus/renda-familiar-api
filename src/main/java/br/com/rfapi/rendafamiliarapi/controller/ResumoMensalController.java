package br.com.rfapi.rendafamiliarapi.controller;

//import br.com.rfapi.rendafamiliarapi.model.Resumo;
//import br.com.rfapi.rendafamiliarapi.service.ResumoService;
import br.com.rfapi.rendafamiliarapi.infra.Categoria;
import br.com.rfapi.rendafamiliarapi.service.CategoriaDTO;
import br.com.rfapi.rendafamiliarapi.service.DespesaService;
import br.com.rfapi.rendafamiliarapi.service.ReceitasService;
import br.com.rfapi.rendafamiliarapi.service.ResumoMensalDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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



    public Long valorTotalReceitas(@PathVariable("ano") int ano, @PathVariable("mes") int mes) {

        Long valor =  receitasService.somarValorReceitas(ano, mes);
        return valor;
    }

    public Long valorTotalDespesas(int ano, int mes) {
        Long valor = despesaService.somarValorDespesas(ano, mes);
        return valor;
    }

    public Long saldoFinalDoMes(int ano, int mes) {

        Long saldoFInal = receitasService.descontarDespesas(ano,mes);
        return saldoFInal;
    }


    public List<Long> valorTotalGastoPorCategoria(int ano, int mes) {

        List<Long> totalGasto = despesaService.somarDespesasPorCategoria(ano, mes);

        return totalGasto;
    }


    @GetMapping("/{ano}/{mes}")
    public ResponseEntity<ResumoMensalDTO> resumo(@PathVariable("ano") int ano, @PathVariable("mes") int mes){


       return ResponseEntity.ok(new ResumoMensalDTO(valorTotalReceitas(ano, mes), valorTotalDespesas(ano, mes), saldoFinalDoMes(ano, mes),valorTotalGastoPorCategoria(ano, mes)));



    }


}
