package br.com.samuel.helloworld.application.products.delete;

import br.com.samuel.helloworld.domain.products.ProductID;

public record DeleteProductOutput(String productId) {
    public static DeleteProductOutput with(ProductID productId) {
        return new DeleteProductOutput(productId.getValue());
    }
}
