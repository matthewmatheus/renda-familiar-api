package br.com.rfapi.rendafamiliarapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Despesas {

    @Id
    @GeneratedValue
    private Long id;

    private String descricao;
    private String valor;
    private LocalDate data;



}
