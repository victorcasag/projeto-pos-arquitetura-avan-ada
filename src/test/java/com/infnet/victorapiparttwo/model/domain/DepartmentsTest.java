package com.infnet.victorapiparttwo.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentsTest {

    @Test
    @DisplayName("Departments: name and timestamps")
    void departmentsBasics() {
        Departments d = new Departments();
        d.setName("Dept");
        assertNull(d.getCreatedAt());
        d.prePersist();
        assertNotNull(d.getCreatedAt());
        assertEquals("Dept", d.getName());
    }

    @Test
    @DisplayName("Departments: getters and setters")
    void departmentsGetSet() {
        Departments d = new Departments();
        d.setId(2);
        d.setName("Engineering");
        d.setCode("ENG");
        d.setDescription("Engineering Dept");
    d.setIsActive(null);
    d.setCreatedAt(null);
    d.setUpdatedAt(null);
    d.prePersist();
        assertEquals(2, d.getId());
        assertEquals("Engineering", d.getName());
        assertEquals("ENG", d.getCode());
        assertEquals("Engineering Dept", d.getDescription());
        assertTrue(d.getIsActive());
        assertNotNull(d.getCreatedAt());
        d.setUpdatedAt(null);
        d.preUpdate();
        assertNotNull(d.getUpdatedAt());
    }
}
