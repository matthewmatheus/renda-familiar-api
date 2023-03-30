package br.com.rfapi.rendafamiliarapi.domain.despesa.dto;

import br.com.rfapi.rendafamiliarapi.services.enums.Categoria;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class CategoriaDTO implements Serializable {


    private static final long serialVersionUID = 1L;

    private Categoria categoria;
   private Categoria ALIMENTAÇÃO;
   private Categoria SAÚDE;
   private Categoria MORADIA;
   private Categoria TRANSPORTE;
   private Categoria EDUCAÇÃO;
   private Categoria LAZER;
   private Categoria IMPREVISTOS;
   private Categoria OUTRAS;




    public CategoriaDTO(Categoria obj, Categoria ALIMENTAÇÃO, Categoria SAÚDE, Categoria MORADIA, Categoria TRANSPORTE, Categoria EDUCAÇÃO, Categoria LAZER, Categoria IMPREVISTOS, Categoria OUTRAS) {
        this.categoria = categoria;
        this.ALIMENTAÇÃO = ALIMENTAÇÃO;
        this.SAÚDE = SAÚDE;
        this.MORADIA = MORADIA;
        this.TRANSPORTE = TRANSPORTE;
        this.EDUCAÇÃO = EDUCAÇÃO;
        this.LAZER = LAZER;
        this.IMPREVISTOS = IMPREVISTOS;
        this.OUTRAS = OUTRAS;
    }
}