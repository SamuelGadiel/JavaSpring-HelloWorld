package com.helloworld.controller;

import com.helloworld.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.helloworld.services.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;


    // Criar um novo produto
    @PostMapping
    public Produto adicionarProduto(@RequestBody Produto produto) {
        return service.adicionarProduto(produto);
    }

    // Buscar todos os produtos
    @GetMapping
    public List<Produto> buscarTodosProdutos() {
        return service.buscarTodosProdutos();
    }

    // Buscar produto pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Integer id) {
        return service.buscarProdutoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Atualizar um produto
    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Integer id, @RequestBody Produto produto) {
        return service.atualizarProduto(produto);
    }

    // Deletar um produto
    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Integer id) {
        service.deletarProduto(id);
    }
}
