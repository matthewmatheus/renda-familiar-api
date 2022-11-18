package br.com.rfapi.rendafamiliarapi.infra;

import br.com.rfapi.rendafamiliarapi.model.Despesas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesasRepository extends JpaRepository<Despesas, Long> {




}
