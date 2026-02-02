package com.decoder;

public class User {

    private final String name;

    User(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nome inválido!");
        }
        super();
        this.name = name;
    }
}
