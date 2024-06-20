package br.com.rickgurgel.bank.bank.entities;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public enum UserRole {

    ADMIN("admin"),
    USER("user");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

}
