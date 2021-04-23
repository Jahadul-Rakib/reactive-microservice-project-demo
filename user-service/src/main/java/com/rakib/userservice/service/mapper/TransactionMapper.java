package com.rakib.userservice.service.mapper;

import com.rakib.userservice.entity.Transactions;
import com.rakib.userservice.service.dto.TransactionRequestDTO;
import com.rakib.userservice.service.dto.TransactionResponseDTO;
import com.rakib.userservice.service.dto.TransactionStatus;

import java.time.LocalDateTime;

public class TransactionMapper {

    public static Transactions toEntity(TransactionRequestDTO requestDTO){
        return Transactions.builder()
                .userId(requestDTO.getUserId())
                .amount(requestDTO.getBalance())
                .transactionTime(LocalDateTime.now())
                .build();
    }

    public static TransactionResponseDTO toDto(Transactions transactions, TransactionStatus status){
        return TransactionResponseDTO.builder()
                .userId(transactions.getUserId())
                .balance(transactions.getAmount())
                .status(status)
                .build();
    }
}
