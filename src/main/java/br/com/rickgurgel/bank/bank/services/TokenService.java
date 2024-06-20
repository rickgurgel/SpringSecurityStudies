package br.com.rickgurgel.bank.bank.services;

import br.com.rickgurgel.bank.bank.entities.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(user.getUsername())
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);
        } catch(JWTCreationException exception){
            throw new RuntimeException("Error generating token", exception);
        }
    }

    public String validateToken(String token){
        JWTVerifier verifier;
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);

            verifier = JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build();

            return verifier.verify(token).getSubject();
        } catch(JWTVerificationException exception){
            throw new RuntimeException("Error validating token", exception);
        }
    }

    private Instant genExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
