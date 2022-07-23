package Next.Internet.Security.Repository;

import Next.Internet.Security.Entity.Rol;
import Next.Internet.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Integer> {

   Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
