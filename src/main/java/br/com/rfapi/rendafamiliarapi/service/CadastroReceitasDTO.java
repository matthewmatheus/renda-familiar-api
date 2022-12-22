package br.com.rfapi.rendafamiliarapi.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public record CadastroReceitasDTO(


        @NotBlank
        String descricao,
        @NotBlank
        int valor,
        @NotBlank
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate data,
        @Nullable
        int ano,
        @Nullable
        int mes) {

        public CadastroReceitasDTO(@NotBlank
                                       String descricao, @NotBlank
                                       int valor, @NotBlank
                                       @JsonFormat(pattern = "dd/MM/yyyy")
                                       LocalDate data,
                                   @Nullable
                                       int ano,
                                   @Nullable
                                       int mes) {
                this.descricao = descricao;
                this.valor = valor;
                this.data = data;
                this.mes = data.getMonthValue();
                this.ano = data.getYear();
        }
}