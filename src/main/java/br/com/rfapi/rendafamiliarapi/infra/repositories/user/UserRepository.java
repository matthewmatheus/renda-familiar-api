package br.com.rfapi.rendafamiliarapi.infra.repositories.user;

import br.com.rfapi.rendafamiliarapi.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findByUsername(String username);

    @Query("SELECT u FROM User u JOIN FETCH u.roles where u.username = :username ")
    User findByUserNameFetchRoles(@Param("username") String username);

}
