package com.rakib.productservice.services.service_impl;

import com.rakib.productservice.repository.ProductRepository;
import com.rakib.productservice.services.ProductService;
import com.rakib.productservice.services.dto.ProductDTO;
import com.rakib.productservice.services.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Flux<ProductDTO> getAllProduct() {
        return productRepository.findAll().map(ProductMapper::productEntityToDto);
    }

    @Override
    public Mono<Void> deleteProduct(String ID) {
        return productRepository.deleteById(ID);
    }

    @Override
    public Mono<ProductDTO> getProductByID(String ID) {
        return productRepository.findById(ID)
                .map(ProductMapper::productEntityToDto);
    }

    @Override
    public Mono<ProductDTO> postProduct(Mono<ProductDTO> productDTO) {
        return productDTO
                .map(ProductMapper::productDtoToEntity)
                .flatMap(productRepository::insert)
                .map(ProductMapper::productEntityToDto);
    }

    @Override
    public Mono<ProductDTO> updateProduct(Mono<ProductDTO> productDTO, String ID) {
        return productRepository.findById(ID)
                .flatMap(product ->
                        productDTO.map(productDTO1 -> {
                            if (Objects.nonNull(productDTO1.getProductPrice())) {
                                product.setProductPrice(productDTO1.getProductPrice());
                            }
                            if (Objects.nonNull(productDTO1.getProductDescription())) {
                                product.setProductDescription(productDTO1.getProductDescription());
                            }
                            return product;
                        })
                )
                .flatMap(productRepository::save)
                .map(ProductMapper::productEntityToDto);
    }


}
