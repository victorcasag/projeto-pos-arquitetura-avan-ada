package com.infnet.victorapiparttwo.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientSupplierTest {
    @Test
    @DisplayName("ClientSupplier: all getters/setters and lifecycle callbacks")
    void clientSupplierAllFields() {
        ClientSupplier cs = new ClientSupplier();

    cs.setId(42);
        cs.setName("ACME Ltd");
        cs.setDocument("123456789");
        cs.setDocumentType("CNPJ");
        cs.setEmail("contact@acme.com");
        cs.setPhone("+5511999999999");
        cs.setAddress("Rua Falsa, 123");
        cs.setCity("São Paulo");
        cs.setState("SP");
        cs.setPostalCode("01000-000");
        cs.setCountryId(55);
        cs.setType("CLIENT");
        cs.setIsActive(Boolean.FALSE);

        
        assertEquals(42, cs.getId());
        assertEquals("ACME Ltd", cs.getName());
        assertEquals("123456789", cs.getDocument());
        assertEquals("CNPJ", cs.getDocumentType());
        assertEquals("contact@acme.com", cs.getEmail());
        assertEquals("+5511999999999", cs.getPhone());
        assertEquals("Rua Falsa, 123", cs.getAddress());
        assertEquals("São Paulo", cs.getCity());
        assertEquals("SP", cs.getState());
        assertEquals("01000-000", cs.getPostalCode());
        assertEquals(55, cs.getCountryId());
        assertEquals("CLIENT", cs.getType());
        assertFalse(cs.getIsActive());

    cs.setCreatedAt(null);
        cs.setUpdatedAt(null);
        cs.setIsActive(null);
        assertNull(cs.getCreatedAt());
        assertNull(cs.getUpdatedAt());
        cs.prePersist();
        assertNotNull(cs.getCreatedAt());
        assertNotNull(cs.getUpdatedAt());
        assertTrue(cs.getIsActive());

    cs.setUpdatedAt(null);
        assertNull(cs.getUpdatedAt());
        cs.preUpdate();
        assertNotNull(cs.getUpdatedAt());

    var now = java.time.LocalDateTime.now();
        cs.setCreatedAt(now);
        cs.setUpdatedAt(now);
        assertEquals(now, cs.getCreatedAt());
        assertEquals(now, cs.getUpdatedAt());
    }
}
