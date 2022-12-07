package br.com.rfapi.rendafamiliarapi.service;

import br.com.rfapi.rendafamiliarapi.model.Resumo;

import java.util.List;

public interface ResumoService {


    List<Resumo> fazerResumo(String ano, String mes);
}
