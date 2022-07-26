package Next.Internet.Security.Entity;

import com.sun.istack.NotNull;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Usuario {

    /*id, nombre,nombreUsuario, email, password, domicilio, dni, telefono, miplan*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Getter
    @Setter
    private String nombre;

    @NotNull
    @Column(unique = true)
    @Getter
    @Setter
    private String nombreUsuario;

    @NotNull
    @Getter
    @Setter
    private String email;

    @NotNull
    @Getter
    @Setter
    private String password;

    @NotNull
    @Getter
    @Setter
    private String domicilio;

    @NotNull
    @Getter
    @Setter
    private String dni;

    @NotNull
    @Getter
    @Setter
    private String telefono;
    
    private String miplan;

    @Getter
    @Setter
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_id", joinColumns = @JoinColumn(name = "usuario_mi_plan"),
            inverseJoinColumns = @JoinColumn(name = "plan_id"))
    private Set<Rol> roles = new HashSet<>();

    public Usuario() {
    }

    public Usuario(String nombre, String nombreUsuario, String email, String password, String domicilio, String dni, String telefono, String miplan) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.domicilio = domicilio;
        this.dni = dni;
        this.telefono = telefono;
        this.miplan = miplan;
    }

}
