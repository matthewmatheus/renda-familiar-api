package br.com.rfapi.rendafamiliarapi.infrastructure.exceptions;

public class ReceitaNaoEncontradaException extends RuntimeException {
    public ReceitaNaoEncontradaException(Long id) {
        super("Nao foi possivel achar a receita de id " + id);
    }
}
