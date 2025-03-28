package app.edumanager.controllers.ControllerAuth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    
    private Long id;

    private String name;

    private String email;

    private String password;


}
