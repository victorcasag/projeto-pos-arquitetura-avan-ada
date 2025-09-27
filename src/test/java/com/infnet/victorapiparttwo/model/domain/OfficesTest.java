package com.infnet.victorapiparttwo.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Offices domain tests")
class OfficesTest {

    @Test
    @DisplayName("prePersist sets timestamps and defaults")
    void prePersistSetsDefaults() {
        Offices o = new Offices();
        o.setName("HQ");
        o.setIsActive(null);
        o.prePersist();
        assertNotNull(o.getCreatedAt());
        assertTrue(o.getIsActive());
    }

    @Test
    @DisplayName("constructors and getters")
    void constructorsAndGetters() {
        Offices o = new Offices("N","C","A","City","State","00000",1,"p","e",true);
        assertEquals("N", o.getName());
        assertEquals("C", o.getCode());
        assertTrue(o.getIsMainOffice());
    }
}

