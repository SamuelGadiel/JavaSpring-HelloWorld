package br.com.samuel.helloworld.application.products.update;

import br.com.samuel.helloworld.domain.products.Product;
import br.com.samuel.helloworld.domain.products.ProductGateway;
import br.com.samuel.helloworld.domain.products.ProductID;
import br.com.zydon.commons.domain.exceptions.InternalErrorException;
import lombok.RequiredArgsConstructor;

import static br.com.zydon.commons.application.utils.ExceptionUtils.notFound;

@RequiredArgsConstructor
public class DefaultUpdateProductUseCase extends UpdateProductUseCase {

    private final ProductGateway productGateway;


    @Override
    public UpdateProductOutput execute(UpdateProductCommand command) {
        final ProductID productId = command.productId();

        final Product product = productGateway.findById(productId)
                .orElseThrow(notFound(productId, Product.class));

        product.update(command.name(), command.price(), command.stock());

        try {
            productGateway.update(product);
        } catch (final Throwable t) {
            throw InternalErrorException.with(
                    "An error on creating product was observed [product:%s]".formatted(productId),
                    t
            );
        }

        return UpdateProductOutput.with(product.getId());
    }
}
