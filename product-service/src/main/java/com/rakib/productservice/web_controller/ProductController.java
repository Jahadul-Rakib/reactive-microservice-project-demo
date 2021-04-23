package com.rakib.productservice.web_controller;

import com.rakib.productservice.configuration.AppConstant;
import com.rakib.productservice.services.ProductService;
import com.rakib.productservice.services.dto.ProductDTO;
import com.rakib.productservice.services.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping(AppConstant.PRODUCT_END_POINT)
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Flux<ResponseEntity<Map<String, Object>>> getAllProducts(){
        return ResponseDTO.sendResponseFlux(HttpStatus.OK,"All data retrieve.",productService.getAllProduct());
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Map<String, Object>>> getProductsByID(@PathVariable(value = "id") String id){
        return ResponseDTO.sendResponseMono(HttpStatus.OK,"Data retrieve By ID.",productService.getProductByID(id));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Map<String, Object>>> deleteProducts(@PathVariable(value = "id") String id){
        return ResponseDTO.sendResponseMono(HttpStatus.OK,"Product deleted.", productService.deleteProduct(id));
    }

    @PostMapping
    public Mono<ResponseEntity<Map<String, Object>>> insertProducts(@RequestBody Mono<ProductDTO> productDTO){
        return ResponseDTO.sendResponseMono(HttpStatus.OK,"Product inserted.",productService.postProduct(productDTO));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Map<String, Object>>> updateProducts(@PathVariable(value = "id") String id,
                                                                    @RequestBody Mono<ProductDTO> productDTO){
        return ResponseDTO.sendResponseMono(HttpStatus.OK,"Product updated.",productService.updateProduct(productDTO, id));
    }

}
