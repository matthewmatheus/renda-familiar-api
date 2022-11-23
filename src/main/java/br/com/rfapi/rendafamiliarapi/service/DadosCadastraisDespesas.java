package br.com.rfapi.rendafamiliarapi.service;

import br.com.rfapi.rendafamiliarapi.infra.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public record DadosCadastraisDespesas(
        @NotBlank

        String descricao,

        @NotBlank
        @JsonInclude(JsonInclude.Include.ALWAYS)
        String valor,
        @NotBlank
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate data,

        @Enumerated(EnumType.STRING)
        Categoria categoria) {






}


