package com.infnet.victorapiparttwo.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientSupplierTest {

    @Test
    @DisplayName("ClientSupplier: fields and timestamps")
    void clientSupplierBasics() {
        ClientSupplier cs = new ClientSupplier();
        cs.setName("ACME");
        assertNull(cs.getCreatedAt());
        cs.prePersist();
        assertNotNull(cs.getCreatedAt());
        assertEquals("ACME", cs.getName());
    }

    @Test
    @DisplayName("ClientSupplier: defaults and timestamps")
    void clientSupplierDefaults() {
        ClientSupplier cs = new ClientSupplier();
        cs.setName("ACME");
        assertNull(cs.getCreatedAt());
        cs.prePersist();
        assertNotNull(cs.getCreatedAt());
        assertTrue(cs.getIsActive());
    }
}
