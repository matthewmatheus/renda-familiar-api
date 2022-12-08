//package br.com.rfapi.rendafamiliarapi.dao;
//
//import br.com.rfapi.rendafamiliarapi.model.Resumo;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//import java.util.List;
//
//
//@AllArgsConstructor
//@Service
//public class ResumoDao {
//
//private EntityManager em;
//
//
//public List<Resumo> resumo(String ano, String mes) {
//
//    String jpql = "SELECT SUM(r.valor) AS total_receitas, SUM(d.valor) AS total_despesas, SUM(r.valor) - SUM(d.valor) AS saldo_final " +
//             "FROM Receita r, Despesa d WHERE d.ano = :ano and d.mes = :mes GROUP BY d.categoria ";
//
//    Query query = em.createQuery(jpql);
//    List resultList = query.getResultList();
//    return resultList;
//
//}
//
//
//}
