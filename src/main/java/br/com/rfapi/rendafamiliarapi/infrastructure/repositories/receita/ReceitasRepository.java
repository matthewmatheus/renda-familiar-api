package br.com.rfapi.rendafamiliarapi.infrastructure.repositories.receita;

import br.com.rfapi.rendafamiliarapi.domain.receita.Receita;
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
    List<Receita> findByData(int ano, int mes);


    @Query(value = "SELECT SUM(R.valor) AS total_receitas FROM Receita R WHERE R.ano = :ano and R.mes = :mes")
   Long somarValorReceitas(int ano, int mes);

    @Query(value = "SELECT SUM(R.valor) - SUM(D.valor) AS saldo_final_mes FROM Receita R,Despesa D WHERE R.ano = :ano and R.mes =:mes and D.ano = :ano and D.mes = :mes")
        Long descontarDespesas(int ano, int mes);
}

