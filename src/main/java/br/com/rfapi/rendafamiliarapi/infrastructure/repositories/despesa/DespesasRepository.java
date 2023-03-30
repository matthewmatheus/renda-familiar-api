package br.com.rfapi.rendafamiliarapi.infrastructure.repositories.despesa;

import br.com.rfapi.rendafamiliarapi.domain.despesa.Despesa;
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

    @Query(value = "SELECT d FROM Despesa d WHERE d.ano = :ano and d.mes = :mes")
    List<Despesa> findByData(int ano, int mes);

    @Query(value = "SELECT SUM(D.valor) AS total_despesas FROM Despesa D WHERE D.ano = :ano and D.mes = :mes ")
    Long somarValorDespesas(int ano, int mes);

    @Query(value = "SELECT SUM(D.valor) AS total_despesas from Despesa D WHERE D.ano = :ano and D.mes = :mes GROUP BY D.categoria")
    List<Long> somarDespesasPorCategoria(int ano, int mes);

    
}


