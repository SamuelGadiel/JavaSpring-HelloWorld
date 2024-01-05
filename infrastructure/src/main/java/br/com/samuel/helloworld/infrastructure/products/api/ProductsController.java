package br.com.samuel.helloworld.infrastructure.products.api;

import br.com.samuel.helloworld.application.products.create.CreateProductCommand;
import br.com.samuel.helloworld.application.products.create.CreateProductOutput;
import br.com.samuel.helloworld.application.products.create.CreateProductUseCase;
import br.com.samuel.helloworld.application.products.delete.DeleteProductCommand;
import br.com.samuel.helloworld.application.products.delete.DeleteProductOutput;
import br.com.samuel.helloworld.application.products.delete.DeleteProductUseCase;
import br.com.samuel.helloworld.application.products.retrieve.get.GetProductCommand;
import br.com.samuel.helloworld.application.products.retrieve.get.GetProductOutput;
import br.com.samuel.helloworld.application.products.retrieve.get.GetProductUseCase;
import br.com.samuel.helloworld.application.products.retrieve.list.ListProductsCommand;
import br.com.samuel.helloworld.application.products.retrieve.list.ListProductsOutput;
import br.com.samuel.helloworld.application.products.retrieve.list.ListProductsUseCase;
import br.com.samuel.helloworld.application.products.update.UpdateProductCommand;
import br.com.samuel.helloworld.application.products.update.UpdateProductOutput;
import br.com.samuel.helloworld.application.products.update.UpdateProductUseCase;
import br.com.samuel.helloworld.domain.products.ProductID;
import br.com.samuel.helloworld.infrastructure.products.models.create.CreateProductRequest;
import br.com.samuel.helloworld.infrastructure.products.models.create.CreateProductResponse;
import br.com.samuel.helloworld.infrastructure.products.models.delete.DeleteProductFailureResponse;
import br.com.samuel.helloworld.infrastructure.products.models.delete.DeleteProductResponse;
import br.com.samuel.helloworld.infrastructure.products.models.delete.DeleteProductSuccessResponse;
import br.com.samuel.helloworld.infrastructure.products.models.retrieve.get.GetProductFailureResponse;
import br.com.samuel.helloworld.infrastructure.products.models.retrieve.get.GetProductResponse;
import br.com.samuel.helloworld.infrastructure.products.models.retrieve.get.GetProductSuccessResponse;
import br.com.samuel.helloworld.infrastructure.products.models.retrieve.list.ListProductsResponse;
import br.com.samuel.helloworld.infrastructure.products.models.update.UpdateProductFailureResponse;
import br.com.samuel.helloworld.infrastructure.products.models.update.UpdateProductRequest;
import br.com.samuel.helloworld.infrastructure.products.models.update.UpdateProductResponse;
import br.com.samuel.helloworld.infrastructure.products.models.update.UpdateProductSuccessResponse;
import br.com.samuel.helloworld.infrastructure.products.presenters.ProductApiPresenter;
import br.com.zydon.commons.domain.exceptions.NotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@Validated
public class ProductsController implements ProductsAPI {

    private final CreateProductUseCase createProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final GetProductUseCase getProductUseCase;
    private final ListProductsUseCase listProductsUseCase;
    private final UpdateProductUseCase updateProductUseCase;


    @Override
    public ResponseEntity<CreateProductResponse> create(@Valid @RequestBody CreateProductRequest createProductRequest) {
        final CreateProductCommand command = CreateProductCommand.with(
                createProductRequest.name(),
                createProductRequest.price(),
                createProductRequest.stock()
        );

        final CreateProductOutput output = createProductUseCase.execute(command);

        final CreateProductResponse response = ProductApiPresenter.present(output);

        return ResponseEntity.created(URI.create("/products/" + response.productId())).body(response);
    }


    @Override
    public ResponseEntity<DeleteProductResponse> delete(String id) {

        try {
            final ProductID productId = ProductID.from(id);
            final DeleteProductCommand command = DeleteProductCommand.with(productId);

            final DeleteProductOutput output = deleteProductUseCase.execute(command);
            final DeleteProductSuccessResponse response = ProductApiPresenter.present(output);
            return ResponseEntity.ok(response);

        } catch (NotFoundException e) {

            final DeleteProductFailureResponse response = ProductApiPresenter.deleteProductFailurePresenter(e);
            return ResponseEntity.status(404).body(response);

        } catch (Throwable e) {

            final DeleteProductFailureResponse response = ProductApiPresenter.deleteProductFailurePresenter(e);
            return ResponseEntity.status(500).body(response);

        }
    }


    @Override
    public ResponseEntity<GetProductResponse> getById(String id) {
        try {

            final ProductID productId = ProductID.from(id);

            final GetProductCommand command = GetProductCommand.with(productId);

            final GetProductOutput output = getProductUseCase.execute(command);

            final GetProductSuccessResponse response = ProductApiPresenter.present(output);

            return ResponseEntity.ok(response);
        } catch (Throwable e) {
            final GetProductFailureResponse response = ProductApiPresenter.getProductFailurePresenter(e);
            return ResponseEntity.status(500).body(response);
        }
    }


    @Override
    public ResponseEntity<ListProductsResponse> list() {
        final ListProductsCommand command = ListProductsCommand.with();

        final ListProductsOutput output = listProductsUseCase.execute(command);

        final ListProductsResponse response = ProductApiPresenter.present(output);

        return ResponseEntity.ok(response);
    }


    @Override
    public ResponseEntity<UpdateProductResponse> update(String id, UpdateProductRequest updateProductRequest) {
        try {

            final ProductID productId = ProductID.from(id);

            final UpdateProductCommand command = UpdateProductCommand.with(
                    productId,
                    updateProductRequest.name(),
                    updateProductRequest.price(),
                    updateProductRequest.stock()
            );

            final UpdateProductOutput output = updateProductUseCase.execute(command);

            final UpdateProductSuccessResponse response = ProductApiPresenter.present(output);

            return ResponseEntity.ok(response);
        } catch (Throwable e) {

            final UpdateProductFailureResponse response = ProductApiPresenter.updateProductFailurePresenter(e);
            return ResponseEntity.status(500).body(response);

        }
    }

}
