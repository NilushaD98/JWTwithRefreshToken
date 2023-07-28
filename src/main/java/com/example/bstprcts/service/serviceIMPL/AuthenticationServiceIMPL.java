package com.example.bstprcts.service.serviceIMPL;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.bstprcts.dto.request.RequestAuthenticatDTO;
import com.example.bstprcts.dto.response.ResponseAuthenticationSuccessDTO;
import com.example.bstprcts.entity.ApplicationUser;
import com.example.bstprcts.repo.ApplicationUserRepo;
import com.example.bstprcts.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceIMPL implements AuthenticationService {

    private final ApplicationUserRepo applicationUserRepo;
    private final AuthenticationManager authenticationManager;
    @Override
    public ResponseAuthenticationSuccessDTO authenticate(RequestAuthenticatDTO requestAuthenticatDTO) {
       Optional<ApplicationUser> applicationUser =  applicationUserRepo.findByUsername(requestAuthenticatDTO.getUsername());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        requestAuthenticatDTO.getUsername(),
                        requestAuthenticatDTO.getPassword()
                )
        );
        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
        ApplicationUser applicationUser1 = applicationUser.get();
        String access_token = JWT.create()
                .withSubject(applicationUser1.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 24*60*60*1000))
                .withIssuer("/api/v1/authentication")
                .withClaim("roles",applicationUser1.getRole())
                .sign(algorithm);

        String refresh_token = JWT.create()
                .withSubject(applicationUser1.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 24*60*60*1000))
                .withClaim("roles",applicationUser1.getRole())
                .sign(algorithm);

        return new ResponseAuthenticationSuccessDTO(
                access_token,
                refresh_token
        );
    }
}
