package br.com.rfapi.rendafamiliarapi.service;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ResumoMensalDTO {


    private List<Object> valorTotalReceitas;
    private Object valorTotalDespesas;
    private Object saldoFinalDoMes;
    private List<Object> valorTotalGastoPorCategoria;


    public ResumoMensalDTO(List<Object> valorTotalReceitas, Object valorTotalDespesas, Object saldoFinalDoMes, List<Object> valorTotalGastoPorCategoria) {
        this.valorTotalReceitas = valorTotalReceitas;
        this.valorTotalDespesas = valorTotalDespesas;
        this.saldoFinalDoMes = saldoFinalDoMes;
        this.valorTotalGastoPorCategoria = valorTotalGastoPorCategoria;
    }


}
