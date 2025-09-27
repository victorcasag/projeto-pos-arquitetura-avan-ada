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
        d.setName("Engineering");
        assertEquals("Engineering", d.getName());
    }
}
