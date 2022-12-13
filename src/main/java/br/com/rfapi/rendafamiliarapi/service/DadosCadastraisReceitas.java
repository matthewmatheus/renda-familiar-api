package br.com.rfapi.rendafamiliarapi.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;

public record DadosCadastraisReceitas(


        @NotBlank
        String descricao,
        @NotBlank
        int valor,
        @NotBlank
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate data,
        @Nullable
        String ano,
        @Nullable
        String mes) {

        public DadosCadastraisReceitas(@NotBlank
                                       String descricao, @NotBlank
                                       int valor, @NotBlank
                                       @JsonFormat(pattern = "dd/MM/yyyy")
                                       LocalDate data,
                                       @Nullable
                                       String ano,
                                       @Nullable
                                       String mes) {
                this.descricao = descricao;
                this.valor = valor;
                this.data = data;
                this.mes = String.valueOf(data.getMonthValue());
                this.ano = String.valueOf(data.getYear());
        }
}
