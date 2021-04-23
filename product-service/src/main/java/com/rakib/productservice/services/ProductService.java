package com.rakib.productservice.services;

import com.rakib.productservice.services.dto.ProductDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Flux<ProductDTO> getAllProduct();

    Mono<ProductDTO> getProductByID(String ID);

    Mono<ProductDTO> postProduct(Mono<ProductDTO> productDTO);

    Mono<ProductDTO> updateProduct(Mono<ProductDTO> productDTO, String ID);

    Mono<Void> deleteProduct(String ID);
}
