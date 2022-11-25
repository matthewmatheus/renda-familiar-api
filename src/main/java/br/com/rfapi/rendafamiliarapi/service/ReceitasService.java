package br.com.rfapi.rendafamiliarapi.service;

import br.com.rfapi.rendafamiliarapi.model.Receita;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ReceitasService {

    List<Receita> buscarDescricao(String descricao);

}
