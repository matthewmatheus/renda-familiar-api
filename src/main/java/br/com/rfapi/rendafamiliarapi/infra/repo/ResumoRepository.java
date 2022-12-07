package br.com.rfapi.rendafamiliarapi.infra.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumoRepository extends JpaRepository<Object, Long> {


    @Query(value = "SELECT SUM(r.valor), SUM(d.valor), MAX(r.valor) - MAX(d.valor) FROM receitas r, despesas d WHERE d.ano = :ano and d.mes = :mes", nativeQuery = true)
    List<Object> fazerResumo(String ano, String mes);
}
