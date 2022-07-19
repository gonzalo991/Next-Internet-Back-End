package Next.Internet.Security.Controller;

import Next.Internet.Dao.Mensaje;
import Next.Internet.Security.Dao.JwtDao;
import Next.Internet.Security.Dao.LoginUsuario;
import Next.Internet.Security.Dao.NuevoUsuario;
import Next.Internet.Security.Entity.Rol;
import Next.Internet.Security.Entity.Usuario;
import Next.Internet.Security.Enums.RolNombre;
import Next.Internet.Security.Jwt.JwtProvider;
import Next.Internet.Security.Service.RolService;
import Next.Internet.Security.Service.UsuarioService;
import jakarta.validation.Valid;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    private final UsuarioService usuarioService;

    private final RolService rolService;

    private final JwtProvider jwtProvider;

    @Autowired
    public AuthController(PasswordEncoder passwordEncoder, AuthenticationManagerBuilder authenticationManagerBuilder, UsuarioService usuarioService, RolService rolService, JwtProvider jwtProvider) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.usuarioService = usuarioService;
        this.rolService = rolService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/registro")
    public ResponseEntity<Object> registro(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new Mensaje("Campos inválidos o mail incorrecto"), HttpStatus.BAD_REQUEST);
        } else if (usuarioService.existsByEmail(nuevoUsuario.getEmail())) {
            return new ResponseEntity(new Mensaje("El usuario ya existe"), HttpStatus.BAD_REQUEST);
        }
        Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByNombre(RolNombre.ROLE_USER).get());
        if (nuevoUsuario.getRoles().contains("admin")) {
            roles.add(rolService.getByNombre(RolNombre.ROLE_ADMIN).get());
            usuario.setRoles(roles);
            usuarioService.save(usuario);
            return new ResponseEntity(new Mensaje("Usuario guardado"), HttpStatus.CREATED);

        }
        return new ResponseEntity<>(new Mensaje("Operación Finalizada"), HttpStatus.ACCEPTED);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Mensaje("Campos Inválidos"), HttpStatus.BAD_REQUEST);
        } else {
            try {
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUsuario.getEmail(), loginUsuario.getPassword());
                Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                String jwt = jwtProvider.generateToken(authentication);
                JwtDao jwtDao = new JwtDao(jwt);
                return new ResponseEntity<>(jwtDao, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(new Mensaje("Revise sus credenciales"), HttpStatus.BAD_REQUEST);
            }
        }
    }

}
