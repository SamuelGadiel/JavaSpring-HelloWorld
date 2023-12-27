package br.com.samuel.helloworld.application.products.update;

import br.com.samuel.helloworld.domain.products.ProductID;

public record UpdateProductOutput(String productId) {
    public static UpdateProductOutput with(ProductID productId) {
        return new UpdateProductOutput(productId.getValue());
    }
}
