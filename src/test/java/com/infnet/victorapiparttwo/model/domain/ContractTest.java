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
        c.setId(10);
        c.setName("Test Contract");
        c.setDescription("Desc");
        c.setContractNumber("CN-001");
        c.setStartDate(java.time.LocalDate.of(2025,1,1));
        c.setEndDate(java.time.LocalDate.of(2025,12,31));
        c.setValue(new BigDecimal("1500.00"));
        c.setCoinTypeId(2);
        c.setClientSupplierId(3);
    c.setIsActive(null);
    c.setCreatedAt(null);
    c.setUpdatedAt(null);
    c.prePersist();
        assertEquals(10, c.getId());
        assertEquals("Test Contract", c.getName());
        assertEquals("Desc", c.getDescription());
        assertEquals("CN-001", c.getContractNumber());
        assertEquals(java.time.LocalDate.of(2025,1,1), c.getStartDate());
        assertEquals(java.time.LocalDate.of(2025,12,31), c.getEndDate());
        assertEquals(new BigDecimal("1500.00"), c.getValue());
        assertTrue(c.getIsActive());
        assertNotNull(c.getCreatedAt());
        assertNotNull(c.getUpdatedAt());
        c.setUpdatedAt(null);
        c.preUpdate();
        assertNotNull(c.getUpdatedAt());
    }
}
