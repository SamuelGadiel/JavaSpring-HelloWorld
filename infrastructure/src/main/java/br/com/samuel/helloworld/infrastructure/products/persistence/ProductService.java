package br.com.samuel.helloworld.infrastructure.products.persistence;

import br.com.samuel.helloworld.domain.products.Product;
import br.com.zydon.commons.infrastructure.persistence.AggregateConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductService extends AggregateConversionService<Product, ProductJpaEntity> {

    final ProductRepository productRepository;

    @Override
    public ProductJpaEntity from(Product product) {
        return new ProductJpaEntity(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStock(),
                product.getCreatedAt(),
                product.getUpdatedAt()
        );
    }
}
