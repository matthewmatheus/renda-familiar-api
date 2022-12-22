package br.com.rfapi.rendafamiliarapi.controller;


import br.com.rfapi.rendafamiliarapi.infra.exceptions.ReceitaNaoEncontradaException;
import br.com.rfapi.rendafamiliarapi.infra.repo.ReceitasRepository;
import br.com.rfapi.rendafamiliarapi.model.Receita;
import br.com.rfapi.rendafamiliarapi.service.CadastroReceitasDTO;
import br.com.rfapi.rendafamiliarapi.service.ListagemReceitasDTO;
import br.com.rfapi.rendafamiliarapi.service.ReceitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("receitas")
public class ReceitasController {

    @Autowired
    private ReceitasRepository repository;



    private ReceitasService receitasService;

    public ReceitasController(ReceitasService receitasService) {
        this.receitasService = receitasService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Receita> cadastrar(@RequestBody CadastroReceitasDTO dados) {

       return ResponseEntity.ok(repository.save(new Receita(dados)));

    }


    @GetMapping
    public ResponseEntity<Page<ListagemReceitasDTO>> listar(@PageableDefault(size = 10, page = 0, sort = {"descricao"}) Pageable paginacao) {

        return ResponseEntity.ok().body(repository.findAll(paginacao).map(ListagemReceitasDTO::new));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Receita> findById(@PathVariable Long id) {

        return ResponseEntity.ok().body(repository.findById(id).orElseThrow(() -> new ReceitaNaoEncontradaException(id)));



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
                    novaReceita.setReceita_id(id);
                    return repository.save(novaReceita);
                });
    }

    @DeleteMapping("/{id}")
    void excluirReceita(@PathVariable Long id) {

        repository.deleteById(id);

    }

    @GetMapping(params = "descricao")
    public ResponseEntity<List<Receita>> buscarDescricao(@RequestParam("descricao") String descricao) {
        return ResponseEntity.ok(receitasService.buscarDescricao(descricao));
    }

    @GetMapping("/{ano}/{mes}")
    public List<Receita> findByData(@PathVariable("ano") int ano, @PathVariable("mes") int mes) {

        List<Receita> date = receitasService.findByData(ano, mes);
        return date;

    }


}



