package app.edumanager.controllers.controllerAuth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.edumanager.controllers.controllerAuth.dto.RegisterDTO;
import app.edumanager.services.AuthService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PostMapping("/validate/{token}")
    public String validate(@PathVariable String token) {
        return authService.validate(token);
    }
    
    
    
}
