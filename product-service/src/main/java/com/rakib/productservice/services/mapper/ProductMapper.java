package com.rakib.productservice.services.mapper;

import com.rakib.productservice.entity.Product;
import com.rakib.productservice.services.dto.ProductDTO;
import org.springframework.beans.BeanUtils;

public class ProductMapper {

    public static ProductDTO productEntityToDto(Product product) {
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);
        return productDTO;
    }

    public static Product productDtoToEntity(ProductDTO product) {
        Product products = new Product();
        BeanUtils.copyProperties(product, products);
        return products;
    }
}
