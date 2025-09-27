package com.infnet.victorapiparttwo.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {

    @Test
    @DisplayName("Country: prePersist sets timestamps and defaults")
    void prePersistSetsTimestamps() {
        Country c = new Country();
        c.setId(5);
        c.setName("Brazil");
        c.setCode2("BR");
        c.setCode3("BRA");
        c.setCurrencyCode("BRL");
    c.setIsActive(null);
    c.setCreatedAt(null);
    c.setUpdatedAt(null);
    c.prePersist();
        assertEquals(5, c.getId());
        assertEquals("Brazil", c.getName());
        assertEquals("BR", c.getCode2());
        assertEquals("BRA", c.getCode3());
        assertEquals("BRL", c.getCurrencyCode());
        assertTrue(c.getIsActive());
        assertNotNull(c.getCreatedAt());
        assertNotNull(c.getUpdatedAt());
    }
}
