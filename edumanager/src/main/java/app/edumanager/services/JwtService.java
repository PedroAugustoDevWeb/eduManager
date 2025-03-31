package app.edumanager.services;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import app.edumanager.models.enums.TipoUsuario;

@Service
public class JwtService {

    private static final String SECRET_KEY = "sadsadsa";

    private static final String ISSUER = "api-gestao-escolar";

    private static final long EXPIRATION_TIME = 604800000; // 7 dias


    public String genereteToken(String email, TipoUsuario role) throws IllegalArgumentException, JWTCreationException, UnsupportedEncodingException {
    
     return JWT.create()
            .withSubject(email)
            .withIssuer(ISSUER)
            .withClaim("role", role.name())
            .withIssuedAt(new Date())
            .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .sign(Algorithm.HMAC256(SECRET_KEY));
    }

    public String validateToken(String token) {

        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SECRET_KEY))
                                            .withIssuer(ISSUER)
                                            .build();   
                                            
            DecodedJWT decodedJWT = jwtVerifier.verify(token);

            return decodedJWT.getSubject();

        } catch (Exception e) {

            return null;

        }

    }

    
}