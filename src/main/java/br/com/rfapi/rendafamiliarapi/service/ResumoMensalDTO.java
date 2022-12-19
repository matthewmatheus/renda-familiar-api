package br.com.rfapi.rendafamiliarapi.service;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ResumoMensalDTO {


    private Long total_receitas;
    private Long total_despesas;
    private Long saldo_final;
    private List<Long> valor_por_categoria;


    public ResumoMensalDTO(Long valorTotalReceitas, Long valorTotalDespesas, Long saldoFinalDoMes, List<Long> valorTotalGastoPorCategoria) {
        this.total_receitas = valorTotalReceitas;
        this.total_despesas = valorTotalDespesas;
        this.saldo_final = saldoFinalDoMes;
        this.valor_por_categoria = valorTotalGastoPorCategoria;
    }


}
