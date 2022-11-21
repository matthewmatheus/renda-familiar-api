package br.com.rfapi.rendafamiliarapi.model;


import br.com.rfapi.rendafamiliarapi.controller.ReceitasController;
import br.com.rfapi.rendafamiliarapi.service.DadosCadastraisReceitas;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Table(name = "receitas")
@Entity(name = "Receita")
@Setter
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
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;



    public Receita(DadosCadastraisReceitas dados) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.descricao = dados.descricao();
        this.valor = dados.valor();
        this.data = dados.data();
    }
}