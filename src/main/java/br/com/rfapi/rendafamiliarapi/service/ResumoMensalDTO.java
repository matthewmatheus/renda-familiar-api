package br.com.rfapi.rendafamiliarapi.service;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ResumoMensalDTO {


    private List<Object> total_receitas;
    private Object total_despesas;
    private Object saldo_final;
    private List<Object> valor_por_categoria;


    public ResumoMensalDTO(List<Object> valorTotalReceitas, Object valorTotalDespesas, Object saldoFinalDoMes, List<Object> valorTotalGastoPorCategoria) {
        this.total_receitas = valorTotalReceitas;
        this.total_despesas = valorTotalDespesas;
        this.saldo_final = saldoFinalDoMes;
        this.valor_por_categoria = valorTotalGastoPorCategoria;
    }


}
