package br.com.samuel.helloworld.application.products.retrieve.get;

import br.com.samuel.helloworld.domain.products.Product;

public record GetProductOutput(Product product) {
    public static GetProductOutput with(Product product) {
        return new GetProductOutput(product);
    }
}
