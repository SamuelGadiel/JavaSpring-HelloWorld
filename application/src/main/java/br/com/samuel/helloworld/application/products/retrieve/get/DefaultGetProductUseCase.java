package br.com.samuel.helloworld.application.products.retrieve.get;

import br.com.samuel.helloworld.domain.products.Product;
import br.com.samuel.helloworld.domain.products.ProductGateway;
import br.com.samuel.helloworld.domain.products.ProductID;
import lombok.RequiredArgsConstructor;

import static br.com.zydon.commons.application.utils.ExceptionUtils.notFound;

@RequiredArgsConstructor
public class DefaultGetProductUseCase extends GetProductUseCase {

    final ProductGateway productGateway;

    @Override
    public GetProductOutput execute(GetProductCommand command) {
        final ProductID productId = command.productId();

        Product product = productGateway.findById(productId)
                .orElseThrow(notFound(productId, Product.class));
        
        return GetProductOutput.with(product);
    }
}
