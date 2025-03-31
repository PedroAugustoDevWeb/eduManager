package app.edumanager.controllers.ControllerAuth.dto;

import app.edumanager.models.enums.TipoUsuario;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    
    private String email;

    private String password;


}
