package Next.Internet.Security.Dao;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


public class NuevoUsuario {

        /*id, nombre,nombreUsuario, email, password, domicilio, dni, telefono, miplan*/

    @NotBlank
    @Getter @Setter
    private String nombre;
   
    @NotBlank
    @Getter @Setter
    private String nombreUsuario;

    @Email
    @Getter @Setter
    private String email;

    @NotBlank
    @Getter @Setter
    private String password;

    @NotBlank
    @Getter @Setter
    private String domicilio;
    
    @NotBlank
    @Getter @Setter
    private String dni;
    
    @NotBlank
    @Getter @Setter
    private String telefono;
    
    @NotBlank
    @Getter @Setter
    private String miPlan;
    
    
    @Getter @Setter
    private Set<String> roles = new HashSet<>();

    public NuevoUsuario() {
    }

    public NuevoUsuario(String nombre, String nombreUsuario, String email, String password, String domicilio, String dni, String telefono,String miPlan) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.domicilio = domicilio;
        this.dni = dni;
        this.telefono = telefono;
        this.miPlan = miPlan;
    }

   

   
    
    

}
