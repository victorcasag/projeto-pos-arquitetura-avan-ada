package com.infnet.victorapiparttwo.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AreaTest {

    @Test
    @DisplayName("Area: name and timestamps")
    void areaBasics() {
        Area a = new Area();
        a.setName("Area 51");
        a.setCode("A51");
        a.setDescription("Secret area");
        assertEquals("Area 51", a.getName());
        assertEquals("A51", a.getCode());
        assertEquals("Secret area", a.getDescription());
    }
}
