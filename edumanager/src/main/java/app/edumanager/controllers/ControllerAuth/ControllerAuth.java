package app.edumanager.controllers.ControllerAuth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.edumanager.controllers.ControllerAuth.dto.RegisterDTO;
import app.edumanager.services.AuthService;
import app.edumanager.services.JwtService;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/auth")
public class ControllerAuth {

    @Autowired
    private AuthService authService;



    @PostMapping("/register")
    public void Register(@RequestBody RegisterDTO registerDTO) {

        authService.register(registerDTO);



    }

    @PostMapping("/login") 
    public String login(@RequestBody RegisterDTO registerDTO) {

        return authService.login(registerDTO);        

    }
    
    
}
