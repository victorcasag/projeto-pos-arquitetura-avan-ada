package com.infnet.victorapiparttwo.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {

    @Test
    @DisplayName("Country: prePersist sets timestamps and defaults")
    void prePersistSetsTimestamps() {
        Country c = new Country();
        c.setName("Brazil");
        assertNull(c.getCreatedAt());
        c.prePersist();
        assertNotNull(c.getCreatedAt());
        assertNotNull(c.getUpdatedAt());
        assertTrue(c.getIsActive());
    }
}
