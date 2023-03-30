package br.com.rfapi.rendafamiliarapi.services.user;


import br.com.rfapi.rendafamiliarapi.infrastructure.repositories.user.UserRepository;
import br.com.rfapi.rendafamiliarapi.domain.user.Role;
import br.com.rfapi.rendafamiliarapi.domain.user.User;
import br.com.rfapi.rendafamiliarapi.domain.user.dto.CreateUserRoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CreateRoleUserService {

    @Autowired
    UserRepository userRepository;

    public User execute(CreateUserRoleDTO createUserRoleDTO) {

        Optional<User> userExists = userRepository.findById(createUserRoleDTO.getIdUser());
        List<Role> roles = new ArrayList<>();

        if (userExists.isEmpty()) {
            throw new Error("User with such id does not exists!");
        }

        roles = createUserRoleDTO.getIdsRoles().stream().map(role -> {
            return new Role(role);
        }).collect(Collectors.toList());

        User user = userExists.get();

        user.setRoles(roles);

        userRepository.save(user);

        return user;
    }

}
