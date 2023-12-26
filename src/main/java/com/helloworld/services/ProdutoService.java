package com.helloworld.services;

import com.helloworld.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.helloworld.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    // Adicionar um produto
    public Produto adicionarProduto(Produto produto) {
        return repository.save(produto);
    }

    // Buscar todos os produtos
    public List<Produto> buscarTodosProdutos() {
        return repository.findAll();
    }

    // Buscar um produto pelo ID
    public Optional<Produto> buscarProdutoPorId(Integer id) {
        return repository.findById(id);
    }

    // Atualizar um produto
    public Produto atualizarProduto(Produto produto) {
        return repository.save(produto);
    }

    // Deletar um produto
    public void deletarProduto(Integer id) {
        repository.deleteById(id);
    }
}
