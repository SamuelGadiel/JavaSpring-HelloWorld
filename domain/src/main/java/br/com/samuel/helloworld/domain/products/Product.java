package br.com.samuel.helloworld.domain.products;

import br.com.zydon.commons.domain.AggregateRoot;
import br.com.zydon.commons.domain.events.DomainEvent;
import br.com.zydon.commons.domain.validation.ValidationHandler;
import lombok.Getter;

import java.util.List;


@Getter
public class Product extends AggregateRoot<ProductID> {

    private String name;
    private Double price;

    protected Product(
            final ProductID productID,
            final List<DomainEvent> domainEvents,
            final String name,
            final Double price
    ) {
        super(productID, domainEvents);

        this.name = name;
        this.price = price;
    }


    public static Product with(Product product) {
        return new Product(
                product.getId(),
                product.getDomainEvents(),
                product.getName(),
                product.getPrice()
        );
    }

    public Product update(Double price) {
        this.price = price;
        return this;
    }

    @Override
    public void validate(ValidationHandler validationHandler) {

    }
}
