package br.com.samuel.helloworld.application.products.create;

import br.com.samuel.helloworld.domain.products.ProductID;

public record CreateProductOutput(String productId) {
    public static CreateProductOutput with(ProductID productId) {
        return new CreateProductOutput(productId.getValue());
    }
}
