package com.rakib.productservice.services.mapper;

import com.rakib.productservice.entity.Product;
import com.rakib.productservice.services.dto.ProductDTO;

public class ProductMapper {

    public static ProductDTO productEntityToDto(Product product) {
        //BeanUtils.copyProperties(product, productDTO);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setProductPrice(product.getProductPrice());
        productDTO.setProductDescription(product.getProductDescription());
        return productDTO;
    }

    public static Product productDtoToEntity(ProductDTO productDTO) {
        //BeanUtils.copyProperties(product, products);
        Product products = new Product();
        products.setId(productDTO.getId());
        products.setProductPrice(productDTO.getProductPrice());
        products.setProductDescription(productDTO.getProductDescription());
        return products;
    }
}
