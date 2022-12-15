package br.com.rfapi.rendafamiliarapi.controller;


import br.com.rfapi.rendafamiliarapi.infra.exceptions.DespesaNaoEncontradaException;
import br.com.rfapi.rendafamiliarapi.infra.repo.DespesasRepository;
import br.com.rfapi.rendafamiliarapi.model.Despesa;
import br.com.rfapi.rendafamiliarapi.model.Receita;
import br.com.rfapi.rendafamiliarapi.service.DadosCadastraisDespesas;
import br.com.rfapi.rendafamiliarapi.service.DadosListagemDespesas;
import br.com.rfapi.rendafamiliarapi.service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("despesas")
public class DespesaController {

    @Autowired
    private DespesasRepository repository;
    private DespesaService despesaService;


    public DespesaController(DespesaService despesaService) {
        this.despesaService = despesaService;
    }

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

    @GetMapping(params = "descricao")
    public ResponseEntity<List<Despesa>> buscarDescricao(@RequestParam("descricao") String descricao) {
        return ResponseEntity.ok(despesaService.buscarDescricao(descricao));
    }


    @GetMapping("/{ano}/{mes}")
    public List<Despesa> findByData(@PathVariable("ano") int ano, @PathVariable("mes") int mes) {

        List<Despesa> date = despesaService.findByData(ano, mes);
        return date;

    }






}


