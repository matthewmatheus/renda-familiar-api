package br.com.rfapi.rendafamiliarapi.model;

import br.com.rfapi.rendafamiliarapi.service.DadosCadastraisDespesas;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Table(name = "despesas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "Despesa")
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String descricao;
    private String valor;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;


    public
    Despesa(DadosCadastraisDespesas dados) {
        this.descricao = dados.descricao();
        this.valor = dados.valor();
        this.data = dados.data();
    }




}
