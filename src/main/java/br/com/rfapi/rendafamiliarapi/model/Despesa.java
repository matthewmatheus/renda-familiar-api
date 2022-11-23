package br.com.rfapi.rendafamiliarapi.model;

import br.com.rfapi.rendafamiliarapi.controller.ReceitasController;
import br.com.rfapi.rendafamiliarapi.infra.Categoria;
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
@EqualsAndHashCode(of = "despesa_id")
@Entity(name = "Despesa")
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "despesa_id")

    private Long despesa_id;


    private String descricao;
    private String valor;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;


//    @OneToOne(fetch = FetchType.LAZY)
//    private Receita receita;

    public Despesa(DadosCadastraisDespesas dados) {
        this.descricao = dados.descricao();
        this.valor = dados.valor();
        this.data = dados.data();
        this.categoria = dados.categoria();

    }


}





