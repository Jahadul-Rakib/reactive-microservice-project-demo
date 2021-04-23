package com.rakib.userservice.entity;


import lombok.*;
import nonapi.io.github.classgraph.json.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    @Id
    private Integer id;
    private String name;
    private Integer balance;
}
