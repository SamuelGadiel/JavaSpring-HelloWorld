package br.com.samuel.helloworld.domain.products;

import br.com.zydon.commons.domain.AggregateRoot;
import br.com.zydon.commons.domain.events.DomainEvent;
import br.com.zydon.commons.domain.validation.ValidationHandler;
import lombok.Getter;

import java.time.Instant;
import java.util.List;


@Getter
public class Product extends AggregateRoot<ProductID> {

    private String name;
    private Double price;
    private Integer stock;

    
    private Instant createdAt;
    private Instant updatedAt;

    protected Product(
            final ProductID productID,
            final List<DomainEvent> domainEvents,
            final String name,
            final Double price,
            final Integer stock,
            final Instant createdAt,
            final Instant updatedAt
    ) {
        super(productID, domainEvents);

        this.name = name;
        this.price = price;
        this.stock = stock;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public static Product with(
            final ProductID productID,
            final String name,
            final Double price,
            final Integer stock,
            final Instant createdAt,
            final Instant updatedAt
    ) {
        return new Product(
                productID,
                null,
                name,
                price,
                stock,
                createdAt,
                updatedAt
        );
    }

    public static Product newProduct(String name, Double price, Integer stock) {
        final ProductID productId = ProductID.unique();
        final Instant now = Instant.now();

        return new Product(
                productId,
                null,
                name,
                price,
                stock,
                now,
                now
        );
    }


    public Product update(String name, Double price, Integer stock) {
        if (name != null) this.name = name;
        if (price != null) this.price = price;
        if (stock != null) this.stock = stock;

        if (name != null || price != null || stock != null) {
            this.updatedAt = Instant.now();
        }

        return this;
    }

    @Override
    public void validate(ValidationHandler validationHandler) {

    }
}
