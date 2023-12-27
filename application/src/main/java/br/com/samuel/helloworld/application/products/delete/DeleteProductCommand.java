package br.com.samuel.helloworld.application.products.delete;

import br.com.samuel.helloworld.domain.products.ProductID;

public record DeleteProductCommand(ProductID productId) {

    public static DeleteProductCommand with(ProductID productId) {
        return new DeleteProductCommand(productId);
    }
}
