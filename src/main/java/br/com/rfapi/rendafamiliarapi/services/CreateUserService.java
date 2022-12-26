package br.com.rfapi.rendafamiliarapi.services;


import br.com.rfapi.rendafamiliarapi.infra.repo.UserRepository;
import br.com.rfapi.rendafamiliarapi.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateUserService {

    @Autowired
    UserRepository userRepository;


    public User execute(User user) {

        User existsUser = userRepository.findByUsername (user.getUsername());

        if(existsUser != null) {
            throw new Error("User already exists!");
        }

        User createdUser = userRepository.save(user);

        return createdUser;
}}
