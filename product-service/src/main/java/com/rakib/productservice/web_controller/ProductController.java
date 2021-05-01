package com.rakib.productservice.web_controller;

import com.rakib.productservice.configuration.AppConstant;
import com.rakib.productservice.services.ProductService;
import com.rakib.productservice.services.dto.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(AppConstant.PRODUCT_END_POINT)
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Flux<ProductDTO> getAllProducts(){
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity> getProductsByID(@PathVariable(value = "id") String id){
        return productService.getProductByID(id)
                .map(productDTO -> ResponseEntity.ok().body(productDTO))
                .cast(ResponseEntity.class)
                .defaultIfEmpty(ResponseEntity.badRequest().body("Empty Data"));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity> deleteProducts(@PathVariable(value = "id") String id){
        return productService.deleteProduct(id)
                .map(unused -> ResponseEntity.ok().body("Deleted"));
    }

    @PostMapping
    public Mono<ResponseEntity> insertProducts(@RequestBody Mono<ProductDTO> productDTO){
        return productService.postProduct(productDTO)
                .map(productDTO1 -> ResponseEntity.ok().body(productDTO1))
                .cast(ResponseEntity.class)
                .defaultIfEmpty(ResponseEntity.badRequest().body("Empty Data"));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity> updateProducts(@PathVariable(value = "id") String id,
                                                                    @RequestBody Mono<ProductDTO> productDTO){
        return productService.updateProduct(productDTO, id)
                .map(productDTO1 -> ResponseEntity.status(HttpStatus.OK).body(productDTO1))
                .cast(ResponseEntity.class)
                .defaultIfEmpty(ResponseEntity.badRequest().body("Empty Data"));

    }

}
