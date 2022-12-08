package br.com.rfapi.rendafamiliarapi.service;

import br.com.rfapi.rendafamiliarapi.model.ResumoMensal;

import java.util.List;

public interface ResumoService {


    List<ResumoMensal> fazerResumo(String ano, String mes);
}
