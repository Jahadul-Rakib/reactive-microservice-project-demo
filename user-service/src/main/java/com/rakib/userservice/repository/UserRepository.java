package com.rakib.userservice.repository;

import com.rakib.userservice.entity.UserInfo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveMongoRepository<UserInfo, Integer> {

}
