package com.estudoDeCaso.shopp.useCases.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.estudoDeCaso.shopp.entities.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class GenerateTokenUseCase {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(Employee employee){
        try {
            Algorithm algorithm= Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("clouth-store")
                    .withSubject(employee.getEmail())
                    .withExpiresAt(this.generateExpirationDate())
                    .sign(algorithm);
            return token;
        }
        catch (JWTCreationException exception){
            throw new RuntimeException("Error while generate token");
        }
    }

    private Instant generateExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
