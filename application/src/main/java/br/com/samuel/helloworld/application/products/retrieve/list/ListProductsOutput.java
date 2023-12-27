package br.com.samuel.helloworld.application.products.retrieve.list;

import br.com.samuel.helloworld.domain.products.Product;

import java.util.List;

public record ListProductsOutput(List<Product> products) {
    public static ListProductsOutput with(List<Product> products) {
        return new ListProductsOutput(products);
    }
}
