package com.rakib.userservice.web_contrller;

import com.rakib.userservice.configuration.AppConstant;
import com.rakib.userservice.service.TransactionsService;
import com.rakib.userservice.service.UserService;
import com.rakib.userservice.service.dto.ResponseDTO;
import com.rakib.userservice.service.dto.TransactionRequestDTO;
import com.rakib.userservice.service.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

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
    public Flux<ResponseEntity<Map<String, Object>>> getAllUser(){
        return ResponseDTO.sendResponseFlux(HttpStatus.OK,"Get ALl", userService.getAllUser());
    }
    @PostMapping
    public Mono<ResponseEntity<Map<String, Object>>> createUser(@RequestBody Mono<UserDTO> userDTO){
        return ResponseDTO.sendResponseMono(HttpStatus.CREATED,"Ceated", userService.createUser(userDTO));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Map<String, Object>>> updateUser(@PathVariable Integer id, @RequestBody Mono<UserDTO> userDTO){
        return ResponseDTO.sendResponseMono(HttpStatus.OK,"Updated", userService.updateUser(id, userDTO));
    }
    @GetMapping("/{id}")
    public Mono<ResponseEntity<Map<String, Object>>> getUserByID(@PathVariable Integer id){
        return ResponseDTO.sendResponseMono(HttpStatus.OK,"Get By ID", userService.getUserById(id));
    }
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Map<String, Object>>> deleteUserByID(@PathVariable Integer id){
        return ResponseDTO.sendResponseMono(HttpStatus.OK,"Deleted", userService.deleteUserById(id));
    }

    @PostMapping("/transaction")
    public Mono<ResponseEntity<Map<String, Object>>> createTransaction(@RequestBody Mono<TransactionRequestDTO> transactionRequestDTOMono){
        return ResponseDTO.sendResponseMono(HttpStatus.CREATED,"Ceated", transactionsService.createTransaction(transactionRequestDTOMono));
    }

}
