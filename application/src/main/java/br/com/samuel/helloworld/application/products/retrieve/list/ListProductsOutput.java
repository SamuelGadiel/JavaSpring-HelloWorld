package br.com.samuel.helloworld.application.products.retrieve.list;

import br.com.samuel.helloworld.application.products.retrieve.get.GetProductOutput;

import java.util.List;

public record ListProductsOutput(List<GetProductOutput> products) {
    public static ListProductsOutput with(List<GetProductOutput> products) {
        return new ListProductsOutput(products);
    }
}
