package com.rakib.userservice.web_contrller;

import com.rakib.userservice.configuration.AppConstant;
import com.rakib.userservice.service.TransactionsService;
import com.rakib.userservice.service.UserService;
import com.rakib.userservice.service.dto.TransactionRequestDTO;
import com.rakib.userservice.service.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(AppConstant.USER_END_POINT)
public class UserController {

    private final UserService userService;
    private final TransactionsService transactionsService;

    public UserController(UserService userService, TransactionsService transactionsService) {
        this.userService = userService;
        this.transactionsService = transactionsService;
    }

    @GetMapping
    public Flux<UserDTO> getAllUser() {
        return userService.getAllUser();
    }

    @PostMapping
    public Mono<ResponseEntity> createUser(@RequestBody Mono<UserDTO> userDTO) {
        return userService.createUser(userDTO)
                .map(userDTO1 -> ResponseEntity.status(HttpStatus.OK).body(userDTO1))
                .cast(ResponseEntity.class)
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Do not create any data"));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity> updateUser(@PathVariable Integer id, @RequestBody Mono<UserDTO> userDTO) {
        return userService.updateUser(id, userDTO)
                .map(userDTO1 -> ResponseEntity.ok().body(userDTO1))
                .cast(ResponseEntity.class)
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Do not update any data"));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity> getUserByID(@PathVariable Integer id) {
        return userService.getUserById(id)
                .map(userDTO -> ResponseEntity.ok().body(userDTO))
                .cast(ResponseEntity.class)
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Do not get any data"));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity> deleteUserByID(@PathVariable Integer id) {
        return userService.deleteUserById(id)
                .map(unused -> ResponseEntity.ok().body(unused))
                .cast(ResponseEntity.class);
    }

    @PostMapping("/transaction")
    public Mono<ResponseEntity> createTransaction(@RequestBody Mono<TransactionRequestDTO> transactionRequestDTOMono) {
        return transactionsService.createTransaction(transactionRequestDTOMono)
                .map(transactionResponseDTO -> ResponseEntity.ok().body(transactionResponseDTO))
                .cast(ResponseEntity.class)
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Create Transaction."));
    }

}
