package br.com.samuel.helloworld.application.products.create;

import br.com.samuel.helloworld.domain.products.Product;
import br.com.samuel.helloworld.domain.products.ProductGateway;
import br.com.zydon.commons.domain.exceptions.InternalErrorException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultCreateProductUseCase extends CreateProductUseCase {

    private final ProductGateway productGateway;

    @Override
    public CreateProductOutput execute(CreateProductCommand command) {

        final Product product = Product.newProduct(command.name(), command.price(), command.stock());

        try {
            productGateway.create(product);
        } catch (final Throwable t) {
            final String productId = product.getId().getValue();

            throw InternalErrorException.with(
                    "An error on creating product was observed [product:%s]".formatted(productId),
                    t
            );
        }

        return CreateProductOutput.with(product.getId());
    }
}
