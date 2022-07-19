package Next.Internet.Product;

import jakarta.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Getter
    @Setter
    private String plan;

    @NotNull
    @Getter
    @Setter
    private double precioMensual;

    public Product() {
    }

    public Product(int id, String plan, double precioMensual) {
        this.id = id;
        this.plan = plan;
        this.precioMensual = precioMensual;
    }
    
    
}
