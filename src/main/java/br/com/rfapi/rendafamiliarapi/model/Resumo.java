package br.com.rfapi.rendafamiliarapi.model;


import br.com.rfapi.rendafamiliarapi.infra.Categoria;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor

public class Resumo {

    private Receita receita;
    private Despesa despesa;

    private Categoria categoria;
    private String valorReceita;
    private String valorDespesa;

    public Resumo(String valorReceita, String valorDespesa, Categoria categoria) {
        this.valorReceita = receita.getValor();
        this.valorDespesa = despesa.getValor();
        this.categoria = despesa.getCategoria();
    }
}
