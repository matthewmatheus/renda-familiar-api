package br.com.rfapi.rendafamiliarapi.controller.User;

import br.com.rfapi.rendafamiliarapi.model.user.User;
import br.com.rfapi.rendafamiliarapi.model.user.dto.CreateUserRoleDTO;
import br.com.rfapi.rendafamiliarapi.services.CreateRoleUserService;
import br.com.rfapi.rendafamiliarapi.services.CreateUserService;
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
