package br.com.rfapi.rendafamiliarapi.model;


import br.com.rfapi.rendafamiliarapi.controller.ReceitasController;
import br.com.rfapi.rendafamiliarapi.service.DadosCadastraisReceitas;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Table(name = "receitas")
@Entity(name = "Receita")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "receita_id")
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receita_id")
    private Long receita_id;

    private String descricao;
    private String valor;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    private String ano;
    private String mes;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private Despesa despesa;


    public Receita(DadosCadastraisReceitas dados) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.descricao = dados.descricao();
        this.valor = dados.valor();
        this.data = dados.data();
        this.ano = String.valueOf(data.getYear());
        this.mes = String.valueOf(data.getMonth());
    }

    public Receita(Receita receita) {

    }
}