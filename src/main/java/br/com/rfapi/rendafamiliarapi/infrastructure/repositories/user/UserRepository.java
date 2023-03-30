package br.com.rfapi.rendafamiliarapi.infrastructure.repositories.user;

import br.com.rfapi.rendafamiliarapi.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findByUsername(String username);

    @Query("SELECT u FROM User u JOIN FETCH u.roles where u.username = :username ")
    User findByUserNameFetchRoles(@Param("username") String username);

}
