package br.com.rfapi.rendafamiliarapi.service;

import br.com.rfapi.rendafamiliarapi.model.Receita;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.List;


public interface ReceitasService {

    List<Receita> buscarDescricao(String descricao);

    List<Receita> findByData(String ano, String mes);
}
