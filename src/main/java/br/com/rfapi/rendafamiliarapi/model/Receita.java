package br.com.rfapi.rendafamiliarapi.model;


import br.com.rfapi.rendafamiliarapi.service.CadastroReceitasDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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
    @Column(name = "id")
    private Long receita_id;

    private String descricao;
    private int valor;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;


    @JsonIgnore
    private int ano;
    @JsonIgnore
    private int mes;




    public Receita(CadastroReceitasDTO dados) {
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