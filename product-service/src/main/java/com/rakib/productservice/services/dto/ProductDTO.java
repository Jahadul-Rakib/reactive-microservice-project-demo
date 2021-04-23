package com.rakib.productservice.services.dto;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String id;
    private Integer productPrice;
    private String productDescription;
}
