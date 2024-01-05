package br.com.samuel.helloworld.application.products.delete;

import br.com.samuel.helloworld.domain.products.ProductGateway;
import br.com.samuel.helloworld.domain.products.ProductID;
import br.com.zydon.commons.domain.exceptions.InternalErrorException;
import br.com.zydon.commons.domain.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultDeleteProductUseCase extends DeleteProductUseCase {

    final ProductGateway productGateway;

    @Override
    public DeleteProductOutput execute(DeleteProductCommand command) {
        final ProductID productId = command.productId();

        try {
            productGateway.deleteById(productId);
        } catch (NotFoundException e) {
            throw e;
        } catch (final Throwable t) {
            throw InternalErrorException.with(
                    "An error on deleting product was observed [product:%s]".formatted(productId),
                    t
            );
        }

        return DeleteProductOutput.with(productId);
    }
}
