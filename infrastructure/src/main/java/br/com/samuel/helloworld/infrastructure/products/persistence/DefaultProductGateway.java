package br.com.samuel.helloworld.infrastructure.products.persistence;

import br.com.samuel.helloworld.domain.products.Product;
import br.com.samuel.helloworld.domain.products.ProductGateway;
import br.com.samuel.helloworld.domain.products.ProductID;
import br.com.zydon.commons.domain.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultProductGateway implements ProductGateway {
    private final ProductRepository productRepository;
    private final ProductService productService;


    @Override
    @Transactional
    public Product create(Product product) {
        return save(product);
    }

    @Override
    @Transactional
    public void deleteById(ProductID productId) {
        final boolean productExists = productRepository.existsById(productId);

        if (!productExists) {
            throw NotFoundException.with(Product.class, productId);
        }

        productRepository.deleteById(productId);
    }

    @Override
    public Optional<Product> findById(ProductID productId) {
        return productRepository
                .findById(productId)
                .map(ProductJpaEntity::toAggregate);
    }

    @Override
    @Transactional
    public Product update(Product product) {
        return save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository
                .findAll()
                .stream()
                .map(ProductJpaEntity::toAggregate)
                .toList();
    }

    private Product save(Product product) {
        final ProductJpaEntity entity = productService.from(product);

        return productRepository.save(entity).toAggregate();
    }
}
