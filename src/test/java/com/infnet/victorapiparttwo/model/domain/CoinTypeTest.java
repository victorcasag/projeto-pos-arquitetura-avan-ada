package com.infnet.victorapiparttwo.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinTypeTest {

    @Test
    @DisplayName("CoinType: fields and lifecycle")
    void coinTypeFields() {
        CoinType t = new CoinType();
        t.setCode("USD");
        t.setName("Dollar");
        t.prePersist();
        assertNotNull(t.getCreatedAt());
        assertEquals("USD", t.getCode());
        assertEquals("Dollar", t.getName());
    }
}
