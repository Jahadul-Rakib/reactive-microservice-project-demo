package com.rakib.userservice.entity;


import lombok.*;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class UserInfo {
    @Id
    private Integer id;
    private String name;
    private Integer balance;
}
