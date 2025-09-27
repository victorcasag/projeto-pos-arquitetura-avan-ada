package com.infnet.victorapiparttwo.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinTypeTest {

    @Test
    @DisplayName("CoinType: fields and lifecycle")
    void coinTypeFields() {
        CoinType t = new CoinType();
        t.setId(1);
        t.setCode("USD");
        t.setName("Dollar");
    t.setIsActive(null);
    t.setCreatedAt(null);
        t.setUpdatedAt(null);
        t.prePersist();
        assertEquals(1, t.getId());
        assertEquals("USD", t.getCode());
        assertEquals("Dollar", t.getName());
        assertTrue(t.getIsActive());
        assertNotNull(t.getCreatedAt());
        assertNotNull(t.getUpdatedAt());
    }
}
