package br.com.rfapi.rendafamiliarapi.infra;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.naming.Context;

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
