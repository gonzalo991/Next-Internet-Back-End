package Next.Internet.Security.Dao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

public class NuevoUsuario {

    @Getter
    @Setter
    @NotBlank
    private String nombre;

    @Getter
    @Setter
    @Email
    private String email;

    @Getter
    @Setter
    @NotBlank
    private String password;
    private Set<String> roles = new HashSet<>();
    
}
