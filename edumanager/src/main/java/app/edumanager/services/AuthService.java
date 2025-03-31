package app.edumanager.services;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.jwt.exceptions.JWTCreationException;

import app.edumanager.controllers.ControllerAuth.dto.RegisterDTO;
import app.edumanager.models.User;
import app.edumanager.repositorys.UserRepository;

@Service
public class AuthService {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository repository;
    
    public void register(RegisterDTO registerDTO) {

        User user = new User();

        user.setEmail(registerDTO.getEmail());

        user.setName(registerDTO.getName());

        user.setPassword(registerDTO.getPassword());

        user.setRole(registerDTO.getRole());

        repository.save(user);


    }

    public String login(RegisterDTO registerDTO) {
        try {
            
            if (repository.findByEmail(registerDTO.getEmail()) == null) {

                throw new RuntimeException("Usuario nao encontrado");

            }

            if (!repository.findByEmail(registerDTO.getEmail()).getPassword().equals(registerDTO.getPassword())) {

                throw new RuntimeException("password incorrect");

            }

            return jwtService.genereteToken(registerDTO.getEmail(), registerDTO.getRole());

        } catch (IllegalArgumentException | JWTCreationException | UnsupportedEncodingException e) {

            throw new RuntimeException(e.getMessage());

        }
    }

}
