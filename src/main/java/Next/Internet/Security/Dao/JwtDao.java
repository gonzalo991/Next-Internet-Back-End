package Next.Internet.Security.Dao;

import java.util.Collection;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

public class JwtDao {

    @Getter
    @Setter
    private String token;

    @Getter
    @Setter
    private String bearer = "Bearer";

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private Collection<? extends GrantedAuthority> authorities;

    public JwtDao(String token, String email, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.email = email;
        this.authorities = authorities;
    }

}
