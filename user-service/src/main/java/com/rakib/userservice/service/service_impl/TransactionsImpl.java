package com.rakib.userservice.service.service_impl;

import com.rakib.userservice.repository.TransactionsRepository;
import com.rakib.userservice.repository.UserRepository;
import com.rakib.userservice.service.TransactionsService;
import com.rakib.userservice.service.dto.TransactionRequestDTO;
import com.rakib.userservice.service.dto.TransactionResponseDTO;
import com.rakib.userservice.service.dto.TransactionStatus;
import com.rakib.userservice.service.mapper.TransactionMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class TransactionsImpl implements TransactionsService {

    private final TransactionsRepository transactionsRepository;
    private final UserRepository userRepository;

    public TransactionsImpl(TransactionsRepository transactionsRepository, UserRepository userRepository) {
        this.transactionsRepository = transactionsRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Mono<TransactionResponseDTO> createTransaction(Mono<TransactionRequestDTO> requestDTO) {
        return requestDTO.map(requestDTO1 -> userRepository.findById(requestDTO1.getUserId())
                .flatMap(userInfo -> {
                    Integer balance = userInfo.getBalance();
                    Integer balance2 = requestDTO1.getBalance();
                    userInfo.setBalance(balance + balance2);
                    userRepository.save(userInfo)
                            .doOnError(userInfoSignal -> Mono.error(new Exception("Error")));
                    return transactionsRepository.save(TransactionMapper.toEntity(requestDTO1))
                            .map(transactions -> TransactionMapper.toDto(transactions, TransactionStatus.APPROVE));
                })).flatMap(Mono::from);
    }
}