package br.com.samuel.helloworld.application.products.retrieve.get;

import br.com.samuel.helloworld.domain.products.ProductID;

public record GetProductCommand(ProductID productId) {
    public static GetProductCommand with(ProductID productId) {
        return new GetProductCommand(productId);
    }
}
