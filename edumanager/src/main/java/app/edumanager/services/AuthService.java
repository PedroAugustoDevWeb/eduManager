package app.edumanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.edumanager.controllers.ControllerAuth.dto.RegisterDTO;

@Service
public class AuthService {
    
    @Autowired
    private JwtService jwtService;

    public void register(RegisterDTO registerDTO) {
            
    }

}
