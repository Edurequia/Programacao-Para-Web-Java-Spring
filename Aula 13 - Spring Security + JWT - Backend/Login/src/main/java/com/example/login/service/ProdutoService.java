package com.example.login.service;

import com.example.login.domain.produto.Produto;
import com.example.login.dto.ProdutoCreateDTO;
import com.example.login.dto.ProdutoDTO;
import com.example.login.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public List<ProdutoDTO> getAllProdutos() {
        return produtoRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ProdutoDTO getProdutoById(Long id) {
        return produtoRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    public ProdutoDTO createProduto(ProdutoCreateDTO produtoCreateDTO) {
        Produto produto = new Produto();
        produto.setNome(produtoCreateDTO.nome());
        produto.setDescricao(produtoCreateDTO.descricao());
        produto.setPreco(produtoCreateDTO.preco());
        Produto savedProduto = produtoRepository.save(produto);
        return convertToDTO(savedProduto);
    }

    public void deleteProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    private ProdutoDTO convertToDTO(Produto produto) {
        return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco());
    }
}