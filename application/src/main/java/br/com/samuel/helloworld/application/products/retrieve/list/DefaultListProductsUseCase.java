package br.com.samuel.helloworld.application.products.retrieve.list;

import br.com.samuel.helloworld.domain.products.Product;
import br.com.samuel.helloworld.domain.products.ProductGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DefaultListProductsUseCase extends ListProductsUseCase {

    final ProductGateway productGateway;

    @Override
    public ListProductsOutput execute(ListProductsCommand command) {
        final List<Product> products = productGateway.findAll();

        return ListProductsOutput.with(products);
    }
}
