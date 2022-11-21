package br.com.rfapi.rendafamiliarapi.infra;

public class DespesaNaoEncontradaException extends RuntimeException {
    public DespesaNaoEncontradaException(Long id) {

        super("Nao foi possivel encontrar a despesa de id " + id );

    }
}
