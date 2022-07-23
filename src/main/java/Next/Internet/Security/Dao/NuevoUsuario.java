package Next.Internet.Security.Dao;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private String nombreUsuario;

    @Getter
    @Setter
    @Email
    private String email;

    @Getter
    @Setter
    @NotBlank
    private String password;

    @Getter
    @Setter
    private Set<String> roles = new HashSet<>();

    public NuevoUsuario() {
    }

    public NuevoUsuario(String nombre,String nombreUsuario, String email, String password) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
    }
    
    

}
