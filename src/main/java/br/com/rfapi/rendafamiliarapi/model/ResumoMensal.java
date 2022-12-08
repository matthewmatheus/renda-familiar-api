package br.com.rfapi.rendafamiliarapi.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class ResumoMensal {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne
    @JoinColumn(name = "receita_id")
    private Receita receita;
    @ManyToOne
    @JoinColumn(name = "despesa_id")
    private Despesa despesa;

}
