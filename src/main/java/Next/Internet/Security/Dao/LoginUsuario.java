package Next.Internet.Security.Dao;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class LoginUsuario {

    @Getter
    @Setter
    @Email
    private String email;

    @Getter
    @Setter
    @NotBlank
    private String password;
}
