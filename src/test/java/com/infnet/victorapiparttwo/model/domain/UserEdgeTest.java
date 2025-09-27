package com.infnet.victorapiparttwo.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("User edge-case tests")
class UserEdgeTest {

    @Test
    @DisplayName("isEnabled and isAccountNonLocked default true when isActive null")
    void enabledWhenIsActiveNull() {
        User u = new User();
        u.setEmail("a@b.com");
        u.setPasswordHash("p");
        u.setIsActive(null);
        // prior to persist behavior
        assertTrue(u.isEnabled());
        assertTrue(u.isAccountNonLocked());
    }
}
