package app.edumanager.services;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

@Service
public class JwtService {

    private static final String SECRET_KEY = "sadsadsa";

    private static final String ISSUER = "api-gestao-escolar";

    private static final long EXPIRATION_TIME = 604800000; // 7 dias


    public String genereteToken(String email, String role) {
        try {
            return JWT.create()
                    .withSubject(email)
                    .withIssuer(ISSUER)
                    .withClaim("role", role)
                    .withIssuedAt(new Date())
                    .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .sign(Algorithm.HMAC256(SECRET_KEY));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage()) ;
        }
    }
    
}
