package br.com.rfapi.rendafamiliarapi.infra.repo;

import br.com.rfapi.rendafamiliarapi.model.Receita;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ReceitasCustomRepository {


    private final EntityManager em;


    public ReceitasCustomRepository(EntityManager em) {
        this.em = em;
    }

    public List<Receita> buscar(String descricao, String data) {


        String query = "SELECT d FROM Receita d WHERE d.";


        if (data != null) {
            query += "data LIKE CONCAT ('%',:data,'%')";
        }

        if (descricao != null) {
            query += "descricao LIKE CONCAT('%',:descricao,'%')";
        }


        var q = em.createQuery(query, Receita.class);

        return q.getResultList();
    }

}
