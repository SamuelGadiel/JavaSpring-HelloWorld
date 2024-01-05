package br.com.samuel.helloworld.application.products.create;

public record CreateProductCommand(
        String name,
        Double price,
        Integer stock
) {
    public static CreateProductCommand with(String name, Double price, Integer stock) {
        return new CreateProductCommand(name, price, stock);
    }
}
