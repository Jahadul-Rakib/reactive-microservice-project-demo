package com.rakib.userservice.repository;

import com.rakib.userservice.entity.Transactions;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends ReactiveMongoRepository<Transactions, Integer> {
}
