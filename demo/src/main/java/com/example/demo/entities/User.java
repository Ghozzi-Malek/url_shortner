package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class User {
    private @Getter @Setter Integer id;
    private @Getter @Setter String name;
    private @Getter @Setter String email;
    private @Getter @Setter String password;
}
