package com.infnet.victorapiparttwo.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Proposals domain tests")
class ProposalsTest {

    @Test
    @DisplayName("prePersist sets timestamps and defaults")
    void prePersistSetsDefaults() {
        Proposals p = new Proposals();
        p.setName("Test");
        p.setExchangeRate(null);
        p.setPriority(null);

        p.prePersist();

        assertNotNull(p.getCreatedAt());
        assertNotNull(p.getUpdatedAt());
        assertEquals(BigDecimal.ONE, p.getExchangeRate());
        assertEquals(0, p.getPriority());
    }

    @Test
    @DisplayName("preUpdate updates updatedAt")
    void preUpdateUpdatesTime() throws InterruptedException {
        Proposals p = new Proposals();
        p.prePersist();
        LocalDateTime before = p.getUpdatedAt();
        Thread.sleep(5);
        p.preUpdate();
        assertNotNull(p.getUpdatedAt());
        assertTrue(!p.getUpdatedAt().isBefore(before));
    }

    @Test
    @DisplayName("getters and setters work")
    void gettersSetters() {
        Proposals p = new Proposals();
        p.setName("Name");
        p.setDescription("Desc");
        p.setValue(new BigDecimal("123.45"));

        assertEquals("Name", p.getName());
        assertEquals("Desc", p.getDescription());
        assertEquals(0, p.getValue().compareTo(new BigDecimal("123.45")));
    }

    @Test
    @DisplayName("defaults and preUpdate flow")
    void proposalsDefaultsAndUpdate() throws InterruptedException {
        Proposals p = new Proposals();
        p.setName("P2");
        p.setExchangeRate(null);
        p.setPriority(null);
        p.prePersist();
        assertNotNull(p.getExchangeRate());
        assertEquals(0, p.getPriority());
        // simulate update
        Thread.sleep(1);
        p.preUpdate();
        assertNotNull(p.getUpdatedAt());
    }
}
