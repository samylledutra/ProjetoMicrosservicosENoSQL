package com.samylle.api.product.product_api.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.samylle.api.product.product_api.models.Product;
import com.samylle.api.product.product_api.models.dto.CategoryDTO;
import com.samylle.api.product.product_api.models.dto.ProductDTO;
import com.samylle.api.product.product_api.repositories.CategoryRepository;
import com.samylle.api.product.product_api.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductDTO save(ProductDTO productDTO) {

        String productIdentifier = UUID.randomUUID().toString();

        Product product = new Product();
        product.setProductIdentifier(productDTO.getProductIdentifier());
        product.setNome(productDTO.getNome());
        product.setDescricao(productDTO.getDescricao());
        product.setPreco(productDTO.getPreco());
        product.setCategoria(
                categoryRepository.findById(productDTO.getCategoria().getId())
                        .orElseThrow(() -> new RuntimeException("Categoria não encontrada")));
        product = productRepository.save(product);
        return toDTO(product);
    }

    public ProductDTO findById(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return toDTO(product);
    }

    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private ProductDTO toDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setProductIdentifier(product.getProductIdentifier());
        dto.setNome(product.getNome());
        dto.setDescricao(product.getDescricao());
        dto.setPreco(product.getPreco());
        dto.setCategoria(new CategoryDTO(product.getCategoria().getId(), product.getCategoria().getNome()));
        return dto;
    }

    public List<ProductDTO> getProductByCategoryId(String categoryId) {
        List<Product> products = productRepository.findByCategoria_Id(categoryId);
        return products.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO findByProductIdentifier(String productIdentifier) {
        Product product = productRepository.findByProductIdentifier(productIdentifier)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return toDTO(product);
    }

    public Page<ProductDTO> getAllPage(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(this::toDTO);
    }

}
