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

    /*id, nombre, domicilio, dni, telefono, email, miplan*/
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

    @Getter
    @Setter
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    public Usuario() {
    }

    public Usuario(String nombre, String nombreUsuario, String email, String password) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
    }


}
