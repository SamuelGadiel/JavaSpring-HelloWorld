package br.com.samuel.helloworld.application.products.retrieve.get;

import br.com.samuel.helloworld.domain.products.Product;

import java.time.Instant;

public record GetProductOutput(
        String id,
        String name,
        Double price,
        Integer stock,
        Instant createdAt,
        Instant updatedAt
) {
    public static GetProductOutput with(Product product) {
        return new GetProductOutput(
                product.getId().getValue(),
                product.getName(),
                product.getPrice(),
                product.getStock(),
                product.getCreatedAt(),
                product.getUpdatedAt()
        );
    }
}
