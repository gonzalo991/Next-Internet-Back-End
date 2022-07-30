package Next.Internet.Dao;

import lombok.Getter;
import lombok.Setter;

public class Mensaje {

    @Getter
    @Setter
    private String mensaje;

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
