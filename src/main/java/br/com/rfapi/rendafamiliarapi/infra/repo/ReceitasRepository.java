package br.com.rfapi.rendafamiliarapi.infra.repo;

import br.com.rfapi.rendafamiliarapi.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.List;


@Repository
public interface ReceitasRepository extends JpaRepository<Receita, Long> {



    @Query(value = "SELECT d FROM Receita d WHERE " +
            "d.descricao LIKE CONCAT('%',:descricao,'%')")
    List<Receita> buscarDescricao(String descricao);

    @Query(value = "SELECT * FROM receitas d WHERE " +
            "d.descricao LIKE CONCAT('%',:descricao,'%')", nativeQuery = true)
    List<Receita> buscaDescricao(String descricao);


//    @Query(value = "SELECT d FROM Receita d WHERE d.data LIKE CONCAT ('%',:data,'%')")
//    List<Receita> buscarData(LocalDate data);

//    @Query(value = "SELECT d FROM Receita d WHERE d.data LIKE CONCAT ('%',:data,'%')")


    @Query(value = "SELECT d FROM Receita d WHERE d.data LIKE CONCAT ('%',:ano,'%') and d.LIKE CONCAT ('%',:mes,'%')")
    List<Receita> findByData(String ano, String mes);
}
