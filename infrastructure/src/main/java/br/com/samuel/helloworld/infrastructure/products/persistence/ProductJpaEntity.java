package br.com.samuel.helloworld.infrastructure.products.persistence;

import br.com.samuel.helloworld.domain.products.Product;
import br.com.samuel.helloworld.domain.products.ProductID;
import br.com.samuel.helloworld.infrastructure.persistence.AuditableJpaEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;

import java.time.Instant;

@Entity
@Table(name = "products")
@Getter @Setter @Accessors(chain = true)
@NoArgsConstructor
public class ProductJpaEntity extends AuditableJpaEntity<Product> {

    @Id
    @Column(name = "id", nullable = false, columnDefinition = "uuid")
    @Type(ProductIDType.class)
    private ProductID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    protected ProductJpaEntity(
            final ProductID id,
            final String name,
            final Double price,
            final Integer stock,
            final Instant createdAt,
            final Instant updatedAt
    ) {
        super(createdAt, updatedAt);

        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public Product toAggregate() {
        return Product.with(
                getId(),
                getName(),
                getPrice(),
                getStock(),
                getCreatedAt(),
                getUpdatedAt()
        );
    }
}
