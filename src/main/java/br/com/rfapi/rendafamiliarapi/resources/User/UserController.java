package br.com.rfapi.rendafamiliarapi.resources.User;

import br.com.rfapi.rendafamiliarapi.domain.user.User;
import br.com.rfapi.rendafamiliarapi.domain.user.dto.CreateUserRoleDTO;
import br.com.rfapi.rendafamiliarapi.services.user.CreateRoleUserService;
import br.com.rfapi.rendafamiliarapi.services.user.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    CreateUserService createUserService;

    @Autowired
    CreateRoleUserService createRoleUserService;

    @PostMapping("/create")
    public User create (@RequestBody User user) {
        return createUserService.execute(user);

    }


    @PostMapping("/role")
    public User role(@RequestBody CreateUserRoleDTO createUserRoleDTO) {
        return createRoleUserService.execute(createUserRoleDTO);
    }




}
