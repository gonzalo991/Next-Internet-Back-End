package Next.Internet.Security.Service;

import Next.Internet.Security.Entity.Rol;
import Next.Internet.Security.Enums.RolNombre;
import Next.Internet.Security.Repository.RolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByNombre(RolNombre rolNombre) {
        return rolRepository.findByRolNombre(rolNombre);
    }
}
