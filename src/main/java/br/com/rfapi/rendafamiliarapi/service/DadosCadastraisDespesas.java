package br.com.rfapi.rendafamiliarapi.service;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public record DadosCadastraisDespesas(
        @NotBlank
        String descricao,
        @NotBlank
        String valor,
        @NotBlank
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate data) {
}
