package com.example.erecruit.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * klasa szyfrująca hasło  'BCrypt'
 */

public class PasswordEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    }
}
