package br.com.rfapi.rendafamiliarapi.services.user;


import br.com.rfapi.rendafamiliarapi.infrastructure.repositories.user.UserRepository;
import br.com.rfapi.rendafamiliarapi.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class CreateUserService {

    @Autowired
    UserRepository userRepository;


    private BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    public User execute(User user) {

        User existsUser = userRepository.findByUsername(user.getUsername());

        if(existsUser != null) {
            throw new Error("User already exists!");
        }


        user.setUsername(user.getUsername());
        user.setPassword(passwordEncoder().encode(user.getPassword()));


        User createdUser = userRepository.save(user);



        return createdUser;
}}
