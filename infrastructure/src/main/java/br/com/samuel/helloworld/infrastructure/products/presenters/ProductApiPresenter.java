package br.com.samuel.helloworld.infrastructure.products.presenters;

import br.com.samuel.helloworld.application.products.create.CreateProductOutput;
import br.com.samuel.helloworld.application.products.delete.DeleteProductOutput;
import br.com.samuel.helloworld.application.products.retrieve.get.GetProductOutput;
import br.com.samuel.helloworld.application.products.retrieve.list.ListProductsOutput;
import br.com.samuel.helloworld.application.products.update.UpdateProductOutput;
import br.com.samuel.helloworld.infrastructure.products.models.create.CreateProductResponse;
import br.com.samuel.helloworld.infrastructure.products.models.delete.DeleteProductFailureResponse;
import br.com.samuel.helloworld.infrastructure.products.models.delete.DeleteProductSuccessResponse;
import br.com.samuel.helloworld.infrastructure.products.models.retrieve.get.GetProductFailureResponse;
import br.com.samuel.helloworld.infrastructure.products.models.retrieve.get.GetProductSuccessResponse;
import br.com.samuel.helloworld.infrastructure.products.models.retrieve.list.ListProductsResponse;
import br.com.samuel.helloworld.infrastructure.products.models.update.UpdateProductFailureResponse;
import br.com.samuel.helloworld.infrastructure.products.models.update.UpdateProductSuccessResponse;

import java.util.List;

public interface ProductApiPresenter {
    static CreateProductResponse present(final CreateProductOutput createProductOutput) {
        return new CreateProductResponse(
                createProductOutput.productId()
        );
    }


    static DeleteProductSuccessResponse present(final DeleteProductOutput deleteProductOutput) {
        return new DeleteProductSuccessResponse(
                deleteProductOutput.productId()
        );
    }

    static DeleteProductFailureResponse deleteProductFailurePresenter(final Throwable exception) {
        return new DeleteProductFailureResponse(
                exception.getMessage()
        );
    }


    static GetProductSuccessResponse present(final GetProductOutput getProductOutput) {
        return new GetProductSuccessResponse(
                getProductOutput.id(),
                getProductOutput.name(),
                getProductOutput.price(),
                getProductOutput.stock(),
                getProductOutput.createdAt(),
                getProductOutput.updatedAt()
        );
    }

    static GetProductFailureResponse getProductFailurePresenter(final Throwable exception) {
        return new GetProductFailureResponse(
                exception.getMessage()
        );
    }


    static ListProductsResponse present(final ListProductsOutput listProductsOutput) {
        final List<GetProductSuccessResponse> products;

        products = listProductsOutput
                .products()
                .stream()
                .map(ProductApiPresenter::present)
                .toList();

        return new ListProductsResponse(products);
    }


    static UpdateProductSuccessResponse present(final UpdateProductOutput updateProductOutput) {
        return new UpdateProductSuccessResponse(updateProductOutput.productId());
    }

    static UpdateProductFailureResponse updateProductFailurePresenter(final Throwable exception) {
        return new UpdateProductFailureResponse(
                exception.getMessage()
        );
    }
}
