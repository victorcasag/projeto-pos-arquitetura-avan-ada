package com.infnet.victorapiparttwo.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SectorTest {

    @Test
    @DisplayName("Sector: getters and lifecycle")
    void sectorBasics() {
        Sector s = new Sector();
        s.setName("R&D");
        s.prePersist();
        assertNotNull(s.getCreatedAt());
    }
}
