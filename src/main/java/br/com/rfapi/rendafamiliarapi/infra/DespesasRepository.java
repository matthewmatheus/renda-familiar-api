package br.com.rfapi.rendafamiliarapi.infra;

import br.com.rfapi.rendafamiliarapi.model.Despesa;
import br.com.rfapi.rendafamiliarapi.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DespesasRepository extends JpaRepository<Despesa, Long> {



    @Query(value = "SELECT d FROM Despesa d WHERE " +
            "d.descricao LIKE CONCAT('%',:descricao,'%')")
    List<Despesa> buscarDescricao(String descricao);

    @Query(value = "SELECT * FROM despesas d WHERE " +
            "d.descricao LIKE CONCAT('%',:descricao,'%')", nativeQuery = true)
    List<Despesa> buscaDescricao(String descricao);

}
