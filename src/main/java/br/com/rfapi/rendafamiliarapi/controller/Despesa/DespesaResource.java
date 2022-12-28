package br.com.rfapi.rendafamiliarapi.controller.Despesa;


import br.com.rfapi.rendafamiliarapi.infra.exceptions.DespesaNaoEncontradaException;
import br.com.rfapi.rendafamiliarapi.infra.repositories.despesa.DespesasRepository;
import br.com.rfapi.rendafamiliarapi.model.despesa.Despesa;
import br.com.rfapi.rendafamiliarapi.model.despesa.dto.DespesasDTO;
import br.com.rfapi.rendafamiliarapi.model.despesa.dto.ListagemDespesasDTO;
import br.com.rfapi.rendafamiliarapi.services.despesa.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("despesas")
public class DespesaResource {

    @Autowired
    private DespesasRepository repository;
    private DespesaService despesaService;


    public DespesaResource(DespesaService despesaService) {
        this.despesaService = despesaService;
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DespesasDTO dados) {

        try {
            repository.save(new Despesa(dados));
        } catch (Exception e) {
            repository.save(new Despesa(dados));
        }


    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping
    public Page<ListagemDespesasDTO> listarDespesa(Pageable paginacao) {
        return repository.findAll(paginacao).map(ListagemDespesasDTO::new);
    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    public Despesa detalharDespesa(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new DespesaNaoEncontradaException(id));

    }
    @PreAuthorize("hasRole('USER')")
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

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/{id}")
    void excluirDespesa(@PathVariable Long id) {
        repository.deleteById(id);

    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping(params = "descricao")
    public ResponseEntity<List<Despesa>> buscarDescricao(@RequestParam("descricao") String descricao) {
        return ResponseEntity.ok(despesaService.buscarDescricao(descricao));
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{ano}/{mes}")
    public List<Despesa> findByData(@PathVariable("ano") int ano, @PathVariable("mes") int mes) {

        List<Despesa> date = despesaService.findByData(ano, mes);
        return date;

    }






}


