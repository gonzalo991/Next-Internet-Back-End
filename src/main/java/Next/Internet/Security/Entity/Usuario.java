package Next.Internet.Security.Entity;

import com.sun.istack.NotNull;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
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

    @NotNull
    @Column(unique = true)
    @Getter
    @Setter
    private String email;

    @NotNull
    @Getter
    @Setter
    private String miplan;

    @Getter
    @Setter
    @ManyToMany
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    public Usuario() {
    }

    public Usuario(String nombre, String domicilio, String dni, String telefono, String email, String miplan) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.miplan = miplan;
    }

    
    
}
