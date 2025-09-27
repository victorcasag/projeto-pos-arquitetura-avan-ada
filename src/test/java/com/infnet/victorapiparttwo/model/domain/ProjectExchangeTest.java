package com.infnet.victorapiparttwo.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Project exchange and defaults tests")
class ProjectExchangeTest {

    @Test
    @DisplayName("exchangeRate getter and setter")
    void exchangeRateGetSet() {
        Project p = new Project();
        assertNull(p.getExchangeRate());
        p.setExchangeRate(new BigDecimal("1.2345"));
        assertEquals(0, p.getExchangeRate().compareTo(new BigDecimal("1.2345")));
    }
}
