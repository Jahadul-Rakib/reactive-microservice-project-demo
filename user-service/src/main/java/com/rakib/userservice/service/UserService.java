package com.rakib.userservice.service;

import com.rakib.userservice.service.dto.UserDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Flux<UserDTO> getAllUser();
    Mono<UserDTO> getUserById(Integer id);
    Mono<Void> deleteUserById(Integer id);
    Mono<UserDTO> createUser(Mono<UserDTO> userDTO);
    Mono<UserDTO> updateUser(Integer id, Mono<UserDTO> userDTO);
}
