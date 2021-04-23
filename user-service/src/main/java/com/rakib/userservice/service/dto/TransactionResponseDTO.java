package com.rakib.userservice.service.dto;


import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponseDTO {
    private Integer userId;
    private Integer balance;
    private TransactionStatus status;
}
