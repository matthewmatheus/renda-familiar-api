package br.com.rfapi.rendafamiliarapi.service;

import br.com.rfapi.rendafamiliarapi.infra.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.lang.Nullable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.time.LocalDate;

public record DadosCadastraisDespesas(
        @NotBlank

        String descricao,

        @NotBlank
        @JsonInclude(JsonInclude.Include.ALWAYS)
        int valor,
        @NotBlank
        @JsonInclude(JsonInclude.Include.ALWAYS)
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate data,
        @Nullable
        int ano,
        @Nullable
        int mes,
        @Enumerated(EnumType.STRING)
        Categoria categoria) {


    public DadosCadastraisDespesas(@NotBlank

                                   String descricao, @NotBlank
                                   @JsonInclude(JsonInclude.Include.ALWAYS)
                                   int valor, @NotBlank
                                   @JsonInclude(JsonInclude.Include.ALWAYS)
                                   @JsonFormat(pattern = "dd/MM/yyyy")
                                   LocalDate data, @Nullable
                                   int ano, @Nullable
                                   int mes,
                                   Categoria categoria) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.ano = data.getYear();
        this.mes = data.getMonthValue();
        this.categoria = categoria;
    }
}


