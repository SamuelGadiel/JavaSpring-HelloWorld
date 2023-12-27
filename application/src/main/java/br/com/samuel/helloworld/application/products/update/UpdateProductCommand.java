package br.com.samuel.helloworld.application.products.update;

import br.com.samuel.helloworld.domain.products.ProductID;

public record UpdateProductCommand(ProductID productId, String name, Double price, Integer stock) {
    public static UpdateProductCommand with(ProductID productId, String name, Double price, Integer stock) {
        return new UpdateProductCommand(productId, name, price, stock);
    }
}
