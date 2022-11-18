package br.com.rfapi.rendafamiliarapi.infra;

import br.com.rfapi.rendafamiliarapi.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@Repository
public interface ReceitasRepository extends JpaRepository<Receita, Long> {




}
