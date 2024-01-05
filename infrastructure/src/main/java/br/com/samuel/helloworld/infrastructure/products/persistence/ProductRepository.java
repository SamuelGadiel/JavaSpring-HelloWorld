package br.com.samuel.helloworld.infrastructure.products.persistence;

import br.com.samuel.helloworld.domain.products.ProductID;
import br.com.samuel.helloworld.infrastructure.products.persistence.ProductJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductJpaEntity, ProductID> {
}
