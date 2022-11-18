package br.com.rfapi.rendafamiliarapi.model;


import br.com.rfapi.rendafamiliarapi.service.DadosCadastraisReceitas;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "receitas")
@Entity(name = "Receita")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String descricao;
    private String valor;
    private String data;


    public Receita(DadosCadastraisReceitas dados) {
    this.descricao = dados.descricao();
    this.valor = dados.valor();
    this.data =  dados.data();
    }
}