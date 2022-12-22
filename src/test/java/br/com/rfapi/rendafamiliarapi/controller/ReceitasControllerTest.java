package br.com.rfapi.rendafamiliarapi.controller;

import br.com.rfapi.rendafamiliarapi.infra.repo.ReceitasRepository;
import br.com.rfapi.rendafamiliarapi.model.Receita;
import br.com.rfapi.rendafamiliarapi.service.CadastroReceitasDTO;
import br.com.rfapi.rendafamiliarapi.service.ReceitasService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ReceitasControllerTest {


    private static final String descricao = "Receita Test 1";
    private static final Long receita_id = 1L;
    private static final int valor = 5500;
    private static final LocalDate data = LocalDate.of(2005, 05, 06);

    private static final int ano = data.getYear();
    private static final int mes = data.getMonthValue();

private Receita receita;
private CadastroReceitasDTO receitasDTO;





    @InjectMocks
    private ReceitasController controller;

    @Mock
    private ReceitasRepository repository;
    @Mock
    private ReceitasService receitasService;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        startReceita();
    }


    @Test
    void cadastrar() {


    }

    @Test
    void listar() {

    }

    @Test
    void detalharReceita() {

    }

    @Test
    void atualizar() {

    }

    @Test
    void excluirReceita() {

    }

    @Test
    void buscarDescricao() {

    }

    @Test
    void findByData() {

    }


    private void startReceita() {
        receitasDTO = new CadastroReceitasDTO(descricao, valor, data, ano, mes);
        receita = new Receita(receitasDTO);
    }
}