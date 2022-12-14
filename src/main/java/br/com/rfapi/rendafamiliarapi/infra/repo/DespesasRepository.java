package br.com.rfapi.rendafamiliarapi.infra.repo;

import br.com.rfapi.rendafamiliarapi.model.Despesa;
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
    List<Despesa> findByData(String ano, String mes);

    @Query(value = "SELECT SUM(d.valor) AS total_despesas FROM despesas d WHERE d.ano = :ano and d.mes = :mes ",nativeQuery = true)
    Despesa somarValorDespesas(String ano, String mes);

    @Query(value = "SELECT SUM(d.valor) AS total_despesas from despesas d WHERE d.ano = :ano and d.mes = :mes  GROUP BY d.categoria", nativeQuery = true)
   List<Despesa> somarDespesasPorCategoria(String ano, String mes);
}


