package br.com.rfapi.rendafamiliarapi.resources.Receita;


import br.com.rfapi.rendafamiliarapi.infrastructure.exceptions.ReceitaNaoEncontradaException;
import br.com.rfapi.rendafamiliarapi.infrastructure.repositories.receita.ReceitasRepository;
import br.com.rfapi.rendafamiliarapi.domain.receita.Receita;
import br.com.rfapi.rendafamiliarapi.domain.receita.dto.ReceitasDTO;
import br.com.rfapi.rendafamiliarapi.services.receita.ReceitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("receitas")
public class ReceitasResource {

    @Autowired
    private ReceitasRepository repository;


    private ReceitasService receitasService;


    public ReceitasResource(ReceitasService receitasService) {
        this.receitasService = receitasService;
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping
    @Transactional
    public ResponseEntity<Receita> cadastrar(@RequestBody ReceitasDTO dados) {
        return ResponseEntity.ok(repository.save(new Receita(dados)));
    }


    @PreAuthorize("hasRole('USER')")
    @GetMapping
    public ResponseEntity<List<Receita>> listar() {
        return ResponseEntity.ok().body(receitasService.findAll());
    }


    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Receita> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(repository.findById(id).orElseThrow(() -> new ReceitaNaoEncontradaException(id)));
    }


    @PreAuthorize("hasRole('USER')")
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


    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/{id}")
    public void excluirReceita(@PathVariable Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(params = "descricao")
    public ResponseEntity<List<Receita>> buscarDescricao(@RequestParam("descricao") String descricao) {
        return ResponseEntity.ok(receitasService.buscarDescricao(descricao));
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{ano}/{mes}")
    public List<Receita> findByData(@PathVariable("ano") int ano, @PathVariable("mes") int mes) {
        List<Receita> date = receitasService.findByData(ano, mes);
        return date;

    }


}



