package br.com.samuel.helloworld.infrastructure.products.api;

import br.com.samuel.helloworld.infrastructure.products.models.create.CreateProductRequest;
import br.com.samuel.helloworld.infrastructure.products.models.create.CreateProductResponse;
import br.com.samuel.helloworld.infrastructure.products.models.delete.DeleteProductResponse;
import br.com.samuel.helloworld.infrastructure.products.models.retrieve.get.GetProductResponse;
import br.com.samuel.helloworld.infrastructure.products.models.retrieve.list.ListProductsResponse;
import br.com.samuel.helloworld.infrastructure.products.models.update.UpdateProductRequest;
import br.com.samuel.helloworld.infrastructure.products.models.update.UpdateProductResponse;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "products")
@Validated
public interface ProductsAPI {

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<CreateProductResponse> create(@Valid @RequestBody CreateProductRequest createProductRequest);


    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<DeleteProductResponse> delete(@PathVariable(name = "id") String id);


    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GetProductResponse> getById(@PathVariable(name = "id") String id);


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ListProductsResponse> list();


    @PutMapping(
            value = "{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<UpdateProductResponse> update(
            @PathVariable(name = "id") String id,
            @Valid @RequestBody UpdateProductRequest updateProductRequest);
}
