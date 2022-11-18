package br.com.rfapi.rendafamiliarapi.service;

import java.time.LocalDate;

public record DadosCadastraisDespesas(String descricao, String valor, LocalDate data) {
}
