package Next.Internet.Security.Dao;


import com.sun.istack.NotNull;
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

    public NuevoUsuario(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }
    
    

}
