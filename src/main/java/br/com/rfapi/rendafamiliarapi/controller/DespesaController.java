package br.com.rfapi.rendafamiliarapi.controller;


import br.com.rfapi.rendafamiliarapi.infra.DespesasRepository;
import br.com.rfapi.rendafamiliarapi.model.Despesa;
import br.com.rfapi.rendafamiliarapi.service.DadosCadastraisDespesas;
import br.com.rfapi.rendafamiliarapi.service.DadosListagemDespesas;
import br.com.rfapi.rendafamiliarapi.service.DadosListagemReceita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping
    public List<DadosListagemDespesas> listar() {
        return repository.findAll().stream().map(DadosListagemDespesas::new).toList();
    }




}


