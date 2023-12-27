package br.com.samuel.helloworld.application.products.retrieve.list;

public record ListProductsCommand() {

    public static ListProductsCommand with() {
        return new ListProductsCommand();
    }
}
