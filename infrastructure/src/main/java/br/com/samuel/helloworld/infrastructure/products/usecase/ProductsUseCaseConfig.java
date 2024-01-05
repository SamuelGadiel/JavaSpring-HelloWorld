package br.com.samuel.helloworld.infrastructure.products.usecase;

import br.com.samuel.helloworld.application.products.create.CreateProductUseCase;
import br.com.samuel.helloworld.application.products.create.DefaultCreateProductUseCase;
import br.com.samuel.helloworld.application.products.delete.DefaultDeleteProductUseCase;
import br.com.samuel.helloworld.application.products.delete.DeleteProductUseCase;
import br.com.samuel.helloworld.application.products.retrieve.get.DefaultGetProductUseCase;
import br.com.samuel.helloworld.application.products.retrieve.get.GetProductUseCase;
import br.com.samuel.helloworld.application.products.retrieve.list.DefaultListProductsUseCase;
import br.com.samuel.helloworld.application.products.retrieve.list.ListProductsUseCase;
import br.com.samuel.helloworld.application.products.update.DefaultUpdateProductUseCase;
import br.com.samuel.helloworld.application.products.update.UpdateProductUseCase;
import br.com.samuel.helloworld.domain.products.ProductGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ProductsUseCaseConfig {

    private final ProductGateway productGateway;

    @Bean
    public CreateProductUseCase createProductUseCase() {
        return new DefaultCreateProductUseCase(productGateway);
    }

    @Bean
    public DeleteProductUseCase deleteProductUseCase() {
        return new DefaultDeleteProductUseCase(productGateway);
    }

    @Bean
    public GetProductUseCase getProductUseCase() {
        return new DefaultGetProductUseCase(productGateway);
    }

    @Bean
    public ListProductsUseCase listProductsUseCase() {
        return new DefaultListProductsUseCase(productGateway);
    }

    @Bean
    public UpdateProductUseCase updateProductUseCase() {
        return new DefaultUpdateProductUseCase(productGateway);
    }
}
