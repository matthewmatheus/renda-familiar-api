package br.com.rfapi.rendafamiliarapi.controller;


import br.com.rfapi.rendafamiliarapi.infra.ReceitasRepository;
import br.com.rfapi.rendafamiliarapi.model.Receita;
import br.com.rfapi.rendafamiliarapi.service.DadosCadastraisReceitas;
import br.com.rfapi.rendafamiliarapi.service.DadosListagemReceita;
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
    public void cadastrar(@RequestBody  DadosCadastraisReceitas dados) {

        repository.save(new Receita(dados));

    }


    @GetMapping
    public List<DadosListagemReceita> listar() {
        return repository.findAll().stream().map(DadosListagemReceita::new).toList();
    }

}
