package com.infnet.victorapiparttwo.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectStatusEnumTest {

    @Test
    @DisplayName("ProjectStatus enum contains expected values")
    void projectStatusValues() {
        ProjectStatus[] vals = ProjectStatus.values();
        assertTrue(vals.length >= 3);
        assertEquals(ProjectStatus.PLANNED, ProjectStatus.valueOf("PLANNED"));
    }
}
