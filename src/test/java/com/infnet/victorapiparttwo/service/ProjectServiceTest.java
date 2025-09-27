package com.infnet.victorapiparttwo.service;

import com.infnet.victorapiparttwo.model.domain.Project;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProjectServiceTest {

    private final ProjectService service = new ProjectService();

    @Test
    @DisplayName("ensureDefaults sets sensible defaults when fields are null")
    void ensureDefaultsSetsDefaults() {
        Project p = new Project();
        p.setName("Test");
        p.setExchangeRate(null);
        p.setBillableFl(null);

        service.ensureDefaults(p);

        assertNotNull(p.getExchangeRate());
        assertEquals(BigDecimal.ONE, p.getExchangeRate());
        assertFalse(p.getBillableFl());
    }

    @Test
    @DisplayName("validateRequiredFields throws on missing name")
    void validateRequiredFieldsThrows() {
        Project p = new Project();
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> service.validateRequiredFields(p));
        assertTrue(ex.getMessage().contains("project.name"));
    }

    @Test
    @DisplayName("applyExchangeRate multiplies amount by project's exchangeRate")
    void applyExchangeRateMultiplies() {
        Project p = new Project();
        p.setName("x");
        p.setExchangeRate(new BigDecimal("2.5"));

        BigDecimal result = service.applyExchangeRate(new BigDecimal("10"), p);
        assertEquals(new BigDecimal("25.0"), result);
    }
}
