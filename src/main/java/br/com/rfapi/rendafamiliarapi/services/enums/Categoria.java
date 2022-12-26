package br.com.rfapi.rendafamiliarapi.services.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.ALWAYS)
public enum Categoria {


    ALIMENTAÇÃO,
    SAÚDE,
    MORADIA,
    TRANSPORTE,
    EDUCAÇÃO,
    LAZER,
    IMPREVISTOS,
    OUTRAS;


    @JsonCreator
    public static Categoria forName(String name) {
            for(Categoria c: values()) {
            if(c.name().equals(name)) { //change accordingly
                return c;
            }
        }
        return OUTRAS;
    }



}
