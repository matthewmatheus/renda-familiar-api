package br.com.rfapi.rendafamiliarapi.controller;


import br.com.rfapi.rendafamiliarapi.service.DadosCadastraisReceitas;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("receitas")
public class ReceitasController {


    @PostMapping
    public void cadastrar(@RequestBody DadosCadastraisReceitas dados) {

        System.out.println(dados);
    }

}
