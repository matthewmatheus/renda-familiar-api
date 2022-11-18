package br.com.rfapi.rendafamiliarapi.controller;


import br.com.rfapi.rendafamiliarapi.infra.DespesasRepository;
import br.com.rfapi.rendafamiliarapi.model.Despesa;
import br.com.rfapi.rendafamiliarapi.service.DadosCadastraisDespesas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("despesas")
public class DespesaController {

    @Autowired
    private DespesasRepository repository;


    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody  DadosCadastraisDespesas dados) {

        repository.save(new Despesa(dados));

    }


}


