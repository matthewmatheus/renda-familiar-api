package br.com.rfapi.rendafamiliarapi.infra.repo;

import br.com.rfapi.rendafamiliarapi.model.Resumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumoRepository extends JpaRepository<Resumo, Long> {


    @Query(value = "SELECT SUM(r.valor) AS total_receitas, SUM(d.valor) AS total_despesas, SUM(r.valor) - SUM(d.valor) AS saldo_final" +
            " FROM receitas r, despesas d WHERE d.ano = :ano and d.mes = :mes GROUP BY d.categoria", nativeQuery = true)
    List<Resumo> fazerResumo(String ano, String mes);
}
