package Next.Internet.Security.Dao;

import java.util.Collection;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

public class JwtDao {

    @Getter
    @Setter
    private String token;

    public JwtDao(String token) {
        this.token = token;
    }

}
