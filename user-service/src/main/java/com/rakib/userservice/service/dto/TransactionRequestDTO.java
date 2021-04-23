package com.rakib.userservice.service.dto;


import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequestDTO {
    private Integer userId;
    private Integer balance;
}
