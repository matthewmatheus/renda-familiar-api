package br.com.rfapi.rendafamiliarapi.controller;

import br.com.rfapi.rendafamiliarapi.infra.repo.ReceitasRepository;
import br.com.rfapi.rendafamiliarapi.model.Receita;
import br.com.rfapi.rendafamiliarapi.service.ReceitasDTO;
import br.com.rfapi.rendafamiliarapi.service.ListagemReceitasDTO;
import br.com.rfapi.rendafamiliarapi.service.ReceitasService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
class ReceitasControllerTest {


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
    private ReceitasDTO receitasDTO;
    private ListagemReceitasDTO listagemReceitasDTO;
    private Optional<Receita> optionalReceita;


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
    void whenListarThenReturnListOfReceitas() {


    }


    @Test
    void whenFindByIdThenReturnOK() {
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
    void deleteWithSuccess() {
        when(repository.findById(anyLong())).thenReturn(optionalReceita);
        doNothing().when(repository).deleteById(anyLong());

        controller.excluirReceita(receita_id);
        verify(repository, times(1)).deleteById(anyLong());




    }

    @Test
    void buscarDescricao() {

    }

    @Test
    void findByData() {

    }


    private void startReceita() {

        receitasDTO = new ReceitasDTO(receita_id, descricao, valor, data, ano, mes);
        receita = new Receita(receitasDTO);
        optionalReceita = Optional.of(new Receita(receitasDTO));

    }
}