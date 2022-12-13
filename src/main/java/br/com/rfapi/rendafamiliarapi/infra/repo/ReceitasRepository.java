package br.com.rfapi.rendafamiliarapi.infra.repo;

import br.com.rfapi.rendafamiliarapi.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReceitasRepository extends JpaRepository<Receita, Long> {


    @Query(value = "SELECT d FROM Receita d WHERE " +
            "d.descricao LIKE CONCAT('%',:descricao,'%')")
    List<Receita> buscarDescricao(String descricao);

    @Query(value = "SELECT * FROM receitas d WHERE " +
            "d.descricao LIKE CONCAT('%',:descricao,'%')", nativeQuery = true)
    List<Receita> buscaDescricao(String descricao);

    @Query(value = "SELECT r FROM Receita r WHERE r.ano = :ano and r.mes = :mes")
    List<Receita> findByData(String ano, String mes);


    @Query(value = "SELECT SUM(R.valor) AS TOTAL_RECEITAS FROM Receita R WHERE R.ano = :ano and R.mes = :mes")
    Receita somarValorReceitas(String ano, String mes);

    @Query(value = "SELECT SUM(r.valor) - SUM(d.valor) AS saldo_final_mes FROM receitas,despesas WHERE r.ano = :ano and r.mes =:mes and d.ano = :ano and d.mes", nativeQuery = true)
        Receita descontarDespesas(String ano, String mes);
}

