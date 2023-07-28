package com.example.bstprcts.config;

import com.example.bstprcts.entity.ApplicationUser;
import com.example.bstprcts.exception.UserNotFoundException;
import com.example.bstprcts.repo.ApplicationUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ApplicationUserRepo applicationUserRepo;

    @Bean
    public UserDetailsService userDetailsService(){

        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                Optional<ApplicationUser> applicationUser = applicationUserRepo.findByUsername(username);
                ApplicationUser applicationUser1 = applicationUser.get();
                if(!applicationUser.isPresent()){
                    System.out.println("user not found");
                    throw new UserNotFoundException();
                }
                Collection<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
                simpleGrantedAuthorities.add(new SimpleGrantedAuthority(applicationUser1.getRole()));
                return new User(
                        applicationUser1.getUsername(),
                        applicationUser1.getPassword(),
                        simpleGrantedAuthorities
                );
            }
        };
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
        return daoAuthenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
