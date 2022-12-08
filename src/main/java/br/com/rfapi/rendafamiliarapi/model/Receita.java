package br.com.rfapi.rendafamiliarapi.model;


import br.com.rfapi.rendafamiliarapi.controller.ReceitasController;
import br.com.rfapi.rendafamiliarapi.service.DadosCadastraisReceitas;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.valueextraction.ExtractedValue;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Table(name = "receitas")
@Entity(name = "Receita")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "receita_id")
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long receita_id;

    private String descricao;
    private String valor;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;


    @JsonIgnore
    private String ano;
    @JsonIgnore
    private String mes;



@OneToOne
@JoinColumn(name = "resumo_mensal_id")
private ResumoMensal resumoMensal;

    public Receita(DadosCadastraisReceitas dados) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.descricao = dados.descricao();
        this.valor = dados.valor();
        this.data = dados.data();
        this.ano = dados.ano();
        this.mes = dados.mes();
    }

    public Receita(Receita receita) {

    }
}