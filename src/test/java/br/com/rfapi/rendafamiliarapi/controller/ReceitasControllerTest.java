package br.com.rfapi.rendafamiliarapi.controller;

import br.com.rfapi.rendafamiliarapi.infra.repo.ReceitasRepository;
import br.com.rfapi.rendafamiliarapi.model.Receita;
import br.com.rfapi.rendafamiliarapi.service.CadastroReceitasDTO;
import br.com.rfapi.rendafamiliarapi.service.ListagemReceitasDTO;
import br.com.rfapi.rendafamiliarapi.service.ReceitasService;
import org.hibernate.validator.constraints.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
class ReceitasControllerTest {


    private ModelMapper mapper;


    private static final String descricao = "Receita Test 1";
    private static final Long receita_id = 24L;
    private static final int valor = 5500;
    private static final LocalDate data = LocalDate.of(2005, 05, 06);
    private static final int ano = data.getYear();
    private static final int mes = data.getMonthValue();

    private Receita receita;

    private static final int INDEX = 0;

    @InjectMocks
    private ReceitasController controller;

    @Mock
    private ReceitasRepository repository;

    @Mock
    private ReceitasService receitasService;
    private CadastroReceitasDTO receitasDTO;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        startReceita();
    }


    @Test
    void whenCadastrarThenReturnOK() {

        when(repository.save(any())).thenReturn(receita);

        ResponseEntity<Receita> response = controller.cadastrar(receitasDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());

    }

    @Test
    void whenListarThenReturnListOfReceitasDTO() {
        Pageable page = Pageable.unpaged();
        Page<ListagemReceitasDTO> page1 = Page.empty();

        when(repository.findAll()).thenReturn(List.of(receita));

        ResponseEntity<Page<ListagemReceitasDTO>> response = controller.listar();


        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(ArrayList.class, response.getBody().getClass());

    }

    @Test
    void whenFindByIdThenReturnSuccess() {
        when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(receita));

        ResponseEntity<Receita> response = controller.findById(receita_id);
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(receita.getReceita_id(), response.getBody().getReceita_id());
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
        receitasDTO = new CadastroReceitasDTO(receita_id, descricao, valor, data, ano, mes);
        receita = new Receita(receitasDTO);

    }
}