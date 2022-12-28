package br.com.rfapi.rendafamiliarapi.authentication.security;

import br.com.rfapi.rendafamiliarapi.infra.repositories.user.UserRepository;
import br.com.rfapi.rendafamiliarapi.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User existsUser = userRepository.findByUserNameFetchRoles(username);

        if(existsUser == null) {
            throw new Error("User does not exists!");
        } else {
            return UserPrincipal.create(existsUser);
        }
    }
}
