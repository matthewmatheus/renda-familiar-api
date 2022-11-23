package br.com.rfapi.rendafamiliarapi.controller;


import br.com.rfapi.rendafamiliarapi.infra.exceptions.DespesaNaoEncontradaException;
import br.com.rfapi.rendafamiliarapi.infra.DespesasRepository;
import br.com.rfapi.rendafamiliarapi.infra.exceptions.ReceitaNaoEncontradaException;
import br.com.rfapi.rendafamiliarapi.model.Despesa;
import br.com.rfapi.rendafamiliarapi.model.Receita;
import br.com.rfapi.rendafamiliarapi.service.DadosCadastraisDespesas;
import br.com.rfapi.rendafamiliarapi.service.DadosListagemDespesas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLNonTransientException;
import java.util.List;

@RestController
@RequestMapping("despesas")
public class DespesaController {

    @Autowired
    private DespesasRepository repository;


    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastraisDespesas dados) {

        try {
            repository.save(new Despesa(dados));
        } catch (Exception e) {
            repository.save(new Despesa(dados));
        }


    }

    @GetMapping
    public Page<DadosListagemDespesas> listarDespesa(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemDespesas::new);
    }

    @GetMapping("/{id}")
    public Despesa detalharDespesa(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new DespesaNaoEncontradaException(id));

    }

    @PutMapping("/{id}")
    public Despesa atualizar(@RequestBody Despesa novaDespesa, @PathVariable Long id) {

        return repository.findById(id).map(receita -> {
                    receita.setDescricao(novaDespesa.getDescricao());
                    receita.setValor(novaDespesa.getValor());
                    receita.setData(novaDespesa.getData());
                    receita.setCategoria(novaDespesa.getCategoria());
                    return repository.save(receita);
                })
                .orElseGet(() -> {
                    novaDespesa.setDespesa_id(id);
                    return repository.save(novaDespesa);
                });
    }


    @DeleteMapping("/{id}")
    void excluirDespesa(@PathVariable Long id) {
        repository.deleteById(id);

    }


}


