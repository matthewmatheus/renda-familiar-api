package br.com.rfapi.rendafamiliarapi.infra;

import br.com.rfapi.rendafamiliarapi.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesasRepository extends JpaRepository<Despesa, Long> {




}
