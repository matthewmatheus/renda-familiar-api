package br.com.rfapi.rendafamiliarapi.controller;


import br.com.rfapi.rendafamiliarapi.infra.ReceitasRepository;
import br.com.rfapi.rendafamiliarapi.model.Receita;
import br.com.rfapi.rendafamiliarapi.service.DadosCadastraisReceitas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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

}
