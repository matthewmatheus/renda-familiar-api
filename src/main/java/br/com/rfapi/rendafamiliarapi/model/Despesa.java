package br.com.rfapi.rendafamiliarapi.model;

import br.com.rfapi.rendafamiliarapi.service.DadosCadastraisDespesas;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;


@Table(name = "despesas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Despesa ")
public class Despesa {

    @Id
    @GeneratedValue
    private Long id;

    private String descricao;
    private String valor;
    private String data;


    public Despesa(DadosCadastraisDespesas dados) {
        this.descricao = dados.descricao();
        this.valor = dados.valor();
        this.data =  dados.data();
    }
}
