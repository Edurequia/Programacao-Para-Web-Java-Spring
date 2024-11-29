package com.example.login.controller;

import com.example.login.dto.ProdutoCreateDTO;
import com.example.login.dto.ProdutoDTO;
import com.example.login.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    public List<ProdutoDTO> getAllProdutos() {
        return produtoService.getAllProdutos();
    }

    @GetMapping("/{id}")
    public ProdutoDTO getProdutoById(@PathVariable Long id) {
        return produtoService.getProdutoById(id);
    }

    @PostMapping
    public ProdutoDTO createProduto(@RequestBody ProdutoCreateDTO produtoCreateDTO) {
        return produtoService.createProduto(produtoCreateDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable Long id) {
        produtoService.deleteProduto(id);
    }
}
