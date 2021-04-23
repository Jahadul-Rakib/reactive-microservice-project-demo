package com.rakib.userservice.service;

import com.rakib.userservice.service.dto.TransactionRequestDTO;
import com.rakib.userservice.service.dto.TransactionResponseDTO;
import reactor.core.publisher.Mono;

public interface TransactionsService {
    Mono<TransactionResponseDTO> createTransaction(Mono<TransactionRequestDTO> requestDTO);

}
