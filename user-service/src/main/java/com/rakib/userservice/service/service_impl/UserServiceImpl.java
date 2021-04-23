package com.rakib.userservice.service.service_impl;

import com.rakib.userservice.repository.UserRepository;
import com.rakib.userservice.service.UserService;
import com.rakib.userservice.service.dto.UserDTO;
import com.rakib.userservice.service.mapper.UserMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Flux<UserDTO> getAllUser() {
        return userRepository.findAll().map(UserMapper::entityToDto);
    }

    @Override
    public Mono<UserDTO> getUserById(Integer id) {
        return userRepository.findById(id).map(UserMapper::entityToDto);
    }

    @Override
    public Mono<Void> deleteUserById(Integer id) {
        return userRepository.deleteById(id);
    }

    @Override
    public Mono<UserDTO> createUser(Mono<UserDTO> userDTO) {
        return userDTO
                .map(UserMapper::dtoToEntity)
                .flatMap(userRepository::save)
                .map(UserMapper::entityToDto);
    }

    @Override
    public Mono<UserDTO> updateUser(Integer id, Mono<UserDTO> userDTO) {
        return getUserById(id)
                .map(dto -> {
                            if (Objects.isNull(dto)) {
                                Mono.error(new Exception("UserInfo Not Found By ID."));
                            }
                            return dto;
                        }
                )
                .flatMap(user ->
                        userDTO.map(userDTO2 -> {
                            if (Objects.nonNull(userDTO2.getBalance()))
                                user.setBalance(userDTO2.getBalance());
                            if (Objects.nonNull(userDTO2.getName()))
                                user.setName(userDTO2.getName());
                            return UserMapper.dtoToEntity(user);
                        }))
                .flatMap(userRepository::save)
                .map(UserMapper::entityToDto);
    }
}
