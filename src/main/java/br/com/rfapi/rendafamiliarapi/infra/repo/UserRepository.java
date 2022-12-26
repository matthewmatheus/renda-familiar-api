package br.com.rfapi.rendafamiliarapi.infra.repo;

import br.com.rfapi.rendafamiliarapi.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findByUsername(String username);

}
