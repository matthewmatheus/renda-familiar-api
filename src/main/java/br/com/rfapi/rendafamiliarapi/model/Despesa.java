package br.com.rfapi.rendafamiliarapi.model;

import br.com.rfapi.rendafamiliarapi.infra.Categoria;
import br.com.rfapi.rendafamiliarapi.service.CadastroDespesasDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "id")
    private Long despesa_id;


    private String descricao;
    private Long valor;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;


    @JsonIgnore
    private int ano;

    @JsonIgnore
    private int mes;



    public Despesa(CadastroDespesasDTO dados) {
        this.descricao = dados.descricao();
        this.valor = dados.valor();
        this.data = dados.data();
        this.categoria = dados.categoria();
        this.ano = dados.ano();
        this.mes = dados.mes();
    }


}





