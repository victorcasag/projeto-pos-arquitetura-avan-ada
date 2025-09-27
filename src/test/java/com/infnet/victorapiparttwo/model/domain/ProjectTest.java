package com.infnet.victorapiparttwo.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    @Test
    @DisplayName("Project: defaults and flags")
    void projectDefaults() {
        Project p = new Project();
        p.setName("Proj X");
        p.prePersist();
        assertNotNull(p.getCreatedAt());
        assertFalse(p.getBillableFl());
    }
}
