package br.com.rfapi.rendafamiliarapi.service;

import br.com.rfapi.rendafamiliarapi.model.Despesa;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public record DadosListagemDespesas(String descricao, String valor, LocalDate data) {



    public DadosListagemDespesas(Despesa despesa) {

        this(despesa.getDescricao(), despesa.getValor() , despesa.getData());

    }


}
