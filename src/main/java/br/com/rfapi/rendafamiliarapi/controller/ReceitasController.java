package br.com.rfapi.rendafamiliarapi.controller;


import br.com.rfapi.rendafamiliarapi.infra.exceptions.ReceitaNaoEncontradaException;
import br.com.rfapi.rendafamiliarapi.infra.ReceitasRepository;
import br.com.rfapi.rendafamiliarapi.model.Receita;
import br.com.rfapi.rendafamiliarapi.service.DadosCadastraisReceitas;
import br.com.rfapi.rendafamiliarapi.service.DadosListagemReceita;
import com.electronwill.nightconfig.core.conversion.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("receitas")
public class ReceitasController {

    @Autowired
    private ReceitasRepository repository;


    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastraisReceitas dados) {

        repository.save(new Receita(dados));

    }


    @GetMapping
    public List<DadosListagemReceita> listar() {
        return repository.findAll().stream().map(DadosListagemReceita::new).toList();
    }

    @GetMapping("/{id}")
    public Receita detalharReceita(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ReceitaNaoEncontradaException(id));

    }

    @PutMapping("/{id}")
    public Receita atualizar(@RequestBody Receita novaReceita, @PathVariable Long id) {

        return repository.findById(id).map(receita -> {
                    receita.setDescricao(novaReceita.getDescricao());
                    receita.setValor(novaReceita.getValor());
                    receita.setData(novaReceita.getData());
                    return repository.save(receita);
                })
                .orElseGet(() -> {
                    novaReceita.setId(id);
                    return repository.save(novaReceita);
                });
    }


    @DeleteMapping("/{id}")
    void excluirReceita(@PathVariable Long id) {
        repository.deleteById(id);


    }

}



