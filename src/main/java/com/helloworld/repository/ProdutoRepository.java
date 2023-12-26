package com.helloworld.repository;

import com.helloworld.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository  extends JpaRepository<Produto, Integer> {

}
