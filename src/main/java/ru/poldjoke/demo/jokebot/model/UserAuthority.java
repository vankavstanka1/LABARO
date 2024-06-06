package ru.poldjoke.demo.jokebot.model;

import org.springframework.security.core.GrantedAuthority;

public enum UserAuthority implements GrantedAuthority {

    PLACE_ORDERS,
    MANAGE_ORDERS,
    FULL;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
