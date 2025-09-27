package com.infnet.victorapiparttwo.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("User: role defaults and authorities")
    void userRoleDefaults() {
        User u = new User();
        u.setEmail("a@b.com");
        u.setPasswordHash("pwd");
        u.prePersist();
        assertNotNull(u.getCreatedAt());
        assertNotNull(u.getRole());
    }

    @Test
    @DisplayName("User: authorities and enabled/locked checks")
    void userAuthoritiesAndEnabled() {
        User u = new User();
        u.setEmail("x@y.com");
        u.setPasswordHash("p");
        u.setRole(UserRole.ROLE_ADMIN);
        assertTrue(u.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN")));
        u.setIsActive(false);
        assertFalse(u.isEnabled());
        assertFalse(u.isAccountNonLocked());
    }
}
