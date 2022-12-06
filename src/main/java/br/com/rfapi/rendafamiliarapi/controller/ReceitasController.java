package br.com.rfapi.rendafamiliarapi.controller;


import br.com.rfapi.rendafamiliarapi.infra.exceptions.ReceitaNaoEncontradaException;
import br.com.rfapi.rendafamiliarapi.infra.repo.ReceitasCustomRepository;
import br.com.rfapi.rendafamiliarapi.infra.repo.ReceitasRepository;
import br.com.rfapi.rendafamiliarapi.model.Receita;
import br.com.rfapi.rendafamiliarapi.service.DadosCadastraisReceitas;
import br.com.rfapi.rendafamiliarapi.service.DadosListagemReceita;
import br.com.rfapi.rendafamiliarapi.service.ReceitasService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("receitas")
public class ReceitasController {

    @Autowired
    private ReceitasRepository repository;

    private ReceitasService receitasService;
    private ReceitasCustomRepository receitasCustomRepository;

    public ReceitasController(ReceitasService receitasService) {
        this.receitasService = receitasService;
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastraisReceitas dados) {

        repository.save(new Receita(dados));

    }


    @GetMapping
    public Page<DadosListagemReceita> listar(@PageableDefault(size = 10, page = 0, sort = {"descricao"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemReceita::new);

//      old ->  return repository.findAll(paginacao).stream().map(DadosListagemReceita::new).toList();
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

//        @GetMapping(params = "data")
//        public ResponseEntity<List<Receita>> buscarData(@RequestParam("data") @DateTimeFormat( pattern = "yyyy/MM/dd",iso = DateTimeFormat.ISO.NONE) LocalDate data) {
//        return ResponseEntity.ok(receitasService.buscarData(data));
//    }

//    @RequestMapping(method = RequestMethod.GET, value = "/receitas/{ano}/{mes}")
    @GetMapping("/{ano}/{mes}")
    public List<Receita> findByData(@PathVariable("ano") String ano, @PathVariable("mes") String mes) {

        List<Receita> date = receitasService.findByData(ano, mes);
        return date;

    }


}



