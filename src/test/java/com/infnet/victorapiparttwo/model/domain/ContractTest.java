package com.infnet.victorapiparttwo.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ContractTest {

    @Test
    @DisplayName("Contract: value column and lifecycle")
    void contractValueAndLifecycle() {
        Contract c = new Contract();
        c.setName("C1");
        c.setValue(new BigDecimal("123.45"));
        c.prePersist();
        assertNotNull(c.getCreatedAt());
        assertEquals(new BigDecimal("123.45"), c.getValue());
    }

    @Test
    @DisplayName("Contract: basic fields and prePersist")
    void contractBasics() {
        Contract c = new Contract();
        c.setName("Test Contract");
        c.setValue(BigDecimal.valueOf(1000));
        assertNull(c.getCreatedAt());
        c.prePersist();
        assertNotNull(c.getCreatedAt());
        assertEquals(BigDecimal.valueOf(1000), c.getValue());
    }
}
